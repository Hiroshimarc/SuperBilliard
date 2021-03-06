package table;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe Table qui permet de créer une talbe de billard en entrant les coordonnées, les dimensions et les couleurs de la table
 *
 * @author Victor Rondeau
 * 2017-02-20  Version 1
 */
public class Table extends Pane {
    
    
    public Table(int positionX1, int positionY1, int longueur1, int largeur1, Color couleur1, Color couleur2, Color couleur3){
        Rectangle table = new Rectangle(positionX1+20,positionY1+20,longueur1, largeur1);
        table.setFill(couleur1);
        Rectangle horsTable = new Rectangle(positionX1,positionY1,longueur1+42,largeur1+42);
        horsTable.setFill(couleur2);
        Rectangle ombreTable = new Rectangle(positionX1+13,positionY1+13,longueur1+15, largeur1+15);
        ombreTable.setFill(couleur3);
        getChildren().addAll(horsTable);
        getChildren().addAll(ombreTable);
        getChildren().addAll(table);
    }
}
