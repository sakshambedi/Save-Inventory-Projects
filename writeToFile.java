/* 
    This method will write all the added items 
    in the array 
*/

//-------------- Importing libraries --------------
import java.io.IOException;
import java.io.File;


public class writeToFile{


    // method to write to a file 
    // checks if the the file is there 
    // if not makes a new file and checkForFile method passes the given information to method ahead 
    // otherwise call the method to write it to file and return true: validate insertion of data
    public void writingMethod(String[] ProductInfo){
        try{
            checkForFile("testFile.txt",ProductInfo); 
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }


    // create a method that creates a file if there is none 
    private void checkForFile(String FileName,String[] ProductInfo) throws IOException{
        File fileObj = new File(FileName);
            if(fileObj.exists()){
                // file doesn't already exist ! 
                System.out.println("Created a new File : " + fileObj.getName()); 
            }else{
                System.out.println("File Exists !");
            }
    }


    // method to write content to a file 


    // main method for debugging 
    public static void main(String[] args){
        writeToFile testCase =  new writeToFile();
        /*
        checkForFile debugging 
        this case works file for debugging
        */
        try{
            String[] testArray = {"Saksham", "Bedi", "Akshit"};
            System.out.println("When file doesnt exist : ");
            testCase.checkForFile("automated1.txt", testArray);
            testCase.checkForFile("automated2.txt",testArray);

            System.out.println("When the File Exists : ");
            testCase.checkForFile("newFile.txt", testArray);
            testCase.checkForFile("testFile.txt", testArray);
        }catch(IOException ioproblem){
            ioproblem.printStackTrace();
        }
        

    }


}