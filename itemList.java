/*
@@  Public class items 
    used to store the name of the item and the expiration date 

*/

// ----------------importing libraries -------------------------
// import java.util.Date;
// import javafx.beans.binding.IntegerExpression;

public class itemList {

    private String[] arrayList;

    // constructor for the itemList 
    public itemList(String name,int foodType,String dateExpiration){
        arrayList = new String[3];
        arrayList[0] = name;
        arrayList[1] = String.valueOf(foodType);
        arrayList[2] = dateExpiration;
    }

    // method to return the array 
    public Object[] returnList(){
        return arrayList;
    }

    // method to return the name of the item 
    public String toStringItem(){
        return String.valueOf(arrayList[0]);
    }

    // method to return the Integer type item 
    // public Integer toIntType(){
    //     return  (Integer)arrayList[1];
    // }


    // method to return the String type item 
    public String toStringType(){
        return String.valueOf(arrayList[1]);
    }


    // method to return the String type item 
    public String toStringDate(){
        return String.valueOf(arrayList[2]);
    }

}