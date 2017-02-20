/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author usager
 */
public class MenuJouer {

    GridPane paneJouer;
    Scene menuJouer;
    Button boutonMenu;
    Stage superBillard;

    public MenuJouer(Stage stage) {
        superBillard = stage;
        paneJouer = new GridPane();
        menuJouer = new Scene(paneJouer, 1250, 625);
        boutonMenu = new Button("Revenir au menu Principal");
        paneJouer.add(boutonMenu, 0, 0);
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
