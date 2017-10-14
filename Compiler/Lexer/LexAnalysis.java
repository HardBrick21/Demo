package Compiler.Lexer;

import java.io.*;
import java.util.Scanner;

/**
 * Created by houli on 2017/3/11.
 */
public class LexAnalysis {

    private static int PUB = 1; //public
    private static int PROT = 2; // protected
    private static int PRI = 3; //private
    private static int ABS = 4; //abstract
    private static int CLA = 5; //class
    private static int EXT = 6; //extends
    private static int FIN = 7; //final
    private static int IMP = 8; //implements
    private static int INTER = 9; //interface
    private static int NAV = 10; //native
    private static int NEW = 11; //new
    private static int STA = 12; //static
    private static int STRI = 13; //strictfp
    private static int SYN = 14; //synchronized
    private static int TRAN = 15; //transient
    private static int VOL = 16; //volatile
    private static int BRE = 17; //break
    private static int CASE = 18; //case
    private static int CONT = 19; //continue
    private static int DEFA = 20; //default
    private static int DO = 21; //do
    private static int ELSE = 22; //else
    private static int FOR = 23; //for
    private static int IF = 24; //if
    private static int INST = 25; //instanceof
    private static int RET = 26; //return
    private static int SWI = 27; //switch
    private static int WHI = 28; //while
    private static int ASSE = 29; //assert
    private static int CAT = 30; //catch
    private static int FINA = 31; //finally
    private static int THR = 32; //throw
    private static int THRO = 33; //throws
    private static int TRY = 34; //try
    private static int IMPO = 35; //import
    private static int PAC = 36; //package
    private static int BOO = 37; //boolean
    private static int BYT = 38; //byte
    private static int CHA = 39; //char
    private static int DOU = 40; //double
    private static int FLO = 41; //float
    private static int INT = 42; //int
    private static int LON = 43; //long
    private static int SHO = 44; //short
    private static int NULL = 45; //null
    private static int SUP = 46; //super
    private static int THI = 47; //this
    private static int VOI = 48; //void
    private static int GOTO = 49; //goto


    private static int EQU = 50;//"="
    private static int LES = 51;//"<"
    private static int LESE = 52;//"<="
    private static int LARE = 53;//">="
    private static int LAR = 54;//">"
    private static int NEQE = 55;//"<>"

    private static int ADD = 56;//"+"
    private static int SUB = 57;//"-"
    private static int MUL = 58;//"*"
    private static int DIV = 59;//"/"

    private static int SYM = 60;//标识符
    private static int CONST = 61;//常量

    private static int CEQU = 62;//":="

    private static int COMMA = 63;//","
    private static int SEMIC = 64;//";"
    private static int POI = 65;//"."
    private static int LBR = 66;//"("
    private static int RBR = 67;//")"

    private SymKWordTable SK = new SymKWordTable();
    private EnvValue EV = new EnvValue();
    private String[] Keyword = SK.getKeyword();
    private String[] ConstTable = SK.getConTable();
    private String[] SymTable = SK.getSymTable();
    private int SymLength = SymTable.length;
    private int ConLength = ConstTable.length;

    private char ch = ' ';
    private String strToken;
    private String fileName;
    private char[] buffer;
    private int searchPtr = 0;
    private int line = 0;
    private boolean errorHappen = false;

    /**
     * 预处理 ： 将源文件中的代码读取到buffer中
     */

    public char[] PreManage() {

        System.out.println("Enter the file path");
        Scanner sc = new Scanner(System.in);
        fileName = sc.next();

        //File file = new File(fileName);
        BufferedReader bf = null;
        String temp1, temp2 = "";
        try {
            FileReader fr = new FileReader(fileName);
            bf = new BufferedReader(fr);
            while ((temp1 = bf.readLine()) != null) {
                temp2 = temp2 + temp1 + String.valueOf('\n');
            }
            buffer = temp2.toCharArray();
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 用于扫描字符
     */
    public char getChar() {
        if (searchPtr < buffer.length) {
            ch = buffer[searchPtr];
            searchPtr++;
        }
        return ch;
    }

    /**
     * 扫描空白符
     * 空格 制表符  换行符
     */

    public void getBlankChar() {
        while ((ch == ' ' || ch == '\t' || ch == '\n') && (searchPtr < buffer.length)) {
            if (ch == '\n')
                line++;
            getChar();
        }

    }

    /**
     * 返回链接过的token
     */
    public String concat() {
        strToken = strToken + String.valueOf(ch);
        return strToken;
    }

    /**
     * 判断是不是数字或字母
     *
     * @return
     */
    public boolean isLeter() {
        if (Character.isLetter(ch))
            return true;
        return false;
    }

    public boolean isDigit() {
        if (Character.isDigit(ch))
            return true;
        return false;
    }

    public int reserve() {
        for (int i = 0; i < Keyword.length; i++) {
            if (Keyword[i].equals(strToken))
                return i + 1;

        }
        return 0;

    }

    public void retract() {
        searchPtr--;
        ch = ' ';
    }

    public int insertID() {
        for (int i = 0; i < SymLength; i++) {
            if (SymTable[i] == null) {
                SymTable[i] = strToken;
                return i;
            }
        }
        return -1;  //表示符号表已满
    }

    public int insertConst() {
        for (int i = 0; i < ConLength; i++) {
            if (ConstTable[i] == null) {
                ConstTable[i] = strToken;
                return i;
            }

        }
        return -1; //表示常熟表已满
    }

    public void showError() {
        System.out.println();
        System.out.println("Error in line " + line);
        System.out.println();
    }

    /**
     * 字符识别函数
     * 分析文本中的字符
     */

    public EnvValue analysis() {
        int code, value;
        strToken = "";
        getChar();
        getBlankChar();
        if (ch == '\n') {
            EV.setId(-1);
            EV.setValue("-1");
            EV.setLine(line);
            return EV;
        }
        if (isLeter()) {
            while (isLeter() || isDigit()) {
                concat();
                getChar();
            }
            retract();
            code = reserve();
            if (code == 0) {
                value = insertID();
                EV.setId(SYM);
                EV.setValue(SymTable[value]);
                EV.setLine(line);
                return EV;
            } else {
                EV.setId(code);
                EV.setValue("-");
                EV.setLine(line);
                return EV;
            }
        } else if (isDigit()) {
            while (isDigit()) {
                concat();
                getChar();
            }
            retract();
            value = insertConst();
            EV.setId(CONST);
            EV.setValue(ConstTable[value]);
            EV.setLine(line);
            return EV;
        } else if (ch == '=') {
            EV.setId(EQU);
            EV.setValue("-");
            EV.setLine(line);
            return EV;
        } else if (ch == '+') {
            EV.setId(ADD);
            EV.setValue("-");
            EV.setLine(line);
            return EV;
        } else if (ch == '-') {
            EV.setId(SUB);
            EV.setValue("-");
            EV.setLine(line);
            return EV;
        } else if (ch == '*') {
            EV.setId(MUL);
            EV.setValue("-");
            EV.setLine(line);
            return EV;
        } else if (ch == '/') {
            EV.setId(DIV);
            EV.setValue("/");
            EV.setLine(line);
            return EV;
        } else if (ch == '<') {
            getChar();
            if (ch == '=') {
                EV.setId(LESE);
                EV.setValue("-");
                EV.setLine(line);
                return EV;
            } else if (ch == '>') {
                EV.setId(NEQE);
                EV.setValue("-");
                EV.setLine(line);
                return EV;
            } else {
                retract();
                EV.setId(LES);
                EV.setValue("-");
                EV.setLine(line);
                return EV;
            }
        } else if (ch == '>') {
            getChar();
            if (ch == '=') {
                EV.setId(LARE);
                EV.setValue("-");
                EV.setLine(line);
                return EV;
            } else {
                retract();
                EV.setId(LAR);
                EV.setValue("-");
                EV.setLine(line);
                return EV;
            }
        } else if (ch == ',') {
            EV.setId(COMMA);
            EV.setValue("-");
            EV.setLine(line);
            return EV;
        } else if (ch == ';') {
            EV.setId(SEMIC);
            EV.setValue("-");
            EV.setLine(line);
            return EV;
        } else if (ch == '.') {
            EV.setId(POI);
            EV.setValue("-");
            EV.setLine(line);
            return EV;
        } else if (ch == '(') {
            EV.setId(LBR);
            EV.setValue("-");
            EV.setLine(line);
            return EV;
        }else if (ch == ')'){
            EV.setId(RBR);
            EV.setValue("-");
            EV.setLine(line);
            return EV;
        }else if (ch == ':'){
            getChar();
            if (ch == '='){
                EV.setId(CEQU);
                EV.setValue("-");
                EV.setLine(line);
                return EV;
            }else {
                retract();
            }
        }
        errorHappen = true;
        return EV;
    }

    /**
     * 识别字符输出到文件
     */

     public void bAnalysis(){
         PreManage();
         EnvValue temp;
         String str = "lex.txt";
         OutputStream myout = null;
         File file = new File(str);
         try {
             myout = new FileOutputStream(file);
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         while (searchPtr < buffer.length && errorHappen == false){
             temp = analysis();

             String tempID = String.valueOf(temp.getId()),
                     tempLine = String.valueOf(temp.getLine());

             byte[] bid = tempID.getBytes();
             byte[] bname = temp.getValue().getBytes();
             byte[] bline = tempLine.getBytes();
             try {
                myout.write(bid);
                myout.write(' ');
                myout.write(bname);
                myout.write(' ');
                myout.write(bline);
                myout.write('\n');
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         try {
             myout.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
         if (errorHappen == true)
             showError();
     }

}


























