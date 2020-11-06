package application;


import java.io.IOException;

import application.solutions.Solutions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;

public class Main extends Application {
    
	@Override public void start(Stage stage) throws Exception {
       
        
        Parent root = FXMLLoader.load(getClass().getResource("style.fxml"));
        Scene scene  = new Scene(root,1080,620);       
        
       
        stage.setScene(scene);
        stage.show();
    }
	 
    public static void main(String[] args) {
        Application.launch(args);
    }
}