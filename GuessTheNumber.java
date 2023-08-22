import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Random rd=new Random();
        int min=1,max=100,numAttempts=10,score=0;      
        System.out.println("--This is Number Guessing Game--");
        do 
        {
            int secNumber=rd.nextInt(max-min+1) + min;
            int userAttempts=0;
            boolean guessCorrect=false;
            
            System.out.println("A number is chosen between " + min + " and " + max + ".");
            System.out.println("Can you guess the number?");
            while(userAttempts<numAttempts && !guessCorrect) 
            {
                int guess=getValidGuess(sc, min, max);
                userAttempts++;            
                if (guess==secNumber)
                {
                    guessCorrect = true;
                    score += numAttempts - userAttempts + 1;
                    System.out.println("You guessed the correct number in " + userAttempts + " attempts.");
                } 
                else if (guess < secNumber) 
                {
                    System.out.println("Too low!Please try again.");
                }
                else 
                {
                    System.out.println("Too high!Please try again.");
                }
            }

            if (!guessCorrect)
            {
                System.out.println("Sorry, you have reached the maximum number of attempts.");
                System.out.println("The chosen number was: " + secNumber);
            }

            System.out.print("Do you want to play again? (Yes/No): ");
        } while(sc.next().equalsIgnoreCase("Yes"));

        System.out.println("Your total score: " + score);
        System.out.println("Thank you for playing the game!s Hava a good day :) ");
        sc.close();
    }

    public static int getValidGuess(Scanner sc, int minimum, int maximum) 
    {
        int guess;

        while(true) 
        {
            System.out.print("Enter the number you guess it is: ");
            if (sc.hasNextInt()) 
            {
                guess = sc.nextInt();
                if (guess >= minimum && guess <= maximum) 
                    break;
                else
                    System.out.println("Your guess should be between " + minimum + " and " + maximum + ".");                
            } 
            else 
            {
                sc.next(); 
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return guess;
    }
}