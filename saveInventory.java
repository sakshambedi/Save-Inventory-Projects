/*
@@  
    Save inventory
    Help you from saving the dying inventory

    Programmed by : Saksham "Saks" Bedi

    using messages classes to print all the
    messages to keep it clutter free
    created a date class to manage with dates  
@@
*/

// ------------ Importing Libararies --------------
import java.util.Scanner;

public class saveInventory {
    // Objects for time
    
    // Creating a Scanner object 
    // accessible to all 
    static Scanner enterItem = new Scanner(System.in);
    static final int maxInput = 2;
    static messages printMessages = new messages();
    // creating a new object for date 
    static DateObj currDate = new DateObj();

    public static void main(String[] args) {

        // creating an object print messages to creat a new object
        // this object contains all the printing messages 
        
        // create a fucking menu
        // use a java messages classes for that
        System.out.println(printMessages.printUIStar());

        // debugging
        System.out.println(currDate.toIntDay()); 


        // print menu messages
        printMessages.openMessage();
        printMessages.printMenu();

        
        // prints : Enter the number to perform the task 
        System.out.print(printMessages.userInputMessage());
        printMessages.printUIStar();
        int userInput = enterItem.nextInt();


        if (userInput > 0 && userInput < maxInput) {
            switchCase(userInput);
        }else{
            System.out.println("Enter a valid number !");
        }

        // close the scanner Object 
        enterItem.close();
    }

    // switch case for the value entered by the user 
    private static void switchCase(int userValue) {
        switch (userValue) {
        case 1:
            enterData();
            break;
        }
    }


    // used for enterint data 
    // data stored in the items object 
    public static void enterData(){
        
    }
}