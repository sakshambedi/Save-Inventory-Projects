/*
@@  Public class items 
    used to store the name of the item and the expiration date 

*/


public class item {

    String itemName;
    DateObj dateItem;

    public item(String name, DateObj date){
        itemName = name;
        dateItem = date; 
    }

}