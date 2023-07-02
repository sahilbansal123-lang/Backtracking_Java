import java.util.Scanner;

public class NKnightsProblem {
    



        public static void printBoard(int board[][]) {
            System.out.println("-------Chess Board----------");
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public static void nKnights(int board[][], int r, int c, int move) {
            int n = board.length;

            if (r < 0 || c < 0 || r >= n || c >= n || board[r][c] > 0) {
                return;
            } else if (move == n * n) {
                board[r][c] = move;
                printBoard(board);
                board[r][c] = 0;
                return;
            }

            board[r][c] = move;
            nKnights(board, r - 2, c + 1, move + 1);
            nKnights(board, r - 1, c + 2, move + 1);
            nKnights(board, r + 1, c + 2, move + 1);
            nKnights(board, r + 2, c + 1, move + 1);
            nKnights(board, r + 2, c - 1, move + 1);
            nKnights(board, r + 1, c - 2, move + 1);
            nKnights(board, r - 1, c - 2, move + 1);
            nKnights(board, r - 2, c - 1, move + 1);
            board[r][c] = 0;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the size of the chessboard: ");
            int n = sc.nextInt();
            System.out.print("Enter the starting row: ");
            int r = sc.nextInt();
            System.out.print("Enter the starting column: ");
            int c = sc.nextInt();
            int board[][] = new int[n][n];

            nKnights(board, r, c, 1);
        }


}
