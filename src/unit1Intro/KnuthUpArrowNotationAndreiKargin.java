/** Required package class namespace */
package unit1Intro;

import javax.swing.JOptionPane;

/*
 * KnuthUpArrowNotationAndreiKargin - description
 * 
 * @author Andrei
 * @since Oct 2, 2026
 */
public class KnuthUpArrowNotationAndreiKargin {

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main() {
        //Intro Message
        JOptionPane.showMessageDialog(null, """
                                            In 1976, Donald Knuth introduced the up-arrow
                                            notation for denoting large numbers. The up arrow
                                            allows us to easily express large numbers by using
                                            towers of exponents.
                                            The value of the expression:
                                            3 \u2191\u2191 3 is 3^(3^3) = 3^27.
                                             As you can imagine,
                                            numbers grow really quickly using the up-arrow
                                            notation.""");

        //   \u2191   upArrow symbol
        //main code loops so you dont have to open the program for every calculation
        while (1 == 1) {

            //declaring variables for a and b
            Integer a = null;
            Integer b = null;

            //declaring variables for computing
            int value;
            int valueResult = 0;

            //bool to check for overflow
            boolean overflow = false;

            //output string declaration
            String output = "\n";

            //takes input from input dialog and trys turning it into an integer, if it cant will try again and show warning until a valid value for a is obtained
            do {
                String aInput = JOptionPane.showInputDialog("Input a");
                if (aInput == null) {
                    System.exit(0);
                }
                try {
                    a = Math.abs(Integer.parseInt(aInput));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please input a valid value for a");
                }
            } while (a == null);

            //takes input from input dialog and trys turning it into an integer, if it cant will try again and show warning until a valid value for b is obtained
            do {
                String bInput = JOptionPane.showInputDialog("Input b");
                if (bInput == null) {
                    System.exit(0);
                }
                try {
                    b = Math.abs(Integer.parseInt(bInput));
                    if (b == 0) {
                        valueResult = 1;
                        output = "";
                    } //else if b is 1 it turns result into a and removes newLine from output for better spacing in the final message
                    else if (b == 1) {
                        valueResult = a;
                        output = "";
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please input a valid value for b");
                }
                //if b is 0 it turns result into 1 and removes newLine from output for better spacing in the final message
                
            } while (b == null);

            //sets value for computing to a
            value = a;

            //loops if b is 2 or greater which is when computing is necessary
            for (int i = 1; i <= b - 1; i++) {

                //trys to exponentiate and set overflow to true if it cant
                try {
                    valueResult = Math.powExact(a, value);
                } catch (Exception e) {
                    overflow = true;
                    i = b;
                }

                //adds a line with values to output string for later printing
                output = output + "(" + i + ")" + a + "^" + value + "=" + valueResult + "\n";

                //sets value to value result for next pass
                value = valueResult;
            }
            //if there was no error
            if (overflow == false) {
                JOptionPane.showMessageDialog(null, "The UpArrow Notation of " + a + " \u2191\u2191 " + b + "\n" + output + "\nThe Final Result is: " + valueResult);
            } //else shows overflow message
            else {
                JOptionPane.showMessageDialog(null, "The UpArrow Notation of " + a + " \u2191\u2191 " + b + " Is Too Large Which Resulted In An Overflow");
            }
        }
    }
}
