/*
@@ Java class for all the messages


*/

// ---------------- importing libraries ------------------
import java.lang.Object;
import java.time.LocalDate;
import java.util.Date;

public class messages{


    public static void printUIStar(){ System.out.println("**************************************************"); }

    public void openMessage(){
        // creating a new object 
        //DateObj currDate = new DateObj();
        
        //Printing messages for initial program starts 
        // should have a welcome message 
        // present user with the option to do stuff for the user  
        printUIStar();
        System.out.println("Welcome to Save Inventory !");
        System.out.println("The Current Day is " +  LocalDate.now()/* currDate.toStringDAY()*/);
        //System.out.println("The Current Time is "+saveInventory.TIME + "\n");
        printUIStar();
        System.out.println("Enter the option below to do the following tasks !"); 
        // printUIStar();
    }

    // mehtod to print the menu for performing functions 
    public void printMenu(){
        System.out.print("\n");
        System.out.println("1. Add an item to the database !");
        printUIStar();
    }

    public String userInputMessage(){
        return "Enter the number to perform the task (0 to leave): ";
    }


    // method prints the initial print messages for entering items 
    public void printFoodTypeMenu(){
        printUIStar();
        //System.out.println("**************************************************");
        System.out.println("-------------------- INSTRUCTIONS ----------------");
        System.out.println("You can enter the brought items!");
        System.out.println("The shopped items can be sorted on the bases of type of food. \nYour options are :");
        System.out.println("1.Grocery \t 2.Medicine \t 3.Pet Food");
        System.out.println("Enter the Date of the bought items as YYYY-MM-DD ");
        System.out.println("Enter esc to exit !");
        System.out.println("--------------------------------------------------");
        printUIStar();
    }


    public String printEnterItem(){
        return "Enter the Item Bought (Type esc to leave) : ";
    }


    public String printEnterType(){
        return "Enter the corresponding number for the type of\nitem purcashed (1.Grocery  2.Medicine  3.Pet Food): ";
    }


    public String printEnterDate(){
        return "Enter the Date of Expiration : ";
    }

}