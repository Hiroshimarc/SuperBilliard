package troudetable;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Classe qui permet de créer un trou noir dans lequel les balles tomberont.
 *
 * @author Victor Rondeau
 * 2017-02-22
 */
public class TrouDeTable extends Circle {
    private int rayon;
    private double positionX, positionY;
    private final Color couleur = Color.BLACK;
    
    public TrouDeTable(int unRayon, int unePositionX, int unePositionY){
        rayon = unRayon;
        positionX = unePositionX;
        positionY = unePositionY;
        setFill(couleur);
    }
    
    //Accesseurs
    public int getRayon(){
        return rayon;
    }
    public double getPositionX(){
        return positionX;
    }
    public double getPositionY(){
        return positionY;
    }
    public Color getCouleur(){
        return couleur;
    }
    
    //Mutateurs
    public void setRayon(int rayon1){
        rayon=rayon1;
    }
    public void setPositionX(double positionX1){
        positionX=positionX1;
    }
    public void setPositionY(double positionY1){
        positionY=positionY1;
    }
    
}
