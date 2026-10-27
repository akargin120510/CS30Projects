/** Required package class namespace */
package unit1Intro;

import javax.swing.JOptionPane;
/*
 * GuessingGameAndreiKargin - description
 * 
 * @author Andrei
 * @since Oct 2, 2026
*/
public class GuessingGameAndreiKargin
{
    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    
    public static void main() {
        //Intro Message
        JOptionPane.showMessageDialog(null, "Number Guessing game","Guessing Game",1);
        
        while (true) {
            //declaring variables
            int guessAmount = 0;
            int low = 1;
            int high = 101;
            int guess = 0;
            int previousGuess;
            Character letter = 'z';
            String letterInput;
            boolean correct = false;
            
            //message to think of a number
            JOptionPane.showMessageDialog(null, "think of a number 1 to 100","Guessing Game",1);

            //repeats logic until the guess is correct
            do {
                //changes guess and previousguess and increases guess amount
                previousGuess = guess;
                guess = (low + high) / 2;
                guessAmount++;

                //if the guess didnt change shows a message
                if (guess == previousGuess) {
                    JOptionPane.showMessageDialog(null, "STOP CHEATING, I KNOW IT WAS CORRECT","Guessing Game",2);
                    
                    //reduces guess amount by one
                    guessAmount--;
                }
                
                //gets input until a valid input is received
                do {
                    letterInput = JOptionPane.showInputDialog(null,"is this your number? " + guess + "\n\nC(Number is Correct), \nL(Number is Lower), \nH(Number is Higher).","Guessing Game",3);
                    if (letterInput == null) {
                        System.exit(0);
                    }
                    //trys to take the first charachter of the input string
                    try {
                        letter = letterInput.charAt(0);
                    } catch (Exception e) {letter = 'z';}
                    
                    //message if input is invalid
                    if (((letter != 'c' && letter != 'l' && letter != 'h'))) {
                        JOptionPane.showMessageDialog(null, "Invalid Input","Guessing Game",2);
                    }
                    
                } while (letter != 'c' && letter != 'l' && letter != 'h');

                //different case depending on input
                switch (letter) {
                    case 'c' -> {
                        //if correct shows message and number of guesses and sets correct to true
                        JOptionPane.showMessageDialog(null, "your number was: " + guess + "\n\nit took me " + guessAmount + " guesses","Guessing Game",1);
                        correct = true;
                    }
                    case 'l' -> {
                        //sets high to guess
                        high = guess;
                        //JOptionPane.showMessageDialog(null, "Low");
                    }
                    case 'h' -> {
                        //sets low to guess
                        low = guess;
                        //JOptionPane.showMessageDialog(null, "high");
                    }
                }
            } while (!correct);
        }
    }
}

