
// ---------------- Importing Libraries ------------------
import java.util.Date;
import java.text.*;
// import java.util.Calendar;
// import java.text.DateFormat;  
// import java.text.SimpleDateFormat;

public class DateObj extends Date {
    private Date myDate;
    private static final long serialVersionUID = 7526472295622776147L; 

    // method to convert Date as String
    // accepts date is a parameter  
    public static String toStringDate(Date enteredDate){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(enteredDate);
        return strDate;
    }


    // method that verifies the entered
    public static boolean verifyEnteredDate(String StringDate){
        String tempDate = StringDate; 
        int dateLength = StringDate.length();
        if(dateLength == 10){
            // call for checking if the entered date 10 characters is
            // entered in the right format 
            if(checkLongDateFormat(tempDate)){
                System.out.println("Long Date Works Perfect");
            }
        }else if (dateLength == 8){
            // call for checking if the entered date 8 characters is
            // entered in the right format
            if(checkShortDateFormat(tempDate)){
                System.out.println("Short Date Works Perfect");
            }
        }else {
            System.out.println("Error in the entered Date !");
            System.out.println("Description : ");
            System.out.println("The entered Date does not meet the requirement.");
        }
        return true;
    }


    // method to check valid long date entered by the user 
    // uses general format of the date and checks if the data is entered in the correct order
    private static boolean checkLongDateFormat(String StringDate){   
        if(StringDate.indexOf("-")==4 && StringDate.lastIndexOf("-") == 7 ){
            return true;
        }
        return false;
    }

    // method to check valid long date entered by the user 
    // uses general format of the date and checks if the data is entered in the correct order
    private static boolean checkShortDateFormat(String StringDate){   
        if(StringDate.indexOf("-")==4 && StringDate.lastIndexOf("-") == 6){
            return true;
        }
        return false;
    } 


    
    // method to split year in the String date 
    private static String spiltYear(String StringDate){
        return StringDate.substring(0, 4);
    }


    // method to split month in the String date 
    private static String spiltMonth(String StringDate){
        return StringDate.substring(5, 7);
    }


    // method to split month in the String date 
    private static String spiltDay(String StringDate){
        return StringDate.substring(8);
    }

    // method to spilt contents of a date and convert them to int 
    // if they can be converted to int ; everything is okay
    private static void convertStringtoInt(String StringDate){
        if(spiltYear(StringDate).In)

    }


    // converts String to Date java type 
    // static method used to throw expection 
    // need to test the method :(
    public static Date convertStringtoDate(String StringDate) throws java.text.ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date dateConverted = formatter.parse(StringDate);
        return dateConverted;
    }
    

    /*
        Solely for debugging each method 
        main method for DateObj
    */

    public static void main(String[] args){
        verifyEnteredDate("2020-02-12");
        verifyEnteredDate("2020-2-2");


        /*
        Debugging split method 
        works perfectly

        System.out.println(spiltYear("2020-02-12"));
        System.out.println(spiltMonth("2020-02-12"));
        System.out.println(spiltDay("2020-02-12"));
        */
    }
}

