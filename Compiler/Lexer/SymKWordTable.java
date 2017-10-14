package Compiler.Lexer;

/**
 * Created by houlixuan on 2017/3/10.
 */
public class SymKWordTable {
    //记录所有关键字

    private static String[] Keyword = new String[]{
            "public", "protected", "private", "abstract", "class", "extends", "final", "implements", "interface", "new", "static",
            "synchronized", "break", "case", "default", "do", "else", "for", "if", "return",
            "switch", "while", "import", "package", "boolean", "byte", "char", "double", "float",
            "int", "long", "short", "null", "super", "this", "void"
    };

    public String[] getKeyword() {

        return Keyword;
    }

    public int getLength() {

        return Keyword.length;
    }

    public static int symLength = 100;

    public String[] symTable = new String[symLength];

    public static int conLength = 100;

    public String[] conTable = new String[conLength];

    public String[] getSymTable() {
        return symTable;
    }

    public String[] getConTable() {
        return conTable;
    }
}



