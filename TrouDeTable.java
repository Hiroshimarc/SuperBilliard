package table;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Classe qui permet de créer un trou noir dans lequel les balles tomberont.
 *
 * @author Victor Rondeau
 * 2017-02-27  Version 1.1
 */
public class TrouDeTable extends Circle {
    private int rayon;
    private double positionX, positionY;
    private final Color couleur = Color.BLACK;
    
    /**
     * Constructeur de la classe TrouDeTable qui prend le rayon et les coordonnées pour créer un trou
     *
     * @param unRayon Rayon du trou
     * @param unePositionX Coordonnée en X du trou à partir du centre du trou
     * @param unePositionY Coordonnée en Y de trou à partir du centre du trou
     */
    public TrouDeTable(int unRayon, double unePositionX, double unePositionY){
        setRayon(unRayon);
        setPositionX(unePositionX);
        setPositionY(unePositionY);
        setFill(couleur);
    }
    
    //Accesseurs

    /**
     * Méthode qui permet d'obtenir le rayon du trou
     *
     * @return rayon
     */
    public int getRayon(){
        return rayon;
    }

    /**
     * Méthode qui permet d'obtenir la coordonnée en X du trou
     *
     * @return positionX
     */
    public double getPositionX(){
        return positionX;
    }

    /**
     * Méthode qui permet d'obtenir la coordonnée en X du trou
     *
     * @return positionY
     */
    public double getPositionY(){
        return positionY;
    }

    /**
     * Méthode qui permet d'obtenir la couleur du trou
     *
     * @return couleur
     */
    public Color getCouleur(){
        return couleur;
    }
    
    //Mutateurs

    /**
     * Méthode qui permet de modifier le rayon du trou
     *
     * @param rayon1 Nouveau rayon du trou
     */
    public void setRayon(int rayon1){
        setRadius(rayon1);
    }

    /**
     * Méthode qui permet de modifier la coordonnée en X du trou
     *
     * @param positionX1 Nouvelle coordonnée en X du trou
     */
    public void setPositionX(double positionX1){
        setLayoutX(positionX1);
    }

    /**
     * Méthode qui permet de modifier la coordonnée en Y du trou
     *
     * @param positionY1 Nouvelle coordonnée en Y du trou
     */
    public void setPositionY(double positionY1){
        setLayoutY(positionY1);
    }
    
}
