package numberGame;
import java.util.Scanner;
public class NumberGame {
    public static void main(String[] args) {

        // Generate random number between 1 and 100 with only integer value
        int number = (int)(Math.random() * 100) + 1;
        Scanner scanner =new Scanner(System.in);
        boolean playAgain = true;
        int roundsWon = 0;
        int score = 0;

        while (playAgain){
            int guess = 0;
            int attempts = 0;
            int maxAttempts = 7;


            while(guess != number && attempts < maxAttempts){

                // Prompt the user to enter their guess for the generated number.
                System.out.println("Enter your guess (1-100) : ");
                guess = scanner.nextInt();

                attempts++;  // count attemots

                // Checking whether the numbers guessed by the user and the computer are equal
                if(number == guess){
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    roundsWon++;

                    // Scoring system
                    score += (maxAttempts - attempts + 1);
                    break;
                } else if (number > guess){
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                // count remaining attemps
                if (attempts < maxAttempts){
                    System.out.println("Remaining Attempts : " +(maxAttempts-attempts));
                }
            }

            // In case user not guess the number
            if (guess != number){
                System.out.println("Out of attempts! Correct number is : " +number);
            }

            // If user want to play again
            System.out.println("Do you wan to play again? (yes/no) : ");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("yes")){
                playAgain = false;
                System.out.println();

                // Display final score
                System.out.println("Display User Score ----> ");
                System.out.println("No. of Attempts : " +attempts);
                System.out.println("Round won by : " +roundsWon);
                System.out.println("Score : " +score);
                System.out.println("Thanks for playing!");
            }
        }
        scanner.close();
    }
}
