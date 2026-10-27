/** Required package class namespace */
package unit2Methods;

import javax.swing.JOptionPane;

/*
 * AndreiKarginHouseBuilder - program to print a house based on base input
 * 
 * @author Andrei
 * @since Oct 8, 2026
 */
public class AndreiKarginHouseBuilder {

    //method to ask for an input and return a base int
    public static int input() {

        //declaring variabels for input and base to return later
        String input;
        int base = -1;

        //keeps trying to get a valid base until one is received
        do {
            //sets input to input dialog return
            input = JOptionPane.showInputDialog(null,
                    "Input an even base",
                    "House Builder",
                    1);

            //if x or cancel was pressed quits
            if (input == null) {
                System.exit(0);
            }

            //trys to take an int from the input string and take absolute value
            try {
                base = Math.abs(Integer.parseInt(input));
            } catch (Exception e) {

                //if theres was an error shows error message 
                JOptionPane.showMessageDialog(null,
                        "Invalid Input",
                        "House Builder",
                        2);
            }

            //if base is odd shows error and resets base to an invalid value
            if (base % 2 == 1) {
                base = -1;
                JOptionPane.showMessageDialog(null,
                        "Base must be even",
                        "House Builder",
                        2);
            }

        } while (base == -1);

        //returns base int
        return base;
    }

    //method to build a roof with base as parameter
    public static void roof(int base) {

        //i is rows of roofs requiered starting from the top at 0
        for (int i = 0; i < base / 2; i++) {

            //prints spaces depending on i before leftmost roof piece
            for (int j = 1; j < base / 2 - i; j++) {
                System.out.print(" ");
            }

            //prints roof piece
            System.out.print("/");

            //prints spaces between the roof pieces
            for (int j = 0; j <= 2 * i - 1; j++) {

                //if its the last line of roof print underscores
                if (i == base / 2 - 1) {
                    System.out.print("_");
                } //else print spaces
                else {
                    System.out.print(" ");
                }
            }
            //prints last roof piece and newline
            System.out.print("\\\n");
        }
    }

    //method to build the house part
    public static void house(int base) {

        //i is the row of house starting from the top adn at 0
        for (int i = 0; i < base / 2; i++) {

            //prints left wall
            System.out.print("|");

            //prints 2 less spaces than the base because of the 2 walls
            for (int j = 0; j < base - 2; j++) {

                //if its the last row prints underscores
                if (i == base / 2 - 1) {
                    System.out.print("_");
                } //else prints spaces
                else {
                    System.out.print(" ");
                }
            }

            //prints right wall and newline
            System.out.print("|\n");
        }
    }

    //method to build a walkway
    public static void walk(int base) {

        //makes spaces left of walkway 1 less than half of base
        for (int i = 0; i < base / 2 - 1; i++) {
            System.out.print(" ");
        }

        //prints walkway next to house
        System.out.print("**\n");

        //prints spaces left of walkway 1 less than half of base
        for (int i = 0; i < base / 2 - 1; i++) {
            System.out.print(" ");
        }

        //prints walkway the length of base
        for (int i = 0; i < base; i++) {
            System.out.print("*");
        }

        //spaces out the houses
        System.out.println("\n");
    }

    //method to ask to play again
    public static void playAgain() {

        //declares return variable and sets it to return of confirm dialog
        int confirmReturn = JOptionPane.showConfirmDialog(null,
                "Do you wish to build another house?",
                "House Builder",
                JOptionPane.YES_NO_OPTION,
                3);

        //confirm dialog returns 0 if yes was pressed so if its not 0 quits
        if (confirmReturn != 0) {
            System.exit(0);
        }
    }

    //main method
    public static void main(String[] args) {
        //declaring base variable
        int base;

        //loops the main program
        while (true) {
            //calls input and sets base to return
            base = input();

            //calls house building functions with base as an argument
            roof(base);
            house(base);
            walk(base);

            //calls playAgain function to ask to build another house
            playAgain();
        }
    }
}
