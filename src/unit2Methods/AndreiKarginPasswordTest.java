/** Required package class namespace */
package unit2Methods;

import javax.swing.JOptionPane;
/*
 * PasswordTestAndreiKargin - tests password for the bosses absurd rules
 * 
 * @author Andrei
 * @since Sep 29, 2026
 */
public class AndreiKarginPasswordTest {

    //method to test the password for the 2 rules
    public static boolean testPassword(String password) {
        int tAmount = 0;
        boolean t = false;
        boolean valid = false;

        //loops through every charachter in the password
        for (int i = 0; i < password.length(); i++) {
            char a = password.charAt(i);
            
            //if the charachter is T it adds one to T amount
            if (a == 'T') {
                tAmount++;
            }
            
            //if there is a t it remembers this to look for a later letter o
            if (a == 't') {
                t = true;
            }
            
            //if there was a previous t then o sets valid to true             
            //and stops looping through the password
            if (t && a == 'o') {
                valid = true;
                i = password.length();
            }
        }
        //if there was 2 Ts sets valid to true
        if (tAmount == 2) {
            valid = true;
        }

        return valid;
    }

    //method for checking if the input has a space since they arent allowed
    public static boolean testInput(String input) {
        boolean valid = true;

        //loops through every charachter 
        //and if any of them is a space sets valid to false
        for (int i = 0; i < input.length(); i++) {
            char b = input.charAt(i);
            if (b == ' ') valid = false;                            
        }
        return valid;
    }

    public static String input() {
        String input;
        
        //gets an input at least once and until there is a valid input
        do {
            input = JOptionPane.showInputDialog(null,
                                                "input password",
                                                "Password test", 
                                                3);
            
            //if x or cancel clicked quits the program
            if (input == null) {
                System.exit(0);
            }
            
            //if its blank shwo a message to at least input something
            if (input.isBlank()) {
                JOptionPane.showMessageDialog(null, 
                                            "please input a password",
                                            "Password test", 
                                            2);
            }
            
            //calls TestInput method to check if theres a space in the input,
            //if there is shows a message saying spaces arent allowed
            if (!testInput(input)) {
                input = " ";
                JOptionPane.showMessageDialog(null, 
                                            "password cant have spaces",
                                            "Password test", 
                                            2);
            }
        } while (input.isBlank());

        return input;
    }

    public static void main(String[] args) {
        //intro message
        JOptionPane.showMessageDialog(null, 
                                    "welcome to password tester",
                                    "Password test", 
                                    1);

        //loops until program is closed
        while (true) {
            //declaring variables and setting them to returns from 
            //methods input and testpasword
            String password = input();
            boolean valid = testPassword(password);

            //messages depending on if the password is valid
            if (valid) {
                JOptionPane.showMessageDialog(null, 
                                        "password \"" + password + "\" is good",
                                        "Password test", 
                                        1);
            } else {
                JOptionPane.showMessageDialog(null,
                                        "password \"" + password + "\" is bad",
                                        "Password test", 
                                        1);
            }
        }
    }
}
