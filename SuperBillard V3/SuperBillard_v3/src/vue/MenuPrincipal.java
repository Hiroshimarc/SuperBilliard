/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**Classe qui représente le menu principal du jeu SuperBillard
 *
 * @author Édouard Raffis
 * @version 2.0
 * 2017-04-09
 */
public class MenuPrincipal {

    Stage superBillard;
    Scene menuPrincipal;
    Button boutonJouer, boutonOptions, boutonQuitter, boutonAide;
    AnchorPane panePrincipal;
    
    /**Constructeur de l'objet de type MenuPrincipal
     * 
     * @param stage stage
     */
    public MenuPrincipal(Stage stage) {

        this.superBillard = stage;
        panePrincipal = new AnchorPane();

        boutonJouer = new Button("Jouer");
        boutonOptions = new Button("Options");
        boutonAide = new Button("Aide");
        boutonQuitter = new Button("Quitter");

        AnchorPane.setTopAnchor(boutonJouer, Double.valueOf(125));
        AnchorPane.setLeftAnchor(boutonJouer, Double.valueOf(100));

        AnchorPane.setTopAnchor(boutonOptions, Double.valueOf(225));
        AnchorPane.setLeftAnchor(boutonOptions, Double.valueOf(100));

        AnchorPane.setTopAnchor(boutonAide, Double.valueOf(325));
        AnchorPane.setLeftAnchor(boutonAide, Double.valueOf(100));

        AnchorPane.setTopAnchor(boutonQuitter, Double.valueOf(425));
        AnchorPane.setLeftAnchor(boutonQuitter, Double.valueOf(100));

        Image imageFond = new Image("Feutre.jpg", true);
        BackgroundImage fond = new BackgroundImage(imageFond, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        panePrincipal.setBackground(new Background(fond));

        Image logo = new Image("Logo.png", 400, 900, true, true);
        ImageView logo1 = new ImageView(logo);

        panePrincipal.getChildren().add(logo1);

        boutonJouer.setStyle(
                "-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: white;"
                + "-fx-font-size: 20px;"
                + "-fx-pref-width: 200px;"
        );
        boutonOptions.setStyle(
                "-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: white;"
                + "-fx-font-size: 20px;"
                + "-fx-pref-width: 200px;"
        );

        boutonQuitter.setStyle(
                "-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: white;"
                + "-fx-font-size: 20px;"
                + "-fx-pref-width: 200px;"
        );

        boutonAide.setStyle(
                "-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: white;"
                + "-fx-font-size: 20px;"
                + "-fx-pref-width: 200px;"
        );

        boutonQuitter.setOnAction((ActionEvent e) -> {
            int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter?", "Super Billard", JOptionPane.YES_NO_OPTION);
            if (reponse == 0) {
                System.exit(0);
            }
        });

        boutonJouer.setOnAction((ActionEvent e) -> {
            MenuJouer menuJouer = new MenuJouer(superBillard);
            superBillard.setScene(menuJouer.getMenu());
            superBillard.centerOnScreen();

        });
        boutonOptions.setOnAction((ActionEvent e) -> {
            MenuOptions menuOptions = new MenuOptions(superBillard);
            superBillard.setScene(menuOptions.getMenu());
            superBillard.centerOnScreen();

        });

        boutonAide.setOnAction((ActionEvent e) -> {
            MenuAide menuAide = new MenuAide(superBillard);
            superBillard.setScene(menuAide.getMenu());
            superBillard.centerOnScreen();

        });

        panePrincipal.getChildren().addAll(boutonJouer, boutonOptions, boutonAide, boutonQuitter);

        menuPrincipal = new Scene(panePrincipal, 391, 500);
    }
    
    /**Méthode qui permet de retourner l'objet de type MenuPrincipal
     * 
     * @return Objet de type MenuPrincipal
     */
    public Scene getMenu() {
        return menuPrincipal;
    }
}
