/** Required package class namespace */
package unit3Arrays;

import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextArea;

/*
 * AndreiKarginStonesPebbles - stones and pebbles game, random array of numbers,
 * move forward on odd numbers, backward on even numbers.
 * 
 * @author Andrei
 * @since Oct 30, 2026
 */
public class AndreiKarginStonesPebbles {

    //title for dialog boxes
    public static final String TITLE = "Stones And Pebbles";
    public static final int CLOSED = -1;

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variables
        int stoneAmount = 0;
        int[] pebbles;

        //calls welcome
        welcome();

        //runs until user decides to close
        do {
            //takes a stone input for amount of stones
            stoneAmount = stoneInput();

            //if stoneinput didnt return -1 closed option
            if (stoneAmount != CLOSED) {

                //randomly generates pebbles
                pebbles = makePebbles(stoneAmount);
                           
                //displays pebbles with a message
                display(pebbles, stoneAmount);
            }
        } while (playAgain());

        //calls quit
        quit();
    }

    /**
     * shows welcome message
     */
    private static void welcome() {
        //message
        final String MESSAGE = "Welcome!";

        //shows message
        JOptionPane.showMessageDialog(
                null,
                MESSAGE,
                TITLE,
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * shows message when quitting
     */
    private static void quit() {
        //message
        final String MESSAGE = "Thank You, Goodbye";

        //shows message
        JOptionPane.showMessageDialog(
                null,
                MESSAGE,
                TITLE,
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * asks to play again
     *
     * @return boolean, if true play again, if false don't play again
     */
    private static boolean playAgain() {
        //message
        final String MESSAGE = "Play Again";

        //shows message and gets option selected
        int playAgainOption = JOptionPane.showConfirmDialog(
                null,
                MESSAGE,
                TITLE,
                JOptionPane.YES_NO_OPTION);

        //returns true if option selected was yes
        return playAgainOption == JOptionPane.YES_OPTION;
    }

    /**
     * takes and input for the amount of stones
     *
     * @return integer for length of pebbles array/amount of stones
     */
    private static int stoneInput() {
        //constants
        final int MAXSTONES = 10;
        final int MINSTONES = 3;
        final int INVALID = 0;

        //variables
        String message = "";
        String input = "";
        int stoneAmount = INVALID;

        //keeps running until a valid input is received
        do {
            //takes input string
            input = JOptionPane.showInputDialog(
                    null,
                    message + "Input stone amount",
                    TITLE,
                    JOptionPane.PLAIN_MESSAGE);

            //if window was closed and null returned returns -1/closed option
            if (input == null) {
                return CLOSED;
            }

            //trys to take int from string
            try {
                stoneAmount = Integer.parseInt(input);
            } catch (Exception e) {
                stoneAmount = INVALID;
            }

            //if too many or too few stones were inputted resets stoneAmount
            if (stoneAmount < MINSTONES || stoneAmount > MAXSTONES) {
                //adds a message saying previous input was invalid for next pass
                message = "Sorry you cant have " + stoneAmount + " stones\n\n";
                stoneAmount = INVALID;
            }

            //until valid stone amount is received
        } while (stoneAmount == INVALID);

        //returns stone amount
        return stoneAmount;
    }

    /**
     * randomizes an int array
     *
     * @param STONEAMOUNT length of array to randomize
     * @return int array with random values
     */
    private static int[] makePebbles(final int STONEAMOUNT) {
        int[] pebbles = new int[STONEAMOUNT];

        for (int i = 0; i < STONEAMOUNT; i++) {
            pebbles[i] = random();
        }

        return pebbles;

    }

    /**
     * makes a random int
     *
     * @return random int between high and low constants
     */
    private static int random() {
        //high and low constants
        final int MAX = 10;
        final int MIN = 3;

        //returns random number between low and high
        return (int) (Math.random() * (MAX - MIN) + MIN);
    }

    /**
     * calculates result of game and returns the proper message
     *
     * @param PEBBLES int array with pebbles amounts for each stone
     * @param STONES length of pebbles array
     * @return string with message depending on game result
     */
    private static String result(final int[] PEBBLES, final int STONES) {
        //constant messages
        final String WINMESSAGE = "Mr. Wachs won!";
        final String LOSSMESSAGE = "The student lost!";
        final String LOOPMESSAGE = "The student got stuck in a loop and lost!";

        //position variable
        int position = 0;

        //repeats the length of the array times. if no result is achived then 
        //there was a loop since at least a stone was visited twice.
        for (int i = 0; i < STONES; i++) {

            if (isEven(PEBBLES[position])) {
                //moves back if pebble amount at stone was even
                position -= PEBBLES[position];
            } else {
                //moves forward if pebble amount at stone was odd
                position += PEBBLES[position];
            }

            //if student moved farther back then the start, returns loss message
            if (position < 0) {
                return LOSSMESSAGE;
            } //else if got to last stone or farther returns win message
            else if (position >= (STONES - 1)) {
                return WINMESSAGE;
            }
        }

        //if the entire for loop ran there was a loop so returns proper message
        return LOOPMESSAGE;
    }

    /**
     * checks if number is even
     *
     * @param NUM int to test if its even
     * @return true if even, false if odd
     */
    private static boolean isEven(final int NUM) {
        //if remainder upon division by 2 is 0 returns true otherwise false
        return (NUM % 2) == 0;
    }

    /**
     * makes table string with contents of pebbles as well as lines for looks
     *
     * @param PEBBLES int array with pebble amounts
     * @param STONEAMOUNT length of pebbles array/ amount of stones
     * @return string with contents of pebbles and divisions
     */
    private static String makeTable(final int[] PEBBLES, final int STONEAMOUNT) {

        //adds initial row divider
        String table = makeRowDivider(STONEAMOUNT);

        //adds stones label
        table += "Stones:  |";

        //adds stone numbers with spacing 
        for (int i = 0; i < STONEAMOUNT; i++) {
            table += "    " + (i + 1) + "    |";
        }

        //adds another row divider
        table += "\n" + makeRowDivider(STONEAMOUNT);

        //adds pebbles label
        table += "Pebbles: |";

        //adds coresponding pebble amounts
        //netbeans suggested enhanced for loop and I searched it up on google
        for (final int PEBBLEAMOUNT : PEBBLES) {
            table += "    " + PEBBLEAMOUNT  + "    |";
        }
        
        //adds final row divider        
        table += "\n" + makeRowDivider(STONEAMOUNT);

        //returns string with table
        return table;
    }

    /**
     * makes a row divider for the table depending on length of a row
     * @param STONEAMOUNT length of divider to make
     * @return 
     */
    private static String makeRowDivider(final int STONEAMOUNT) {
        //constant for section of row divider
        final String DIVSECTION = "---------+";
        
        //intial spacing
        String rowDivider = "         +";
        
        //adds section for the length of row divider necessary
        for (int i = 0; i < STONEAMOUNT; i++) {
            rowDivider += DIVSECTION;
        }
        //adds newline
        rowDivider += "\n";
        
        //returns row divider string
        return rowDivider;
    }

    /**
     * formats text into a jTextArea with proper font and size
     * @param TEXT text to format into jTextArea
     * @return 
     */
    private static JTextArea formatArea(final String TEXT) {

        //creates new jTextArea
        JTextArea area = new JTextArea();
        final Font CONSOLAS = new Font(
                "Consolas",
                Font.PLAIN,
                12);

        //passes arguments to area
        area.setFont(CONSOLAS);
        area.setText(TEXT);
        area.setEditable(false);

        //returns for display
        return area;
    }

    /**
     * displays the game and result
     * @param PEBBLES
     * @param STONEAMOUNT 
     */
    private static void display(final int[] PEBBLES, final int STONEAMOUNT) {
        //message to display
        String message = "The stones and pebbles were:\n\n";
       
        //adds table to message
        message += makeTable(PEBBLES, STONEAMOUNT);

        //adds result of game to message
        message += result(PEBBLES, STONEAMOUNT);

        //displays message dialog with return from formatArea
        JOptionPane.showMessageDialog(
                null,
                formatArea(message),
                TITLE,
                JOptionPane.OK_OPTION);
    }
}
