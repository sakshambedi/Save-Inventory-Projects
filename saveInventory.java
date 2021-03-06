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
// import java.util.Date;
// import java.util.Calendar;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class saveInventory {
    
    //--------------------- Class Variables ---------------------
    
    // Creating a Scanner object 
    // accessible to all 
    static Scanner enterItem = new Scanner(System.in);
    static int maxInput = 2; 
    // creating a new object for date
    //static DateObj currDate = new DateObj();

    
    // creating an object print messages to creat a new object
    // this object contains all the printing messages        
    static messages printMessages = new messages();

    public static void main(String[] args) {

        // create a fucking menu
        // use a java messages classes for that
        // print menu messages
        System.out.println("--------------------------------------------------");
        System.out.println("Welcome to Save Inventory !");
        System.out.println("The Current Day is " +  LocalDate.now()/* currDate.toStringDAY()*/);
        //System.out.println("The Current Time is "+saveInventory.TIME + "\n");
        System.out.println("--------------------------------------------------");
        System.out.println("Enter the option below to do the following tasks !"); 

        // printing the menu
        printMessages.printMenu();

        // ask for user input 
        askForInput();

        // close the scanner Object 
        enterItem.close();
    }


    // asks users for input 
    // put into separate method to re-use it  
    private static void askForInput(){
          // prints : Enter the number to perform the task 
          System.out.println("--------------------------------------------------");
          System.out.print("\nEnter the number to perform the task (0 to leave): ");
          int userInput = enterItem.nextInt();
          performAction(userInput);  
    }
    

    //method to call funtions depending upon the input by the user 
    // put in a different method to make recall different methods easy 
    // help to make a continues experience 
    private static void performAction(int userInput){
        if(userInput<0 || userInput >= maxInput+1){
            System.out.println("\nPlease enter a valid number !");
           
            // asks again for the number 
            askForInput();

        }else if (userInput > 0 || userInput < maxInput) {
            switchCase(userInput);
        }
    }


    // switch case for the value entered by the user 
    private static void switchCase(int userValue) {
        switch (userValue) {
        case 1: checkForDirectory();
            break;
        case 2 : listFilesinDirectory();
            break;
        }
    }


    // method to check if the directories exists or not 
    private static void checkForDirectory(){
        if(writeToFile.checkForDir()){
            enterUserItem();
        }else{
            System.out.println("Directory does not exist !");
        }
    }


    // method to enter food items 
    // Enters the food 
    // then call a method to enter type of item 
    // then enter a valid date in String 
    // String date is then changed to Localdate Java Object type 
    // Return type to void for now  
    private static void enterUserItem(){
        
        printMessages.printFoodTypeMenu();

        System.out.print(printMessages.printEnterItem());
        String itemsEnteredUser = enterItem.next();
        while(!itemsEnteredUser.equals("esc") && !itemsEnteredUser.equals(" ") ){
            
            System.out.print(printMessages.printEnterType());
            int foodTypeInt = enterItem.nextInt();
            enterUserType(foodTypeInt); 


            String itemDate = enterUserDate();
            System.out.println("==================================================");
            // this is for debugging 
            //System.out.print(Date);
            
            // assigning data in the array 
            // this array is later passed to the other methods and will be future used
            itemList listOfItems =  new itemList(itemsEnteredUser,foodTypeInt,itemDate);


            // write to file 
            writeToFile.writingMethod(DateObj.fileName(itemDate),listOfItems.returnList());
            
            // ask again 
            System.out.print(printMessages.printEnterItem());
            itemsEnteredUser = enterItem.next();
        }
        askForInput();
    }


    // method to enter food Type in int and 
    private static int enterUserType(int foodType){
        // assingning variable 
        while(foodType<0 || foodType >3){
            System.out.println(printMessages.printEnterType());
            foodType = enterItem.nextInt();
        }
        return foodType;
    }


    // method to enter date and return the date 
    // need to add verification system for the entered date
    private static String enterUserDate(){
        System.out.print(printMessages.printEnterDate());
        String enteredDateUser = enterItem.next();
        while(!DateObj.verifyEnteredDate(enteredDateUser)){
            // System.out.println(printMessages.printUIStar());
            System.out.print(printMessages.printEnterDate());
            enteredDateUser = enterItem.next();
        }
        return enteredDateUser;
    }  



    // method to list all the files in the directory and initiate 
    private static void listFilesinDirectory(){
        System.out.println("Current files in your Inventory : ");
        try (Stream<Path> walk = Files.walk(Paths.get(System.getProperty("user.dir")+"\\logFile\\"))) {
            List<String> result = walk.filter(Files::isRegularFile).map(x -> x.toString()).collect(Collectors.toList());
        
            result.forEach(System.out::println);      
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


   