package obesityincomecorrelation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class obeseincome{
    
   // public static Double[][] obeserate = new Double [51][5];
   // public static Double[][] income = new Double [51][2]; 
    
    private static final String filepath= "src/doc/Obesity prevalence rate.csv";
    
    private static final String COMMA = ",";
    
    //these are the indexes
    private static final int STATE = 0;
    private static final int OVERALL = 1;
    private static final int WHITE = 2;
    private static final int BLACK = 3;
    private static final int HISPANIC = 4;
    private static final int INCOME = 5;
    
    private String state;
   // private int overall_obesity = 0;
   // private int non_hisoanic_white = 0;
   // private int non_hispanic_black = 0;
  //  private int hispanic = 0;
   // private int income = 0;
    
    private Scanner scanner;
    
    Data data;
    
    List<Data> dataList;
    
    String line;
    
   
    
    public obeseincome(){
        
        dataList = new ArrayList<Data>();
        line = null;
         state = null;
    }
     
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
              
               dataList.add(data);
               
        }//end of if statement
    
            }//end of while loop
         
        
    }//end of try
        catch (Exception e){
             e.printStackTrace();
        }
        finally{
            
            try{ //extra precaution
                
            scanner.close();
            
            }catch(Exception ioe){
                ioe.printStackTrace();
                
            }
        }
         
       //  for(Data d: dataList){
             
          //   System.out.println(row+" "+d.getState()+","+d.getOverall()+","+d.getWhite()+","+d.getBlack()+","+d.getHispanic()+","+d.getIncome());
             
           //  System.out.println(d.getWhite());
         //    row++;
        // }
        
     return dataList;
  }//end of we method
    
    
}//end of class
