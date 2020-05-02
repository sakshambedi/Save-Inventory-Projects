/*
@@ Java class for all the messages


*/

// ---------------- importing libraries ------------------


public class messages{


    // mehtod to print the menu for performing functions 
    public void printMenu(){
        System.out.print("\n");
        System.out.println("1. Add an item to the database");
        System.out.println("2. See current items in your inventory!");
    }


    // method prints the initial print messages for entering items 
    public void printFoodTypeMenu(){
      
        // System.out.println("--------------------------------------------------");
        System.out.println("\n-------------------- INSTRUCTIONS ----------------");
        System.out.println("You can enter the brought items!");
        System.out.println("The shopped items can be sorted on the bases of type of food. \nYour options are :");
        System.out.println("1.Grocery \t 2.Medicine \t 3.Pet Food");
        System.out.println("Enter the Date of the bought items as YYYY-MM-DD ");
        System.out.println("Enter esc to exit !");
        System.out.println("--------------------------------------------------");
        System.out.println();
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