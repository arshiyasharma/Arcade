import java.util.Scanner;
public class hangman extends arcade
{
    void rules()
    {
        System.out.println("RULES OF TECH HANGMAN (1 person): ");
        System.out.println("1. A word will randomly be chosen from a series of Technical Terminology from the world of Computers.");
        System.out.println("2. You will have 15 guesses.");
        System.out.println("3. You will be allowed to enter only a single letter at once, if multiple letters are entered, only the first letter is taken into account.");
        System.out.println("4. If you enter the same letter again, you have the same amount of tries left (no change).");
        System.out.println("5. If you guess the word correctly in 15 attempts, you win.");
    }
   
    boolean game()
    {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"java","programming","computer","algorithm","software","code","web","database","keyboard","cpu","ram","monitor","hardware","byte","api"};
        String word = words[(int) (Math.random() * words.length)];
        char[] hiddenWord = new char[word.length()];
        for (int i = 0; i < hiddenWord.length; i++) {
            hiddenWord[i] = '_';
        }
        int attempts = 15;
        boolean guessed = false;
        while (attempts > 0 && !guessed) {
            System.out.println("\nYou have " + attempts + " attempts left.");
            System.out.println("The word is:");
            System.out.println(hiddenWord);
            System.out.print("Enter a letter: ");
            char letter = scanner.next().charAt(0);
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    hiddenWord[i] = letter;
                    found = true;
                }
            }
            if (!found) {
                attempts--;
            }
            if (word.equals(new String(hiddenWord))) {
                guessed = true;
            }
        }
        if (guessed) {
            System.out.println("You guessed the word: " + word);
            return true;
        } else {
            System.out.println("The word was: " + word);
            return false;
        }
    }
   
    public static void main(String []ar)
    {
        hangman obj = new hangman();
        obj.welcome();
        obj.rules();
        obj.result(obj.game());
    }
}
