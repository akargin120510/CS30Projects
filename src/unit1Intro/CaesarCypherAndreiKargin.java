/** Required package class namespace */
package unit1Intro;

import javax.swing.JOptionPane;


/*
 * CaesarCypherAndreiKargin - description
 * 
 * @author Andrei
 * @since Oct 2, 2026
*/
public class CaesarCypherAndreiKargin
{            
    //Quitting function instead of writing message seperatly
    public static void Quit(){
        JOptionPane.showMessageDialog(null, "Quitting Program","Caesar Cypher Encryption",1);
        System.exit(0);
    }
 
    public static void main(){
        //declaring variables
        Character letter = null;
        Integer key =null;
        String message = null;
        String message2 = null;
        String keyInput = null;
        char[] messageArray = null;

        //charachter integer equivalents
        //char space = ' ';//32
        //char a = 'a';//97
        //char z = 'z';//122
        //char A = 'A';//65
        //char Z = 'Z';//90
        //JOptionPane.showMessageDialog(null, (int)Z);

        //intro message
        JOptionPane.showMessageDialog(null, """
                                            In general, encryption algorithms transform messages into some form that is not easily understood by an unintended reader. Secret
                                            key encryption algorithms make use of a secret key or number that is shared only between the sender and intended receiver of the
                                            message. Using the secret key, the sender encrypts the original message or plaintext into an unintelligible form known as cipher text.
                                            The cipher text may then be transmitted to the receiver. Using the same secret key, the receiver can decrypt the cipher text and recover
                                            the plaintext. The Caesar cipher is a very simple (and easily broken) encryption algorithm that works by substituting each letter of the
                                            alphabet with another letter some fixed number of positions away in the alphabet. This fixed number is also known as the key. For
                                            example, for a key of 3 the letter 'A' would become 'D' and 'W' would become 'Z'. The letters 'X', 'Y', and 'Z' would wrap
                                            around to become 'A', 'B', and 'C' respectively.""","Caesar Cypher Encryption",1);

        //main loop so it you dont have to keep relaunching the program each encryption/decryption
        while(true){
            //takes input letter at least once and until it has a valid one
            do{
                //saves input string as input dialog return
                String letterInput = JOptionPane.showInputDialog(null,"Do you wish to Encrypt(E), Decrypt(D), or Quit(Q)?","Caesar Cypher Encryption",3 );

                //if x or cancel was pressed program quits
                if (letterInput==null){
                    Quit();
                }

                //trys to take the first letter of the string and if string is empty shows message to do better
                try{
                    letter = letterInput.toLowerCase().charAt(0);
                }catch(java.lang.StringIndexOutOfBoundsException e){}  

                if (((letter != 'd' && letter != 'e' && letter != 'q'))) {
                            JOptionPane.showMessageDialog(null, "Please input valid command","Caesar Cypher Encryption",2);
                        }

                //if string was empty and no letter extracted sets it to g so theres no error in checking if its d,e, or q
                if (letter==null){
                letter='g';
                }
            }while(!(letter=='d'||letter=='e'||letter=='q'));

            //if q command quits
            if (letter=='q'){
                Quit();
            }

            //takes input key at least once and until it has a valid one
            do{
                //message if encrypting, takes input string
                if (letter == 'e'){
                    keyInput = JOptionPane.showInputDialog(null,"Input encryption key:","Caesar Cypher Encryption",3);
                }

                //message if decrypting, takes input string
                else{
                    keyInput = JOptionPane.showInputDialog(null,"Input decryption key:","Caesar Cypher Encryption",3);
                }

                //if x or cancel was pressed quits
                if (keyInput==null){
                    Quit();
                }

                //trys changing string to int, if it cant shows warning message to input a proper key
                try{
                    key = Math.abs(Integer.parseInt(keyInput));
                }catch(NumberFormatException e){JOptionPane.showMessageDialog(null, "Please input valid key","Caesar Cypher Encryption",2);};
            }while(key==null);

            //takes message do decrypt
            if (letter=='d'){
                message = JOptionPane.showInputDialog(null,"Input text to decrypt","Caesar Cypher Encryption",3);
            }

            //takes message to encrypt
            else {
                message = JOptionPane.showInputDialog(null,"Input text to encrypt","Caesar Cypher Encryption",3);
            }

            //quits if x or cancel is clicked
            if (message==null){
                Quit();
            }

            //chanes input string to array for encrypting/decrypting and sets all to uppercase, otherwise uppercase and lowercase letters would need to be encrypted seperatly
            messageArray = message.toUpperCase().toCharArray();

            //process for decrypting
            if (letter =='d'){
                //for every charachter in the array:
                for (int i=0; messageArray.length>=i+1; i++){ 
                    //if its a alphabet charachter take its int equivalent and change depending on key then change back into charachter and replace in the array
                    if (messageArray[i]>=65&&messageArray[i]<=90){
                       messageArray[i] = (char)(65+(messageArray[i]+Math.abs(26-key)-65)%26);                  
                    }
                }        
            }

            //process for encrypting
            else {
                //for every charachter in the array:
                for (int i=0; messageArray.length>=i+1; i++){
                    //if its a alphabet charachter take its int equivalent and change depending on key then change back into charachter and replace in the array
                    if (messageArray[i]>=65&&messageArray[i]<=90){
                       messageArray[i] = (char)(65+(messageArray[i]+Math.abs(key)-65)%26);             
                    }
                }  
            }

            //sets encrypted/decrypted phrase by converting array and changes the phraase to all uppercase
            message2 = new String(messageArray);

            //final message if decrypting with key and both messages
            if (letter=='d'){
                JOptionPane.showMessageDialog(null,"Using key: "+key
            +"\n\nOriginal message: "+message.toUpperCase()
            +"\nDecrypted message: "+message2,"Caesar Cypher Encryption",1);
            }

            //final message if encrypting with key and both messages
            else{
                JOptionPane.showMessageDialog(null,"Using key: "+key
            +"\n\nOriginal message: "+message.toUpperCase()
            +"\nEncrypted message: "+message2,"Caesar Cypher Encryption",1);
            }
        }
}

        
    }



