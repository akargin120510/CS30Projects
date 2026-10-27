/** Required package class namespace */
package unit2Methods;

import javax.swing.JOptionPane;

/*
 * AndreiKarginCalendarMaker - program to make a calendar 
 *                             based on days and starting day
 * 
 * @author Andrei
 * @since Oct 6, 2026
 */
public class AndreiKarginCalendarMaker {

    //method for length of month input returns int
    public static int daysInput() {
        //declaring variables
        String daysInput;
        int days = -1;

        //asks for input until a valid one is received
        do {

            //sets input string
            daysInput = JOptionPane.showInputDialog(null, 
                                    "Input number of days in the month", 
                                    "Calendar Maker", 
                                    3);

            //if x or cancel was pressed quits
            if (daysInput == null) {
                System.exit(0);
            }

            //trys taking an int from the input string if not shows message
            try {
                days = Math.abs(Integer.parseInt(daysInput));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                                            "Invalid Input", 
                                            "Calendar Maker", 
                                            2);
            }
        } while (days == -1);

        //returns day amount
        return days;
    }

    //method for getting starting day input 
    public static int startdayInput() {

        //declaring variables
        String input;
        int startDay = -1;

        //asks for input until a valid one is given
        do {
            //sets input string
            input = JOptionPane.showInputDialog(null, 
                                                """
                                                Input the day the month starts 
                                                on (1-7)
                                                1 = SUNDAY
                                                2 = MONDAY
                                                3 = TUESDAY
                                                4 = WEDNESDAY
                                                5 = THURSDAY
                                                6 = FRIDAY
                                                7 = SATURDAY
                                                """, 
                                                "Calendar Maker",
                                                3);
            if (input == null) {
                System.exit(0);
            }

            try {
                startDay = Math.abs(Integer.parseInt(input));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                                            "Invalid Input", 
                                            "Calendar Maker", 
                                            2);
            }

        } while (startDay == -1);

        //retuens day to start from
        return startDay;
    }

    //method for displaying the calendar, takes two arguments
    public static void display(int days, int startday) {

        //declaring variables
        final String rowGridLine = "+----------+----------+----------+----------+----------+----------+----------+\n";
        final String columnGridLine = "|          |          |          |          |          |          |          |\n|          |          |          |          |          |          |          |\n";
        String output = rowGridLine + "|  SUNDAY  |  MONDAY  |  TUESDAY | WEDNESDAY| THURSDAY |  FRIDAY  | SATURDAY |\n" + rowGridLine;
        int gapNum = startday - 1;
        int position = 1;

        //loops for every
        for (int i = 1; i < days + 1; i++) {

            if (position == 1) {
                output = output + "|";
            }

            // if the start of the calendar needs gap days adds those and 
            //decreases i so it still starts counting from 1 later
            if (gapNum > 0) {
                output = output + "          |";
                gapNum--;
                i--;
            } //if no gaps are needed adds spaces based on how many 
            //digits the day number has to keep the calendar alligned
            //then adds the day number
            else {
                for (int j = 0; j < 10 - String.valueOf(i).length(); j++) {
                    output = output + " ";
                }
                output = output + i + "|";
            }

            //if all numbered days have been added adds a gap square at the end 
            //until position 7 is reached and sets position to 7 for the final 
            //rowGridLine
            if (i == days) {
                for (int j = 0; j < 7 - position; j++) {
                    output = output + "          |";
                }
                position = 7;
            }

            //increments the position by one and if it goes to 8 its reset back 
            //to 1 and a rowGrridLine is drawn
            position++;
            if (position >= 8) {
                position = 1;
                output = output + "\n" + columnGridLine + rowGridLine;
            }
        }

        //prints the output string to console
        System.out.print(output);
    }

    //method to ask to play again
    public static boolean playAgain() {
        //simpler solution than a redundant if statement, learnt from internet
        return JOptionPane.showConfirmDialog(
                                null, 
                                "Do you wish to make another calendar?", 
                                "Calendar Maker", 
                                JOptionPane.YES_NO_OPTION, 
                                3) == 0;
    }    

    //main method
    public static void main(String[] args) {
        //declaring variables
        int days;
        int startDay;

        //intro message
        JOptionPane.showMessageDialog(null, 
                                "Welcome to the calendar making program", 
                                "Calendar Maker", 
                                1);

        //main looop so program repeats
        while (true) {

            //calls daysInput and sets days to return
            days = daysInput();

            //calls startDayInput and sets startDay to return
            startDay = startdayInput();

            //calls display with arguments
            display(days, startDay);

            //calls playAgain and if it returns false quits
            if (!playAgain()) {
                System.exit(0);
            }
        }
    }
}
