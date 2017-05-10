/*
 * Ensemble des balles 
 */
package modele;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javafx.application.Platform;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;

/**
 * Classe représentant l'ensemble des balles sur une table de billard 2017-04-09
 *
 * @author Vittorio Passuello-Dussault
 * @version 2.0
 * @see Balle
 */
public class EnsembleDeBalles extends BalleStructure {

    //Attributs
    private BalleStructure[] tabBalles = new BalleStructure[2];
    private BalleStructure balle1, balle2, balle3, balle4, balle5, balle6, balle7, balle9, balle10, balle11, balle12, balle13, balle14, balle15;
    private BalleStructure balleBlanche;
    private BalleStructure balleHuit;
    private Color motif = Color.WHITE;
    private int nombreBallesEntrees = 0;

    //Accesseurs des attributs
    /**
     * Accesseur du tableau d'objets BalleStructure tabBalles
     *
     * @return tabBalles Objet de type BalleStructure[], tableau des balles de
     * billard (BalleStructure) du jeu
     */
    public BalleStructure[] getTabBalles() {
        return this.tabBalles;
    }

    /**
     * Accesseur de la couleur du motif distinguant les objets BalleStructure
     * des deux équipes
     *
     * @return motif Couleur du motif qui distingue les objets BalleStructure
     * des deux équipes
     */
    public Color getMotif() {
        return this.motif;
    }

    /**
     * Accesseur de balleBlanche
     *
     * @return balleBlanche Balle blanche du jeu
     */
    public BalleStructure getBalleBlanche() {
        return this.balleBlanche;
    }

    /**
     * Accesseur de balle1
     *
     * @return balle1 balle numéro 1 du jeu
     */
    public BalleStructure getBalle1() {
        return this.balle1;
    }

    /**
     * Accesseur de balle2
     *
     *
     * @return balle2 balle numéro 2 du jeu
     */
    public BalleStructure getBalle2() {
        return this.balle2;
    }

    /**
     * Accesseur de balle3
     *
     * @return balle3 balle numéro 3 du jeu
     */
    public BalleStructure getBalle3() {
        return this.balle3;
    }

    /**
     * Accesseur de balle4
     *
     * @return balle4 balle numéro 4 du jeu
     */
    public BalleStructure getBalle4() {
        return this.balle4;
    }

    /**
     * Accesseur de balle5
     *
     * @return balle5 balle numéro 5 du jeu
     */
    public BalleStructure getBalle5() {
        return this.balle5;
    }

    /**
     * Accesseur de balle6
     *
     * @return balle6 balle numéro 6 du jeu
     */
    public BalleStructure getBalle6() {
        return this.balle6;
    }

    /**
     * Accesseur de balle7
     *
     * @return balle7 balle numéro 7 du jeu
     */
    public BalleStructure getBalle7() {
        return this.balle7;
    }

    /**
     * Accesseur de balleHuit
     *
     * @return balleHuit balle numéro 8 du jeu
     */
    public BalleStructure getBalleHuit() {
        return this.balleHuit;
    }

    /**
     * Accesseur de balle9
     *
     * @return balle9 balle numéro 9 du jeu
     */
    public BalleStructure getBalle9() {
        return this.balle9;
    }

    /**
     * Accesseur de balle10
     *
     * @return balle10 balle numéro 10 du jeu
     */
    public BalleStructure getBalle10() {
        return this.balle10;
    }

    /**
     * Accesseur de balle11
     *
     * @return balle11 balle numéro 11 du jeu
     */
    public BalleStructure getBalle11() {
        return this.balle11;
    }

    /**
     * Accesseur de balle12
     *
     * @return balle12 balle numéro 12 du jeu
     */
    public BalleStructure getBalle12() {
        return this.balle12;
    }

    /**
     * Accesseur de balle13
     *
     * @return balle13 balle numéro 13 du jeu
     */
    public BalleStructure getBalle13() {
        return this.balle13;
    }

    /**
     * Accesseur de balle14
     *
     * @return balle14 balle numéro 14 du jeu
     */
    public BalleStructure getBalle14() {
        return this.balle14;
    }

    /**
     * Accesseur de balle15
     *
     * @return balle15 balle numéro 15 du jeu
     */
    public BalleStructure getBalle15() {
        return this.balle15;
    }

    //Mutateurs
    /**
     * Mutateur de l'objet tabBalles de type BalleStructure[]
     *
     * @param tabBalles Objet de type BalleStructure[] à assigner à l'attribut
     * tabBalles
     */
    public void setTabBalles(BalleStructure[] tabBalles) {
        this.tabBalles = tabBalles;
    }

    /**
     * Mutateur de l'attribut motif
     *
     * @param motif couleur à considérer comme un motif
     */
    public void setMotif(Color motif) {
        this.motif = motif;
    }

    /**
     * Mutateur de balleBlanche (balle blanche du jeu de billard)
     *
     * @param balleBlanche Objet BalleStructure à considérer comme une balle
     * blanche
     */
    public void setBalleBlanche(BalleStructure balleBlanche) {
        this.balleBlanche = balleBlanche;
    }

    /**
     * Mutateur de la balle1
     *
     * @param balle BalleStructure qui remplacera la balle1
     */
    public void setBalle1(BalleStructure balle) {
        this.balle1 = balle;
    }

    /**
     * Mutateur de la balle2
     *
     * @param balle BalleStructure qui remplacera la balle2
     */
    public void setBalle2(BalleStructure balle) {
        this.balle2 = balle;
    }

    /**
     * Mutateur de la balle3
     *
     * @param balle BalleStructure qui remplacera la balle3
     */
    public void setBalle3(BalleStructure balle) {
        this.balle3 = balle;
    }

    /**
     * Mutateur de la balle4
     *
     * @param balle BalleStructure qui remplacera la balle4
     */
    public void setBalle4(BalleStructure balle) {
        this.balle4 = balle;
    }

    /**
     * Mutateur de la balle5
     *
     * @param balle BalleStructure qui remplacera la balle5
     */
    public void setBalle5(BalleStructure balle) {
        this.balle5 = balle;
    }

    /**
     * Mutateur de la balle6
     *
     * @param balle BalleStructure qui remplacera la balle6
     */
    public void setBalle6(BalleStructure balle) {
        this.balle6 = balle;
    }

    /**
     * Mutateur de la balle7
     *
     * @param balle BalleStructure qui remplacera la balle7
     */
    public void setBalle7(BalleStructure balle) {
        this.balle7 = balle;
    }

    /**
     * Mutateur de la balle9
     *
     * @param balle BalleStructure qui remplacera la balle9
     */
    public void setBalle9(BalleStructure balle) {
        this.balle9 = balle;
    }

    /**
     * Mutateur de la balle10
     *
     * @param balle BalleStructure qui remplacera la balle10
     */
    public void setBalle10(BalleStructure balle) {
        this.balle10 = balle;
    }

    /**
     * Mutateur de la balle11
     *
     * @param balle BalleStructure qui remplacera la balle11
     */
    public void setBalle11(BalleStructure balle) {
        this.balle11 = balle;
    }

    /**
     * Mutateur de la balle12
     *
     * @param balle BalleStructure qui remplacera la balle12
     */
    public void setBalle12(BalleStructure balle) {
        this.balle12 = balle;
    }

    /**
     * Mutateur de la balle13
     *
     * @param balle BalleStructure qui remplacera la balle1
     */
    public void setBalle13(BalleStructure balle) {
        this.balle13 = balle;
    }

    /**
     * Mutateur de la balle14
     *
     * @param balle BalleStructure qui remplacera la balle14
     */
    public void setBalle14(BalleStructure balle) {
        this.balle14 = balle;
    }

    /**
     * Mutateur de la balle15
     *
     * @param balle BalleStructure qui remplacera la balle15
     */
    public void setBalle15(BalleStructure balle) {
        this.balle15 = balle;
    }

    /**
     * Mutateur de balleHuit (Balle huit du jeu de billard)
     *
     * @param balleHuit Objet BalleStructure à considérer comme une balle huit
     */
    public void setBalleHuit(BalleStructure balleHuit) {
        this.balleHuit = balleHuit;
    }

    /**
     * Constructeur de l'EnsembleDeBalles à placer sur une surface de jeu
     * précise
     *
     * @param surfaceDeJeu Tapis de jeu
     */
    public EnsembleDeBalles(Table surfaceDeJeu) {

        balleBlanche = new BalleStructure(new Balle(0, 10, Color.WHITE, surfaceDeJeu.getBoundsInLocal().getWidth() / 3, surfaceDeJeu.getBoundsInLocal().getHeight() / 2), 0.162);
        balleHuit = new BalleStructure(new Balle(8, 10, Color.BLACK, 2.295 * surfaceDeJeu.getBoundsInLocal().getWidth() / 3, surfaceDeJeu.getBoundsInLocal().getHeight() / 2), 0.162);

        balleBlanche.setLayoutX(surfaceDeJeu.getBoundsInLocal().getWidth() / 3);
        balleBlanche.setLayoutY(surfaceDeJeu.getBoundsInLocal().getHeight() / 2);

        //Balles avec motifs
        int r=12;
        balle9 = new BalleStructure(new Balle(9, r, Color.RED, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 60), 0.162);
        balle10 = new BalleStructure(new Balle(10, r, Color.BLUE, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 90), 0.162);
        balle11 = new BalleStructure(new Balle(11, r, Color.YELLOW, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 120), 0.162);
        balle12 = new BalleStructure(new Balle(12, r, Color.CYAN, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 150), 0.162);
        balle13 = new BalleStructure(new Balle(13, r, Color.PURPLE, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 180), 0.162);
        balle14 = new BalleStructure(new Balle(14, r, Color.CHARTREUSE, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 210), 0.162);
        balle15 = new BalleStructure(new Balle(15, r, Color.DARKGOLDENROD, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 240), 0.162);

        //Balles sans motifs
        balle1 = new BalleStructure(new Balle(1, r, Color.RED, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 60), 0.162);
        balle2 = new BalleStructure(new Balle(2, r, Color.BLUE, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 90), 0.162);
        balle3 = new BalleStructure(new Balle(3, r, Color.YELLOW, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 120), 0.162);
        balle4 = new BalleStructure(new Balle(4, r, Color.CYAN, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 150), 0.162);
        balle5 = new BalleStructure(new Balle(5, r, Color.PURPLE, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 180), 0.162);
        balle6 = new BalleStructure(new Balle(6, r, Color.CHARTREUSE, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 210), 0.162);
        balle7 = new BalleStructure(new Balle(7, r, Color.DARKGOLDENROD, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 240), 0.162);

        //Ajout des balles au tableau tabBalles
        tabBalles[0] = balleBlanche;
        /*tabBalles[1] = balle1;
        tabBalles[2] = balle2;
        tabBalles[3] = balle3;
        tabBalles[4] = balle4;
        tabBalles[5] = balle5;
        tabBalles[6] = balle6;*/
        tabBalles[1] = balle7;
        /*tabBalles[8] = balle9;
        tabBalles[9] = balle10;
        tabBalles[10] = balle11;
        tabBalles[11] = balle12;
        tabBalles[12] = balle13;
        tabBalles[13] = balle14;
        tabBalles[14] = balle15;
        tabBalles[15] = balleHuit;*/

        surfaceDeJeu.getChildren().addAll(Arrays.asList(tabBalles));
    }

    /**
     * Méthode qui permet de positionner les balles pour le premier coup
     *
     * @param surfaceDeJeu Objet Table qui représente la table de billard
     */
    public void initialiserBalles(Table surfaceDeJeu) {

        balle9.setLayoutY(surfaceDeJeu.getBoundsInLocal().getHeight() / 2);
        balle9.setLayoutX(2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3));

        balle7.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) - balle9.getBalle().getRayon());
        balle7.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 2 * (balle9.getBalle().getRayon()));

        balle12.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) + balle9.getBalle().getRayon());
        balle12.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 2 * (balle9.getBalle().getRayon()));

        balle15.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) - (2 * (balle9.getBalle().getRayon())));
        balle15.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 4 * (balle9.getBalle().getRayon()));

        balle1.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) + (2 * (balle9.getBalle().getRayon())));
        balle1.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 4 * (balle9.getBalle().getRayon()));

        balle6.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) - (3 * (balle9.getBalle().getRayon())));
        balle6.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 6 * (balle9.getBalle().getRayon()));

        balle10.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) - balle9.getBalle().getRayon());
        balle10.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 6 * (balle9.getBalle().getRayon()));

        balle3.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) + balle9.getBalle().getRayon());
        balle3.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 6 * (balle9.getBalle().getRayon()));

        balle14.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) + (3 * (balle9.getBalle().getRayon())));
        balle14.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 6 * (balle9.getBalle().getRayon()));

        balle11.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) - (4 * (balle9.getBalle().getRayon())));
        balle11.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 8 * (balle9.getBalle().getRayon()));

        balle2.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) - (2 * (balle9.getBalle().getRayon())));
        balle2.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 8 * (balle9.getBalle().getRayon()));

        balle13.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2));
        balle13.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 8 * (balle9.getBalle().getRayon()));

        balle4.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) + (2 * (balle9.getBalle().getRayon())));
        balle4.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 8 * (balle9.getBalle().getRayon()));

        balle5.setLayoutY((surfaceDeJeu.getBoundsInLocal().getHeight() / 2) + (4 * (balle9.getBalle().getRayon())));
        balle5.setLayoutX((2 * (surfaceDeJeu.getBoundsInLocal().getWidth() / 3)) + 8 * (balle9.getBalle().getRayon()));

        balleHuit.setLayoutX(2.295 * surfaceDeJeu.getBoundsInLocal().getWidth() / 3);
        balleHuit.setLayoutY(surfaceDeJeu.getBoundsInLocal().getHeight() / 2);
    }

    /**
     * Méthode qui retourne une valeur booléenne signalant si toutes les balles
     * sont immobiles
     *
     * @return Valeur booléenne qui indique si toutes les balles sont immobiles
     */
    public boolean allImmobiles() {
        int nbImmobiles = 0;
        for (BalleStructure tabBalle : tabBalles) {
            if (tabBalle.getVarX() == 0 && tabBalle.getVarY() == 0) {
                nbImmobiles++;
            }
        }
        return nbImmobiles == tabBalles.length;
    }

    /**
     * Méthode qui gère les collisions avec la Table
     *
     * @param table Objet Table représentant la table de billard
     */
    public void gestionCollisionsTable(Table table) {
        //Si les balles entrent en collision avec la table
        observeTable(table);
        //gestionTrousDeTable(table);

    }

    /**
     * Méthode qui gère les collisions entre les balles
     *
     */
    public void gestionCollisionsBalle(Table table) {
        observeBalles(table);

    }

    /**
     * Méthode qui observe si une balle touche la table
     *
     * @param table
     */
    public void observeTable(Table table) {
        for (BalleStructure tabBalle : tabBalles) {
            if (tabBalle.collisionsTable(table)[0] || tabBalle.collisionsTable(table)[1]) {
                tabBalle.setVarX(tabBalle.getVarX() * -1);
            }
            if (tabBalle.collisionsTable(table)[2] || tabBalle.collisionsTable(table)[3]) {
                tabBalle.setVarY(tabBalle.getVarY() * -1);
            }
        }
    }

    /**
     * À PUBLIER LORS DE LA VERSION 4 Méthode qui permet de traiter les
     * collisions avec la nouvelle table
     */
    public void collisionsTableGraphique(ArrayList<Path> list) {
        for (BalleStructure tabBalle : tabBalles) {
            if (tabBalle.getBoundsInParent().intersects(list.get(0).getBoundsInLocal())) { //Collision avec le côté gauche (utilisateur)
                System.out.println("a");
                tabBalle.setVarX(tabBalle.getVarX() * -1);
                return;
            } else if (tabBalle.getBoundsInParent().intersects(list.get(2).getBoundsInLocal())) {//Collision avec le côté droit (utilisateur)
                System.out.println("b");
                tabBalle.setVarY(tabBalle.getVarY() * -1);
                return;
            } else if (tabBalle.getBoundsInParent().intersects(list.get(1).getBoundsInLocal())) {
                System.out.println("c");
                tabBalle.setVarX(tabBalle.getVarX() * -1);
                return;
            } else if (tabBalle.getBoundsInParent().intersects(list.get(3).getBoundsInLocal())) {
                tabBalle.setVarY(tabBalle.getVarY() * -1);
                System.out.println("d");
                return;
            } else if (tabBalle.getBoundsInParent().intersects(list.get(4).getBoundsInLocal())) {
                tabBalle.setVarY(tabBalle.getVarY() * -1);
                System.out.println("e");
                return;
            } else if (tabBalle.getBoundsInParent().intersects(list.get(5).getBoundsInLocal())) {
                tabBalle.setVarY(tabBalle.getVarY() * -1);
                System.out.println("f");
                return;
            } else if (list.get(6).contains(tabBalle.getLayoutX(),tabBalle.getLayoutY())) {
                teleportBalle(tabBalle);
                System.out.println("g");
                return;
            } else if (list.get(7).contains(tabBalle.getLayoutX(),tabBalle.getLayoutY())) {
                teleportBalle(tabBalle);
                System.out.println("g");
                return;
            } else if (list.get(8).contains(tabBalle.getLayoutX(),tabBalle.getLayoutY())) {
                teleportBalle(tabBalle);
                System.out.println("g");
                return;
            } else if (list.get(9).contains(tabBalle.getLayoutX(),tabBalle.getLayoutY())) {
                teleportBalle(tabBalle);
                System.out.println("g");
                return;
            } else if (list.get(10).contains(tabBalle.getLayoutX(),tabBalle.getLayoutY())) {
                teleportBalle(tabBalle);
                System.out.println("g");
                return;
            } else if (list.get(11).contains(tabBalle.getLayoutX(),tabBalle.getLayoutY())) {
                teleportBalle(tabBalle);
                System.out.println("g");
                return;
            }
        }
    }

    /**
     * Méthode qui observe si deux balles se touchent CONCEPT PHYSIQUE
     * Collisions élastiques: Momentum Formule: Unités: P: masse de la balle *
     * vitesse: kg*m/s Pix+Piy = PfxBalle1+PfyBalle1 + PfxBalle2 + PfyBalle2
     * m1u1+m2u2 = m1v1+m2v2
     */
    public void observeBalles(Table table) {
        Thread tCB = new Thread() {
            public void run() {
                for (int i = 0; i < tabBalles.length; i++) {
                    for (int j = 0; j < tabBalles.length; j++) {
                        if (i != j) {
                            if (tabBalles[i].getBoundsInParent().intersects(tabBalles[j].getBoundsInParent())) {
                                //On conserve en mémoire la vitesse de la tabBalles[i]
                                double vitesseCollision = tabBalles[i].obtenirVitesseActuelle();
                                //On conserve en mémoire l'angle auquel relancer la balle lancée
                                double angleF = angleDeviation(tabBalles[i], tabBalles[j], table);
                                //On conserve en mémoire le momentum Piy
                                double piY = (tabBalles[i].getMasse() * tabBalles[i].getVarY()) + (tabBalles[j].getMasse() * tabBalles[j].getVarY());
                                //On conserve en mémoire le momentum Pix
                                double piX = (tabBalles[i].getMasse() * tabBalles[i].getVarX()) + (tabBalles[j].getMasse() * tabBalles[j].getVarX());
                                //On conserve en mémoire le momentum pfYA
                                double pfYA = tabBalles[i].getMasse() * (vitesseCollision * (Math.sin(angleF)));
                                //On conserve en mémoire le momentum pfYA
                                double pfXA = tabBalles[i].getMasse() * (vitesseCollision * (Math.cos(angleF)));
                                //Lancement des balles
                                //Nouvelles vars de tabBalles[i]
                                double newVarX = pfXA / tabBalles[i].getMasse();
                                double newVarY = pfYA / tabBalles[i].getMasse();
                                tabBalles[i].setVarX(newVarX);
                                tabBalles[i].setVarY(newVarY);
                                iniBalleFrappee(tabBalles[j], piX, piY, pfXA, pfYA);
                                return;
                            }
                        }
                    }
                }
            }
        };
        tCB.start();

    }

    /**
     * Méthode qui stoppe les balles inactives
     *
     */
    public void ballesInactives() {
        //Vérifie si la balle est arrêtée
        for (BalleStructure tabBalle : tabBalles) {
            if (Math.sqrt(Math.pow(tabBalle.getVarX(), 2) + Math.pow(tabBalle.getVarY(), 2)) < 0.009) {
                tabBalle.setVarX(0);
                tabBalle.setVarY(0);
                tabBalle.setEnMouvement(false);
            }
        }
    }

    /**
     * Méthode qui actualise les balles
     *
     */
    public void actualiserBalles() {
        //Préparation au lancement
        for (BalleStructure tabBalle : tabBalles) {
            Platform.runLater(() -> {
                tabBalle.updatePositionBalle(tabBalle.getVarX(), tabBalle.getVarY());
            });
            //Variation de la vitesse dans le temps
            tabBalle.setVarX(tabBalle.decelerationBalle(tabBalle.getVarX()));
            tabBalle.setVarY(tabBalle.decelerationBalle(tabBalle.getVarY()));

        }

        //Vérification des balles à arrêter
        ballesInactives();

    }

    /**
     * Méthode qui gère le moment où une balle croise un trou de la table (par
     * Victor Rondeau)
     *
     * @param table Objet de type Table qui représenta la table de billard
     */
    public void gestionTrousDeTable(Table table) {
        for (int i = 0; i < tabBalles.length; i++) {
            if (tabBalles[i].getLayoutX() >= table.getTrouSuperieurGauche().getLayoutX() - table.getTrouSuperieurGauche().getRadius() & tabBalles[i].getLayoutX() <= table.getTrouSuperieurGauche().getLayoutX() + table.getTrouSuperieurGauche().getRadius() & tabBalles[i].getLayoutY() >= table.getTrouSuperieurGauche().getLayoutY() - table.getTrouSuperieurGauche().getRadius() & tabBalles[i].getLayoutY() <= table.getTrouSuperieurGauche().getLayoutY() + table.getTrouSuperieurGauche().getRadius()) {
                teleportBalle(tabBalles[i]);
                //Coordonnées qui font déplacer la balle pour le trou supérieur du milieu
            } else if (tabBalles[i].getLayoutX() >= table.getTrouSuperieurMilieu().getLayoutX() - table.getTrouSuperieurMilieu().getRadius() & tabBalles[i].getLayoutX() <= table.getTrouSuperieurMilieu().getLayoutX() + table.getTrouSuperieurMilieu().getRadius() & tabBalles[i].getLayoutY() >= table.getTrouSuperieurMilieu().getLayoutY() - table.getTrouSuperieurMilieu().getRadius() & tabBalles[i].getLayoutY() <= table.getTrouSuperieurMilieu().getLayoutY() + table.getTrouSuperieurGauche().getRadius()) {
                teleportBalle(tabBalles[i]);
                //Coordonnées qui font déplacer la balle pour le trou supérieur droit
            } else if (tabBalles[i].getLayoutX() >= table.getTrouSuperieurDroite().getLayoutX() - table.getTrouSuperieurDroite().getRadius() & tabBalles[i].getLayoutX() <= table.getTrouSuperieurDroite().getLayoutX() + table.getTrouSuperieurDroite().getRadius() & tabBalles[i].getLayoutY() >= table.getTrouSuperieurDroite().getLayoutY() - table.getTrouSuperieurDroite().getRadius() & tabBalles[i].getLayoutY() <= table.getTrouSuperieurDroite().getLayoutY() + table.getTrouSuperieurDroite().getRadius()) {
                teleportBalle(tabBalles[i]);
                //Coordonnées qui font déplacer la balle pour le trou inférieur gauche
            } else if (tabBalles[i].getLayoutX() >= table.getTrouInferieurGauche().getLayoutX() - table.getTrouInferieurGauche().getRadius() & tabBalles[i].getLayoutX() <= table.getTrouInferieurGauche().getLayoutX() + table.getTrouInferieurGauche().getRadius() & tabBalles[i].getLayoutY() >= table.getTrouInferieurGauche().getLayoutY() - table.getTrouInferieurGauche().getRadius() & tabBalles[i].getLayoutY() <= table.getTrouInferieurGauche().getLayoutY() + table.getTrouInferieurGauche().getRadius()) {
                teleportBalle(tabBalles[i]);
                //Coordonnées qui font déplacer la balle pour le trou inférieur du milieu
            } else if (tabBalles[i].getLayoutX() >= table.getTrouInferieurMilieu().getLayoutX() - table.getTrouInferieurMilieu().getRadius() & tabBalles[i].getLayoutX() <= table.getTrouInferieurMilieu().getLayoutX() + table.getTrouInferieurMilieu().getRadius() & tabBalles[i].getLayoutY() >= table.getTrouInferieurMilieu().getLayoutY() - table.getTrouInferieurMilieu().getRadius() & tabBalles[i].getLayoutY() <= table.getTrouInferieurMilieu().getLayoutY() + table.getTrouInferieurMilieu().getRadius()) {
                teleportBalle(tabBalles[i]);
                //Coordonnées qui font déplacer la balle pour le trou inférieur droite
            } else if (tabBalles[i].getLayoutX() >= table.getTrouInferieurDroite().getLayoutX() - table.getTrouInferieurDroite().getRadius() & tabBalles[i].getLayoutX() <= table.getTrouInferieurDroite().getLayoutX() + table.getTrouInferieurDroite().getRadius() & tabBalles[i].getLayoutY() >= table.getTrouInferieurDroite().getLayoutY() - table.getTrouInferieurDroite().getRadius() & tabBalles[i].getLayoutY() <= table.getTrouInferieurDroite().getLayoutY() + table.getTrouInferieurDroite().getRadius()) {
                teleportBalle(tabBalles[i]);
            }
        }
    }

    public void teleportBalle(BalleStructure uneBalle) {//Version 3
        if (uneBalle.getBalle().getCouleur() == Color.WHITE) {
            uneBalle.stopBalle();
            uneBalle.setLayoutX(20);
            uneBalle.setLayoutY(550);
            uneBalle.getBalle().setBalleEntree(true);
        } else {
            uneBalle.stopBalle();
            uneBalle.setLayoutX(25 + getNombreBallesEntrees() * 30);
            uneBalle.setLayoutY(605);
            setNombreBallesEntrees(getNombreBallesEntrees() + 1);
        }
    }

    /**
     * Méthode qui retourne l'angle (en radians) auquel une balle lancée est
     * déviée
     *
     */
    public double angleDeviation(BalleStructure balleA, BalleStructure balleB, Table table) {
        //Il faut d'abord trouver le commencement en X et en Y de la ligne
        double startX = balleA.getBoundsInParent().getMaxX() - balleA.getBalle().getRadius();
        double startY = balleA.getBoundsInParent().getMaxY() - balleA.getBalle().getRadius();
        //Coordonnées en X et en Y de la fin de la ligne
        double endX = balleB.getBoundsInParent().getMaxX() - balleB.getBalle().getRadius();
        double endY = balleB.getBoundsInParent().getMaxY() - balleB.getBalle().getRadius();
        //Calcul de l'angle de la pende de la Line: utilisation de deltaY/deltaX
        double deltaX = startX - endX;
        double deltaY = endY - startY;
        return Math.atan(deltaY / deltaX);
    }

    /**
     * Méthode qui calcule la vitesse de la balle frappée
     */
    public void iniBalleFrappee(BalleStructure balle, double piX, double piY, double pfXA, double pfYA) {
        //Calcul de la composante en Y de la vitesse recherchée
        double vy = (piY - pfYA) / balle.getMasse();
        //Calcul de la composante en X de la vitesse recherchée
        double vx = (piX - pfXA) / balle.getMasse();
        balle.setVarX(vx);
        balle.setVarY(vy);
        if (Math.atan(vy / vx) > 0) {
            balle.setAngle(Math.atan(vy / vx));
        } else {
            balle.setAngle(Math.PI + Math.atan(vy / vx));
        }
    }

    /**
     * Méthode qui permet de détecter le collisions entre les balles et entre
     * une balle et les bords de la table
     *
     * @param angle Angle auquel la Balle est lancée
     * @param vitesse Vitesse à laquelle la Balle est lancée
     * @param table Table qui représente la table de billard
     */
    public void effectuerTour(double angle, double vitesse, Table table, ArrayList<Path> pathList) {
        //Collisions entre les murs de la table et entre les balles
        collisionsTableGraphique(pathList);
        //gestionCollisionsTable(table);
        gestionCollisionsBalle(table);

    }

    /**
     * @return the nombreBallesEntrees
     */
    public int getNombreBallesEntrees() {
        return nombreBallesEntrees;
    }

    /**
     * @param nombreBallesEntrees the nombreBallesEntrees to set
     */
    public void setNombreBallesEntrees(int nombreBallesEntrees) {
        this.nombreBallesEntrees = nombreBallesEntrees;
    }

}
