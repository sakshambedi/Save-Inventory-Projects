/*
@@ Java class for all the messages


*/

public class messages{


    public String printUIStar(){ return "**************************************************"; }

    public void openMessage(){
        // creating a new object 
        DateObj currDate = new DateObj();
        
        //Printing messages for initial program starts 
        // should have a welcome message 
        // present user with the option to do stuff for the user  
        
        System.out.println("Welcome to Save Inventory !");
        System.out.println("The Current Day is " + currDate.toStringDAY());
        //System.out.println("The Current Time is "+saveInventory.TIME + "\n");
        System.out.println(printUIStar());
        System.out.println("Enter the option below to do the following tasks !");
        System.out.println(printUIStar());
        System.out.println("1. Add an item to the database !"); 
    }

    public String userInputMessage(){
        return "Enter the number to perform the task : ";
    }
}