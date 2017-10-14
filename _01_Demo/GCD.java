package _01_Demo;

import java.util.Scanner;

/**
 * Created by houli on 2017/1/14.
 */
public class GCD {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int gdc = 1;
        int k = 2;
        System.out.println("Enter the first number");
        int a = input.nextInt();
        System.out.println("Enter the second number");
        int b = input.nextInt();

        while (k<=a && k<=b){
            if (a%k==0 && b%k==0)
                gdc=k;
            k++;

        }
        System.out.println("The GDC is " + gdc);
        input.close();
    }
}
