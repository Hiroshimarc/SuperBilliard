/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piversionun;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**Méthode main test pour la classe Balle.java
 *
 * @author Vittorio Passuello-Dussault
 */
public class PIversionUn extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Table table = new Table(10,10,1000,500,Color.GREEN,Color.BROWN,Color.rgb(128,0,0));
        
        Scene scene = new Scene(table, 1020, 520);
        Balle test = new Balle(15,Color.WHITE,table.getWidth()/2,table.getHeight()/2);
        double angle = Double.parseDouble(JOptionPane.showInputDialog("Entrez l'angle de tir en drgrés"));
        double vitesse = Double.parseDouble(JOptionPane.showInputDialog("Entrez la vitesse "));
        test.launch(test,test.angleDeTir(angle),vitesse,table);
        table.getChildren().add(test);
        scene.setFill(Color.WHITE);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
