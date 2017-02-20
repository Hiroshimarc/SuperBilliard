/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Classe Main pour tester la classe Table
 *
 * @author Victor Rondeau
 * 2017-02-20  Version 1
 */
public class mainTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane  canvas;
        canvas = new Pane();
        final Scene scene = new Scene(canvas, 1000, 500);

        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        Table uneTable = new Table(20,20,900,450,Color.GREEN,Color.BROWN,Color.rgb(128,0,0));
        
        canvas.getChildren().addAll(uneTable);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
