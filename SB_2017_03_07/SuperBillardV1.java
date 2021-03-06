/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;


import Modèle.Balle;
import Modèle.Table;
import vue.MenuPrincipal;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vue.MenuPrincipal;
import static javafx.application.Application.launch;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Edouard
 */
public class SuperBillardV1 extends Application {

    Stage superBillard;
    Scene menuPrincipal;

    @Override
    public void start(Stage stage) throws Exception {

        this.superBillard = stage;
        MenuPrincipal unMenuPrincipal = new MenuPrincipal(superBillard);
        this.menuPrincipal = unMenuPrincipal.menuPrincipal;

        superBillard = stage;
        superBillard.setWidth(1300);
        superBillard.setHeight(625);
        superBillard.setResizable(true);

        stage.setTitle("Super Billard");
        stage.setScene(menuPrincipal);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

