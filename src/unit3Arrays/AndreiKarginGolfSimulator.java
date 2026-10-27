/** Required package class name space */
package unit3Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;

/*
 * AndreiKarginGolfSimulator - 
 * program to make a table of scores and find winners
 * 
 * @author Andrei
 * @since Oct 14, 2026
 */
public class AndreiKarginGolfSimulator {

    //declaration of final global variables
    public static final Font FONT = new Font("Consolas", Font.PLAIN, 12);
    public static final int HOLES = 9;
    public static final int PLAYERS = 4;
    public static final String TITLE = "Golf Simulator";
    public static final String PLAYGOLF = "Play a round of golf";
    public static final String FINDWINNER = "Find the winer of a hole";
    public static final String QUIT = "Quit";
    public static final String[] CHOICES = {PLAYGOLF, FINDWINNER, QUIT};

    //global matrix for scores
    public static int[][] golfScore = new int[PLAYERS][HOLES];

    /**
     * randomizes global int matrix golfScore between low and high values
     */
    public static void playGolf() {
        //final variables
        final int HIGH = 10;
        final int LOW = 1;

        //generates random int between HIGH and LOW                
        //loops through the matrix randomising every element
        for (int player = 0; player < PLAYERS; player++) {
            for (int hole = 0; hole < HOLES; hole++) {

                //generates a random int between high and low
                int randomScore = (int) (Math.random() * (HIGH - LOW) + LOW);

                //sets the element to the the random number
                golfScore[player][hole] = randomScore;
            }
        }
    }

    /**
     * finds winner of chosen hole in golfScore
     *
     * @param hole hole number for which to find winner
     * @return int[0] -> -1 if tie, player number counting from 0 int[1] ->
     * lowest score int
     */
    public static int[] findWinner(int hole) {

        //variables        
        int bestScore = 10;
        int bestPlayer = -1;
        boolean tie = false;
        int[] findWinnerResult = new int[2];

        //loops through the player scores for the given hole
        for (int player = 0; player < PLAYERS; player++) {

            if (golfScore[player][hole] < bestScore) {
                //if the players score is lower than previous best score sets 
                //new best score, best player, and tie to false
                bestScore = golfScore[player][hole];
                bestPlayer = player;
                tie = false;
            } else if (golfScore[player][hole] == bestScore) {
                //when players score is the same as best score sets tie to true
                tie = true;
            }
        }

        //sets bestplayer to -1 to indicate a tie
        if (tie) {
            bestPlayer = -1;
        }

        //sets the two values in the array to return to player and score
        findWinnerResult[0] = bestPlayer;
        findWinnerResult[1] = bestScore;

        //return array with best player and score
        return findWinnerResult;
    }

    /**
     * displays the winner of the hole with the score shows hole and score for
     * tie when winner is -1
     *
     * @param findWinnerResult array with result from findWinner function
     * @param score the score with which the hole was won
     */
    public static void displayWinner(int[] findWinnerResult, int hole) {
        //declaring variable
        final int WINNER = findWinnerResult[0];
        final int SCORE = findWinnerResult[1];

        String message = "";

        if (WINNER == -1) {
            //if there was a tie
            message = "Tie of score " + SCORE + " on hole " + hole;
        } else {
            //if there was a winner
            message = "Player " + (WINNER + 1) + " won with a score of " + SCORE + " on hole " + (hole + 1);
        }

        //outputs message 
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * takes input for which hole to find the winner of
     *
     * @return a hole number counting from 0
     */
    public static int holeInput() {
        //variables
        String input;
        int hole = -1;

        //takes an input at least once until a valid one is received
        do {
            //input dialog
            input = JOptionPane.showInputDialog("Input hole number");

            //if x or cancel was pressed returns -1
            if (input == null) {
                return -1;
            }

            //trys taking an int from the string, if it cant sets hole to -1
            try {
                hole = Integer.parseInt(input) - 1;
            } catch (Exception e) {
                hole = -1;
            }

            //if hole is not within the boundaries sets it back to -1
            if (hole < 0 || hole > HOLES - 1) {
                JOptionPane.showMessageDialog(null, "input a number between 1 and 9");
                hole = -1;
            }

        } while (hole == -1);

        //return hole number
        return hole;
    }

    /**
     * shows message and closes the program
     */
    public static void quit() {
        JOptionPane.showMessageDialog(
                null,
                "Thanks for playing golf");

        //closes program
        System.exit(0);
    }

    /**
     * displays the golf score and returns the option the user selected
     *
     * @return Object from global array CHOICES based on user selection
     *
     */
    public static Object displayGolfScore() {
        //variables   
        String table = makeTable();
        String message = table + "\n\nWhat do you want to do?";

        //displays table and message then gets option user selected
        Object choice = JOptionPane.showInputDialog(
                null,
                formatArea(message),
                TITLE,
                1,
                null,
                CHOICES,
                PLAYGOLF);

        //returns users choice
        return choice;
    }

    /**
     * makes a table from values of golfScore as a string to display later
     *
     * @return String with the table of golf scores
     */
    public static String makeTable() {
        //String with space
        String scoreTable = "          ";

        //loops through the number of holes and adds "hole #" to the table string
        for (int i = 1; i <= HOLES; i++) {
            scoreTable = scoreTable + "Hole " + i + "  ";
        }

        //newline in scoretable
        scoreTable = scoreTable + "\n";

        //loops through players in matrix
        for (int player = 0; player < PLAYERS; player++) {

            //adds "player #" to table wiht space
            scoreTable = scoreTable + "\nPlayer " + (player + 1) + ":    ";

            //loops through holes for each player and adds the score with space
            for (int hole = 0; hole < HOLES; hole++) {
                scoreTable = scoreTable + golfScore[player][hole] + "       ";
            }
        }

        //returns scoreTable String
        return scoreTable;
    }

    /**
     * formats area to have proper font, text, and cant be edited
     *
     * @param text text to add to the area
     * @return JTextArea with global Font FONT and cant be edited by user
     */
    private static JTextArea formatArea(String text) {

        //creates new jTextArea
        JTextArea area = new JTextArea();

        //passes arguments to area
        area.setFont(FONT);
        area.setText(text);
        area.setEditable(false);

        //returns for display
        return area;
    }

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variable        
        int hole;

        //main loop
        while (true) {
            //switch statement of display golf score return as a string
            switch (displayGolfScore().toString()) {
                
                //if user selected playgolf
                case PLAYGOLF -> {
                    playGolf();
                }
                //if user selcted find winner
                case FINDWINNER -> {
                    //calls holeInput, if window was closed returns -1
                    hole = holeInput();
                    
                    //passes hole number to display and find winner
                    //if -1 was returned from holeInput should do nothing to 
                    //loop back to score display
                    if (hole!=-1){                      
                        displayWinner(findWinner(hole), hole);
                    }
                }
                //if user selected quit
                case QUIT -> {
                    quit();
                }
                //hopefully wont appear
                default -> {
                    JOptionPane.showMessageDialog(null, "Hopefully this doesnt appear");
                }
            }                        
        }
    }
}
