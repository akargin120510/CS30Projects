/** Required package class namespace */
package unit1Intro;

import javax.swing.JOptionPane;
/*
 * MathematicalCityAndreiKargin - description
 * 
 * @author Andrei
 * @since Sep 28, 2026
 */
public class MathematicalCityAndreiKargin {

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //intro message
        JOptionPane.showMessageDialog(null, """
                                            In Wachs city (a very mathematical place to live), the mayor is elected every 4 years, the treasurer is appointed every 2 years, the chief programmer is elected every 3
                                            years and the dog catcher is replaced every 5 years. This year (year ), the newly elected mayor announced the appointment of the new treasurer, a new dog catcher
                                            and congratulated the chief programmer for winning the recent election. That is, all positions were changed over. This is highly unusual. You will quantify how unusual this
                                            really is. Write a program that inputs the year and the future year and then lists all years between and inclusive when all positions change.""","Mathematical City", 1);
        
        while (true) {
            //declaring variables
            Integer startingYear = null;
            String startingYearInput;
            Integer endingYear = null;
            String endingYearInput;
            String output = "";
            final int period = 60;

            //takes current year input at least once and until its valid
            do {
                startingYearInput = JOptionPane.showInputDialog(null,"Input current year","Mathematical City", 3);
                if (startingYearInput == null) {
                    System.exit(0);
                }
                try {
                    startingYear = Integer.valueOf(startingYearInput);
                } catch (Exception e) {
                    //shows message for invalid input
                    JOptionPane.showMessageDialog(null, "Invalid input","Mathematical City", 2);
                }
            } while (startingYear == null);
            
            //takes ending year input at least once and until its valid
            do {
                endingYearInput = JOptionPane.showInputDialog(null,"Input ending year","Mathematical City", 3);
                if (endingYearInput == null) {
                    System.exit(0);
                }
                //trys taking an int from the string input checking for an error because of an invalid input
                try {
                    endingYear = Integer.valueOf(endingYearInput);
                    
                    //checks to make sure ending year is greater than starting year
                    if (endingYear < startingYear) {
                        endingYear = null;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid input","Mathematical City", 2);
                }
                
                
            } while (endingYear == null);

            //loops at least once and for every 60 year period adding a line every time to an output string with the year of change
            for (int i = 0; i < (endingYear - startingYear) / period + 1; i++) {
                output = output + "\nAll positions change in " + (startingYear + (period * i));
            }
            //output message
            JOptionPane.showMessageDialog(null, "over the next " + (endingYear - startingYear) + " years\n" + output,"Mathematical City", 1);
        }
    }
}
