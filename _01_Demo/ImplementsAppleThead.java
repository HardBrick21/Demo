package _01_Demo;

/**
 * Created by houli on 2017/2/20.
 */
class Apple implements Runnable {
    private int AppleNum = 50;

    @Override
    public void run() {
            //同步代码块
        for (int i = 0; i < 50; i++) {
            synchronized (this) {
                if (AppleNum > 0) {
                    System.out.println(Thread.currentThread().getName() + "Eat _01_Demo.Apple" + AppleNum);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    AppleNum--;

                }
            }
        }
    }
}

public class ImplementsAppleThead {

    public static void main(String[] args) {
        Apple apple = new Apple();
        new Thread(apple, " A ").start();
        new Thread(apple, " B ").start();
        new Thread(apple, " C ").start();

    }
}
