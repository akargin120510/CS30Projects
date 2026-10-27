/** Required package class namespace */
package unit3Arrays;

import javax.swing.JOptionPane;

/*
 * AndreiKarginOptometristChart - program to flip a chart horizontally or 
 * vertically depending on option selected
 * 
 * @author Andrei
 * @since Oct 9, 2026
 */
public class AndreiKarginOptometristChart {

    public static final String VERTFLIP = "Vertical flip";
    public static final String HORFLIP = "Horizontal flip";

    /**
     * takes an input option to flip vertically or horizontally
     *
     * @param original original chart to display
     * @return int, 0 = vertical flip, 1 = horizontal flip
     */
    public static Object input(int[][] original) {
        
        //variables
        String[] options = {VERTFLIP, HORFLIP};
        Object selection;
        String message = makeInputMessage(original);

        //shows input and sets selection to return based on input       
        selection = javax.swing.JOptionPane.showInputDialog(
                null,
                message,
                "Optometrist Chart",
                1,
                null,
                options,
                options[0]);

        //if null returned quits
        if (selection == null) {
            System.exit(0);
        }

        //returns object from input, VERTFLIP or HORFLIP
        return selection;
    }

    /**
     * makes a message from a matrix
     * 
     * @param original original matrix to display
     * @return String input message to display
     */
    public static String makeInputMessage(int[][] original) {
        
        //decalring variable
        String message = "how would you like to flip?\n\n";

        //loops through rows in original, no iterative i
        //netbeans suggested this for loop style and i searched it up
        for (int[] row : original) {

            //loops through elements/columns in the row
            for (int column : row) {

                //adds the element to message
                message = message + column;
            }
            //newline
            message = message + "\n";
        }
        //newline
        message = message + "\n";

        //return string with complete message
        return message;
    }

    /**
     * flips a given matrix horizontally
     *
     * @param original original chart matrix
     * @return flipped chart matrix
     */
    public static int[][] flipHorizontal(int[][] original) {

        //declare matrix for flipped chart
        int[][] flipped = new int[original.length][original[0].length];

        //loops through rows
        for (int row = 0; row < original.length; row++) {

            //loops through columns
            for (int column = 0; column < original[row].length; column++) {

                //takes element on the same column but opposite row
                flipped[row][column] = original[original.length - 1 - row][column];
            }
        }
        return flipped;
    }

    /**
     * flips a given matrix vertically
     *
     * @param original original chart matrix
     * @return flipped chart matrix
     */
    public static int[][] flipVertical(int[][] original) {

        //declare matrix for flipped chart with the same size as the original 
        int[][] flipped = new int[original.length][original[0].length];

        //loops through the rows
        for (int row = 0; row < original.length; row++) {

            //loops through the columns
            for (int column = 0; column < original[row].length; column++) {

                //takes element on the same row but opposite column
                flipped[row][column] = original[row][original[row].length - 1 - column];
            }
        }
        return flipped;
    }

    /**
     * displays the two optometrist charts
     *
     * @param original original chart to display
     * @param flipped flipped chart to display
     */
    public static void display(int[][] original, int[][] flipped) {
        //output string for the message box
        String output = "original chart:\n";

        // enhanced for loop netbeans suggested and i looked up on the internet
        //loops through every int array in original matrix, only read
        for (int[] row : original) {
            //loops through every int column in row array and adds to output
            for (int column : row) {
                output = output + column;
            }

            //new line after every row
            output = output + "\n";
        }

        //text to indicate flipped chart below
        output = output + "\n\nflipped chart:\n";

        // enhanced for loop netbeans suggested and i looked up on the internet
        //loops through every int array in original matrix, only read
        for (int[] row : flipped) {
            //loops through every int column in row array and adds to output
            for (int column : row) {
                output = output + column;
            }

            //new line after every row
            output = output + "\n";
        }

        //displays the output string
        JOptionPane.showMessageDialog(null, output);
    }

    /**
     * main method for the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //declaring variables
        int[][] original = {{1, 2}, {3, 4}};
        int[][] flipped = new int[original.length][original[0].length];
        Object selection = VERTFLIP;

        //program loops until closed
        while (true) {
            //calls input and sets return to option
            selection = input(original);

            //if vertical flip chosen, flipped set to flipVertical return 
            //passing original
            if (selection == VERTFLIP) {
                flipped = flipVertical(original);
            } //else if horizontal chosen, flipped set to flipHorizontal return
            else if (selection == HORFLIP) {
                flipped = flipHorizontal(original);
            }

            //calls display passing original and flipped chart
            display(original, flipped);

            //sets original to flipped for next pass
            original = flipped;
        }
    }
}
