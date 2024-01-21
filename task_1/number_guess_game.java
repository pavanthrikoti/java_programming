import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        playNumberGuessingGame();
    }

    public static void playNumberGuessingGame() {
        Random rand = new Random();
        int randomNum = rand.nextInt(11);
        makeGuess(randomNum);
    }

    public static void makeGuess(int randomNum) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nNumber Guessing Game");
        System.out.print("Guess a number between 0-10: ");
        int guess = scanner.nextInt();
        System.out.println("");

        // Input validation
        while (guess < 0 || guess > 10) {
            System.out.print("Guess a number between 0-10: ");
            guess = scanner.nextInt();
            System.out.println("");
        }

        // Try again until the correct number is guessed
        int tries = 0;
        while (guess != randomNum) {
            tries++;
            System.out.println("Wrong Guess!");
            System.out.print("Guess again: ");
            guess = scanner.nextInt();
            System.out.println("");

            // Input validation
            while (guess < 0 || guess > 10) {
                System.out.print("Guess a number between 0-10: ");
                guess = scanner.nextInt();
                System.out.println("");
            }
        }

        // Game Won
        System.out.println("Correct Answer. You Won!");
        System.out.println("Wrong Tries: " + tries);
        System.out.println("");

        // Play again or exit?
        System.out.println("Press 1 to Play again.");
        System.out.println("Press 0 to exit.");
        int choice = scanner.nextInt();

        if (choice == 1)
            playNumberGuessingGame();
        else
            return;
    }
}
