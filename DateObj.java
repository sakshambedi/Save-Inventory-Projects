/*
@@
    Date class to store date 
    personalised methods for fetching date

    FORMAT for date : DD/MONTH/YEAR
@@
*/ 

// ------------ Importing Libararies --------------
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DateObj{
    
    String currDay ;

    // constructor class for date 
    public DateObj(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateobj = new Date();
        currDay = df.format(dateobj);
    }


    // returns the current Day
    public String toStringDAY(){
        return currDay;
    }
    
    // return the day value of the date thing
    public int toIntDay(){
        return Integer.parseInt(currDay.substring(0,2));
    }

    public int toIntMonth(){
        return Integer.parseInt(currDay.substring(3,5));
    }

    public int toIntYear(){
        return Integer.parseInt(currDay.substring(6));
    }


    /*
    returning day part of the date with accepted parameters   
    */

    public int toIntDay(String date){
        return Integer.parseInt(date.substring(0,2));
    }

    public int toIntMonth(String date){
        return Integer.parseInt(date.substring(3,5));
    }

    public int toIntYear(String date){
        return Integer.parseInt(date.substring(6));
    }


    // this method validates date 
    // if condition checks if the year is a leap year or no t
    // if leap year makes sure that the condition for febuary is taken care of  
    public boolean validateDate(String expirationDate) throws StringIndexOutOfBoundsException{
        String tempDate = expirationDate;    
        // Conditions for leap year
        if ((toIntYear(tempDate) % 4 == 0 ) && (toIntYear(tempDate) >= toIntYear()) ){
            if(toIntMonth(tempDate) >0 && toIntMonth(tempDate)<13 && toIntMonth(tempDate) >= toIntMonth() ){
                if(toIntMonth(tempDate) == 2){
                    if (toIntDay(tempDate)>0 && toIntDay(tempDate) <30 && toIntDay(tempDate) >= toIntDay() ){
                        return true;
                    }else{
                        System.out.println("The month of February can only have 29 days for Leap Year ! ");
                    }
                }else if(( (toIntMonth(tempDate) == 1) || (toIntMonth(tempDate) == 3) || (toIntMonth(tempDate) == 5) || (toIntMonth(tempDate) == 7) || (toIntMonth(tempDate) == 8) || (toIntMonth(tempDate) == 10) || (toIntMonth(tempDate) ==12 )) && toIntMonth(tempDate) >= toIntMonth()  ){
                    if( toIntDay(tempDate) > 0 && toIntDay(tempDate) < 32 && toIntDay(tempDate) >= toIntDay() ){
                        return true;
                    }else{
                        System.out.println("This month can only have 31 Days ! ");
                    } 
                }else{
                    if( toIntDay(tempDate) > 0 && toIntDay(tempDate) < 31 && toIntDay(tempDate) >= toIntDay() ){
                        return true;
                    }else{
                        System.out.println("This month can only have 30 Days ! ");
                    }
                }
            }else{
                return false;

            }
        }else if (toIntYear(tempDate) >= toIntYear()){
            if(toIntMonth(tempDate) >0 && toIntMonth(tempDate)<13 && toIntMonth(tempDate) >= toIntMonth() ){
                if(toIntMonth(tempDate) == 2){
                    if (toIntDay(tempDate)>0 && toIntDay(tempDate) <29 && toIntDay(tempDate) >= toIntDay() ){
                        return true;
                    }else{
                        System.out.println("The month of February can only have 29 days for Leap Year ! ");
                    }
                }else if(( (toIntMonth(tempDate) == 1) || (toIntMonth(tempDate) == 3) || (toIntMonth(tempDate) == 5) || (toIntMonth(tempDate) == 7) || (toIntMonth(tempDate) == 8) || (toIntMonth(tempDate) == 10) || (toIntMonth(tempDate) ==12 )) && toIntMonth(tempDate) >= toIntMonth()  ){
                    if( toIntDay(tempDate) > 0 && toIntDay(tempDate) < 32 && toIntDay(tempDate) >= toIntDay() ){
                        return true;
                    }else{
                        System.out.println("This month can only have 31 Days ! ");
                    } 
                }else{
                    if( toIntDay(tempDate) > 0 && toIntDay(tempDate) < 31 && toIntDay(tempDate) >= toIntDay() ){
                        return true;
                    }else{
                        System.out.println("This month can only have 30 Days ! ");
                    }
                }
            }else{
                return false;

            }
        }
        return false;
    }
}