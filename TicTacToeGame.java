import java.util.Scanner;

public class TicTacToeGame {
     
    public static void main(String[] args) {
        Scanner input_scanner = new Scanner(System.in);

        char[][] game_board = new char[3][3];
        char current_player = 'X';

        initialize_game_board(game_board);

        while (true) {
            print_game_board(game_board);
            System.out.println("Player " + current_player + ", enter row (1-3) and column (1-3) separated by space: \n");
            int row = input_scanner.nextInt() - 1;
            int col = input_scanner.nextInt() - 1;

            if (is_valid_move(game_board, row, col)) {
                game_board[row][col] = current_player;

                if (check_win(game_board, current_player)) {
                    print_game_board(game_board);
                    System.out.println("Player " + current_player + " wins!\n");
                    break;
                }

                if (is_board_full(game_board)) {
                    print_game_board(game_board);
                    System.out.println("It's a tie!\n");
                    break;
                }

                current_player = (current_player == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move! Try again.\n");
            }
        }

        input_scanner.close();
    }

    private static void initialize_game_board(char[][] game_board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game_board[i][j] = '-';
            }
        }
    }

    private static void print_game_board(char[][] game_board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(game_board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean is_valid_move(char[][] game_board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && game_board[row][col] == '-');
    }

    private static boolean check_win(char[][] game_board, char player) {
        for (int i = 0; i < 3; i++) {
            if (game_board[i][0] == player && game_board[i][1] == player && game_board[i][2] == player) {
                return true; // Check rows
            }
            if (game_board[0][i] == player && game_board[1][i] == player && game_board[2][i] == player) {
                return true; // Check columns
            }
        }
        return (game_board[0][0] == player && game_board[1][1] == player && game_board[2][2] == player) || // Check diagonals
                (game_board[0][2] == player && game_board[1][1] == player && game_board[2][0] == player);
    }

    private static boolean is_board_full(char[][] game_board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game_board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
