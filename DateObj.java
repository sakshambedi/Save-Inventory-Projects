
// ---------------- Importing Libraries ------------------
import java.util.Date;
import java.text.*;
import java.time.LocalDate;
// import java.util.Calendar;
// import java.text.DateFormat;  
// import java.text.SimpleDateFormat;

public class DateObj extends Date {
    private static final long serialVersionUID = 7526472295622776147L; 
    static messages printMessages = new messages();


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
                // System.out.println("Long Date Works Perfect");
                System.out.println("Code works perectly till here !");
                // convertStringtoDate(tempDate);
            }
        }else if (dateLength == 8){
            // call for checking if the entered date 8 characters is
            // entered in the right format
            if(checkShortDateFormat(tempDate)){
                System.out.println("Short Date Works Perfect");
                conversionMethod(tempDate);
            }
        }else if(dateLength ==9) {
            if(checkLongerDateFormat(tempDate)){
                System.out.println("Dates will length 9 works perfect");

            }
        }else {
            System.out.println(printMessages.printUIStar());
            System.out.println("Error in the entered Date !");
            System.out.println("Description : ");
            System.out.println("The entered Date does not meet the requirement.");
            System.out.println(printMessages.printUIStar());
        }
        return true;
    }


    // method to check valid long date entered by the user 
    // uses general format of the date and checks if the data is entered in the correct order
    // prints a messages otherwise to check the formatting of the parameter passed
    private static boolean checkLongDateFormat(String StringDate){   
        if(StringDate.indexOf("-")==4 && StringDate.lastIndexOf("-") == 7 ){
            return convertStringtoInt(StringDate);
        }else{
            System.out.println(printMessages.printUIStar());
            System.out.println("Inappropriate formatting issue");
            System.out.println("Check placement of - in the entered Date");
            System.out.println(printMessages.printUIStar());
        }
        return false;
    }


    // method to check valid long date entered by the user 
    // uses general format of the date and checks if the data is entered in the correct order
    // prints a messages otherwise to check the formatting of the parameter passed
    private static boolean checkShortDateFormat(String StringDate){ 
        
        String tempDay = StringClone(StringDate);
        String tempMonth = StringClone(StringDate);
        if(StringDate.indexOf("-")==4 && StringDate.lastIndexOf("-") == 6){
            tempMonth  = tempMonth.substring(5, 6);
            tempDay = tempDay.substring(7);
            StringDate = StringDate.substring(0, 5) + correctShortDate(tempMonth) + "-"+ correctShortDate(tempDay);
            System.out.println(StringDate);
            return convertStringtoInt(StringDate);
        }else{
            System.out.println(printMessages.printUIStar());
            System.out.println("Inappropriate formatting issue");
            System.out.println("Check placement of - in the entered Date");
            System.out.println(printMessages.printUIStar());
        }
        return false;
    } 



    private static boolean checkLongerDateFormat(String StringDate){   
        // ----------------- assigning variables ------------------ 
        int firstIndex = StringDate.indexOf("-");
        String tempDate = StringDate; 

        // check for this condition : YYYY-MM-D
        if(firstIndex == 4 && StringDate.lastIndexOf("-") == (firstIndex+3)){ 
            String correctDateElement = correctShortDate(tempDate.substring(8));
            StringDate = StringDate.substring(0, 8) + correctDateElement;
            System.out.println(StringDate);
            return convertStringtoInt(StringDate);
        }

        // check for the condition : YYYY-M-DD
        else if(firstIndex == 4 && StringDate.lastIndexOf("-") == (firstIndex+2)){
            String correctDateElement = correctShortDate(tempDate.substring(5,6));
            StringDate = StringDate.substring(0, 5) + correctDateElement + StringDate.substring(6);
            System.out.println(StringDate);
            return convertStringtoInt(StringDate);
        }
        else{
            System.out.println(printMessages.printUIStar());
            System.out.println("Inappropriate formatting issue");
            System.out.println("Check placement of dash (-) in the entered Date");
            System.out.println(printMessages.printUIStar());
        }
        return false;
    } 



    // method to deal with the short dates and change them to valid formated dates 
    // For Example given 
    private static String correctShortDate(String StringDate){
        String correctedDateElement = StringDate ;
        
        switch(Integer.valueOf(correctedDateElement)){
            case 1: correctedDateElement = "01";
                    break;
            case 2: correctedDateElement = "02";
                    break;
            case 3: correctedDateElement = "03";
                    break;
            case 4: correctedDateElement = "04";
                    break;
            case 5: correctedDateElement = "05";
                    break;
            case 6: correctedDateElement = "06";
                    break;
            case 7: correctedDateElement = "07";
                    break;
            case 8: correctedDateElement = "08";
                    break;
            case 9: correctedDateElement = "09";
                    break;
            default : correctedDateElement= "\n"+printMessages.printUIStar() + "\nExplicit use of method\nError in correctShortDate : DateObj class\n" + printMessages.printUIStar();
        }
        return correctedDateElement;
    } 


    
    // method to split year in the String date 
    private static String splitYear(String StringDate){
        return StringDate.substring(0, 4);
    }


    // method to split month in the String date 
    private static String splitMonth(String StringDate){
        return StringDate.substring(5, 7);
    }


    // method to split month in the String date 
    private static String splitDay(String StringDate){
        return StringDate.substring(8);
    }


    // method to split contents of a date and convert them to int 
    // if they can be converted to int ; everything is okay
    // otherwise prints strace Trace 
    //  
    private static boolean convertStringtoInt(String StringDate){
        // mainly tries to convert String to Int 
        // put in try catch block 
        // only passes true if all the values are parsed to Int 
        // otherwise prints a error messages
        try{
            int year = Integer.valueOf(splitYear(StringDate));
            int month = Integer.valueOf(splitMonth(StringDate));
            int day = Integer.valueOf(splitDay(StringDate));
            // debugging 
            // System.out.println("The following code returns : \n" +year + " " + month + " " + day);
            return true ;
       }catch(NumberFormatException nfException ){
            System.out.println(printMessages.printUIStar());
            System.out.println("Error");
            System.out.println("Explicit error in coversion of String to Int ");
            System.out.println(nfException.getMessage());
            System.out.println(printMessages.printUIStar());
       }
       return false;
    }



    // try catch method for conversion  of String to Date format
    private static void conversionMethod(String StringDate){
        try{
            convertStringtoDate(StringDate);
        }catch(ParseException parseExcept){
            System.out.println(printMessages.printUIStar());
            System.out.println("Error in the conversion of String to Date datat type !");
            System.out.println("Check the convertString to Date method !");
            System.out.println(printMessages.printUIStar());
        }
    }

    // converts String to Date java type 
    // static method used to throw expection 
    // need to test the method :(
    public static Date convertStringtoDate(String StringDate) throws java.text.ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date dateConverted = formatter.parse(StringDate);
        return dateConverted;
    }


    // boolean method to compare the current date to the entered Date by the user 
    // 
    private static int greatThanTodayDate(String StringDate){
        LocalDate todayDate = LocalDate.now();
        LocalDate userDate = LocalDate.parse(StringDate);
        return userDate.compareTo(todayDate);
    }
    


    // java deep clone method for String 
    // instance method 
    public static String StringClone(String enteredDate){
        String newstring = enteredDate;
        return newstring;
    }

    /*
        Solely for debugging each method 
        main method for DateObj
    */

    public static void main(String[] args){
        /*
            Debugging entered date 
            Testing different entered Dates as string 
        
        System.out.println("When correct dates are entered : ");
        verifyEnteredDate("2020-02-12");
        verifyEnteredDate("202/-02-12");
        verifyEnteredDate("/221-1/-1/");
        // verifyEnteredDate("2020-2-2");
        */

        /*
        System.out.print("\n");
        System.out.println("When no - dates are entered (length is okay) :   ");
        verifyEnteredDate("2020120212");
        verifyEnteredDate("20201212"); 

        System.out.print("\n");
        System.out.println("When incorrect dates are entered :  ");
        verifyEnteredDate("2020212");
        verifyEnteredDate("202022");
        */

        /*
        Debugging split method 
        works perfectly

        System.out.println(splitYear("2020-02-12"));
        System.out.println(splitMonth("2020-02-12"));
        System.out.println(splitDay("2020-02-12"));
        */

        /*
            Debugging correct short date method 
            Tests every switch case and without additional problem case of 1o and 11
        
        System.out.println(printMessages.printUIStar());
        System.out.println("Testing changing of short date in long date elements : ");
        System.out.println(correctShortDate(String.valueOf(1)));
        System.out.println(correctShortDate(String.valueOf(2)));
        System.out.println(correctShortDate(String.valueOf(3)));
        System.out.println(correctShortDate(String.valueOf(4)));
        System.out.println(correctShortDate(String.valueOf(5)));
        System.out.println(correctShortDate(String.valueOf(6)));
        System.out.println(correctShortDate(String.valueOf(7)));
        System.out.println(correctShortDate(String.valueOf(8)));
        System.out.println(correctShortDate(String.valueOf(9)));
        System.out.println(correctShortDate(String.valueOf(10)));
        System.out.println(correctShortDate(String.valueOf(11)));
        System.out.println(printMessages.printUIStar());
        */


        /* Debugging checkLongerDate
        checkLongerDateFormat("2020-2-11");
        checkLongerDateFormat("2020-9-21");
        checkLongerDateFormat("2020-1-51");
        */


        /* debugging checkShortDate 
        
        checkShortDateFormat("2020-1-2");
        checkShortDateFormat("2020-8-5");
        checkShortDateFormat("2019-4-2");
        */

        System.out.println(greatThanTodayDate("2020-01-27"));
        System.out.println(greatThanTodayDate("2020-02-27"));
        System.out.println(greatThanTodayDate("2020-01-30"));
        System.out.println(greatThanTodayDate("2020-01-13"));
        System.out.println(greatThanTodayDate("2020-04-27"));

    }
}

