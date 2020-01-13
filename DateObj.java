
// ---------------- Importing Libraries ------------------
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;

public class DateObj extends Date {
    Date myDate;


    // method to convert Date as String
    // accepts date is a parameter  
    public static String toStringDate(Date enteredDate){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(enteredDate);
        return strDate;
    }


    // method that verifies the entered
    public static boolean verifyEnteredDate(){
        return true;
    }
}