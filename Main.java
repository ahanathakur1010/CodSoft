import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Enter Initial Balance in Your Account: ");
        Scanner sc=new Scanner(System.in);
        double b=sc.nextDouble();
        AtmInterface atm = new AtmInterface();
        atm.Balance(b);
        atm.display();
    }
}