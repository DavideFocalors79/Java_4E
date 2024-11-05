package Tools;

import java.util.Random;
import java.util.Scanner;

public class utility {
    /*Clears the screen of the terminal */
    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Prints a menu and asks the user the options passed using the scanner
     * attribute.
     * The first element of the passed string array is the title, so the
     * passed array's length can't be lower than 2, otherwise null is returned.
     * If the scanner object passed is null, the method returns a negative value.
     * The method clears the screen.
     * If the user inputs an incorrect value the method requests the value again until
     * it's correct.
     */
    public static int menu(String[] content, Scanner keyboard) {
        //If the content array is null or not big enough return -1
        if(content == null || content.length < 2 || keyboard == null)
            return -1;

        //Contains the user input
        int userInput;
        do {
            /*Print the interface */
            //Clear the screen
            clearScreen();
            System.out.println("=== " + content[0] + " ===");
            //Iterate trough all the elements in the options and print them out
            for(int currentElement = 1; currentElement < content.length; currentElement++)
                System.out.println("[" + currentElement + "] : " + content[currentElement]);
            //Print a space
            System.out.print("\n> ");

            //Fill the user input
            userInput = keyboard.nextInt();
        } while (userInput <= 0 || userInput >= content.length);

        //Return the value the user inserted as input
        return userInput;
    }


}