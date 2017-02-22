/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piversionun;


import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/**Classe représentant une balle de Billard du jeu Super Billard
 * @version 0.1
 * @author Vittorio Passuello-Dussault
 * @see javafx.scene.shape.Circle
 */
public class Balle extends Circle{
    
    //Attributs d'une balle pour la version 1
    private double rayon; //Rayon de la balle
    private Color couleur; //Couleur de la balle
    private boolean enMouvement; //Variable booléenne qui mentionne si la balle est en mouvement
    private boolean visAvisTrou; //Variable booléenne qui mentionne si la balle doit tomber dans un trou de la table
    private double positionInitialeX; //Position initiale en X de la Balle sur la table
    private double positionInitialeY; //Position initiale en Y de la Balle sur la table
    
    //Accesseurs des Attributs
    
    /**Accesseur du rayon de la balle
     * @return rayon
     */
    public double getRayon(){
        return this.rayon;
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
    
    /**Accesseur de l'état du but
     * 
     * @return visAvisTrou
     */
    public boolean getVisAvisTrou(){
        return this.visAvisTrou;
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
    
    
    //Mutateurs des Attributs
    
    /**Mutateur du rayon de la balle
     * 
     * @param rayon Rayon à attribuer à la balle
     */
    public void setRayon(double rayon){
        this.setRadius(rayon);
    }
    
    /**Mutateur de la couleur de la balle
     * 
     * @param couleur Couleur à attribuer à la balle
     */
    public void setCouleur(Color couleur){
        this.setStroke(couleur);
        this.setFill(couleur);
    }
    
    /**Mutateur de l'état de mouvement de la balle
     * 
     * @param enMouvement État de mouvement à attribuer à la balle
     */
    public void setEnMouvement(boolean enMouvement){
        this.enMouvement = enMouvement;
    }
    
    /**Mutateur de l'état du but
     * 
     * @param visAvisTrou État du but à attribuer à la balle
     */
    public void setVisAvisTrou(boolean visAvisTrou){
        this.visAvisTrou = visAvisTrou;
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
    
    
    //Constructeurs de la classe Balle
    
    /**Constructeur par défaut de la Classe Balle
     * 
     */
    public Balle(){
        
    }
    
    /**Constructeur avec paramètres de la Classe Balle
     * 
     * @param rayon Rayon de la balle
     * @param couleur Couleur de la balle
     * @param positionInitialeX Position initiale en X de la balle
     * @param positionInitialeY Position initiale en Y de la balle
     */
    public Balle(double rayon, Color couleur, double positionInitialeX, double positionInitialeY){
        this.setRayon(rayon);
        this.setCouleur(couleur);
        this.setPositionInitialeX(positionInitialeX);
        this.setPositionInitialeY(positionInitialeY);
        this.setEnMouvement(false);
        this.setVisAvisTrou(false);
    }
    
    //Méthodes de la classe Balle
    
    /**Méthode qui permet de lancer la balle
     * 
     * @param balle Balle lancée
     * @param angle Angle de tir
     * @param vitesse Vitesse de tir
     * @param pane Surface de jeu
     */
    public void launch(Balle balle,double angle,double vitesse, Table table){ //Remplacer pane par la table
        //Création du Thread qui permet de lancer la balle et d'éffectuer d'autres opérations en arrière-plan
        new Thread(()->{
            double varX=0,varY=0;
            varX = initialiserVariationsBalle(varX, varY, angle, vitesse)[0];
            varY = initialiserVariationsBalle(varX, varY, angle, vitesse)[1];
            initialiserVariationsBalle(varX, varY, angle, vitesse);
            Thread.currentThread().setName("Animation d'une balle");
            while(!Thread.interrupted()){
                updatePositionBalle(balle, varX, varY);
                //Variation de la vitesse dans le temps
                varX=decelerationBalle(varX);
                varY=decelerationBalle(varY);
                //Conditions de collision avec les paroies
                if (collisionsTable(balle, table)[0] || collisionsTable(balle, table)[1]) {
                    varX *= -1;
                }

                if (collisionsTable(balle, table)[2] || collisionsTable(balle, table)[3]) {
                    varY *= -1;
                }

                if(Math.sqrt(Math.pow(varX, 2)+Math.pow(varY, 2)) < 0.025){
                    varX=0;
                    varY=0;
                    System.out.println("Thread de lancement terminé");
                    break;
                }
                
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    
                }

            }
            
        }).start();
    }
    
    /**Méthode qui détermine l'angle de tir de la balle
     * 
     * @param angleEnDegres angle auquel on tire la balle en degrés
     * @return angle de tir en radians pour application dans le Thread Animation d'une balle
     */
    public double angleDeTir(double angleEnDegres){
        double angle = Math.toRadians(angleEnDegres);
        return angle;
    }
    
    /**Méthode qui permet de rassembler les conditions de collisions avec les paroies de la table
     * 
     * @param balle balle observée
     * @param pane Surface de la table
     * @return tabConditionsTable Tableau de données booléennes concernant les collisions avec les paroies de la table
     */
    public boolean[] collisionsTable(Balle balle, Table table){ //Remplacer pane par table
        boolean[] tabConditionsTable = new boolean[4];
        Bounds limits = table.getLayoutBounds();
        boolean atRightBorder = balle.getLayoutX() >= ((limits.getMaxX()-400) - balle.getRadius());
        boolean atLeftBorder = balle.getLayoutX() <= (limits.getMinX()+20 + balle.getRadius());
        boolean atBottomBorder = balle.getLayoutY() >= ((limits.getMaxY()-360)- balle.getRadius());
        boolean atTopBorder = balle.getLayoutY() <= (limits.getMinY()+20 + balle.getRadius());
        tabConditionsTable[0]=atRightBorder;
        tabConditionsTable[1]=atLeftBorder;
        tabConditionsTable[2]=atBottomBorder;
        tabConditionsTable[3]=atTopBorder;
        return tabConditionsTable;
    }
    
    /**Méthode qui permet la mise à jour de la position de la balle
     * 
     * @param balle Balle observée
     * @param varX Variation de position en X
     * @param varY Variation de position en Y
     */
    public void updatePositionBalle(Balle balle, double varX, double varY){
        balle.setLayoutX(balle.getLayoutX() + varX);
        balle.setLayoutY(balle.getLayoutY() + varY);
    }
    
    /**Méthode qui permet la décélération de la balle
     * @param axeVariation Axe de la variation de position (X ou Y)
     * @return axeVariation
     */
    public double decelerationBalle(double axeVariation){ //Rajouter la masse et le frottement dans les prochaines versions
        axeVariation = 0.99925*axeVariation;
        return axeVariation;
    }
    
    /**Méthode qui permet d'initialiser les variations de positions de la Balle avec l'orientation et la vitesse du tir
     * @param varX Variation en X de la Balle
     * @param varY Variation en Y de la Balle
     * @param angle Angle de tir
     * @param vitesse Vitesse de tir
     * @return tabVariationsInitiales Tableau des valeurs des variations initiales
     */
    public double[] initialiserVariationsBalle(double varX, double varY, double angle, double vitesse){
        double[] tabVariationsInitiales = new double[2];
        varX = vitesse*Math.cos(angle);
        varY = vitesse*Math.sin(angle);
        tabVariationsInitiales[0] = varX;
        tabVariationsInitiales[1] = varY;
        return tabVariationsInitiales;
    }
}
