package finalOSP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class obeseincome{
    
    public static Double[][] obeserate = new Double [51][5];
    public static Double[][] income = new Double [51][2]; 
    
    public static void main(String[] args) throws FileNotFoundException{

         try{
       String line1 = null;
       
        int row = 1; 
       
       
        //parse obese prevalence rate into obeserate array
            //get scanner 
        Scanner scanner1 = new Scanner(new File("/Users/HongbinSun/Documents/Git/finalOSP/Obesity prevalence rate.csv"));
        Scanner scanner2 = new Scanner(new File("/Users/HongbinSun/Documents/Git/finalOSP/Median income.csv"));
        //set delimiter 
       // scanner1.useDelimiter(",");
       // scanner2.useDelimiter(",");
        //scan, take and store in an array
        
        while (scanner1.hasNext()){
            //get the line
           line1 = scanner1.nextLine();  
           //split the lines at the commas 
           String[] array1 = line1.split(",");
           //copy the content and create a new array 
        for (int i=0; i< array1.length; i++){
               obeserate[row][i] =  Double.parseDouble(array1[i]);
           
               row++;
        }//end of for loop
    
            }//end of while loop
         scanner1.close();
         
            System.out.print(obeserate);
        
    }//end of try
        catch (Exception e){
       System.out.print(e);
    
    }//end of catch
        
      //  while (scanner2.hasNext()){
        // input2 =  scanner2.nextline();
     //   }//end of while loop
        
         //do not forget to close the scanner
   
   // scanner2.close();
  }//end of main method
    
    
}//end of class
