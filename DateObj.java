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
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date dateobj = new Date();
        currDay = df.format(dateobj);
    }

    // returns the current Day
    public String toStringDAY(){
        return currDay;
    }
    
    // return the day value of the date thing
    public int toIntDay(){
        return Integer.parseInt(currDay.substring(1,1));
    }

    public int toIntMonth(){
        return Integer.parseInt(currDay.substring(4,6));
    }

    public int toIntYear(){
        return Integer.parseInt(currDay.substring(7));
    }


    public boolean compareDate(DateObj expirationDate){
            //if 
        return true;
    }
}