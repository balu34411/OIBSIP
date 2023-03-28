import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your name to continue ");
        String userName = myObj.nextLine();
        System.out.println("Username is: " + userName);
        int result,guess;
        final int n=100;
        boolean right = false;
        Scanner sc = new Scanner(System.in);
        Random no = new Random();
        result=no.nextInt(n)+1;
        System.out.println("Welcome to the Number Guessing Game my friend");
        do
        {
            System.out.println("Guess the number in between 1-100");
            guess=sc.nextInt();
            if(guess>result)
            {
                System.out.println("Entered number is too large!!");

            }
            else if(guess<result)
            {
                System.out.println("Entered number is too small!!");
            }
            else
            {
                System.out.println("Yes, You have guessed the correct number as i generated in memory "+ userName);
                right=true;
            }

        }
        while(!right);
        System.exit(0);
    }
}
