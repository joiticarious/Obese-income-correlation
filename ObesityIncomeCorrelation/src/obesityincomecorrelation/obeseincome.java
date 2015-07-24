package obesityincomecorrelation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class obeseincome{
    
    //this is the file path of the csv file
    private static final String filepath= "src/doc/Obesity prevalence rate.csv";
    
    
    private static final String COMMA = ",";
    
    //these are the indexes or position of each data
    private static final int STATE = 0;
    private static final int OVERALL = 1;
    private static final int WHITE = 2;
    private static final int BLACK = 3;
    private static final int HISPANIC = 4;
    private static final int INCOME = 5;
    
    private String state;
 
    private Scanner scanner;
    
    Data data;
    
    List<Data> dataList; //List for Data object
    
    String line;
    
   
    //default constructor
    public obeseincome(){
        
        dataList = new ArrayList<Data>();
        line = null;
         state = null;
    }
     
    //This method return a Data List
    public List<Data> we() throws FileNotFoundException{

         int row =1;
        
         try{
           
             
        //parse obese prevalence rate into obeserate array
            //get scanner 
        scanner = new Scanner(new File(filepath));
       
        //skips the first row which is the title
         scanner.nextLine();
         
         
        //scan, take and store in an array

        while (scanner.hasNext()){
            //get the line
           line = scanner.nextLine();  
           //split the lines at the commas 
           String[] array = line.split(COMMA);
           //copy the content and create a new array 
           
        if (array.length > 0){
            
               data = new Data(array[STATE],array[OVERALL],array[WHITE],array[BLACK],array[HISPANIC],array[INCOME]);
              
               dataList.add(data); //adds the Data class object to dataList list
               
        }//end of if statement
    
            }//end of while loop
         
        
    }//end of try
        catch (Exception e){
             e.printStackTrace();
        }
        finally{
            
            try{ //extra precaution
                
                //try close the scanner
            scanner.close();
            
            }//end of try
            catch(Exception ioe){
                
                ioe.printStackTrace();
                
            }//end of catch
        }
         
    
        
     return dataList;
  }//end of we method
    
    
}//end of class
