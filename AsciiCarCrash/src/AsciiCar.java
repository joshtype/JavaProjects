/**
 * Creates a char grid for an ascii car facing right, reverses it in a new grid,
 * prints both grids separately, then prints both together with rows on the same
 * lines, as if the cars were colliding.
 * @author Joshua Gregory (Jan. 2025)
 */
public class AsciiCar {

    // Driver
    public static void main(String[] args) {
        char[][] rightCar = asciiCarFacingRight();     // set to primary grid
        char[][] leftCar = reverseCharGrid(rightCar);  // set to reversed grid

        printCharGrid(rightCar);                       // print each grid separately
        printCharGrid(leftCar);

        System.out.println("\n" + "         SCREECH!!");
        printTwoCharGrids(rightCar, leftCar);          // print grids with rows on same lines
    }

    /**
     * Creates a 4x13 char grid that stores chars for an ascii car facing right.
     * @return carGrid char[][]
     */
    public static char[][] asciiCarFacingRight() {
        char[][] carGrid = new char[4][13];  // faces right
        carGrid[0][0]=' ';    // row 0
        carGrid[0][1]=' ';
        carGrid[0][2]='_';
        carGrid[0][3]='_';
        carGrid[0][4]='_';
        carGrid[0][5]='_';
        carGrid[0][6]='_';
        carGrid[0][7]='_';
        carGrid[0][8]=' ';
        carGrid[0][9]=' ';
        carGrid[0][10]=' ';
        carGrid[0][11]=' ';
        carGrid[0][12]=' ';
        carGrid[1][0]=' ';    // row 1
        carGrid[1][1]='/';
        carGrid[1][2]='|';
        carGrid[1][3]='_';
        carGrid[1][4]='|';
        carGrid[1][5]='|';
        carGrid[1][6]='_';
        carGrid[1][7]='\\';
        carGrid[1][8]='\'';
        carGrid[1][9]='.';
        carGrid[1][10]='_';
        carGrid[1][11]='_';
        carGrid[1][12]=' ';
        carGrid[2][0]='(';    // row 2
        carGrid[2][1]=' ';
        carGrid[2][2]=' ';
        carGrid[2][3]=' ';
        carGrid[2][4]='_';
        carGrid[2][5]=' ';
        carGrid[2][6]=' ';
        carGrid[2][7]=' ';
        carGrid[2][8]=' ';
        carGrid[2][9]='_';
        carGrid[2][10]=' ';
        carGrid[2][11]='_';
        carGrid[2][12]='\\';
        carGrid[3][0]='=';    // row 3
        carGrid[3][1]='\'';
        carGrid[3][2]='-';
        carGrid[3][3]='(';
        carGrid[3][4]='_';
        carGrid[3][5]=')';
        carGrid[3][6]='-';
        carGrid[3][7]='-';
        carGrid[3][8]='(';
        carGrid[3][9]='_';
        carGrid[3][10]=')';
        carGrid[3][11]='-';
        carGrid[3][12]='\'';
        return carGrid;
    }

    /**
     * Returns a char grid with cells reversed from input grid.
     * @param inpGrid any char grid/matrix/2d array
     * @return revGrid char[][]
     */
    public static char[][] reverseCharGrid(char[][] inpGrid) {
        int r = inpGrid.length, c = inpGrid[0].length;  // get num rows & cols
        char[][] revGrid = new char[r][c];              // for reversed chars

        // loop through jth col of ith row
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char origCell = inpGrid[i][c - 1 -j];          // curr char in input grid

                if (origCell == '(') revGrid[i][j] = ')';      // replace with mirror char
                else if (origCell == ')') revGrid[i][j] = '(';
                else if (origCell == '[') revGrid[i][j] = ']';
                else if (origCell == ']') revGrid[i][j] = '[';
                else if (origCell == '{') revGrid[i][j] = '}';
                else if (origCell == '}') revGrid[i][j] = '{';
                else if (origCell == '\\') revGrid[i][j] = '/';
                else if (origCell == '/') revGrid[i][j] = '\\';
                else { revGrid[i][j] = origCell; }
            }
        }
        return revGrid;
    }

    /**
     * Prints to console an input char grid.
     * @param inpGrid any char grid/matrix/2d array
     */
    public static void printCharGrid(char[][] inpGrid) {
        int r = inpGrid.length, c = inpGrid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(inpGrid[i][j]);
            }
            System.out.println();  // finish line
        }
    }

    /**
     * Prints to console two input char grids with rows on same lines.
     * @param gridA any char grid/matrix/2d array
     * @param gridB of same dimensions as gridA
     */
    public static void printTwoCharGrids(char[][] gridA, char[][] gridB) {
        int r = gridA.length, c = gridA[0].length;

        if (r != gridB.length || c != gridB[0].length) {
            System.out.print("Input grids must have same dimensions.");
            return;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(gridA[i][j]);
            }
            System.out.print(" ");  // space between cells
            for (int j = 0; j < c; j++) {
                System.out.print(gridB[i][j]);
            }
            System.out.println();  // finish line
        }
    }
}