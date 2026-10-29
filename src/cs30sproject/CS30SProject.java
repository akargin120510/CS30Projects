/** Required package class namespace */
package cs30sproject;

// "*" wildcard operator imports all in unit2methods
import unit1Intro.*;
import unit2Methods.*;
import unit3Arrays.*;

import javax.swing.JOptionPane;

/*
 * CS30SProject - description
 * 
 * @author Andrei
 * @since Oct 27, 2026
*/
public class CS30SProject{    
    
    public static final String CaesarCypher = "CaesarCypher";
    public static final String GuessingGame = "GuessingGame";
    public static final String KnuthUpArrow = "KnuthUpArrow";
    public static final String MathematicalCity = "MathematicalCity";
    
    public static final String CalendarMaker = "CalendarMaker";
    public static final String HouseBuilder = "HouseBuilder";
    public static final String PasswordTest = "PasswordTest";
    public static final String Rovarspraket = "Rovarspraket";
    
    public static final String GolfSimulator = "GolfSimulator";
    public static final String OptometristChart = "OptometristChart";
    public static final String PrizeBoard = "Prize Board";
   
    public static final String[] Programs = {CaesarCypher,GuessingGame,KnuthUpArrow,
        MathematicalCity,CalendarMaker,HouseBuilder,PasswordTest,Rovarspraket,
        GolfSimulator,OptometristChart,PrizeBoard};
    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            switch (input()){
                case CaesarCypher ->{
                    CaesarCypherAndreiKargin.main();
                }
                case GuessingGame ->{
                    GuessingGameAndreiKargin.main();
                }
                case KnuthUpArrow ->{
                    KnuthUpArrowNotationAndreiKargin.main();
                }
                case MathematicalCity ->{
                    MathematicalCityAndreiKargin.main(args);
                }
                case CalendarMaker ->{
                    AndreiKarginCalendarMaker.main(args);
                }
                case HouseBuilder ->{
                    AndreiKarginHouseBuilder.main(args);
                }
                case PasswordTest ->{
                    AndreiKarginPasswordTest.main(args);
                }
                case Rovarspraket ->{
                    AndreiKarginRovarspraket.main(args);
                }
                case GolfSimulator ->{
                    AndreiKarginGolfSimulator.main(args);
                }
                case OptometristChart ->{
                    AndreiKarginOptometristChart.main(args);
                }
                case PrizeBoard ->{
                    AndreiKarginPrizeBoard.main(args);
                }                                
            }
        }
    }        
    
    public static String input(){
        return JOptionPane.showInputDialog(null, "select program to run", "Program Selector", 0, null, Programs, CaesarCypher).toString();
    }
}

