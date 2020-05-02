/* 
    This method will write all the added items 
    in the array 
*/

//-------------- Importing libraries --------------
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;


public class writeToFile{


    // method to write to a file 
    // checks if the the file is there 
    // if not makes a new file and checkForFile method passes the given information to method ahead 
    // otherwise call the method to write it to file and return true: validate insertion of data
    public static void writingMethod(String fileName, Object[] ProductInfo){
        try{
            // creating an object of this and file writing is done at an instance 
            writeToFile writeMethod =  new writeToFile();
        
            writeMethod.checkForFile(fileName,ProductInfo); 
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }


    // methods to check if the required directories exist or not 
    // static because need to check only once when the file is compiled
    public static boolean checkForDir(){
        // Assigning variables 
        String currentDir = System.getProperty("user.dir");

        File dirFile = new File( currentDir + "\\logFile");
        File expiredLog = new File( currentDir + "\\ExpLog");
        if (!dirFile.exists() && !expiredLog.exists()){
            // printing UI messages
            System.out.println("--------------------------------------------------");
            System.out.println("Necessary folders missing !");
            System.out.println("Cooking folders : " + dirFile.getName() + " and " + expiredLog.getName());
            System.out.println("Resolving issue.");
            System.out.println("--------------------------------------------------");

            return dirFile.mkdir() && expiredLog.mkdir(); 
        }

        // System.out.println("Issue Resolved");
        return true;
    }


    // method that returns the default log File directory 
    private String FileDirLocation(){
        return System.getProperty("user.dir") + "\\logFile\\" ;
    }

    // create a method that creates a file if there is none 
    private boolean checkForFile(String FileName,Object[] ProductInfo) throws IOException{
        File fileObj = new File(FileDirLocation() + FileName);
            if(fileObj.createNewFile()){
                // file doesn't already exist ! 
                System.out.println("--------------------------------------------------");
                System.out.println("Created a new File : " + fileObj.getName()); 
                System.out.println("--------------------------------------------------");
                return checkForFile(FileName, ProductInfo);
            }else{
                // System.out.println("File Exists !");
                return writeData(FileName, ProductInfo);
            }
    }


    // method to write content to a file 
    // return type boolean to verify if the data was added to the file or not 
    private boolean writeData(String FileName, Object[] ProductInfo) throws IOException{
        // isn't the best code here but can be fixed 
        PrintWriter printFile = new PrintWriter(new FileWriter(FileDirLocation() + FileName,true));
        // for loop to control the concatenation of , and ; according to the data
        // adds , in the end of the data item and 
        // adds ; in the end of the data set 
        for(int count = 0 ; count< 2 ; count++){
            if (count<1) printFile.print(ProductInfo[count]+",");
            else         printFile.print(ProductInfo[count]+ ";");
        }
        printFile.close();
        return true;
    }


    // main method for debugging 
    /*
    public static void main(String[] args){
        writeToFile testCase =  new writeToFile();
        
        checkForFile debugging 
        this case works file for debugging
        
        String[] testArray = {"Saksham", "Bedi", "Akshit"};
        testCase.writingMethod("testFile.txt",testArray);
        /*try{
            
            
            System.out.println("When file doesnt exist : ");
            testCase.checkForFile("automated1.txt", testArray);
            testCase.checkForFile("automated2.txt",testArray);

            System.out.println("When the File Exists : ");
            testCase.checkForFile("newFile.txt", testArray);
            testCase.checkForFile("testFile.txt", testArray);
            
        }catch(IOException ioproblem){
            ioproblem.printStackTrace();
        }
        

    }*/


}