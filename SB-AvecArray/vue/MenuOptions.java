/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author usager
 */
public class MenuOptions {

    GridPane paneOptions;
    Scene menuOptions;
    Button boutonMenu;
    Stage superBillard;

    public MenuOptions(Stage stage) {
        this.superBillard = stage;
        paneOptions = new GridPane();
        menuOptions = new Scene(paneOptions, 1250, 625);
        boutonMenu = new Button("Revenir au menu Principal");
        paneOptions.add(boutonMenu, 0, 0);
        boutonMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                paneOptions.getChildren().clear();
                MenuPrincipal menuPrincipal = new MenuPrincipal(superBillard);
                superBillard.setScene(menuPrincipal.menuPrincipal);
            }
        }
        );
    }
}

