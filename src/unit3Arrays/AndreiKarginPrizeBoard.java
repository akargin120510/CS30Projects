/** Required package class namespace */
package unit3Arrays;

import javax.swing.JOptionPane;


/*
 * AndreiKarginPrizeBoard - description
 * 
 * @author Andrei
 * @since Oct 22, 2026
 */
public class AndreiKarginPrizeBoard {

    public static final int ROWAMOUNT = 4;
    public static final int COLUMNAMOUNT = 5;

    public static final int NOTHING = 0;
    public static final int COMP = 1;
    public static final int UTER = 2;
    public static final int NOTHINGGUESS = 3;
    public static final int COMPGUESS = 5;
    public static final int UTERGUESS = 6;

    public static final String MAKEGUESS = "Make a Guess";
    public static final String NEWGAME = "Start a New Game";
    public static final String QUIT = "Quit";
    public static final String[] ACTIONS = {MAKEGUESS, NEWGAME, QUIT};

    public static final int MAXGUESSAMOUNT = ROWAMOUNT * COLUMNAMOUNT / 2;

    public static int guessAmount = MAXGUESSAMOUNT;

    public static boolean gotComp = false;
    public static boolean gotUter = false;

    public static int[][] prizeBoard = new int[ROWAMOUNT][COLUMNAMOUNT];

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] guess;

        welcomeMessage();
        newGame();

        while (true) {
            checkWin();
            checkLoss();

            switch (actionInput().toString()) {
                case MAKEGUESS -> {
                    guess = guessInput();

                    if (guess != null) {
                        guessResult(guess);
                        guessAmount--;
                    }
                }
                case NEWGAME -> {
                    newGame();
                }
                case QUIT -> {
                    quitMessage();
                }
            }
        }
    }

    private static void newGame() {
        guessAmount = MAXGUESSAMOUNT;

        int[] compLocation;
        int[] uterLocation;

        compLocation = randomLocation();

        do {
            uterLocation = randomLocation();
        } while (compLocation == uterLocation);

        prizeBoard[compLocation[0]][compLocation[1]] = COMP;
        prizeBoard[uterLocation[0]][uterLocation[1]] = UTER;
    }

    private static int random(final int HIGH) {
        return (int) (Math.random() * (HIGH - 1) + 1);
    }

    private static int[] randomLocation() {
        int[] location = {random(ROWAMOUNT), random(COLUMNAMOUNT)};
        return location;
    }

    private static int[] guessInput() {
        final int INVALID = -1;
        int[] guess = {-1, -1};        
        String input;

        for (int i = 0; i < 2; i++) {

            do {
                //ternary operator (condition? true : false)
                input = JOptionPane.showInputDialog("Input " + (i == 0 ? "row" : "column") + " for guess");

                try {
                    guess[i] = Integer.parseInt(input) -1;
                } catch (Exception e) {
                    guess[i] = INVALID;
                }

                if (input == null) {
                    return null;
                }

                if (guess[i] < 0 || guess[i] >= (i == 0 ? ROWAMOUNT : COLUMNAMOUNT)) {
                    guess[i] = INVALID;
                }

                if (guess[i] == INVALID) {
                    JOptionPane.showMessageDialog(null, "please input a valid guess number");
                }

            } while (guess[i] == INVALID);
        }
        return guess;
    }

    private static Object actionInput() {
        String board = makeBoard();
        String message = "";
        
        
        Object action = JOptionPane.showInputDialog(
                null,
                "action input",
                null,
                JOptionPane.OK_CANCEL_OPTION,
                null,
                ACTIONS,
                MAKEGUESS);

        if (action == null) {
            quitMessage();
        }

        return action;
    }

    private static void welcomeMessage() {
        JOptionPane.showMessageDialog(null, "Welcome");
    }

    private static void winMessage() {
        JOptionPane.showMessageDialog(null,
                "you won in " + guessAmount + " guesses");
    }

    private static void lossMessage() {
        JOptionPane.showMessageDialog(null,
                "sorry you're out of guesses. here is the solution");
    }

    private static void quitMessage() {
        JOptionPane.showMessageDialog(null, "Thank you, Goodbye");
        System.exit(0);
    }

    private static void checkWin() {
        if (gotComp && gotUter) {
            winMessage();
            newGame();
        }
    }

    private static void checkLoss() {
        if (guessAmount <= 0) {
            lossMessage();
            newGame();
        }
    }

    private static void guessResult(int[] guess) {
        String message = "";

        switch (prizeBoard[guess[0]][guess[1]]) {
            case COMP -> {
                prizeBoard[guess[0]][guess[1]] = COMPGUESS;
                message = "You guessed the first part \"COMP\"";
            }
            case UTER -> {
                prizeBoard[guess[0]][guess[1]] = UTERGUESS;
                message = "You guessed the second part \"UTER\"";
            }
            case NOTHING -> {
                prizeBoard[guess[0]][guess[1]] = NOTHINGGUESS;
                message = "There is nothing here";
            }
            case COMPGUESS -> {
                message = "You already guessed here and found \"COMP\"";
            }
            case UTERGUESS -> {
                message = "You already guessed here and found \"UTER\"";
            }
            case NOTHINGGUESS -> {
                message = "You already guessed here and found nothing";
            }
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private static String makeBoard() {
        return "";
    }
}
