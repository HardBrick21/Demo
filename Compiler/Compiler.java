package Compiler;

import Compiler.Lexer.LexAnalysis;

/**
 * Created by houlixuan on 2017/3/19.
 */
public class Compiler {
    public static void main(String[] args) {
        LexAnalysis lex = new LexAnalysis();
        lex.bAnalysis();
    }
}
