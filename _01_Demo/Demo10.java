package _01_Demo;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by houli on 2017/6/21.
 */
public class Demo10 {

    public  int aMethod(){
        int i = 0;

        i++;

        return i;

    }

    public static void main(String[] args) {
        Demo10 demo = new Demo10();
        demo.aMethod();
        int j = demo.aMethod();

        System.out.println(j);

    }
}
