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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

/**Classe qui représente le menu options du menu principal
 *
 * @author Édouard Raffis
 * @version 2.0
 * 2017-04-09
 */
public class MenuOptions {

    Stage superBillard;
    Scene menuOptions;
    AnchorPane paneOptions;
    Label masseLabel,rayonLabel, frottementLabel;
    TextField masseText, rayonText, frottementText;
    Button boutonMenu, boutonInitialiser;
    
    /**Constructeur de l'objet MenuOptions
     * 
     * @param stage stage
     */
    public MenuOptions(Stage stage) {
        this.superBillard = stage;
        paneOptions = new AnchorPane();

        //masse = new TextField("Masse des boules");
        boutonMenu = new Button("Menu Principal");

        boutonInitialiser = new Button("Enregistrer");
        masseText = new TextField("Masse");
        rayonText = new TextField("Rayon");
        frottementText = new TextField("Frottement");
        
        masseLabel = new Label("Masse :");
        rayonLabel = new Label("Rayon :");
        frottementLabel = new Label("Frottement :");

        AnchorPane.setBottomAnchor(boutonMenu, Double.valueOf(50));
        AnchorPane.setLeftAnchor(boutonMenu, Double.valueOf(100));

        AnchorPane.setBottomAnchor(boutonInitialiser, Double.valueOf(150));
        AnchorPane.setLeftAnchor(boutonInitialiser, Double.valueOf(100));

        AnchorPane.setBottomAnchor(masseText, Double.valueOf(235));
        AnchorPane.setLeftAnchor(masseText, Double.valueOf(125));

        AnchorPane.setBottomAnchor(rayonText, Double.valueOf(335));
        AnchorPane.setLeftAnchor(rayonText, Double.valueOf(125));

        AnchorPane.setBottomAnchor(frottementText, Double.valueOf(435));
        AnchorPane.setLeftAnchor(frottementText, Double.valueOf(125));
        
        AnchorPane.setBottomAnchor(frottementLabel, Double.valueOf(470));
        AnchorPane.setLeftAnchor(frottementLabel, Double.valueOf(125));
        
        AnchorPane.setBottomAnchor(rayonLabel, Double.valueOf(370));
        AnchorPane.setLeftAnchor(rayonLabel, Double.valueOf(125));
        
        AnchorPane.setBottomAnchor(masseLabel, Double.valueOf(270));
        AnchorPane.setLeftAnchor(masseLabel, Double.valueOf(125));

        boutonMenu.setStyle(
                "-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: white;"
                + "-fx-font-size: 20px;"
                + "-fx-pref-width: 200px;"
        );

        boutonInitialiser.setStyle(
                "-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: white;"
                + "-fx-font-size: 20px;"
                + "-fx-pref-width: 200px;"
        );

        masseText.setStyle(
                "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: black;"
                + "-fx-font-size: 15px;"
                + "-fx-pref-width: 150px;"
        );

        rayonText.setStyle(
                "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: black;"
                + "-fx-font-size: 15px;"
                + "-fx-pref-width: 150px;"
        );

        frottementText.setStyle(
                "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: black;"
                + "-fx-font-size: 15px;"
                + "-fx-pref-width: 150px;"
        );

        paneOptions.getChildren().addAll(boutonMenu, boutonInitialiser, masseText, rayonText, frottementText,masseLabel,rayonLabel,frottementLabel);
        menuOptions = new Scene(paneOptions, 400, 500);

        boutonMenu.setOnAction((ActionEvent e) -> {
            MenuPrincipal menuPrincipal = new MenuPrincipal(superBillard);
            superBillard.setScene(menuPrincipal.getMenu());
            superBillard.centerOnScreen();

        });

        boutonInitialiser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Masse : " + masseText.getText());
                System.out.println("Rayon : " + rayonText.getText());
                System.out.println("Frottement : " + frottementText.getText());

            }
        }
        );

        Image imageFond = new Image("Feutre.jpg", true);
        BackgroundImage fond = new BackgroundImage(imageFond, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        paneOptions.setBackground(new Background(fond));
    }
    
    /**Méthode qui permet de retourner l'objet de type MenuOptions
     * 
     * @return Objet MenuOptions
     */
    public Scene getMenu() {
        return menuOptions;
    }
}
