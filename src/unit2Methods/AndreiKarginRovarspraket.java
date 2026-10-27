/** Required package class namespace */
package unit2Methods;

import javax.swing.JOptionPane;

/*
 * AndreiKarginRovarspraket - swedish childrens code where every consonant is 
 *                            replaced by itself followed by the closest vowel 
 *                            and next consonant
 * @author Andrei
 * @since Oct 2, 2026
 */
public class AndreiKarginRovarspraket {

    //method to convert to rovarspraket
    public static String toRovarspraket(String input) {

        //declaring variables
        final char[] inputArray = input.toCharArray();
        final String vowels = "aeiou";
        final int aInt = 97;
        final int zInt = 122;

        String output = "";

        for (int i = 0; i < inputArray.length; i++) {
            //declaring variables
            boolean upper = false;
            char letter = inputArray[i];

            // got \0 from internet to make char empty
            char closeVow = '\0';
            char nextCons = '\0';

            //if letter is uppercase sets upper to true
            if (Character.isUpperCase(letter)) {
                upper = true;
                letter = Character.toLowerCase(letter);
            }

            //if not a vowel and in the english alphabet
            if (vowels.indexOf(letter) == -1 &&
                                  (int) letter >= aInt &&
                                  (int) letter <= zInt) {
                //declaring/setting variables
                closeVow = letter;
                int x = -1;

                //if z next consonant is also z
                if (letter == 'z') {
                    nextCons = 'z';

                    //else sets nextCons to the next letter
                } else {
                    nextCons = (char) (letter + 1);

                    //if it got set to a vowel set it to the next letter
                    if (vowels.contains(String.valueOf(nextCons))) {
                        nextCons = (char) (nextCons + 1);
                    }
                }

                //closest vowel logic until a vowel is found
                //taking the current letter as zero, will check letter 
                //-1,1,-2,2,etc until a vowel is found
                do {
                    closeVow = (char) ((int) closeVow + x);

                    //changing x to cycle through close letters properly
                    if (x > 0) {
                        x = -(x + 1);
                    } else {
                        x = -(x - 1);
                    }
                } while (!vowels.contains(String.valueOf(closeVow)));
            }

            //if the letter was an uppercase, changes it back to uppercase not 
            //touching closest vowel or next consonant
            if (upper) {
                letter = Character.toUpperCase(letter);
            }

            //adds letters to output string
            output = output + letter + closeVow + nextCons;
        }
        //return output
        return output;
    }

    //input method
    public static String input() {
        //declares input variable
        String input;

        //keeps asking for a input of text until one is received
        do {
            input = JOptionPane.showInputDialog(
                                    null, 
                                    "Input a word/sentence to translate", 
                                    "Rovarspraket", 
                                    3);

            //closes program if x or cancel was pressed
            if (input == null) {
                System.exit(0);
            }
        } while (input.isBlank());

        //returns the input string
        return input;
    }

    //method to ask to play again, returns boolean
    public static boolean playAgain() {
        //showconfirm dialog returns 0 if yes was pressed  

        //netbeans suggested an if statement was redundant and upon research 
        //this was a simpler solution
        return JOptionPane.showConfirmDialog(null, 
                                       "Do you want to play again?") == 0;
    }

    //main method
    public static void main(String[] args) {
        //declaring variables fro original and translated sentences
        String english;
        String rovarspraket;

        //intro message
        JOptionPane.showMessageDialog(null, 
                                    "Welcome to Rovarspraket!", 
                                    "Rovarspraket", 
                                    1);

        //program keeps running until you close it
        while (true) {
            //calls input and sets english sentence to return
            english = input();

            //calls toRovarspraket with english as the parameter, return is 
            //saved in string rovarspraket
            rovarspraket = toRovarspraket(english);

            //displays the original and translated mesage
            JOptionPane.showMessageDialog(null,
                                        "The word/sentence \"" + english + 
                                        "\" in Rovarspraket is \"" + 
                                        rovarspraket + "\"");

            //calls playagain and if it had returned false closes the program
            if (!playAgain()) {
                System.exit(0);
            }
        }
    }
}
