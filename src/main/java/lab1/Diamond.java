package lab1;

import java.util.Scanner;

/**
 * Diamond!
 */
public class Diamond {

    // This is where the program begins
    public static void main(String[] args) {
        int length = getLength();
        printDiamond(length);
    }

    public static int getLength() {
        Scanner scan = new Scanner(System.in);  // Scanner object will read from the System.in (the keyboard)

        int length = 0; // must be odd

        boolean first = true;
        boolean wrongType = false;
        do {
            if (!first) {   // do not check for errors the first iteration
                System.out.print("Error! ");
                if (wrongType) {
                    System.out.print("Input was not an integer!");
                    wrongType = false;
                } else if (length > 19) {
                    System.out.print("Length too large!");
                } else if (length < 1) {
                    System.out.print("Length too small!");
                } else if (length % 2 != 1) {
                    System.out.print("Input not odd!");
                } else {
                    System.out.print("Unknown Error!");
                }
                System.out.println(" Try Again");
            }

            System.out.print("Please enter an odd number between 1 and 19: ");
            first = false;

            try {
                length = scan.nextInt();    // read an integer from the scanner
            } catch (Exception e) {
                length = 0;
                wrongType = true;
                scan.nextLine();    // this will discrad the bad input since nextInt() did not read it
            }

        } while (length % 2 != 1 || length < 1 || length > 19); // if not odd or out of bounds keep looping
        return length;
    }

    // this function assume that length is odd
    public static void printDiamond(int length) {
        for (int i = 0; i < length; i++) {	// row loop (this loop is responsible for printing a row each iteration)
            for (int j = 0; j < length; j++) {	// print loop (this loop is responsible for printing a character each iteration)
                if (shouldPrintSpace(i, j, length)) {	// shouldPrintSpace() is true when we should print a space
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.print("\n");	//print new line
        }
    }

    // this function assumes length is odd and row and col are positive and less than length
    public static boolean shouldPrintSpace(int row, int col, int length) {
        int middle = length / 2;  // assumes length is odd (this is integer division)

        // these if statements reduce this problem to solving just the top left quadrant
        // the -1 is because the length parameter is not 0 indexed think of it like a unit conversion
        if(row < middle){   // upper half
            if(col < middle){   // left side
                //  do nothing for top left quadrant
            }else{
                col = length - col - 1; // flip about the middle row for bottom left quadrant
            }   
        }else{
            if(col < middle){   // left side
                row = length - row - 1; // flip about the middle column for top right quadrant
            }else{
                row = length - row - 1; // flip about the middle column for bottom right quadrant
                col = length - col - 1; // flip about the middle row for bottom right quadrant
            }   
        }

        return col + row < middle;  // return true if the row + col is less than middle
    }
}
