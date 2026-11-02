/** Required package class namespace */
package cs30sproject;

// "*" wildcard operator imports all in unit2methods
import unit3Arrays.*;

import javax.swing.JOptionPane;

/*
 * CS30SProject - description
 * 
 * @author Andrei
 * @since Oct 27, 2026
*/
public class CS30SProject{    
    
    public static final String GOLFSIMULTOR = "Golf Simulator";
    public static final String OPTOMETRISTCHART = "Optometrist Chart";
    public static final String PRIZEBOARD = "Prize Board";
    public static final String STONESPEBBLES = "Stones and Pebbles";
   
    public static final String[] Programs = {GOLFSIMULTOR,
                                             OPTOMETRISTCHART,
                                             PRIZEBOARD};
    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            switch (input()){                
                case GOLFSIMULTOR ->{
                    AndreiKarginGolfSimulator.main(args);
                }
                case OPTOMETRISTCHART ->{
                    AndreiKarginOptometristChart.main(args);
                }
                case PRIZEBOARD ->{
                    AndreiKarginPrizeBoard.main(args);
                }     
                case STONESPEBBLES ->{
                    AndreiKarginStonesPebbles.main(args);
                }

            }
        }
    }        
    
    public static String input(){
        return JOptionPane.showInputDialog(null, "select program to run", "Program Selector", 0, null, Programs, GOLFSIMULTOR).toString();
    }
}

