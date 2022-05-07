import java.util.Arrays;

public class Data
{
    /** Fills all elements of grid with randomly generated values, 
     *  as described in part (a) 
     *  Precondition: grid is not null.
     *      grid has at least one element.
     */
    // part (a)
    public void repopulate()
    {
        for(int r = 0; r < grid.length; r++)
            for(int c = 0; c < grid[0].length; c++)
            {
                /* there's certainly a better way */
                while(true) {
                    int i = (int) ((Math.random()*MAX) + 1);
                    if(i % 10 == 0 && i % 100 != 0) {
                        grid[r][c] = i;
                        break;
                    }
                }

            }
    }

    /** Returns the number of columns in grid that are in increasing order, 
     *  as described in part (b)
     *  Precondition: grid is not null.
     *      grid has at least one element.
     */
    // part (b)
    public int countIncreasingCols()
    {
        int count = 0;
        for(int c = 0; c < grid[0].length; c++)
        {
            if(grid.length == 1)
                count++;
            else
                for(int r = 1; r < grid.length; r++)
                    {
                        if(grid[r][c] < grid[r-1][c])
                            break;
                        if(r == grid.length - 1)
                            count++;
                    }
        }
        return count;
    }

    // scaffolding
    public static int MAX; // is final in problem specs
    private int[][] grid;

    public Data(int r, int c, int max) {
        grid = new int[r][c];
        MAX = max;
    }

    public Data(int[][] g, int max) {
        grid = g;
        MAX = max;
    }

    public static void main(String[] args) {

        Data d = new Data(5, 5, 1000);
        d.repopulate();
        System.out.println("Generated grid:");
        System.out.println(Arrays.deepToString(d.grid));
        
        int[][] g = {{10, 50, 40}, {20, 40, 20}, {30, 50, 30}};
        d = new Data(g, 100);
        System.out.println("d.countIncreasingCols() should be 1: " +
                           d.countIncreasingCols());

        g = new int[][] {{10, 540, 440, 440}, {220, 450, 440, 190}};
        d = new Data(g, 1000);
        System.out.println("d.countIncreasingCols() should be 2: " +
                           d.countIncreasingCols());
        g = new int[][] {{10, 0, 20, 0}};
        d = new Data(g, 100);
        System.out.println("d.countIncreasingCols() should be 4: " +
                           d.countIncreasingCols());
    }
}
