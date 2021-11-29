
// A simple Java program to implement Game of Life 
public class Cell
{
    public static void main(String[] args)
    {
        int x = 7, y = 7;

        int[][] grid = {
                { 1, 0, 0, 1, 0, 0, 0},
                { 1, 0, 0, 1, 0, 0, 0},
                { 1, 0, 0, 1, 0, 0, 0},
                { 1, 0, 0, 1, 0, 0, 0},
                { 1, 0, 0, 1, 0, 0, 0},
                { 1, 0, 0, 1, 0, 0, 0},
                { 1, 0, 0, 1, 0, 0, 0}
        };

        System.out.println("första ");
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid, x, y);
    }

    static void nextGeneration(int grid[][], int x, int y)
    {
        int[][] future = new int[x][y];

        for (int l = 1; l < x - 1; l++)
        {
            for (int m = 1; m < y - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];

                aliveNeighbours -= grid[l][m];


                // ensam cell
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;

                    // överpopulation
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;

                    // ny cell
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;

                    // samma
                else
                    future[l][m] = grid[l][m];
            }
        }

        System.out.println("andra");
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                if (future[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}