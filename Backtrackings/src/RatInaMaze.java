public class RatInaMaze {


    public static boolean isSafe(int[][] maze, int x, int y) {
        return(x>=0 && y>=0 && x < maze.length && y < maze.length && maze[x][y] == 1);
    }
    public static boolean ratInAMaze(int maze[][], int x, int y, int sol[][]){

        if (x == maze.length-1 && y == maze.length-1 && maze[x][y] == 1){
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)){
            if (sol[x][y] == 1){
                return false;
            }
            sol[x][y] = 1;
            if (ratInAMaze(maze, x+1, y, sol)){
                return true;
            }
            if (ratInAMaze(maze, x, y+1, sol)){
                return true;
            }
            return false;
        }
        return false;
    }

    public static void printSolution(int sol[][]){
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(sol[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean solveMaze(int maze[][]) {

        int N = maze.length;
        int sol[][] = new int[N][N];

        if (ratInAMaze(maze,0,0,sol) == false){
            System.out.println("Solution doesn't exist");
            return false;
        }
        printSolution(sol);
        return true;
    }
    public static void main(String[] args) {
        int maze[][] = {
                {1,0,0,0},
                {1,1,0,1},
                {0,1,0,0},
                {1,1,1,1}
        };
        solveMaze(maze);
    }
}
