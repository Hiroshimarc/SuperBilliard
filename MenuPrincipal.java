/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.Balle;
import Modèle.Table;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Edouard
 */
public class MenuPrincipal {

    public Scene menuPrincipal;
    Button boutonJouer, boutonOptions, boutonQuitter, boutonAPropos;
    GridPane paneMenu;
    Stage superBillard;

    public MenuPrincipal(Stage stage) {
        this.superBillard = stage;

        paneMenu = new GridPane();

        paneMenu.setHgap(10);
        paneMenu.setVgap(10);
        paneMenu.setPadding(new Insets(6, 6, 10, 10));

        boutonJouer = new Button("Jouer");
        boutonOptions = new Button("Options");
        boutonQuitter = new Button("Quitter");
        boutonAPropos = new Button("Aide");

        Image icone = new Image("Icone.png");
        superBillard.getIcons().add(icone);

        Image imageFond = new Image("BackGround.png", 1250, 625, true, true);
        BackgroundImage fond = new BackgroundImage(imageFond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        paneMenu.setBackground(new Background(fond));

        Image btJouer = new Image("Boule.jpg", 100, 100, true, true);
        BackgroundImage fondBouton = new BackgroundImage(btJouer, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondBoule = new Background(fondBouton);

        boutonJouer.setBackground(fondBoule);
        boutonAPropos.setBackground(fondBoule);
        boutonOptions.setBackground(fondBoule);
        boutonQuitter.setBackground(fondBoule);

        boutonJouer.setOnMouseEntered((MouseEvent t) -> {
            boutonJouer.setOpacity(0.75);
            boutonJouer.setBorder(new Border(new BorderStroke(Color.DARKBLUE, BorderStrokeStyle.SOLID, new CornerRadii(1000), new BorderWidths(2))));
        });

        boutonJouer.setOnMouseExited((MouseEvent t) -> {
            boutonJouer.setOpacity(1);
            boutonJouer.setBorder(null);
        });

        boutonOptions.setOnMouseEntered((MouseEvent t) -> {
            boutonOptions.setOpacity(0.75);
            boutonOptions.setBorder(new Border(new BorderStroke(Color.INDIGO, BorderStrokeStyle.SOLID, new CornerRadii(1000), new BorderWidths(2))));
        });

        boutonOptions.setOnMouseExited((MouseEvent t) -> {
            boutonOptions.setOpacity(1);
            boutonOptions.setBorder(null);
        });

        boutonAPropos.setOnMouseEntered((MouseEvent t) -> {
            boutonAPropos.setOpacity(0.75);
            boutonAPropos.setBorder(new Border(new BorderStroke(Color.DARKGREEN, BorderStrokeStyle.SOLID, new CornerRadii(1000), new BorderWidths(2))));
        });

        boutonAPropos.setOnMouseExited((MouseEvent t) -> {
            boutonAPropos.setOpacity(1);
            boutonAPropos.setBorder(null);
        });

        boutonQuitter.setOnMouseEntered((MouseEvent t) -> {
            boutonQuitter.setOpacity(0.75);
            boutonQuitter.setBorder(new Border(new BorderStroke(Color.DARKRED, BorderStrokeStyle.SOLID, new CornerRadii(1000), new BorderWidths(2))));
        });

        boutonQuitter.setOnMouseExited((MouseEvent t) -> {
            boutonQuitter.setOpacity(1);
            boutonQuitter.setBorder(null);
        });

        boutonJouer.setStyle(
                "-fx-min-width: 80px; "
                + "-fx-min-height: 80px; "
                + "-fx-max-width: 80px; "
                + "-fx-max-height: 80px;"
        );
        boutonOptions.setStyle(
                "-fx-min-width: 80px; "
                + "-fx-min-height: 80px; "
                + "-fx-max-width: 80px; "
                + "-fx-max-height: 80px;"
        );

        boutonQuitter.setStyle(
                "-fx-min-width: 80px; "
                + "-fx-min-height: 80px; "
                + "-fx-max-width: 80px; "
                + "-fx-max-height: 80px;"
        );

        boutonAPropos.setStyle(
                "-fx-min-width: 80px; "
                + "-fx-min-height: 80px; "
                + "-fx-max-width: 80px; "
                + "-fx-max-height: 80px;"
        );

        boutonQuitter.setOnAction((ActionEvent e) -> {
            System.exit(0);
        });

        boutonJouer.setOnAction((ActionEvent e) -> {
            paneMenu.getChildren().clear();
            paneMenu.setBackground(Background.EMPTY);
            MenuJouer menuJouer = new MenuJouer(superBillard);
            paneMenu.getChildren().add(menuJouer.paneJouer);
           
        });
        boutonOptions.setOnAction((ActionEvent e) -> {
            paneMenu.getChildren().clear();
            paneMenu.setBackground(Background.EMPTY);
            MenuOptions menuOptions = new MenuOptions(superBillard);
            paneMenu.getChildren().add(menuOptions.paneOptions);
        });
        boutonAPropos.setOnAction((ActionEvent e) -> {
            paneMenu.getChildren().clear();
            paneMenu.setBackground(Background.EMPTY);
            Menu_A_Propos menuAPropos = new Menu_A_Propos(superBillard);
            paneMenu.getChildren().add(menuAPropos.paneAPropos);
        });

        paneMenu.add(boutonJouer, 5, 2);
        paneMenu.add(boutonOptions, 100, 2);
        paneMenu.add(boutonAPropos, 5, 40);
        paneMenu.add(boutonQuitter, 100, 40);

        menuPrincipal = new Scene(paneMenu, 1250, 625);
    }

}
