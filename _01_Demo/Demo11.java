package _01_Demo;

/**
 * Created by houli on 2017/6/21.
 */
public class Demo11 {

    public static void main(String[] args) {
        int i = 1;
        int j = i++;
        if ((i==(++j))&&((i++)==j)){

            i+=j;

        }

        System.out.println("i = " +i);
    }

}
