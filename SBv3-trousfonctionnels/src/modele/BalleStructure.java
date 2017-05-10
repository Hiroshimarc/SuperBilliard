/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import vue.MenuOptions;

/**
 * Classe qui représente le StackPane de la Balle avec son numéro
 *
 * @author Vittorio Passuello-Dussault
 * @version 2.1
 */
public class BalleStructure extends StackPane {

    //Attributs
    private Label etiquette;
    private Balle balle;
    private boolean enMouvement; //Variable booléenne qui mentionne si la balle est en mouvement
    private double positionInitialeX; //Position initiale en X de la Balle sur la table
    private double positionInitialeY; //Position initiale en Y de la Balle sur la table
    private double varX; //Composante en X du vecteur vitesse
    private double varY; //Composante en Y du vecteur vitesse
    private double vitesse; //Vitesse de BalleStructure
    private double angle; //Angle du lancé
    private int numero; //Numéro de l'objet BalleStructure
    private final double rayonBalleAmericaine = 0.0286; //Constante final double qui représente le rayon d'une balle américaine
    private boolean motif; //Attribut signalant si la balle a un motif ou non
    public static double masse;

    /**
     * Accesseur de la masse de la BalleStructure
     *
     */
    public double getMasse() {
        return this.masse;
    }
    
    /**
     * Accesseur de l'étiquette de la BalleStructure
     *
     */
    public Label getEtiquette() {
        return this.etiquette;
    }

    /**
     * Accesseur de la Balle du StackPane
     *
     */
    public Balle getBalle() {
        return this.balle;
    }

    /**
     * Accesseur du numéro de la BalleStructure
     *
     * @return numero de l'objet BalleStructure
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * Accesseur de l'état de mouvement de la BalleStructure
     *
     * @return enMouvement
     */
    public boolean getEnMouvement() {
        return this.enMouvement;
    }

    /**
     * Accesseur de la position initiale en X de la BalleStructure
     *
     * @return positionInitialeX
     */
    public double getPositionInitialeX() {
        return this.positionInitialeX;
    }

    /**
     * Accesseur de la position initiale en Y de la BalleStructure
     *
     * @return positionInitialeY
     */
    public double getPositionInitialeY() {
        return this.positionInitialeY;
    }

    /**
     * Accesseur de la variation en x de la BalleStructure
     *
     * @return Variation en X de la BalleStructure
     */
    public double getVarX() {
        return this.varX;
    }

    /**
     * Accesseur de la variation en Y de la BalleStructure
     *
     * @return Variation en Y de la BalleStructure
     */
    public double getVarY() {
        return this.varY;
    }

    /**
     * Accesseur de la vitesse de la BalleStructure
     *
     * @return Vitesse de la BalleStructure
     */
    public double getVitesse() {
        return this.vitesse;
    }

    /**
     * Accesseur de l'angle de la Balle
     *
     * @return Angle de la BalleStructure
     */
    public double getAngle() {
        return this.angle;
    }
    

    /**
     * Mutateur de la masse de la BalleStructure
     *
     */
    public void setMasse(double masse) {
        this.masse = masse;
    }
    
    /**
     * Mutateur de l'étiquette de la BalleStructure
     *
     */
    public void setEtiquette(Label etiquette) {
        this.etiquette = etiquette;
    }

    /**
     * Mutateur de l'objet Balle du StackPane
     *
     */
    public void setBalle(Balle balle) {
        this.balle = balle;
    }

    /**
     * Mutateur du numéro de la BalleStructure
     *
     * @param numero numero à assigner à l'objet BalleStructure
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Mutateur de l'état de mouvement de la BalleStructure
     *
     * @param enMouvement État de mouvement à attribuer à la BalleStructure
     */
    public void setEnMouvement(boolean enMouvement) {
        this.enMouvement = enMouvement;
    }

    /**
     * Mutateur de la position initiale en X de la BalleStructure
     *
     * @param positionInitialeX Position initiale en X à attribuer à la
     * BalleStructure
     */
    public void setPositionInitialeX(double positionInitialeX) {
        this.setLayoutX(positionInitialeX);
    }

    /**
     * Mutateur de la position initiale en X de la BalleStructure
     *
     * @param positionInitialeY Position initiale en Y à attribuer à la
     * BalleStructure
     */
    public void setPositionInitialeY(double positionInitialeY) {
        this.setLayoutY(positionInitialeY);
    }

    /**
     * Mutateur de la variation de position en X de la BalleStructure
     *
     * @param varX Variation en X à assigner à la BalleStructure
     */
    public void setVarX(double varX) {
        this.varX = varX;
    }

    /**
     * Mutateur de la variation de position en X de la BalleStructure
     *
     * @param varY Variation en Y à assigner à la BalleStructure
     */
    public void setVarY(double varY) {
        this.varY = varY;
    }

    /**
     * Mutateur de la vitesse de la BalleStructure
     *
     * @param vitesse vitesse à assigner à la BalleStructure
     */
    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    /**
     * Mutateur de l'angle de la BalleStructure
     *
     * @param angle angle à assigner à la BalleStructure
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * Constructeur avec paramètres
     *
     * @param etiquette Etiquette à sonner à la BalleStructure
     * @param balle Balle du StackPane
     */
    public BalleStructure(Balle balle, double masse) {
        Circle interieur = new Circle(8);
        interieur.setStroke(Color.WHITE);
        interieur.setFill(Color.WHITE);
        this.setEtiquette(new Label(balle.getNumero() + ""));
        this.setBalle(balle);
        if (balle.getNumero() == 0) {
            this.setEtiquette(new Label(""));
            interieur.setStroke(Color.TRANSPARENT);
            interieur.setFill(Color.TRANSPARENT);
        }
        //Création des motifs pour distinguer les balles des deux joueurs
        Rectangle motif = new Rectangle(9, 26);
        motif.setStroke(Color.WHITESMOKE);
        motif.setFill(Color.WHITESMOKE);
        motif.setArcHeight(5);
        motif.setArcWidth(5);
        if (balle.getNumero() < 9) {
            motif.setStroke(Color.TRANSPARENT);
            motif.setFill(Color.TRANSPARENT);
        }
        this.getChildren().addAll(balle, motif, interieur, etiquette);
        setMasse(masse);
    }

    /**
     * Constructeur par défaut de BalleStructure
     *
     */
    public BalleStructure() {

    }

    //MÉTHODES
    /**
     * Méthode qui détermine l'angle de tir de la balle
     *
     * @param angleEnDegres angle auquel on tire la balle en degrés
     * @return angle de tir en radians pour application dans le Thread Animation
     * d'une balle
     */
    public double angleDeTir(double angleEnDegres) {
        return (2*Math.PI)-Math.toRadians(angleEnDegres);

    }

    /**
     * Méthode qui permet de rassembler les conditions de collisions avec les
     * paroies de la table
     *
     * @param table
     * @return tabConditionsTable Tableau de données booléennes concernant les
     * collisions avec les paroies de la table
     */
    public boolean[] collisionsTable(Table table) { //Remplacer pane par table
        boolean[] tabConditionsTable = new boolean[4];
        Bounds limits = table.getLayoutBounds();
        boolean atRightBorder = this.getLayoutX() >= ((limits.getMaxX()) - this.getBoundsInLocal().getMaxX()-20);
        boolean atLeftBorder = this.getLayoutX() <= (limits.getMinX() + this.getBoundsInLocal().getMinX()+20);
        boolean atBottomBorder = this.getLayoutY() >= ((limits.getMaxY()) - this.getBoundsInLocal().getMaxY()-20);
        boolean atTopBorder = this.getLayoutY() <= (limits.getMinY() + this.getBoundsInLocal().getMinY()+20);
        tabConditionsTable[0] = atRightBorder;
        tabConditionsTable[1] = atLeftBorder;
        tabConditionsTable[2] = atBottomBorder;
        tabConditionsTable[3] = atTopBorder;
        return tabConditionsTable;
    }

    /**
     * Méthode qui permet la mise à jour de la position de la balle
     *
     * @param varX Variation de position en X
     * @param varY Variation de position en Y
     */
    public void updatePositionBalle(double varX, double varY) {
        this.setLayoutX(this.getLayoutX() + varX);
        this.setLayoutY(this.getLayoutY() + varY);
    }

    /**
     * Méthode qui permet la décélération de la balle
     *
     * @param axeVariation Axe de la variation de position (X ou Y)
     * @return axeVariation
     */
    public double decelerationBalle(double axeVariation) { //Rajouter la masse et le frottement dans les prochaines versions
        axeVariation = axeVariation/(MenuOptions.valeurFrottement*masse*MenuOptions.forceGravitationnelle);
        return axeVariation;
    }

    /**
     * Méthode qui permet d'initialiser les variations de positions de la Balle
     * avec l'orientation et la vitesse du tir
     *
     * @param varX Variation en X de la Balle
     * @param varY Variation en Y de la Balle
     * @param angle Angle de tir
     * @param vitesse Vitesse de tir
     * @return tabVariationsInitiales Tableau des valeurs des variations
     * initiales
     */
    public double[] initialiserVariationsBalle(double varX, double varY, double angle, double vitesse) {
        double[] tabVariationsInitiales = new double[2];
        varX = vitesse * Math.cos(angle);
        varY = vitesse * Math.sin(angle);
        tabVariationsInitiales[0] = varX;
        tabVariationsInitiales[1] = varY;
        return tabVariationsInitiales;
    }

    /**
     * Méthode qui permet de convertir la vitesse en m/s en vitesse en pixels/s
     * entrée par l'utilisateur
     *
     * @param vitesse
     * @return vitesse de lancement de l'objet Balle
     */
    public double obtenirVitesseLancementFromMS(double vitesse) {
        double vitesseChange = vitesse * metersToPixels();
        vitesseChange = vitesseChange * 0.001;
        return vitesseChange;
    }

    /**
     * Méthode qui permet de convertir la vitesse en km/h en vitesse en pixels/s
     * entrée par l'utilisateur
     *
     * @param vitesse vitesse en km/h
     * @return vitesse de lancement de l'objet Balle
     */
    public double obtenirVitesseLancementFromKH(double vitesse) {
        double vitesseChange = vitesse * kilometersToPixels();
        vitesseChange = vitesseChange * 0.001;
        return vitesseChange;
    }

    /**
     * Méthode qui permet de convertir la vitesse en px/s en m/s
     *
     * @param vitesse vitesse en px/s à convertir en m/s
     * @return vitesse en m/s
     */
    public double obtenirVitesseMS(double vitesse) {
        double vitesseChange = vitesse * pixelsToMeters();
        vitesseChange = vitesseChange / 0.001;
        return vitesseChange;
    }

    /**
     * Méthode qui permet de retourner la vitesse actuelle (en px/s)
     *
     * @return vitesse actuelle de l'objet Balle
     */
    public double obtenirVitesseActuelle() {
        return Math.sqrt((Math.pow(this.varX, 2) + Math.pow(this.varY, 2)));
    }
    
    /**
     * Méthode qui retourne l'angle actuel
     */
    public double orientationActuelle(){
        double orientation = 0;
        if(Math.atan(this.varY/this.varX)>0){
            orientation = Math.atan(this.varY/this.varX);
        }else{
            orientation = Math.PI + Math.atan(this.varY/this.varX);
        }
        return orientation;
    }

    /**
     * Méthode qui retourne la valeur d'un pixel en mètres
     *
     * @return valeur d'un pixel en mètres
     */
    public double pixelsToMeters() {
        //Règle de trois
        return (rayonBalleAmericaine) / (this.balle.getRadius()); //1 px = 0.0019m
    }

    /**
     * Méthode qui retourne la valeur d'un mètre en pixels
     *
     * @return valeur d'un mètre en pixels
     */
    public double metersToPixels() {
        //Règle de trois
        return (this.balle.getRadius()) / (rayonBalleAmericaine); //1 m = 524.48 px
    }

    /**
     * Méthode qui retourne la valeur d'un pixel en kilomètres Statut: À
     * Vérifier
     *
     * @return valeur d'un pixel en kilomètres
     */
    public double pixelsToKilometers() {
        //Règle de trois
        return (rayonBalleAmericaine / 1000) / (this.balle.getRadius());
    }

    /**
     * Méthode qui retourne la valeur d'un kilomètre en pixels Statut: À
     * Vérifier
     *
     * @return valeur d'un kilomètre en pixels
     */
    public double kilometersToPixels() {
        //Règle de trois
        return (this.balle.getRadius()) / (rayonBalleAmericaine / 1000);
    }

    /**
     * Méthode qui initialise la balle avant de la lancer
     *
     * @param angle Angle de lancement de l'objet Balle
     * @param vitesse Vitesse de lancement de l'objet Balle
     */
    public void prepareToLaunch(double angle, double vitesse) {
        this.setEnMouvement(true);
        this.setVitesse(vitesse);
        this.setAngle(angle);
        this.setVarX(initialiserVariationsBalle(varX, varY, angle, vitesse)[0]);
        this.setVarY(initialiserVariationsBalle(varX, varY, angle, vitesse)[1]);
    }

    /**
     * Méthode qui stoppe la Balle
     *
     */
    public void stopBalle() {
        this.setVitesse(0);
        this.setVarX(0);
        this.setVarY(0);
    }
}
