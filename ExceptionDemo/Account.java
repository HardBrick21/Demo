package ExceptionDemo;

public class Account {

  protected double balance;

  public Account(double balance){
    this.balance = balance;
  }

  public double getBalance(){
    return balance;
  }

  public void deposit(double amt){
    this.balance += amt;
  }
  public void withdraw (double amt) throws OverdraftException{
    
    if (balance < amt)
      throw  new OverdraftException("余额不足", amt-this.balance);
    
    this.balance -= amt;
  }
  
  public static void main(String[] args) {
    
    Account acc = new Account(2000);
  
    System.out.println(acc.getBalance());
    
    acc.deposit(3000);
  
    System.out.println(acc.getBalance());
    
    try {
      acc.withdraw(5001);
    } catch (OverdraftException e) {
      System.err.println("透支金额" + e.getDeficit());
      e.printStackTrace();
    }
  
  }

}
