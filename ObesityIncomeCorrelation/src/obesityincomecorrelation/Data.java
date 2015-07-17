/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obesityincomecorrelation;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author corneliusoludeyi
 */
public class Data {
    
    private SimpleStringProperty state;
    private SimpleStringProperty overall;
    private SimpleStringProperty white;
    private SimpleStringProperty black;
    private SimpleStringProperty hispanic;
    private SimpleStringProperty income;
    
  
    
    public Data(String _state, String _overall,String _white, String _black, String _hispanic, String _income){
        
        
        this.state = new SimpleStringProperty(_state);
        this.overall = new SimpleStringProperty(_overall);
        this.white = new SimpleStringProperty(_white);
        this.black = new SimpleStringProperty(_black);
        this.hispanic = new SimpleStringProperty(_hispanic);
        this.income = new SimpleStringProperty(_income);
        
    }//end of constructor 
    
    //setter and getter for state
    public void setState(String STATE){
        this.state.set(STATE);
    }
    
    public String getState(){
        return state.get();
    }
    
    //setter and getter method for over all obesity
    public void setOverall(String OVERALL){
         this.overall.set(OVERALL);
    }
    
    public String getOverall(){
       
        return overall.get(); //the value is converted from String to double and returned
        
    }
    
    //setter and getther methods for non hispanic white
    public void setWhite(String WHITE){
        
    this.white.set(WHITE);
    
    }
    
    public String getWhite(){
        
        return white.get(); //the value is converted from String to double and returned
    }
    
    //setter and getter method for non hispanic black
    public void setBlack(String BLACK){
        this.black.set(BLACK);
    }
    
    public String getBlack(){
        
        return black.get(); //the value is converted from String to double and returned
    }
    
    //setter and getter method for hispanic
    public void setHispanic(String HISPANIC){
        this.hispanic.set(HISPANIC);
    }
    
    public String getHispanic(){
        
        return hispanic.get(); //the value is converted from String to double and returned
    }
    
    //setter and getter methods for income
    public void setIncome(String INCOME){
        this.income.set(INCOME);
    }
    
    public String getIncome(){
        
        return income.get(); //converts income frm String to Double and returns value
    }
}
