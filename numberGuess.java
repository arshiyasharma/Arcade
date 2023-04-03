import java.util.Scanner;
import java.util.Random;
public class numberGuess extends arcade
{
    void rules()
    {
        System.out.println("RULES OF NUMBER GUESSER (1 person): ");
        System.out.println("1. The game has unlimited tries.");
        System.out.println("2. A number between 1-100 will be generated.");
        System.out.println("3. If you guess below the target number, it displays a similar message and tells you to try again. Same for a higher value than the target.");
        System.out.println("4. When you guess the right number, the game is over. It shows you the amount of tries and the target number.");
    }
   
    boolean game()
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int numberToGuess = rand.nextInt(101); // generates a random number between 0 and 100
        int numberOfGuesses = 0;
        int guess;
        System.out.println("Guess a number between 0 and 100.");

        do 
        {
            guess = input.nextInt();
            numberOfGuesses++;
            if (guess < numberToGuess) {
                System.out.println("That's low! Guess again.");
            } else if (guess > numberToGuess) {
                System.out.println("That's high! Guess again.");
            } else {
                System.out.println("\nYou guessed the number in " + numberOfGuesses + " tries.");
            }
        } while (guess != numberToGuess);
        return true;
    }
   
    public static void main(String []ar)
    {
        numberGuess obj = new numberGuess();
        obj.welcome();
        obj.rules();
        obj.result(obj.game());
    }
}
