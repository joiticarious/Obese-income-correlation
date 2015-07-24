/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import obesityincomecorrelation.Data;
import obesityincomecorrelation.obeseincome;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author corneliusoludeyi
 */
public class JUnitTest {
    
    private String state = "Alabama";
    private String white = "23";
    private String black = "34";
    private String overall = "25";
    private String hispanic = "19";
    private String income = "60264";
    
    Data data;
    
    obeseincome oi;
    
    List<Data> dataList;
    
    public JUnitTest() {
        
        data = new Data(state,overall,white,black,hispanic,income);
        
        oi = new obeseincome();
        
        dataList = new ArrayList<Data>();
        dataList.add(data);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
           @Test
    public void testGetState(){
        
        System.out.println("getState");
        String expResult = state;
        String result = data.getState();
        assertEquals(expResult, result);
        
    }
    
            @Test
    public void testGetWhite(){
        
        System.out.println("getWhite");
        String expResult = white;
        String result = data.getWhite();
        assertEquals(expResult, result);
        
    }
    
            @Test
    public void testGetBlack(){
        
        System.out.println("getBlack");
        String expResult = black;
        String result = data.getBlack();
        assertEquals(expResult, result);
        
    }
    
            @Test
    public void testGetHispanic(){
        
        System.out.println("getHispanic");
        String expResult = hispanic;
        String result = data.getHispanic();
        assertEquals(expResult, result);
        
    }
    
            @Test
    public void testGetIncome(){
        
        System.out.println("getIncome");
        String expResult = income;
        String result = data.getIncome();
        assertEquals(expResult, result);
        
    }
    
            @Test
    public void testGetOverall(){
        
        System.out.println("getOverall");
        String expResult = overall;
        String result = data.getOverall();
        assertEquals(expResult, result);
        
    }
    

    
}
