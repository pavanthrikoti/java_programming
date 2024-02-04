import java.util.*;

public class rock_paper_scissors_game {

    enum Move {
        ROCK,
        PAPER,
        SCISSORS
    }

    public static String get_player_choice() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        String player_choice = choice.toLowerCase();
        scanner.close();

        if (player_choice.equals("rock") || player_choice.equals("paper") || player_choice.equals("scissors")) {
            return player_choice;
        } else {
            System.out.println("This is not a valid move. Try again!");
            return "Bad Input";
        }
    }

    public static String get_computer_choice() {
        String computer_choice;
        Random random = new Random();
        int input = random.nextInt(3) + 1;

        if (input == 1) {
            computer_choice = Move.ROCK.name().toLowerCase();
        } else if (input == 2) {
            computer_choice = Move.PAPER.name().toLowerCase();
        } else {
            computer_choice = Move.SCISSORS.name().toLowerCase();
        }
        return computer_choice;
    }

    public static void main(String args[]) {
        System.out.println("Welcome to the rock-paper-scissors game!\nYour game partner is the computer.\nEnter your move: ");
        System.out.println("rock");
        System.out.println("paper");
        System.out.println("scissors");

        String player_move = get_player_choice();
        System.out.println("Your move is: " + player_move);

        if (!player_move.equals("Bad Input")) {
            String computer_move = get_computer_choice();
            System.out.println("Computer move is: " + computer_move);

            if (player_move.equals(computer_move)) {
                System.out.println("Game is a tie!");
            } else if (player_move.equals(Move.ROCK.name().toLowerCase())) {
                if (computer_move.equals(Move.PAPER.name().toLowerCase())) {
                    System.out.println("Computer wins. Better luck next time!");
                } else {
                    System.out.println("You win! Congratulations!");
                }
            } else if (player_move.equals(Move.PAPER.name().toLowerCase())) {
                if (computer_move.equals(Move.SCISSORS.name().toLowerCase())) {
                    System.out.println("Computer wins. Better luck next time!");
                } else {
                    System.out.println("You win! Congratulations!");
                }
            } else {
                if (computer_move.equals(Move.ROCK.name().toLowerCase())) {
                    System.out.println("Computer wins. Better luck next time!");
                } else {
                    System.out.println("You win! Congratulations!");
                }
            }
        }
    }
}
