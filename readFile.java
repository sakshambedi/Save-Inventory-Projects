/*
    Objective : create an object to readFiles 
*/



// --------------- Importing Libraries -----------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// import java.nio.file.Path;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile{

    // assigning class variables 
    private ArrayList<String[]> FileData = new ArrayList<String[]>(); 
    private File fileToRead;


    // Constructor   
    public readFile(String FileWithDirectory){
        fileToRead = new File(FileWithDirectory);
    }


    // method to read each file
    public void readLineLine() throws IOException{
        String tempString ="";
        BufferedReader buffReader = new BufferedReader(new FileReader(fileToRead));
        Scanner scanTokens = new Scanner(buffReader).useDelimiter(";");
        while(scanTokens.hasNext()) {
            tempString = scanTokens.next();
            // System.out.println(tempString);
            String[] tempArray = tempString.split(",") ;
            // System.out.println(Arrays.toString(tempArray));
            FileData.add(tempArray);
        }
        for(String[] str : FileData) System.out.println(Arrays.toString(str));
        // BufferedReader.close();
        buffReader.close();
        scanTokens.close();
    } 
    
    

    // making a static main method 
    public static void main(String[] args){
        readFile readFile1 = new readFile("C:\\Users\\geeky\\OneDrive\\Documents\\COMP1020\\Assignments\\Save-Inventory-Projects\\logFile\\randomFile.txt");
        try{
            readFile1.readLineLine();
        }catch(IOException ioEx){
            ioEx.getMessage();
        }
    }

}