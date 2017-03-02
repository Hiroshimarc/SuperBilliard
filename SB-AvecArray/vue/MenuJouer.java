/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import Modèle.Balle;
import static Modèle.Balle.outOfSecondThread;
import Modèle.EnsembleDeBalles;
import Modèle.Table;
import Modèle.VitesseHorsLimiteException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author usager
 */
public class MenuJouer{

    Pane paneJouer;
    Scene menuJouer;
    Button boutonMenu;
    Stage superBillard;
    Table table;
    //Balle balle;
    Label indicationVitesse;
    Slider saisieVitesse;
    Label indicationAngle;
    public static Label attenteTour;
    TextField saisieAngle;
    public static Button appliquerVitesse;
    Rectangle graduationG;
    Rectangle graduationY;
    Rectangle graduationR;
    
    
    public MenuJouer(Stage stage) {
        superBillard = stage;
        paneJouer = new Pane();
        table = new Table(10, 10, 1000, 500, Color.GREEN, Color.BROWN, Color.rgb(128, 0, 0));
        menuJouer = new Scene(table, 1000, 500);
        //balle = new Balle(0,15, Color.WHITE, table.getWidth() / 2, table.getHeight() / 2);
        
        boutonMenu = new Button("Revenir au menu Principal");
        boutonMenu.setLayoutX(1070);
        boutonMenu.setLayoutY(525);
        
        appliquerVitesse= new Button("GO!");
        appliquerVitesse.setMaxSize(50, 50);
        appliquerVitesse.setLayoutX(1120);
        appliquerVitesse.setLayoutY(270);
        
        indicationVitesse = new Label("Vitesse:");
        indicationVitesse.setMaxSize(150, 30);
        indicationVitesse.setLayoutX(1070);
        indicationVitesse.setLayoutY(80);
        
        attenteTour = new Label("Veuillez attendre la fin du tour");
        attenteTour.setMaxSize(200,40);
        attenteTour.setLayoutX(1070);
        attenteTour.setLayoutY(320);
        
        
        saisieVitesse = new Slider();
        saisieVitesse.setMaxSize(150,30);
        saisieVitesse.setLayoutX(1070);
        saisieVitesse.setLayoutY(120);
        saisieVitesse.setMin(0);
        saisieVitesse.setMax(4);
        
        indicationAngle = new Label("Angle:");
        indicationAngle.setMaxSize(150, 30);
        indicationAngle.setLayoutX(1070);
        indicationAngle.setLayoutY(180);
        
        saisieAngle = new TextField("");
        saisieAngle.setMaxSize(150,30);
        saisieAngle.setLayoutX(1070);
        saisieAngle.setLayoutY(210);
        
        graduationG = new Rectangle(1070, 120, 50, 15);
        graduationG.setFill(Color.GREEN);
        graduationY = new Rectangle(1120, 120, 50, 15);
        graduationY.setFill(Color.YELLOW);
        graduationR = new Rectangle(1170, 120, 50, 15);
        graduationR.setFill(Color.RED);
        
        EnsembleDeBalles players = new EnsembleDeBalles(table);
        
        players.initialiserBalles(table);
        paneJouer.getChildren().add(table);
        //table.getChildren().add(balle);
        paneJouer.getChildren().add(boutonMenu);
        paneJouer.getChildren().add(appliquerVitesse);
        paneJouer.getChildren().add(graduationG);
        paneJouer.getChildren().add(graduationY);
        paneJouer.getChildren().add(graduationR);
        paneJouer.getChildren().add(indicationVitesse);
        paneJouer.getChildren().add(saisieVitesse);
        paneJouer.getChildren().add(indicationAngle);
        paneJouer.getChildren().add(saisieAngle);
        paneJouer.getChildren().add(attenteTour);
        attenteTour.setVisible(false);
        
        
        
        boutonMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                paneJouer.getChildren().clear();
                MenuPrincipal menuPrincipal = new MenuPrincipal(superBillard);
                superBillard.setScene(menuPrincipal.menuPrincipal);

            }
        }
        );
        
        appliquerVitesse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double angle = Double.parseDouble(saisieAngle.getText());
                //On demande la saisie de la vitesse qui sera considérée comme une vitesse en m/s
                try{
                    appliquerVitesse.setDisable(true);
                    attenteTour.setVisible(true);
                    double vitesse = saisieVitesse.getValue();
                    if(vitesse<=4 && vitesse>=0){
                        vitesse = players.balleBlanche.obtenirVitesseLancement(vitesse);
                        players.balleBlanche.launch(players.balleBlanche.angleDeTir(angle),vitesse, table);
                        players.collisionsBalles(table,angle,vitesse); 
                    }else{
                        throw new VitesseHorsLimiteException("veuillez entrer une vitesse comprise entre ");
                    }
                }catch(VitesseHorsLimiteException vhle){
                    JOptionPane.showMessageDialog(null, vhle.getMessage()+vhle.vitesseMinimale+" m/s et "+vhle.vitesseMaximale+" m/s");
                    paneJouer.getChildren().clear();
                    MenuPrincipal menuPrincipal = new MenuPrincipal(superBillard);
                    superBillard.setScene(menuPrincipal.menuPrincipal);
                }

            }
        }
        );

    }

}

