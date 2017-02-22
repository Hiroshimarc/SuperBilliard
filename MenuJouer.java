/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.Balle;
import Modèle.Table;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author usager
 */
public class MenuJouer {

    Pane paneJouer;
    Scene menuJouer;
    Button boutonMenu;
    Stage superBillard;
    Table table;
    Balle balle;

    public MenuJouer(Stage stage) {
        superBillard = stage;
        paneJouer = new Pane();
        table = new Table(10, 10, 1000, 500, Color.GREEN, Color.BROWN, Color.rgb(128, 0, 0));
        menuJouer = new Scene(table, 1000, 500);
        balle = new Balle(15, Color.WHITE, table.getWidth() / 2, table.getHeight() / 2);
        double angle = Double.parseDouble(JOptionPane.showInputDialog("Entrez l'angle de tir en drgrés"));
        double vitesse = Double.parseDouble(JOptionPane.showInputDialog("Entrez la vitesse "));
        balle.launch(balle, balle.angleDeTir(angle), vitesse, table);
        
        boutonMenu = new Button("Revenir au menu Principal");
        
        
        paneJouer.getChildren().add(table);
        table.getChildren().add(balle);
        paneJouer.getChildren().add(boutonMenu);
        
        
        
        
        
        boutonMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                paneJouer.getChildren().clear();
                MenuPrincipal menuPrincipal = new MenuPrincipal(superBillard);
                superBillard.setScene(menuPrincipal.menuPrincipal);

            }
        }
        );

    }

}
