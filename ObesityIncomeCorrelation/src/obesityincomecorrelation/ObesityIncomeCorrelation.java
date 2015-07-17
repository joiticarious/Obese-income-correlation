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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
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
       

    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        
        final Label label = new Label("Income & Obesity Table");
        label.setFont(new Font("Segoe UI Semibold", 20));
      
        TableColumn firstCol = new TableColumn("S/N");
        
       final TableColumn secondCol = new TableColumn("State");
        secondCol.setCellValueFactory(new PropertyValueFactory<Data, String>("state"));
        
       final TableColumn thirdCol = new TableColumn("Overall");
        thirdCol.setCellValueFactory(new PropertyValueFactory<Data, String>("overall"));
        
       final TableColumn fourthCol = new TableColumn("White");
        fourthCol.setCellValueFactory(new PropertyValueFactory<Data, String>("white"));
        
       final TableColumn fifthCol = new TableColumn("Black");
        fifthCol.setCellValueFactory(new PropertyValueFactory<Data, String>("black"));
        
       final TableColumn sixthCol = new TableColumn("Hispanic");
        sixthCol.setCellValueFactory(new PropertyValueFactory<Data, String>("hispanic"));
        
       final TableColumn seventhCol = new TableColumn("Income");
        seventhCol.setCellValueFactory(new PropertyValueFactory<Data, String>("income"));
       
               try{
                   
          final ObservableList<Data> dd = FXCollections.observableArrayList(oi.we());
        
            
        //disables the table from being edited
        table.setEditable(false);
        

        table.setItems(dd);
        table.setMinWidth(700);
        table.setMinHeight(800);
        table.getColumns().addAll(firstCol,secondCol,seventhCol,thirdCol,fourthCol,fifthCol,sixthCol);
        
       }catch(Exception e){
                 e.printStackTrace();
               }
        
        final Text txt = new Text();
       
        
        final ChoiceBox<String> dropdown = new ChoiceBox<String>();
        
        //populates the ChoiceBox with values
        dropdown.getItems().addAll("All","White","Black","Hispanic");
        
        //sets default value
        dropdown.setValue("All");
        
        HBox actionMenu = new HBox();
        actionMenu.setSpacing(50);
        actionMenu.getChildren().addAll(dropdown,btn);
        
        VBox leftMenu = new VBox();
        leftMenu.setSpacing(10);
        leftMenu.getChildren().addAll(label,table,actionMenu);
        
        VBox tableMenu = new VBox();
        tableMenu.setSpacing(10);
        tableMenu.getChildren().addAll(txt);
        
        
        final CategoryAxis xAxis2 = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        
        //chart 
       // final LineChart<String, Number> linechart = new LineChart<>(,);
       // linechart.setTitle("Line Chart");
        
        
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
        
       // System.out.print(v);
        
        switch(v){
            
            case "All":
                fourthCol.setVisible(true);
                fifthCol.setVisible(true);
                sixthCol.setVisible(true);
                seventhCol.setVisible(true);
                break;
            case "White":
                
                fourthCol.setVisible(false);
                fifthCol.setVisible(true);
                sixthCol.setVisible(false);
                seventhCol.setVisible(false);
                break;
            case "Black":
                fourthCol.setVisible(false);
                fifthCol.setVisible(false);
                sixthCol.setVisible(true);
                seventhCol.setVisible(false);
                break;
            case "Hispanic":
                fourthCol.setVisible(false);
                fifthCol.setVisible(false);
                sixthCol.setVisible(false);
                seventhCol.setVisible(true);
                break;
        }
                 
             
                  
        try{
       // oi.we();
        
        int counter = 0;
        
        for(Data d:oi.we()){
            
              counter++;
          
      //  txt.setText(counter+" "+d.getState()+","+d.getOverall()+" , "+d.getWhite()+" , "+d.getBlack()+" , "+d.getHispanic()+" , "+d.getIncome());
       
     
        
        }
        }catch(Exception e){
            System.out.println(e);
        }
         
            }
        });
      
        
        Scene scene = new Scene(root, 1000, 1000);
        
        primaryStage.setTitle("Obesity - Income Correlation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
      
    }
    
    private void getChoice(ChoiceBox<String> dropdown){
        
        //assigns the dropdown value to v
        String v = dropdown.getValue();
        
       // System.out.print(v);
        
        switch(v){
            
            case "All":
                break;
            case "White":
                
               // fourthCol.setVisible(true);
                break;
            case "Black":
                break;
            case "Hispanic":
                break;
        }
    }
    
}
