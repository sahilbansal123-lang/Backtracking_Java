public class SudokuSolve {

    private static boolean isSafe(int[][] sudoku, int row, int col, int dizit) {

        // col
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == dizit){
                return false;
            }
        }
        // row
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == dizit){
                return false;
            }
        }
        // grid
        int sR = (row/3)*3;
        int sC = (col/3)*3;
        for (int i = sR; i < sR + 3 ; i++) {
            for (int j = sC; j < sC+3; j++) {
                if (sudoku[i][j] == dizit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int sudoku[][], int row, int col){

        // Base case
        if (row == 9 ) {
            return true;
        }
        // Recursion

        int nextRow = row;
        int nextCol = col+1;
        if (col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int dizit = 1; dizit <= 9; dizit++){
           if(isSafe(sudoku, row, col, dizit)){
               sudoku[row][col] = dizit;
               if(sudokuSolver(sudoku, nextRow, nextCol)){
                return true;
               }
               sudoku[row][col] = 0;
           }
        }
        return false;
    }


    public static void printSudoku(int sudoku[][]){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] sudoku = {
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };
        if (sudokuSolver(sudoku, 0, 0)){
            System.out.println("solution exist");
            printSudoku(sudoku);
        } else {
            System.out.println("solution does not exist");
        }
    }
}
