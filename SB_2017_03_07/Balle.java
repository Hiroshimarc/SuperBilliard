/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;


import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import vue.MenuJouer;

/**Classe représentant une balle de Billard du jeu Super Billard
 * @version 0.1
 * @author Vittorio Passuello-Dussault
 * @see javafx.scene.shape.Circle
 */
public class Balle extends Sphere{
    
    //Attributs d'une balle pour la version 1
    private double rayon; //Rayon de la balle
    private Color couleur; //Couleur de la balle
    private boolean enMouvement; //Variable booléenne qui mentionne si la balle est en mouvement
    private boolean visAvisTrou; //Variable booléenne qui mentionne si la balle doit tomber dans un trou de la table
    private double positionInitialeX; //Position initiale en X de la Balle sur la table
    private double positionInitialeY; //Position initiale en Y de la Balle sur la table
    double varX;
    double varY;
    double vitesse;
    public static boolean outOfSecondThread = false;
    public static boolean outOfFirstThread = false;
    double angle;
    
    //Accesseurs des Attributs
    
    /**Accesseur du rayon de la balle
     * @return rayon
     */
    public double getRayon(){
        return this.getRadius();
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
        this.setRadius(rayon); //Enregistrement du rayon de la balle selon les balles de type américaines (0.0286m de rayon)
        //IMPORTANT: Signifie que rayon(15 pixels) = 0,0286m
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
    public Balle(int numero,double rayon, Color couleur, double positionInitialeX, double positionInitialeY){
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
    public void launch(double angle,double vitesse, Table table){ 
        //Création du Thread qui permet de lancer la balle et d'éffectuer d'autres opérations en arrière-plan
        this.vitesse = vitesse;
        this.angle = angle;
        varX = initialiserVariationsBalle(varX, varY, this.angle, this.vitesse)[0];
        varY = initialiserVariationsBalle(varX, varY, this.angle, this.vitesse)[1];
        new Thread(()->{
            Thread.currentThread().setName("Animation d'une balle");
            while(true){
                updatePositionBalle(varX, varY);
                //Variation de la vitesse dans le temps
                varX=decelerationBalle(varX);
                varY=decelerationBalle(varY);
                //Conditions de collision avec les paroies
                if (collisionsTable(table)[0] || collisionsTable(table)[1]) {
                    varX *= -1;
                }

                if (collisionsTable(table)[2] || collisionsTable(table)[3]) {
                    varY *= -1;
                }
                

                        if(Math.sqrt(Math.pow(varX, 2)+Math.pow(varY, 2)) < 0.025){
                            varX=0;
                            varY=0;
                            outOfSecondThread=true;
                            MenuJouer.appliquerVitesse.setDisable(false);
                            MenuJouer.saisieAngle.setDisable(false);
                            MenuJouer.attenteTour.setVisible(false);
                            break;
                        }

                
         
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    System.out.println("Thread intérompu");
                }

            }
            System.out.println("Thread de lancement terminé");
            
        }).start();
    }
    
    /**Méthode qui détermine l'angle de tir de la balle
     * 
     * @param angleEnDegres angle auquel on tire la balle en degrés
     * @return angle de tir en radians pour application dans le Thread Animation d'une balle
     */
    public double angleDeTir(double angleEnDegres){
        double angle = (2*Math.PI)-Math.toRadians(angleEnDegres);
        return angle;
    }
    
    /**Méthode qui permet de rassembler les conditions de collisions avec les paroies de la table
     * 
     * @param table
     * @return tabConditionsTable Tableau de données booléennes concernant les collisions avec les paroies de la table
     */
    public boolean[] collisionsTable(Table table){ //Remplacer pane par table
        boolean[] tabConditionsTable = new boolean[4];
        Bounds limits = table.getLayoutBounds();
        boolean atRightBorder = this.getLayoutX() >= ((limits.getMaxX())-20 - this.getRadius());
        boolean atLeftBorder = this.getLayoutX() <= (limits.getMinX()+20 + this.getRadius());
        boolean atBottomBorder = this.getLayoutY() >= ((limits.getMaxY()-20)- this.getRadius());
        boolean atTopBorder = this.getLayoutY() <= (limits.getMinY()+20 + this.getRadius());
        tabConditionsTable[0]=atRightBorder;
        tabConditionsTable[1]=atLeftBorder;
        tabConditionsTable[2]=atBottomBorder;
        tabConditionsTable[3]=atTopBorder;
        return tabConditionsTable;
    }
    
    /**Méthode qui permet de rassembler les conditions de collisions entre les balles
     * 
     */
    //public static void collisionsBalles()
    
    /**Méthode qui permet la mise à jour de la position de la balle
     * 
     * @param balle Balle observée
     * @param varX Variation de position en X
     * @param varY Variation de position en Y
     */
    public void updatePositionBalle(double varX, double varY){
        this.setLayoutX(this.getLayoutX() + varX);
        this.setLayoutY(this.getLayoutY() + varY);
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
    
    /**Méthode qui permet de convertir la vitesse en m/s en vitesse en pixels/s entrée par l'utilisateur
     * 
     * @param vitesse
     * @return 
     */
    public double obtenirVitesseLancement(double vitesse){
        double vitesseChange = vitesse*metersToPixels();
        vitesseChange = vitesseChange*0.001;
        return vitesseChange;
    }
    
    /**Méthode qui retourne le rayon d'une balle de type américaine
     * 
     * @return rayon d'une balle de billard américaine en mètres
     */
    public double rayonBalleAmericaine(){
        return 0.0286;
    }
    
    /**Méthode qui retourne cla valeur d'un pixel en mètres
     * 
     * @return valeur d'un pixel en mètres
     */
    public double pixelsToMeters(){
        //Règle de trois
        return (rayonBalleAmericaine())/(this.getRayon()); //1 px = 0.0019m
    }
    
    /**Méthode qui retourne cla valeur d'un mètre en pixels
     * 
     * @return valeur d'un mètre en pixels
     */
    public double metersToPixels(){
        //Règle de trois
        return (this.getRayon())/(rayonBalleAmericaine()); //1 m = 524.48 px
    }
    
}
