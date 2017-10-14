package _03_Considerthefollowingthreetypesofnumbers;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Houlixuan on 2017/2/23.
 */
public class Number {
    public static void main(String[] args) {

        System.out.println("Give a number");
        Scanner input = new Scanner(System.in);
        int Number = input.nextInt();

        PrimeNumber(Number);
        FibonacciNumber(Number);
        CullenNumber(Number);

    }

    public static void PrimeNumber(int Num) {
        if (Num < 2) {
            System.out.println("小于2的数即不是合数也不是素数  ");//小于2的数即不是合数也不是素数

        }
        for (int i = 2; i <= Math.sqrt(Num); i++) {
            // 和比它的一半小数相除，如果都除不尽，证明素数
            if (0 == Num % i) {
                break;// 除尽了，合数

            } else {
                System.out.println("是一个素数");
                break;
            }
        }

    }

    public static void FibonacciNumber(int Num) {
        //通项公式 [（1＋√5）/2]^n /√5 － [（1－√5）/2]^n /√5
        if (Num == Math.pow(((1 + Math.sqrt(5)) / 2), Num) / Math.sqrt(5) - Math.pow((1 - Math.sqrt(5)) / 2, Num) / Math.sqrt(5))
            System.out.println("是斐波那契数列中的数");
    }

    public static void CullenNumber(int Num) { //Cn = n*2^{n/2} +1
        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 0; i < Num; i++) {
            number.add((int) (i * Math.pow(2, i / 2) + 1));
        }
        if (number.contains(Num))
            System.out.println("这是一个卡伦数");
    }
}
