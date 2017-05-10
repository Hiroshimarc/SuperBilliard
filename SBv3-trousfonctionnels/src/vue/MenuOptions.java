/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Launcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modele.BalleStructure;

/**
 * Classe qui représente le menu options du menu principal
 *
 * @author Édouard Raffis
 * @version 2.0 2017-04-09
 */
public class MenuOptions {

    Stage superBillard;
    Scene menuOptions;
    AnchorPane paneOptions;
    Label masseLabel, musiqueLabel, frottementLabel;
    ComboBox frottement, masse, rayon;
    Button boutonMenu, boutonInitialiser, boutonMusique;
    Slider niveauMusique;
    public static double valeurFrottement=0.6305;
    public static double forceGravitationnelle=9.8;

    /**
     * Constructeur de l'objet MenuOptions
     *
     * @param stage stage
     */
    public MenuOptions(Stage stage) {
        this.superBillard = stage;
        paneOptions = new AnchorPane();

        boutonMenu = new Button("Menu Principal");

        boutonInitialiser = new Button("Enregistrer");
        boutonMusique = new Button("", new ImageView(new Image("musicLogo.png", 15, 15, true, true)));

        masseLabel = new Label("Masse :");
        musiqueLabel = new Label("Musique :");
        frottementLabel = new Label("Frottement :");

        ObservableList<String> optionsFrottement
                = FXCollections.observableArrayList(
                        "Asphalte",
                        "Glace",
                        "Or",
                        "Tapis"
                );
        frottement = new ComboBox(optionsFrottement);

        ObservableList<String> optionsMasse
                = FXCollections.observableArrayList(
                        "0,162kg (Américain)",
                        "0,127kg (Snooker)",
                        "0,209kg (Français)",
                        "0,280kg (Russe)"
                );
        masse = new ComboBox(optionsMasse);

        niveauMusique = new Slider(0, 0.25, Launcher.mp.getVolume());

        AnchorPane.setBottomAnchor(boutonMenu, Double.valueOf(50));
        AnchorPane.setLeftAnchor(boutonMenu, Double.valueOf(100));

        AnchorPane.setBottomAnchor(boutonInitialiser, Double.valueOf(150));
        AnchorPane.setLeftAnchor(boutonInitialiser, Double.valueOf(100));

        AnchorPane.setBottomAnchor(masse, Double.valueOf(235));
        AnchorPane.setLeftAnchor(masse, Double.valueOf(125));

        AnchorPane.setBottomAnchor(niveauMusique, Double.valueOf(335));
        AnchorPane.setLeftAnchor(niveauMusique, Double.valueOf(125));

        AnchorPane.setBottomAnchor(boutonMusique, Double.valueOf(335));
        AnchorPane.setLeftAnchor(boutonMusique, Double.valueOf(325));

        AnchorPane.setBottomAnchor(frottement, Double.valueOf(435));
        AnchorPane.setLeftAnchor(frottement, Double.valueOf(125));

        AnchorPane.setBottomAnchor(frottementLabel, Double.valueOf(470));
        AnchorPane.setLeftAnchor(frottementLabel, Double.valueOf(125));

        AnchorPane.setBottomAnchor(musiqueLabel, Double.valueOf(370));
        AnchorPane.setLeftAnchor(musiqueLabel, Double.valueOf(125));

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

        masse.setStyle(
                "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: black;"
                + "-fx-font-size: 15px;"
                + "-fx-pref-width: 150px;"
        );

        niveauMusique.setStyle(
                "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: black;"
                + "-fx-font-size: 15px;"
                + "-fx-pref-width: 150px;"
        );

        if (Launcher.mp.getStatus() == MediaPlayer.Status.PLAYING) {

            boutonMusique.setStyle("-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                    + " -fx-text-fill: black;"
                    + "-fx-font-size: 15px;"
                    + "-fx-pref-width: 15px;");
        } else {
            boutonMusique.setStyle("-fx-border-color:red;"
                    + "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                    + " -fx-text-fill: black;"
                    + "-fx-font-size: 15px;"
                    + "-fx-pref-width: 15px;");
        }

        frottement.setStyle(
                "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                + "-fx-background-insets: 0,1,2,3;"
                + "-fx-background-radius: 3,2,2,2;"
                + " -fx-text-fill: black;"
                + "-fx-font-size: 15px;"
                + "-fx-pref-width: 150px;"
        );

        paneOptions.getChildren()
                .addAll(boutonMenu, boutonInitialiser, masse, niveauMusique, frottement, masseLabel, musiqueLabel, frottementLabel, boutonMusique);
        menuOptions = new Scene(paneOptions, 400, 500);

        boutonMenu.setOnAction(
                (ActionEvent e) -> {
                    MenuPrincipal menuPrincipal = new MenuPrincipal(superBillard);
                    superBillard.setScene(menuPrincipal.getMenu());
                    superBillard.centerOnScreen();

                }
        );

        boutonInitialiser.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e
            ) {

                MenuJouer.background = frottement.getSelectionModel().getSelectedItem().toString();
                
                switch(frottement.getSelectionModel().getSelectedItem().toString()){
                    case "Asphalte" : valeurFrottement = 0.633;
                                      break;
                    case "Glace" : valeurFrottement = 0.6300005;
                                   break;
                    case "Or" : valeurFrottement = 0.63005;
                                break;
                    case "Tapis" : valeurFrottement = 0.6305;
                                   break;
                    default : JOptionPane.showMessageDialog(null,"Sélectionnez quelque chose");
                              break;     
                }
                
                switch(masse.getSelectionModel().getSelectedItem().toString()){
                    case "0,162kg (Américain)" : BalleStructure.masse = 0.162;
                                                 break;
                    case "0,127kg (Snooker)" : BalleStructure.masse = 0.127;
                                               break;
                    case "0,209kg (Français)" : BalleStructure.masse = 0.209;
                                                break;
                    case "0,280kg (Russe)" : BalleStructure.masse = 0.28;
                                             break;
                    default : JOptionPane.showMessageDialog(null,"Sélectionnez une masse");
                              break;
                }
                
            }
        }
        );

        niveauMusique.setOnMouseClicked(
                new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event
            ) {
                Launcher.mp.setVolume(niveauMusique.getValue() / 2);
            }
        }
        );

        boutonMusique.setOnAction(
                (ActionEvent e) -> {
                    if (Launcher.mp.getStatus() == MediaPlayer.Status.PLAYING) {
                        Launcher.mp.pause();
                        boutonMusique.setStyle("-fx-border-color: red;"
                                + "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                                + " -fx-text-fill: black;"
                                + "-fx-font-size: 15px;"
                                + "-fx-pref-width: 15px;");
                    }
                    if (Launcher.mp.getStatus() == MediaPlayer.Status.PAUSED) {
                        Launcher.mp.play();
                        boutonMusique.setStyle("-fx-border-color:null;"
                                + "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                                + " -fx-text-fill: black;"
                                + "-fx-font-size: 15px;"
                                + "-fx-pref-width: 15px;");
                    }
                }
        );

        Image imageFond = new Image("Feutre.jpg", true);
        BackgroundImage fond = new BackgroundImage(imageFond, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        paneOptions.setBackground(
                new Background(fond));
    }

    /**
     * Méthode qui permet de retourner l'objet de type MenuOptions
     *
     * @return Objet MenuOptions
     */
    public Scene getMenu() {
        return menuOptions;
    }
}
