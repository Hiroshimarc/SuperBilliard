/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Launcher;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * Classse qui représente le menu aide du menu principal
 *
 * @author Édouard Raffis
 * @version 2.0 2017-04-09
 */
public class MenuAide {

    Stage superBillard;
    Scene menuAide;
    AnchorPane paneAide;
    Button boutonMenu, boutonSite, boutonSuperBillard, boutonMusique;
    TextArea regles;

    /**
     * Constructeur de l'objet MenuAide
     *
     * @param stage stage
     */
    public MenuAide(Stage stage) {
        this.superBillard = stage;
        paneAide = new AnchorPane();

        boutonMenu = new Button("Retourner au menu principal");
        boutonSite = new Button("Billard Quebec");
        boutonSuperBillard = new Button("Site du jeu");
        boutonMusique = new Button("", new ImageView(new Image("musicLogo.png", 15, 15, true, true)));
        regles = new TextArea();
        regles.setEditable(false);

        AnchorPane.setBottomAnchor(boutonMenu, Double.valueOf(10));
        AnchorPane.setRightAnchor(boutonMenu, Double.valueOf(100));

        AnchorPane.setBottomAnchor(boutonSite, Double.valueOf(10));
        AnchorPane.setLeftAnchor(boutonSite, Double.valueOf(240));

        AnchorPane.setBottomAnchor(boutonSuperBillard, Double.valueOf(10));
        AnchorPane.setLeftAnchor(boutonSuperBillard, Double.valueOf(100));

        AnchorPane.setTopAnchor(regles, Double.valueOf(10));
        AnchorPane.setLeftAnchor(regles, Double.valueOf(10));

        AnchorPane.setBottomAnchor(boutonMusique, Double.valueOf(0));
        AnchorPane.setRightAnchor(boutonMusique, Double.valueOf(0));

        regles.setMinSize(680, 440);

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

        boutonMenu.setStyle(
                "-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);"
                + " -fx-text-fill: white;"
                + "-fx-font-size: 10px;"
                + "-fx-pref-width: 150px;"
        );

        boutonSite.setStyle(
                "-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);"
                + " -fx-text-fill: white;"
                + "-fx-font-size: 10px;"
                + "-fx-pref-width: 125px;"
        );

        boutonSuperBillard.setStyle(
                "-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);"
                + " -fx-text-fill: white;"
                + "-fx-font-size: 10px;"
                + "-fx-pref-width: 125px;"
        );

        boutonSite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                openWebpage("http://www.billardquebec.com/jeu_de_la_huit.htm");
            }
        }
        );

        boutonSuperBillard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                openWebpage("http://www.superbillard.com/");
            }
        }
        );

        try {
            File f = new File("regle.txt");
            String reglements = "";
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            try {
                String line = br.readLine();

                while (line != null) {
                    reglements += line;
                    reglements += "\n";
                    line = br.readLine();
                }

                br.close();
                fr.close();
                regles.setText(reglements);

            } catch (IOException exception) {
                System.out.println("Erreur lors de la lecture : " + exception.getMessage());
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Le fichier n'a pas été trouvé");
        }

        paneAide.getChildren().addAll(boutonMenu, regles, boutonSite, boutonSuperBillard, boutonMusique);
        menuAide = new Scene(paneAide, 700, 500);

        boutonMenu.setOnAction((ActionEvent e) -> {
            MenuPrincipal menuPrincipal = new MenuPrincipal(superBillard);
            superBillard.setScene(menuPrincipal.getMenu());
            superBillard.centerOnScreen();

        });

        boutonMusique.setOnAction((ActionEvent e) -> {
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
        });

        Image imageFond = new Image("Feutre.jpg", true);
        BackgroundImage fond = new BackgroundImage(imageFond, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        paneAide.setBackground(new Background(fond));
    }

    /**
     * Méthode qui retourne l'objet MenuAide
     *
     * @return MenuAide
     */
    public Scene getMenu() {
        return menuAide;
    }

    /**
     * Méthode qui permet d'ouvrir une page de navigateur
     *
     * @param urlString URL
     */
    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
