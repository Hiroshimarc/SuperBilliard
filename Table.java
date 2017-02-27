package table;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe Table qui permet de créer une talbe de billard en entrant les coordonnées, les dimensions et les couleurs de la table
 *
 * @author Victor Rondeau
 * 2017-02-27  Version 2.1
 */
public class Table extends Pane {
    
    /**
     * Constructeur de la classe Table qui prend les posisitions, les dimensisons et les couleurs pour créer une Table
     *
     * @param positionX1 Coordonnée en X de la table à partir du rectangle du centre
     * @param positionY1 Coordonnée en Y de la table à partir du rectangle du centre
     * @param longueur1 Longueur de la table (Côté horizontal)
     * @param largeur1 Largeur de la table (Côté vertical)
     * @param couleur1 Couleur du rectangle du centre
     * @param couleur2 Couleur du rebord de la table
     * @param couleur3 Couleur de l'ombre du rebord
     */
    public Table(int positionX1, int positionY1, int longueur1, int largeur1, Color couleur1, Color couleur2, Color couleur3){
        Rectangle table = new Rectangle(positionX1+20,positionY1+20,longueur1, largeur1);
        table.setFill(couleur1);
        Rectangle horsTable = new Rectangle(positionX1,positionY1,longueur1+42,largeur1+42);
        horsTable.setFill(couleur2);
        Rectangle ombreTable = new Rectangle(positionX1+13,positionY1+13,longueur1+15, largeur1+15);
        ombreTable.setFill(couleur3);
        TrouDeTable trouSuperieurGauche = new TrouDeTable(15,positionX1+24,positionY1+24);
        TrouDeTable trouSuperieurMilieu = new TrouDeTable(15,positionX1+(longueur1/2)+24,positionY1+24);
        TrouDeTable trouSuperieurDroite = new TrouDeTable(15,positionX1+longueur1+24,positionY1+24);
        TrouDeTable trouInferieurGauche = new TrouDeTable(15,positionX1+24,positionY1+20+largeur1);
        TrouDeTable trouInferieurMilieu = new TrouDeTable(15,positionX1+(longueur1/2)+24,positionY1+20+largeur1);
        TrouDeTable trouInferieurDroite = new TrouDeTable(15,positionX1+longueur1+24,positionY1+20+largeur1);
        
        getChildren().addAll(horsTable);
        getChildren().addAll(ombreTable);
        getChildren().addAll(table);
        getChildren().addAll(trouSuperieurGauche);
        getChildren().addAll(trouSuperieurMilieu);
        getChildren().addAll(trouSuperieurDroite);
        getChildren().addAll(trouInferieurGauche);
        getChildren().addAll(trouInferieurMilieu);
        getChildren().addAll(trouInferieurDroite);
        
    }
}
