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
 * @version 0.2
 * 2017-04-09
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

    /**Méthode qui détermine l'angle de tir de la balle
     * 
     * @param angleEnDegres angle auquel on tire la balle en degrés
     * @return angle de tir en radians pour application dans le Thread Animation d'une balle
     */
    public double angleDeTir(double angleEnDegres){
        double angleValide = (2*Math.PI)-Math.toRadians(angleEnDegres);
        return angleValide;
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
    
    
    /**Méthode qui permet la mise à jour de la position de la balle
     * 
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
     * @return vitesse de lancement de l'objet Balle
     */
    public double obtenirVitesseLancement(double vitesse){
        double vitesseChange = vitesse*metersToPixels();
        vitesseChange = vitesseChange*0.001;
        return vitesseChange;
    }
    
    /**Méthode qui permet de convertir la vitesse en px/s en m/s
     * 
     * @param vitesse vitesse en px/s à convertir en m/s
     * @return vitesse en m/s
     */
    public double obtenirVitesseMS(double vitesse){
        double vitesseChange = vitesse*pixelsToMeters();
        vitesseChange = vitesseChange/0.001;
        return vitesseChange;
    }
    
    /**Méthode qui permet de retourner la vitesse actuelle (en px/s)
     * 
     * @return vitesse actuelle de l'objet Balle
     */
    public double obtenirVitesseActuelle(){
        return Math.sqrt((Math.pow(this.varX, 2)+Math.pow(this.varY,2)));
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
    
    
    
   /**Méthode qui initialise la balle avant de la lancer
    * 
     * @param angle Angle de lancement de l'objet Balle
     * @param vitesse Vitesse de lancement de l'objet Balle
    */
    public void prepareToLaunch(double angle,double vitesse){
        this.setEnMouvement(true);
        this.setVitesse(vitesse);
        this.setAngle(angle);
        this.setVarX(initialiserVariationsBalle(varX, varY, this.angle, this.vitesse)[0]);
        this.setVarY(initialiserVariationsBalle(varX, varY, this.angle, this.vitesse)[1]);
    }
    
    /**Méthode qui stoppe la Balle
     * 
     */
    public void stopBalle(){
        this.setVitesse(0);
        this.setVarX(0);
        this.setVarY(0);
    }
    
}
