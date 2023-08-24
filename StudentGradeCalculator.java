import java.util.Scanner;
import java.util.Formatter;
import java.io.*;
public class StudentGradeCalculator 
{
    public static void main(String[] args) 
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the no. of subjects the student has:");
       int n=sc.nextInt();
       int marks=0;
       int total=0;
       double avgper=0.0;
       String grade="";
       for(int i=1;i<=n;i++)
       {
           System.out.println("Enter the marks for subject "+i+":");
           marks=sc.nextInt();
           if(marks<0 || marks>100)
           {
               System.out.println("Marks should be between 0-100");
               return;
           }
           total=total+marks;
       }
       avgper=(double)total/(n * 100)*100;
       if(avgper>=90)
           grade="A";
       else if(avgper>=80)
           grade="B";
       else if(avgper>=70)
           grade="C";
       else if(avgper>=60)
           grade="D";
       else if(avgper>=50)
           grade="E";
       else 
           grade="F"; 
        System.out.println("--Student Grade Details--");
        System.out.println("Total Marks:"+total);
        System.out.println(String.format("Average Percentage:%.2f",avgper)+"%");
        System.out.println("Grade:"+grade);
      }   
}