package _02_FileIO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by houli on 2017/2/21.
 */
public class FileIODemo {
    public static void main(String[] args) throws IOException {
        File f = new File("FileIO.txt");
        ReturnTheAttributes(f);

        PrintWriter output = new PrintWriter(f);
        output.println("test -----------------");
        output.println(900000000);
        output.close();

        Scanner input = new Scanner(f);
        while (input.hasNext()) {
            String num1 = input.next();
            System.out.println(num1);
        }
    }

    public static void ReturnTheAttributes(File file) throws IOException {

        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Create file success!");
        }
        System.out.println("File Name : " + file.getName());
        System.out.println("File has " + file.length() + " bytes");
        System.out.println("Can it be read? " + file.canRead());
        System.out.println("Can it be written? " + file.canWrite());
        System.out.println("It is a director? " + file.isDirectory());
        System.out.println("It is a file ? " + file.isFile());
        System.out.println("Is it absolute ? " + file.isAbsolute());
        System.out.println("Is it hidden ? " + file.isHidden());
        System.out.println("Absolute path is " + file.getAbsolutePath());
        System.out.println("Last modified on " + new Date(file.lastModified()));

    }
}
