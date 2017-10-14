package Compiler.Lexer;

/**
 * Created by houlixuan on 2017/3/12.
 * --******__环境值 （environment）
 *
 */
public class EnvValue {
    private int id;
    private int line;
    private String value;

    public void setId(int id) {
        this.id = id;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getLine(){
        return line;
    }

    public String getValue() {
        return value;
    }

}
