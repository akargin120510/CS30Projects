/** Required package class namespace */
package cs30sproject;

// "*" wildcard operator imports all in unit2methods
import unit1Intro.*;
import unit2Methods.*;
import unit3Arrays.*;

import javax.swing.JOptionPane;

/*
 * CS30SProject - launch all CS30 projects here. Some projects will kill this 
 * program upon closing
 * 
 * @author Andrei
 * @since Oct 27, 2026
 */
public class CS30SProject {
    public static boolean running = true;

    //unit 1 projects
    public static final String CAESARCYPHER = "Caesar Cypher";
    public static final String KNUTHUPARROW = "Knuth Up Arrow Notation";
    public static final String MATHEMATICALCITY = "Mathematical City";
    public static final String GUESSINGGAME = "Guessing Game";

    //unit 2 projects 
    public static final String CALENDARMAKER = "Calendar Maker";
    public static final String HOUSEBUILDER = "House Builder";
    public static final String PASSWORDTEST = "Password test";
    public static final String ROVARSPRAKET = "Rovarspraket";

    //unit 3 projects
    public static final String GOLFSIMULTOR = "Golf Simulator";
    public static final String OPTOMETRISTCHART = "Optometrist Chart";
    public static final String PRIZEBOARD = "Prize Board";
    public static final String STONESPEBBLES = "Stones and Pebbles";

    //array of programs
    public static final String[] Programs = {
        CAESARCYPHER,KNUTHUPARROW,MATHEMATICALCITY,GUESSINGGAME,
        CALENDARMAKER, HOUSEBUILDER, PASSWORDTEST, ROVARSPRAKET,
        GOLFSIMULTOR, OPTOMETRISTCHART, PRIZEBOARD, STONESPEBBLES};

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {                
        while (running) {
            run(args);
        }
    }

    public static String input() {
        Object selection = JOptionPane.showInputDialog(
                null,
                "select program to run",
                "Program Selector",
                0, null,
                Programs,
                GOLFSIMULTOR);                
        
        return selection.toString();
    }
    
    public static void run(String[] args){
        try {
                switch (input()) {
                    case CAESARCYPHER -> CaesarCypherAndreiKargin.main();                                            
                    case KNUTHUPARROW -> KnuthUpArrowNotationAndreiKargin.main();                                            
                    case MATHEMATICALCITY -> MathematicalCityAndreiKargin.main(args);                                            
                    case GUESSINGGAME -> GuessingGameAndreiKargin.main();
                    
                    case CALENDARMAKER ->AndreiKarginCalendarMaker.main(args);
                    case HOUSEBUILDER ->AndreiKarginHouseBuilder.main(args);
                    case PASSWORDTEST -> AndreiKarginPasswordTest.main(args);
                    case ROVARSPRAKET -> AndreiKarginRovarspraket.main(args);                    
                    
                    case GOLFSIMULTOR -> AndreiKarginGolfSimulator.main(args);                                            
                    case OPTOMETRISTCHART -> AndreiKarginOptometristChart.main(args);                    
                    case PRIZEBOARD -> AndreiKarginPrizeBoard.main(args);                                            
                    case STONESPEBBLES -> AndreiKarginStonesPebbles.main(args);                     
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
    }
}
