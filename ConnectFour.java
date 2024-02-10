import java.util.Scanner;

public class ConnectFour {
    
    public static String[][] createPattern() {
        String[][] f = new String[6][7];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                f[i][j] = " ";
            }
        }
        return f;
    }

    public static void printPattern(String[][] f) {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                System.out.print("|" + f[i][j]);
            }
            System.out.println("|");
        }
        for (int j = 0; j < f[0].length; j++) {
            System.out.print("--");
        }
        System.out.println("-");
    }

    public static void dropPattern(String[][] f, String color, int col) {
        for (int i = f.length - 1; i >= 0; i--) {
            if (f[i][col].equals(" ")) {
                f[i][col] = color;
                break;
            }
        }
    }

    public static String checkWinner(String[][] f) {
        // Checking horizontally
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length - 3; j++) {
                if (!f[i][j].equals(" ") && f[i][j].equals(f[i][j + 1]) && f[i][j].equals(f[i][j + 2])
                        && f[i][j].equals(f[i][j + 3])) {
                    return f[i][j];
                }
            }
        }
        // Checking vertically
        for (int i = 0; i < f.length - 3; i++) {
            for (int j = 0; j < f[i].length; j++) {
                if (!f[i][j].equals(" ") && f[i][j].equals(f[i + 1][j]) && f[i][j].equals(f[i + 2][j])
                        && f[i][j].equals(f[i + 3][j])) {
                    return f[i][j];
                }
            }
        }
        // Checking diagonally "/"
        for (int i = 0; i < f.length - 3; i++) {
            for (int j = 0; j < f[i].length - 3; j++) {
                if (!f[i][j].equals(" ") && f[i][j].equals(f[i + 1][j + 1]) && f[i][j].equals(f[i + 2][j + 2])
                        && f[i][j].equals(f[i + 3][j + 3])) {
                    return f[i][j];
                }
            }
        }
        // Checking diagonally "\"
        for (int i = 0; i < f.length - 3; i++) {
            for (int j = 3; j < f[i].length; j++) {
                if (!f[i][j].equals(" ") && f[i][j].equals(f[i + 1][j - 1]) && f[i][j].equals(f[i + 2][j - 2])
                        && f[i][j].equals(f[i + 3][j - 3])) {
                    return f[i][j];
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[][] f = createPattern();
        boolean loop = true;
        int count = 0;
        printPattern(f);
        while (loop) {
            int col;
            if (count % 2 == 0) {
                System.out.println("Player 1 (Red): Enter column (0–6): ");
                col = new Scanner(System.in).nextInt();
                dropPattern(f, "R", col);
            } else {
                System.out.println("Player 2 (Yellow): Enter column (0–6): ");
                col = new Scanner(System.in).nextInt();
                dropPattern(f, "Y", col);
            }
            count++;
            printPattern(f);
            String winner = checkWinner(f);
            if (winner != null) {
                if (winner.equals("R"))
                    System.out.println("Player 1 (Red) won the game.");
                else if (winner.equals("Y"))
                    System.out.println("Player 2 (Yellow) won the game.");
                loop = false;
            }
        }
    }
}
