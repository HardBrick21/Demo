package _01_Demo;

public class ExceptionDemo {

  public static void main(String[] args) {
    System.out.println(method());
  }

  public static int method(){
    try {
      return 1;
    }catch (Exception e){
      e.printStackTrace();
      return 2;
    }
    finally {
      return 3;
    }
  }
}
