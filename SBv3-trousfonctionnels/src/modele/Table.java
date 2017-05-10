package modele;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe Table qui permet de créer une talbe de billard en entrant les coordonnées, les dimensions et les couleurs de la table
 *
 * @author Victor Rondeau
 * 2017-04-09  Version 2
 */
public class Table extends Pane {
    
    private TrouDeTable trouSuperieurGauche, trouSuperieurMilieu, trouSuperieurDroite, trouInferieurGauche, trouInferieurMilieu, trouInferieurDroite;
    private int positionX, positionY, longueur, largeur;
    private Color couleur1, couleur2, couleur3;
    
    /**
     *
     * @param positionX1
     * @param positionY1
     * @param longueur1
     * @param largeur1
     * @param couleur1
     * @param couleur2
     * @param couleur3
     */
    public Table(int positionX1, int positionY1, int longueur1, int largeur1, Color couleur1, Color couleur2, Color couleur3){
        Rectangle table = new Rectangle(positionX1+20,positionY1+20,longueur1, largeur1);
        table.setFill(couleur1);
        Rectangle horsTable = new Rectangle(positionX1,positionY1,longueur1+42,largeur1+42);
        horsTable.setFill(couleur2);
        Rectangle ombreTable = new Rectangle(positionX1+13,positionY1+13,longueur1+15, largeur1+15);
        ombreTable.setFill(couleur3);
        trouSuperieurGauche = new TrouDeTable(15,positionX1+24,positionY1+24);
        trouSuperieurMilieu = new TrouDeTable(15,positionX1+(longueur1/2)+24,positionY1+24);
        trouSuperieurDroite = new TrouDeTable(15,positionX1+longueur1+18,positionY1+24);
        trouInferieurGauche = new TrouDeTable(15,positionX1+24,positionY1+20+largeur1);
        trouInferieurMilieu = new TrouDeTable(15,positionX1+(longueur1/2)+24,positionY1+20+largeur1);
        trouInferieurDroite = new TrouDeTable(15,positionX1+longueur1+18,positionY1+20+largeur1);
        
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
    
    //Accesseurs

    /**Accesseur de trouSuperieurGauche
     *
     * @return trouSuperieurGauche
     */
    public TrouDeTable getTrouSuperieurGauche(){
        return trouSuperieurGauche;
    }

    /**Accesseur de TrouSuperieurMilieu
     *
     * @return trouSuperieurMilieu
     */
    public TrouDeTable getTrouSuperieurMilieu(){
        return trouSuperieurMilieu;
    }

    /**Accesseur de trouSuperieurDroite
     *
     * @return trouSuperieurDroite
     */
    public TrouDeTable getTrouSuperieurDroite(){
        return trouSuperieurDroite;
    }

    /**Accesseur de trouInferieurGauche
     *
     * @return trouInferieurGauche
     */
    public TrouDeTable getTrouInferieurGauche(){
        return trouInferieurGauche;
    }

    /**Accesseur de trouInferieurMilieu
     *
     * @return trouInferieurMilieu
     */
    public TrouDeTable getTrouInferieurMilieu(){
        return trouInferieurMilieu;
    }

    /**Accesseur de trouInferieurDroite
     *
     * @return trouInferieurDroite
     */
    public TrouDeTable getTrouInferieurDroite(){
        return trouInferieurDroite;
    }
    
    //Mutateurs

    /**Mutateur de trouSuperieurGauche
     *
     * @param unTrouSuperieurGauche
     */
    public void setTrouSuperieurGauche(TrouDeTable unTrouSuperieurGauche){
        trouSuperieurGauche = unTrouSuperieurGauche;
    }

    /**Mutateur de trouSuperieurMilieu
     *
     * @param unTrouSuperieurMilieu
     */
    public void setTrouSuperieurMilieu(TrouDeTable unTrouSuperieurMilieu){
        trouSuperieurMilieu = unTrouSuperieurMilieu;
    }

    /**Mutateur de trouSuperieurDroite
     *
     * @param unTrouSuperieurDroite
     */
    public void setTrouSuperieurDroite(TrouDeTable unTrouSuperieurDroite){
        trouSuperieurDroite = unTrouSuperieurDroite;
    }

    /**Mutateur de trouInferieurGauche
     *
     * @param unTrouInferieurGauche
     */
    public void setTrouInferieurGauche(TrouDeTable unTrouInferieurGauche){
        trouInferieurGauche = unTrouInferieurGauche;
    }

    /**Mutateur de trouInferieurMilieu
     *
     * @param unTrouInferieurMilieu
     */
    public void setTrouInferieurMilieu(TrouDeTable unTrouInferieurMilieu){
        trouInferieurMilieu = unTrouInferieurMilieu;
    }

    /**Mutateur de trouInferieurDroite
     *
     * @param unTrouInferieurDroite
     */
    public void setTrouInferieurDroite(TrouDeTable unTrouInferieurDroite){
        trouInferieurDroite = unTrouInferieurDroite;
    }

    /**Accesseur de positionX
     * @return the positionX
     */
    public int getPositionX() {
        return positionX;
    }

    /**Mutateur de positionX
     * @param positionX the positionX to set
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**Accesseur de positionY
     * @return the positionY
     */
    public int getPositionY() {
        return positionY;
    }

    /**Mutateur de positionY
     * @param positionY the positionY to set
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**Accesseur de longueur
     * @return the longueur
     */
    public int getLongueur() {
        return longueur;
    }

    /**Mutateur de longueur
     * @param longueur the longueur to set
     */
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    /**Accesseur de largeur
     * @return the largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**Mutateur de largeur
     * @param largeur the largeur to set
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**Accesseur de couleur1
     * @return the couleur1
     */
    public Color getCouleur1() {
        return couleur1;
    }

    /**Mutateur de couleur1
     * @param couleur1 the couleur1 to set
     */
    public void setCouleur1(Color couleur1) {
        this.couleur1 = couleur1;
    }

    /**Accesseur de couleur2
     * @return the couleur2
     */
    public Color getCouleur2() {
        return couleur2;
    }

    /**Mutateur de couleur2
     * @param couleur2 the couleur2 to set
     */
    public void setCouleur2(Color couleur2) {
        this.couleur2 = couleur2;
    }

    /**Accesseur de couleur3
     * @return the couleur3
     */
    public Color getCouleur3() {
        return couleur3;
    }

    /**Mutateur de couleur3
     * @param couleur3 the couleur3 to set
     */
    public void setCouleur3(Color couleur3) {
        this.couleur3 = couleur3;
    }
}
