package _02_FileIO;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by houli on 2017/2/21.
 */
public class ReadFromURL {
    public static void main(String[] args) {
        System.out.println("Enter a URL");
        String UrlString = new Scanner(System.in).next();

        try {
            URL Url = new URL(UrlString);
            int count = 0;
            Scanner input = new Scanner(Url.openStream());
            while (input.hasNext()) {
                String line = input.nextLine();
                count += line.length();
            }
            System.out.println("The file size is " + count + " characters");
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
