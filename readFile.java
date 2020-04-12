/*
    Objective : create an object to readFiles 
*/



// --------------- Importing Libraries -----------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// import java.nio.file.Path;
import java.io.File;

public class readFile{

    // assigning class variables 
    private BufferedReader buffReader = null;
    private File fileToRead = null;

    public readFile(String FileWithDirectory){
        try{
            fileToRead = new File(FileWithDirectory);
            buffReader = new BufferedReader(new FileReader(fileToRead));
        }catch(IOException ioExcept){
            messages.printUIStar();
            System.out.println("Error : File Not Found !");
            messages.printUIStar();
        }
        
    }

    public void readLineLine(){

    }


}