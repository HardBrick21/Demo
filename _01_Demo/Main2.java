package _01_Demo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by houlixuan on 2017/5/4.
 */
public class Main2 {
    public static void main(String args[]) {
        char[] cbuf = new char[256];
        System.out.println("hey, may I have your name, please? ");
        int n = 0;
        Reader r = new InputStreamReader(System.in);
        try {
            n = r.read(cbuf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("hello," + cbuf[0]);
    }
}

