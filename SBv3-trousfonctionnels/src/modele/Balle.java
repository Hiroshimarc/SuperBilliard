/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;



import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

/**Classe représentant une balle de Billard du jeu Super Billard
 * @version 3.0
 * 2017-04-29
 * @author Vittorio Passuello-Dussault
 * @see javafx.scene.shape.Sphere
 */
public class Balle extends Sphere{
    
    //Attributs d'une balle pour la version 2
    //Le rayon de la balle est déjà un attribut de la classe Sphere (radius). Ce sera donc cet attribut qui sera utilisé
    private Color couleur; //Couleur de la balle
    private boolean enMouvement; //Variable booléenne qui mentionne si la balle est en mouvement
    private double positionInitialeX; //Position initiale en X de la Balle sur la table
    private double positionInitialeY; //Position initiale en Y de la Balle sur la table
    private double varX;
    private double varY;
    private double vitesse;
    private double angle;
    private int numero;
    private boolean balleEntree = false;
    
    //Accesseurs des Attributs
    
    /**Accesseur du rayon de la balle
     * @return rayon
     */
    public double getRayon(){
        return this.getRadius();
    }
    
    /**Accesseur du numéro de la Balle
     * 
     * @return numero de l'objet Balle
     */
    public int getNumero(){
        return this.numero;
    }
    
    /**Accesseur se la couleur de la balle
     * 
     * @return couleur
     */
    public Color getCouleur(){
        return this.couleur;
    }
    
    /**Accesseur de l'état de mouvement de la balle
     * 
     * @return enMouvement
     */
    public boolean getEnMouvement(){
        return this.enMouvement;
    }
    
    
    /**Accesseur de la position initiale en X de la balle
     * 
     * @return positionInitialeX
     */
    public double getPositionInitialeX(){
        return this.positionInitialeX;
    }
    
    /**Accesseur de la position initiale en Y de la balle
     * 
     * @return positionInitialeY
     */
    public double getPositionInitialeY(){
        return this.positionInitialeY;
    }
    
    /**Accesseur de la variation en x de la Balle
     * 
     * @return Variation en X de la Balle
     */
    public double getVarX(){
        return this.varX;
    }
    
    /**Accesseur de la variation en Y de la Balle
     * 
     * @return Variation en Y de la Balle
     */
    public double getVarY(){
        return this.varY;
    }
    
    /**Accesseur de la vitesse de la balle
     * 
     * @return Vitesse de la Balle
     */
    public double getVitesse(){
        return this.vitesse;
    }
    
    /**Accesseur de l'angle de la Balle
     * 
     * @return Angle de la Balle
     */
    public double getAngle(){
        return this.angle;
    }
    
    
    //Mutateurs des Attributs
    
    /**Mutateur du rayon de la balle
     * 
     * @param rayon Rayon à attribuer à la balle
     */
    public void setRayon(double rayon){
        this.setRadius(rayon); //Enregistrement du rayon de la balle selon les balles de type américaines (0.0286m de rayon)
        //IMPORTANT: Signifie que rayon(15 pixels) = 0,0286m
    }
    
    /**Mutateur du numéro de la Balle
     * 
     * @param numero numero à assigner à l'objet Balle
     */
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    /**Mutateur de la couleur de la balle
     * 
     * @param couleur Couleur à attribuer à la balle
     */
    public void setCouleur(Color couleur){
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(couleur);
        material.setSpecularColor(Color.BLACK);
        this.setMaterial(material);
    }
    
    /**Mutateur de l'état de mouvement de la balle
     * 
     * @param enMouvement État de mouvement à attribuer à la balle
     */
    public void setEnMouvement(boolean enMouvement){
        this.enMouvement = enMouvement;
    }
    
    /**Mutateur de la position initiale en X de la balle
     * 
     * @param positionInitialeX Position initiale en X à attribuer à la balle
     */
    public void setPositionInitialeX(double positionInitialeX){
        this.setLayoutX(positionInitialeX);
    }
    
    /**Mutateur de la position initiale en X de la balle
     * 
     * @param positionInitialeY Position initiale en Y à attribuer à la balle
     */
    public void setPositionInitialeY(double positionInitialeY){
        this.setLayoutY(positionInitialeY);
    }
    
    /**Mutateur de la variation de position en X de la Balle
     * 
     * @param varX Variation en X à assigner à la Balle
     */
    public void setVarX(double varX){
        this.varX = varX;
    }
    
    /**Mutateur de la variation de position en X de la Balle
     * 
     * @param varY Variation en Y à assigner à la Balle
     */
    public void setVarY(double varY){
        this.varY = varY;
    }
    
    /**Mutateur de la vitesse de la Balle
     * 
     * @param vitesse vitesse à assigner à la Balle
     */
    public void setVitesse(double vitesse){
        this.vitesse = vitesse;
    }
    
    /**Mutateur de l'angle de la Balle
     * 
     * @param angle angle à assigner à la Balle
     */
    public void setAngle(double angle){
        this.angle = angle;
    }
    
    
    //Constructeurs de la classe Balle
    
    /**Constructeur par défaut de la Classe Balle
     * 
     */
    public Balle(){
        
    }
    
    /**Constructeur avec paramètres de la Classe Balle
     * 
     * @param numero numéro de la Balle
     * @param rayon Rayon de la balle
     * @param couleur Couleur de la balle
     * @param positionInitialeX Position initiale en X de la balle
     * @param positionInitialeY Position initiale en Y de la balle
     */
    public Balle(int numero,double rayon, Color couleur, double positionInitialeX, double positionInitialeY){
        this.setNumero(numero);
        this.setRayon(rayon);
        this.setCouleur(couleur);
        this.setPositionInitialeX(positionInitialeX);
        this.setPositionInitialeY(positionInitialeY);
        this.setEnMouvement(false);
    }

    /**
     * @return the balleEntree
     */
    public boolean isBalleEntree() {
        return balleEntree;
    }

    /**
     * @param balleEntree the balleEntree to set
     */
    public void setBalleEntree(boolean balleEntree) {
        this.balleEntree = balleEntree;
    }

}