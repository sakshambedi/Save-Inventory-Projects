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
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class saveInventory {
    
    //--------------------- Class Variables ---------------------
    
    // Creating a Scanner object 
    // accessible to all 
    static Scanner enterItem = new Scanner(System.in);
    static final int maxInput = 2; 
    // creating a new object for date
    static DateObj currDate = new DateObj();

    
    // creating an object print messages to creat a new object
    // this object contains all the printing messages        
    static messages printMessages = new messages();

    public static void main(String[] args) {

        // create a fucking menu
        // use a java messages classes for that
        System.out.println(printMessages.printUIStar());

        // debugging
        System.out.println(currDate.toIntDay() + "" + currDate.toIntMonth() + "" +  currDate.toIntYear()); 


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
        printMessages.printUIStar();
        System.out.print("Enter an Item in the Data Base : ");
        String foodItem = enterItem.next();

        // runs the loop untill the stop key is not entered 
        // Stop Key : "esc"

        while(!foodItem.equals("esc")){
            String returnString = enterDateforData();

            // this condition print statment for debugging 
            if (!returnString.equals("Error")){
                System.out.println("This Function Works !");  
            }else{
                System.out.println("System Error");
            }
            System.out.print("Enter an Item in the Data Base : ");
            foodItem = enterItem.next();  
        }
    }


    private static String enterDateforData(){
        System.out.print("Enter the Date (DD/MM/YYYY) : ");
        String enteredDate = enterItem.next();
        // try catch block to avoid exceptions
        try{
            if (currDate.validateDate(enteredDate)){
                System.out.println("Function Works");
                return enteredDate;
            }else{
                System.out.println("Please enter a valid date !");
                return "Error";
            }
        }catch(StringIndexOutOfBoundsException StringIndexExcept){
            //StringIndexExcept.printStackTrace();
            System.out.println(printMessages.printUIStar());
            System.out.println("The entered Date is not complete \nError : " + StringIndexExcept.getMessage());
            System.out.println(printMessages.printUIStar());
            return "Error";
        }catch(InputMismatchException InputMisExcept){
            System.out.println(printMessages.printUIStar());
            System.out.println("Please enter single digit numbers as double digit.\nFor Example : Enter \"1\" as \"01\"   \nError : " + InputMisExcept.getMessage());
            System.out.println(printMessages.printUIStar());
            return "Error";
        }
        //return "Error";
    }
}