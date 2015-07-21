/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obesityincomecorrelation;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author corneliusoludeyi
 */
public class ObesityIncomeCorrelation extends Application {
    
       obeseincome oi = new obeseincome();
       
       TableView<Data> table = new TableView<Data>();
       
       Correlation pearsons;
       
       //array for the datasets
       double[] overallArray;
       double[] blackArray;
       double[] whiteArray;
       double[] hispanicArray;
       double[] incomeArray;
       
       int counter;
       
       Text text;
       

       //Note: the rows without data in the csv were replaced with 0. This is to prevent error when converting String to Double
              //however, the graph does not display the data as the X and Y axes do not include 0
  
    
    @Override
    public void start(Stage primaryStage) {
        
        overallArray = new double[51];
        blackArray = new double[51];
        whiteArray = new double[51];
        hispanicArray = new double[51];
        incomeArray = new double[51];
        
        pearsons = new Correlation();
        
        Button btn = new Button();
        
        text = new Text();
        
        final Label label = new Label("Average Income in different USA states & Obesity Rate Table");
        label.setFont(new Font("Segoe UI Semibold", 20)); 
        
        final Label viewlabel = new Label("View:");
     
        
      
        //this is the first column in the table
        TableColumn firstCol = new TableColumn("S/N");
      
        
        //this is the second column in the table
       final TableColumn secondCol = new TableColumn("State");
        secondCol.setCellValueFactory(new PropertyValueFactory<Data, String>("state"));
        
        //this is the third column in the table
       final TableColumn thirdCol = new TableColumn("Overall");
        thirdCol.setCellValueFactory(new PropertyValueFactory<Data, String>("overall"));
        thirdCol.setMinWidth(70);
        //this is the fourt column in the table
       final TableColumn fourthCol = new TableColumn("White");
        fourthCol.setCellValueFactory(new PropertyValueFactory<Data, String>("white"));
        fourthCol.setMinWidth(70);
        //this is the fifth column in the table
       final TableColumn fifthCol = new TableColumn("Black");
        fifthCol.setCellValueFactory(new PropertyValueFactory<Data, String>("black"));
        fifthCol.setMinWidth(70);
        //this is the sixth column in the table
       final TableColumn sixthCol = new TableColumn("Hispanic");
        sixthCol.setCellValueFactory(new PropertyValueFactory<Data, String>("hispanic"));
        sixthCol.setMinWidth(70);
        
        //this is the seventh column in the table
       final TableColumn seventhCol = new TableColumn("Income");
        seventhCol.setCellValueFactory(new PropertyValueFactory<Data, String>("income"));
       seventhCol.setMinWidth(80);
       
               try{
                   
          final ObservableList<Data> dd = FXCollections.observableArrayList(oi.we());
        
            
        //disables the table from being edited
        table.setEditable(false);
        
        //assigns list to the table
        table.setItems(dd);
        table.setMinWidth(500); //table's default minimum width
        table.setMinHeight(900); // table's default maximum height
        table.getColumns().addAll(firstCol,secondCol,seventhCol,thirdCol,fourthCol,fifthCol,sixthCol);
        
       }catch(Exception e){
                 e.printStackTrace();
               }//end of catch 
        
        //this is the choicebox or dropdown menu as popularly known
        final ChoiceBox<String> dropdown = new ChoiceBox<String>();
        
        //populates the ChoiceBox with values
        dropdown.getItems().addAll("Obesity Rate Vrs Overall", "All" , "Obesity Rate Vrs White Ethnic Group","Obesity Rate Vrs Black Ethnic Group","Obesity Rate Vrs Hispanic Ethnic Group");
        
        //sets default value
        dropdown.setValue("Obesity Rate Vrs Overall");
        
        //this is an horizontal box which is a container that aligns elements horizontally 
        HBox actionMenu = new HBox();
        actionMenu.setSpacing(5);
        actionMenu.getChildren().addAll(viewlabel,dropdown,btn); // the choice box and button are added to this container
        
        //sets margin for viewlabel
       HBox.setMargin(viewlabel, new Insets(5,5,5,50));
        
        //this is a vertical box which is a container that aligns elements vertically
        VBox leftMenu = new VBox();
        leftMenu.setSpacing(20);
        leftMenu.getChildren().addAll(label,table); // label, table and actionMenu are added to this container
                                                               // which will be on the left side
        
        VBox.setMargin(label, new Insets(10,10,10,50));
        VBox.setMargin(table, new Insets(0,10,10,20));
  
       
        final NumberAxis xAxis = new NumberAxis(40000,70000,200);
        final NumberAxis yAxis = new NumberAxis(20,37,1);
        
        final ScatterChart<Number, Number> sc = new ScatterChart<Number, Number>(xAxis, yAxis);
        yAxis.setLabel("Obesity Rate (%)");
        xAxis.setLabel("Income ($)");
        sc.setTitle("Scatter Plot for Obesity Rate - Average Income in USA");
        sc.setMinHeight(700);
        
        final XYChart.Series overallseries = new XYChart.Series<>();
        overallseries.setName("Overall Obesity");
        
        final XYChart.Series blackseries = new XYChart.Series<>();
        blackseries.setName("Black Obesity");
        
        final XYChart.Series whiteseries = new XYChart.Series<>();
        whiteseries.setName("White Obesity");
        
        final XYChart.Series hispanicseries = new XYChart.Series<>();
        hispanicseries.setName("Hispanic Obesity");
     
      
        
        
        try{
            
            counter = 0; //sets counter to zero 
            
            
        for(Data d: oi.we()){
            
            //retrieves data from Data class object named d and assigned to doule arrays after conversion from String to Array 
           overallArray[counter] = Double.valueOf(d.getOverall());
           whiteArray[counter] = Double.valueOf(d.getWhite());
           blackArray[counter] = Double.valueOf(d.getBlack());
           hispanicArray[counter] = Double.valueOf(d.getHispanic());
           incomeArray[counter] = Double.valueOf(d.getIncome());
            
            overallseries.getData().add(new XYChart.Data(Double.valueOf(d.getIncome()),Double.valueOf(d.getOverall())));
            
            whiteseries.getData().add(new XYChart.Data(Double.valueOf(d.getIncome()),Double.valueOf(d.getWhite())));
            
            hispanicseries.getData().add(new XYChart.Data(Double.valueOf(d.getIncome()),Double.valueOf(d.getHispanic())));
            
            blackseries.getData().add(new XYChart.Data(Double.valueOf(d.getIncome()),Double.valueOf(d.getBlack())));
            
            counter++;
            
        }//end of for loop
        
        Result(Correlation.getPearsonCorrelation(overallArray,incomeArray));
        
        }catch(Exception e){
            
            e.printStackTrace();
            
        }//end of catch
        
        
        
        VBox tableMenu = new VBox();
        tableMenu.setSpacing(30);
        tableMenu.getChildren().addAll(sc,actionMenu,text);
        
        VBox.setMargin(text, new Insets(5,5,5,50));
        
        sc.getData().addAll(overallseries);
   
        
        
        final BorderPane root = new BorderPane();
       // root.setTop(topMenu);
        root.setLeft(leftMenu);
        root.setCenter(tableMenu);
        
        btn.setText("Update!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
           
            
            @Override
            public void handle(ActionEvent event) {
                //when button is clicked do something
                System.out.println("Button clicked");
                
                   //assigns the dropdown value to v
        String v = dropdown.getValue();
        
        //switch case to handle the selected option in the choicebox after button is clicked
        switch(v){
            
            case "All":
                
              //  sc.getData().remove(whiteseries);
              //  sc.getData().remove(hispanicseries);
                sc.getData().remove(overallseries);
              //  sc.getData().addAll(overallseries);
                sc.getData().addAll(blackseries);
                sc.getData().addAll(whiteseries);
                sc.getData().addAll(hispanicseries);
                break;
            
            case "Obesity Rate Vrs Overall":
             
                sc.getData().remove(blackseries);
                sc.getData().remove(whiteseries);
                sc.getData().remove(hispanicseries);
                sc.getData().addAll(overallseries);
                Result(Correlation.getPearsonCorrelation(overallArray,incomeArray));
                break;
                
            case "Obesity Rate Vrs White Ethnic Group":
                
                sc.getData().remove(blackseries);
                sc.getData().remove(hispanicseries);
                sc.getData().remove(overallseries);
                sc.getData().addAll(whiteseries);
                Result(Correlation.getPearsonCorrelation(whiteArray,incomeArray));
                break;
                
            case "Obesity Rate Vrs Black Ethnic Group":
      
                sc.getData().remove(hispanicseries);
                sc.getData().remove(whiteseries);
                sc.getData().remove(overallseries);
                sc.getData().addAll(blackseries);
                Result(Correlation.getPearsonCorrelation(blackArray,incomeArray));
                break;
                
            case "Obesity Rate Vrs Hispanic Ethnic Group":
                
                sc.getData().remove(blackseries);
                sc.getData().remove(whiteseries);
                sc.getData().remove(overallseries);
                sc.getData().addAll(hispanicseries);
                Result(Correlation.getPearsonCorrelation(hispanicArray,incomeArray));
                break;
        }
                 
             
         
            }
        });
      
        
        Scene scene = new Scene(root, 1800, 1000); //default width and height of the screen
        
        primaryStage.setTitle("USA Obesity Rate - Average Income Overview");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
      
    } //end of main method
    
    private void Result(double result){
        
        
        if((result>= 0.5 && result <= 1.0) || (result >= -0.5 && result <= 1.0)){
            
            text.setText("There is High correlation between Average Income and this Obseity Rate "+result);
        }
        else if ((result >= 0.3 && result <= 0.5) || (result >= -0.03 && result <= 0.5)){
            
             text.setText("There is Medium correlation between Average Income and this Obseity Rate "+result);
            
        }else if((result >= 0.1 && result <= 0.3) || (result >= -0.1 && result <= -0.3)){
            
             text.setText("There is Low correlation between Average Income and this Obseity Rate "+result);
        }
        
        
        
    }//end of Result method
    
}


class Correlation{
    
       public static double getPearsonCorrelation(double[] scores1,double[] scores2){
        double result = 0;
        double sum_sq_x = 0;
        double sum_sq_y = 0;
        double sum_coproduct = 0;
        double mean_x = scores1[0];
        double mean_y = scores2[0];
        for(int i=2;i<scores1.length+1;i+=1){
            double sweep =Double.valueOf(i-1)/i;
            double delta_x = scores1[i-1]-mean_x;
            double delta_y = scores2[i-1]-mean_y;
            sum_sq_x += delta_x * delta_x * sweep;
            sum_sq_y += delta_y * delta_y * sweep;
            sum_coproduct += delta_x * delta_y * sweep;
            mean_x += delta_x / i;
            mean_y += delta_y / i;
        }
        double pop_sd_x = (double) Math.sqrt(sum_sq_x/scores1.length);
        double pop_sd_y = (double) Math.sqrt(sum_sq_y/scores1.length);
        double cov_x_y = sum_coproduct / scores1.length;
        result = cov_x_y / (pop_sd_x*pop_sd_y);
        return result;
    } //end of getPearsonCorrelation method
    
}//end of Correlation class