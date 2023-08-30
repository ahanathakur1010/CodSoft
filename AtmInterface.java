import java.util.Scanner;
public class AtmInterface extends UserBankDetails
{
    double balance;
    Scanner sc=new Scanner(System.in);
    public void checkBalance()
    {
        System.out.println("Your account balance is: "+super.balance);
    }
    public void withdraw(double wdamount)
    {
        if(wdamount<=0 || wdamount>super.balance)
            System.out.println("Transaction failed because your entered amount is incorrect");
        else 
        {
            super.balance=super.balance-wdamount;
            System.out.println("Thank you!"+'\n'+"You have successfully withdrawn your money");
        }
    }
    public void deposit(double bal)
    {        
        super.balance = super.balance + bal;
        System.out.println("Thank you!"+'\n'+"You have deposited your money");
    }
    public void display()
    {      
      System.out.println("--Welcome to ATM Machine--");
      System.out.println("(1)Check Balance");
      System.out.println("(2)Withdraw");
      System.out.println("(3)Deposit");
      System.out.println("(4)Exit");
      int ch;
      while(true)
      {
         System.out.println("Enter Your Choice");
         ch=sc.nextInt();
         switch(ch)
         {
              case 1:
              checkBalance();
              break;
          case 2:
              System.out.println("Enter the Amount");
              double wd = sc.nextDouble();
              withdraw(wd);
              break;
          case 3:
              System.out.println("Enter The Balance");
              double bala = sc.nextDouble();
              deposit(bala);
              break;
          case 4:
              System.out.println("Thank You For Using ATM");
              System.exit(0);
          default:
              System.out.println("Invalid Choice");
        }
      }
    }
}
