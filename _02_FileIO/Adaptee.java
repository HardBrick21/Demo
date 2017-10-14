package _02_FileIO;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by houlixuan on 2017/4/30.
 */
public class Adaptee {

    public static void main(String[] args) {
        byte[] buf = new byte[512];
        System.out.println("hey, may I have your name, please? ");
        int n = 0;

        try {
             System.in.read(buf);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.print("hello, ");
        System.out.write(buf, 0, buf.length);  //-28 -66 -81 10
    }

}
