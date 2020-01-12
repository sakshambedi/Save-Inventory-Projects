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
import java.util.Calendar;
import java.util.Scanner;

public class saveInventory {
    
    //--------------------- Class Variables ---------------------
    
    // Creating a Scanner object 
    // accessible to all 
    static Scanner enterItem = new Scanner(System.in);
    static final int maxInput = 2; 
    // creating a new object for date
    //static DateObj currDate = new DateObj();

    
    // creating an object print messages to creat a new object
    // this object contains all the printing messages        
    static messages printMessages = new messages();

    public static void main(String[] args) {

        // create a fucking menu
        // use a java messages classes for that
        // print menu messages
        printMessages.openMessage();
        printMessages.printMenu();

        
        // prints : Enter the number to perform the task 
        System.out.print(printMessages.userInputMessage());
       
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
            enterUserItem();
            break;
        }
    }


    // method to enter food items 
    // Enters the food 
    // then call a method to enter type of item 
    // then enter a valid date in String 
    // String date is then changed to date Java Object
    // Return type to void for now  
    private static void enterUserItem(){
        
        // assigning variables 
        String[] foodInfo = new String[3];

        printMessages.printFoodTypeMenu();

        System.out.print(printMessages.printEnterItem());
        String itemsEnteredUser = enterItem.next();
        while(!itemsEnteredUser.equals("esc") && !itemsEnteredUser.equals(" ") ){
            

            String itemType = enterUserType(); 


            String Date = enterUserDate();
            System.out.print(Date);
            
            // ask again 
            System.out.print(printMessages.printEnterItem());
            itemsEnteredUser = enterItem.next();
        }
        //return 
    }


    // 
    private static int enterUserType(){
        // assingning variable 
        int foodType = 0;
        while(foodType<0 || foodType > 3){
            System.out.println(printMessages.printEnterType());
            foodType = enterItem.nextInt();
            if(foodType<=1 || foodType>=3){
                return foodType;
            }else {
                foodType = 0;
            }
        }
    }


    // method to enter date and return the date 
    // need to add verification system for the entered date
    private static String enterUserDate(){
        System.out.print(printMessages.printEnterDate());
        String enteredDateUser = enterItem.next();
        System.out.println(printMessages.printUIStar());
        return enteredDateUser;
    }  
}


   