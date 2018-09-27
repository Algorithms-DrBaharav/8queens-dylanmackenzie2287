import java.util.Arrays;
/**
 * Solves 8-Queens problem
 *
 * How to place 8-queens on a chess board such that none can capture another.
 *
 *
 * The function solve() return the board for display.
 *
 * @author Dr. Baharav
 */
public class Solver8x8 {

    int[] a;

    // Board representation
    // Initialize all to empty
    public Solver8x8() {
        a = new int[8];

                
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
    }

    /**
     *
     * @return int[][] - Board - 2D array, with 1 representing a queen, and 0
     * represents NO queen (aka empty square)
     *
     */
   
    
    public int[][] solve() {
        while (!legal()) {
            nextBoard();
            //dPrintBoard();
            
            
            
        }
        int[] temp = a;
        
        return b2board();
    }
    /*public void dPrintBoard(){
        for(int i =0; i<7; i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
    */
    public boolean legal() {
        for (int t = 0; t < a.length; t++) {
            for (int i = 0; i < 8; i++) {
                if (t == i) {
                    continue;
                }
                if (a[t] == a[i]) {
                    return false;
                }

            }
        }
        for (int ii = 0; ii < 7; ii++) {
            int temp = a[ii];
            for (int y = ii+1; y < 8; y++) {
                if ((temp - (a[y] + (y - ii))) == 0) {
                    return false;
                }
                if ((temp - (a[y] - (y - ii))) == 0) {
                    return false;
                }
            }
        }
        return true;

    }

    public void nextBoard() {

        for (int ii = 0; ii < a.length; ii++) {
            if (a[ii] != 7) {
                a[ii]++;
                return;
            } else {
                a[ii] = 0;

            }
        }
        //a = null;
    }

    /*
    
    UTILITY methods below
    
     */
    //  Convert into a 2D representation.
    //  Used to communicate out. For display. Simple 8x8 array
    //      bDisplay[ii][jj] is square [ii][jj] on the board.
    //      content of cell: 1 is Queen present, 0 is empty cell.

    private int[][] b2board() {
        int[][] br = new int[8][8];
        for (int ii = 0; ii < 8; ++ii) {
            for (int jj = 0; jj < 8; ++jj) {
                br[ii][jj] = 0;
            }
        }

        for (int ii = 0; ii < 8; ++ii) {
            br[a[ii]][ii] =1;
        }

        // Just if you want intermediate printouts, see how it works
        printBoard(br);

        return br;
    }

    private void printBoard(int[][] b) {
        System.out.println("Board");

        for (int cc = 0; cc < 8; ++cc) {
            System.out.print("+-");
        }
        System.out.println("+");

        for (int rr = 0; rr < 8; ++rr) {
            for (int cc = 0; cc < 8; ++cc) {
                if (b[rr][cc] == 1) {
                    System.out.format("|*");
                } else {
                    System.out.format("| ");
                }
            }
            System.out.println("|");

            for (int cc = 0; cc < 8; ++cc) {
                System.out.print("+-");
            }
            System.out.println("+");
        }

    }

}
