/*
 * Ensemble des balles 
 */
package modele;

import java.util.Arrays;
import javafx.scene.paint.Color;
import javafx.application.Platform;

/**
 * Classe représentant l'ensemble des balles sur une table de billard 2017-04-09
 *
 * @author Vittorio Passuello-Dussault
 * @version 2.0
 * @see Balle
 */
public class EnsembleDeBalles extends BalleStructure {

    //Attributs
    //Désuet: public ArrayList<Balle> balles = new ArrayList<>();
    public BalleStructure[] tabBalles = new BalleStructure[16];
    BalleStructure balle1, balle2, balle3, balle4, balle5, balle6, balle7, balle9, balle10, balle11, balle12, balle13, balle14, balle15;
    BalleStructure balleBlanche;
    BalleStructure balleHuit;
    Color motif = Color.WHITE;
    int numeroBalleTouchee;
    public boolean tourFini;

    /**
     * Constructeur de l'EnsembleDeBalles à placer sur une surface de jeu
     * précise
     *
     * @param surfaceDeJeu Tapis de jeu
     */
    public EnsembleDeBalles(Table surfaceDeJeu) {

        balleBlanche = new BalleStructure(new Balle(0, 15, Color.WHITE, surfaceDeJeu.getBoundsInLocal().getWidth() / 3, surfaceDeJeu.getBoundsInLocal().getHeight() / 2));
        balleHuit = new BalleStructure(new Balle(8, 15, Color.BLACK, 2.295 * surfaceDeJeu.getBoundsInLocal().getWidth() / 3, surfaceDeJeu.getBoundsInLocal().getHeight() / 2));

        balleBlanche.setLayoutX(surfaceDeJeu.getBoundsInLocal().getWidth() / 3);
        balleBlanche.setLayoutY(surfaceDeJeu.getBoundsInLocal().getHeight() / 2);

        //Balles avec motifs
        balle9 = new BalleStructure(new Balle(9, 15, Color.RED, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 60));
        balle10 = new BalleStructure(new Balle(10, 15, Color.BLUE, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 90));
        balle11 = new BalleStructure(new Balle(11, 15, Color.YELLOW, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 120));
        balle12 = new BalleStructure(new Balle(12, 15, Color.CYAN, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 150));
        balle13 = new BalleStructure(new Balle(13, 15, Color.PURPLE, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 180));
        balle14 = new BalleStructure(new Balle(14, 15, Color.CHARTREUSE, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 210));
        balle15 = new BalleStructure(new Balle(15, 15, Color.DARKGOLDENROD, surfaceDeJeu.getLayoutBounds().getMinX() + 50, 240));

        //Balles sans motifs
        balle1 = new BalleStructure(new Balle(1, 15, Color.RED, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 60));
        balle2 = new BalleStructure(new Balle(2, 15, Color.BLUE, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 90));
        balle3 = new BalleStructure(new Balle(3, 15, Color.YELLOW, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 120));
        balle4 = new BalleStructure(new Balle(4, 15, Color.CYAN, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 150));
        balle5 = new BalleStructure(new Balle(5, 15, Color.PURPLE, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 180));
        balle6 = new BalleStructure(new Balle(6, 15, Color.CHARTREUSE, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 210));
        balle7 = new BalleStructure(new Balle(7, 15, Color.DARKGOLDENROD, surfaceDeJeu.getLayoutBounds().getMaxX() - 50, 240));

        //Ajout des balles au tableau tabBalles
        tabBalles[0] = balleBlanche;
        tabBalles[1] = balle1;
        tabBalles[2] = balle2;
        tabBalles[3] = balle3;
        tabBalles[4] = balle4;
        tabBalles[5] = balle5;
        tabBalles[6] = balle6;
        tabBalles[7] = balle7;
        tabBalles[8] = balle9;
        tabBalles[9] = balle10;
        tabBalles[10] = balle11;
        tabBalles[11] = balle12;
        tabBalles[12] = balle13;
        tabBalles[13] = balle14;
        tabBalles[14] = balle15;
        tabBalles[15] = balleHuit;

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
        gestionTrousDeTable(table);
        
    }

    /**
     * Méthode qui gère les collisions entre les balles
     *
     */
    public void gestionCollisionsBalle() {
        observeBalles();
        

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
                tabBalle.setAngle(tabBalle.getAngle() + Math.toRadians(180));
            }
            if (tabBalle.collisionsTable(table)[2] || tabBalle.collisionsTable(table)[3]) {
                tabBalle.setVarY(tabBalle.getVarY() * -1);
            }
        }
    }

    /**
     * Méthode qui observe si deux balles se touchent
     *
     */
    public void observeBalles() {
        for (int i = 0; i < tabBalles.length; i++) {
            for (int j = 0; j < tabBalles.length; j++) {
                if (i != j) {
                    if (tabBalles[i].getBoundsInParent().intersects(tabBalles[j].getBoundsInParent())) {
                        if (tabBalles[i].obtenirVitesseActuelle() != 0 && tabBalles[j].obtenirVitesseActuelle() == 0) {
                            lancerBallePercutee(tabBalles[i], tabBalles[j]);

                        } else if (tabBalles[i].obtenirVitesseActuelle() == 0 && tabBalles[j].obtenirVitesseActuelle() != 0) {
                            lancerBallePercutee(tabBalles[j], tabBalles[i]);
                        }
                    }
                }
            }
        }
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
                //Variation de la vitesse dans le temps
                tabBalle.setVarX(tabBalle.decelerationBalle(tabBalle.getVarX()));
                tabBalle.setVarY(tabBalle.decelerationBalle(tabBalle.getVarY()));
            });

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
                tabBalles[i].setLayoutX(20);
                tabBalles[i].setLayoutY(550);
                //Coordonnées qui font déplacer la balle pour le trou supérieur du milieu
            } else if (tabBalles[i].getLayoutX() >= table.getTrouSuperieurMilieu().getLayoutX() - table.getTrouSuperieurMilieu().getRadius() & tabBalles[i].getLayoutX() <= table.getTrouSuperieurMilieu().getLayoutX() + table.getTrouSuperieurMilieu().getRadius() & tabBalles[i].getLayoutY() >= table.getTrouSuperieurMilieu().getLayoutY() - table.getTrouSuperieurMilieu().getRadius() & tabBalles[i].getLayoutY() <= table.getTrouSuperieurMilieu().getLayoutY() + table.getTrouSuperieurGauche().getRadius()) {
                tabBalles[i].setLayoutX(20);
                tabBalles[i].setLayoutY(550);
                //Coordonnées qui font déplacer la balle pour le trou supérieur droit
            } else if (tabBalles[i].getLayoutX() >= table.getTrouSuperieurDroite().getLayoutX() - table.getTrouSuperieurDroite().getRadius() & tabBalles[i].getLayoutX() <= table.getTrouSuperieurDroite().getLayoutX() + table.getTrouSuperieurDroite().getRadius() & tabBalles[i].getLayoutY() >= table.getTrouSuperieurDroite().getLayoutY() - table.getTrouSuperieurDroite().getRadius() & tabBalles[i].getLayoutY() <= table.getTrouSuperieurDroite().getLayoutY() + table.getTrouSuperieurDroite().getRadius()) {
                tabBalles[i].setLayoutX(20);
                tabBalles[i].setLayoutY(550);
                //Coordonnées qui font déplacer la balle pour le trou inférieur gauche
            } else if (tabBalles[i].getLayoutX() >= table.getTrouInferieurGauche().getLayoutX() - table.getTrouInferieurGauche().getRadius() & tabBalles[i].getLayoutX() <= table.getTrouInferieurGauche().getLayoutX() + table.getTrouInferieurGauche().getRadius() & tabBalles[i].getLayoutY() >= table.getTrouInferieurGauche().getLayoutY() - table.getTrouInferieurGauche().getRadius() & tabBalles[i].getLayoutY() <= table.getTrouInferieurGauche().getLayoutY() + table.getTrouInferieurGauche().getRadius()) {
                tabBalles[i].setLayoutX(20);
                tabBalles[i].setLayoutY(550);
                //Coordonnées qui font déplacer la balle pour le trou inférieur du milieu
            } else if (tabBalles[i].getLayoutX() >= table.getTrouInferieurMilieu().getLayoutX() - table.getTrouInferieurMilieu().getRadius() & tabBalles[i].getLayoutX() <= table.getTrouInferieurMilieu().getLayoutX() + table.getTrouInferieurMilieu().getRadius() & tabBalles[i].getLayoutY() >= table.getTrouInferieurMilieu().getLayoutY() - table.getTrouInferieurMilieu().getRadius() & tabBalles[i].getLayoutY() <= table.getTrouInferieurMilieu().getLayoutY() + table.getTrouInferieurMilieu().getRadius()) {
                tabBalles[i].setLayoutX(20);
                tabBalles[i].setLayoutY(550);
                //Coordonnées qui font déplacer la balle pour le trou inférieur droite
            } else if (tabBalles[i].getLayoutX() >= table.getTrouInferieurDroite().getLayoutX() - table.getTrouInferieurDroite().getRadius() & tabBalles[i].getLayoutX() <= table.getTrouInferieurDroite().getLayoutX() + table.getTrouInferieurDroite().getRadius() & tabBalles[i].getLayoutY() >= table.getTrouInferieurDroite().getLayoutY() - table.getTrouInferieurDroite().getRadius() & tabBalles[i].getLayoutY() <= table.getTrouInferieurDroite().getLayoutY() + table.getTrouInferieurDroite().getRadius()) {
                tabBalles[i].setLayoutX(20);
                tabBalles[i].setLayoutY(550);
            }
        }
    }

    /**
     * Méthode qui permet la préparation du lancement de la balle percutée
     *
     * @param balleLancee Balle lancée qui percute une autre Balle
     * @param balleFrappee Balle percutée par la Balle lancée
     */
    public void lancerBallePercutee(BalleStructure balleLancee, BalleStructure balleFrappee) {
        //Si l'angle de la collision est de 0deg ou 0 rads     
        if (angleDeCollision(balleLancee, balleFrappee) == 0) {
            tranfertAlignees(balleLancee, balleFrappee);
        } else {
            transfertNonAlignees(balleLancee, balleFrappee);
        }

    }

    /**
     * Méthode qui représente un transfert d'énergie entre deux balles alignées
     *
     * @param balleLancee Balle lancée qui percute une autre Balle
     * @param balleFrappee Balle percutée par la Balle lancée
     */
    public void tranfertAlignees(BalleStructure balleLancee, BalleStructure balleFrappee) {
        //Temp: On immobilise la balleLancee, mais avant on sauvegarde sa vitesse d'incidence
        double vitesseCollision = balleLancee.obtenirVitesseActuelle();
        balleLancee.stopBalle();
        //utilisation de la formule de physique mécanique: v0ini = v0finale + v1initiale donc la balle frappee reçoit la vitesse de la balle lancee
        balleFrappee.prepareToLaunch(balleLancee.getAngle(), vitesseCollision);
    }

    /**
     * Méthode qui représente un transfert d'énergie entre deux balles
     * non-alignées
     *
     * @param balleLancee Balle lancée qui percute une autre Balle
     * @param balleFrappee Balle percutée par la Balle lancée
     */
    public void transfertNonAlignees(BalleStructure balleLancee, BalleStructure balleFrappee) {

        //Si les deux balles sont en mouvement: application de application de m1u1 + m2u2 = m1v1 + m2v2
        if (balleLancee.obtenirVitesseActuelle() != 0 && balleFrappee.obtenirVitesseActuelle() != 0) {
            deuxBallesEnMouvement(balleLancee, balleFrappee);
        } else {
            uneBalleEnMouvement(balleLancee, balleFrappee);
        }
    }

    /**
     * Méthode qui gère le transfert d'énergie entre deux balles en mouvement
     *
     * @param balleLancee Balle lancée qui percute une autre Balle
     * @param balleFrappee Balle percutée par la Balle lancée
     *
     */
    public void deuxBallesEnMouvement(BalleStructure balleLancee, BalleStructure balleFrappee) {
        double vitesseCollision, angleIncident, angleIncident2;
        //En dév: Si l'angle de collision est quelconque
        //On sauvegarde la vitesse de la Balle lancée au moment de la collision
        vitesseCollision = balleLancee.obtenirVitesseActuelle();
        //Il faut déterminer l'angle auquel il fault lancer balleLancee
        angleIncident = balleLancee.getAngle();
        //Il faut déterminer l'angle auquel il faut lancer la balleFrappee
        if (balleLancee.getVarX() > 0) {
            angleIncident2 = angleIncident - (Math.PI / 2);
        } else {
            angleIncident2 = angleIncident + (Math.PI / 2);
        }
        double vitesse1, vitesse2;
        //Vérifier respect des principes de physique mécanique
        //Vitesse à laquelle lancer la balleLancee
        vitesse1 = balleFrappee.obtenirVitesseActuelle();
        //Vitesse à laquelle lancer la balleFrappee
        vitesse2 = vitesseCollision;

        //Lancement de la balleLancee
        balleLancee.prepareToLaunch(angleIncident, vitesse1);
        //Lancement de la balleFrappee
        balleFrappee.prepareToLaunch(angleIncident2, vitesse2);
    }

    /**
     * Méthode qui gère le transfert d'énergie entre une balle en mouvement et
     * une balle fixe
     *
     * @param balleLancee Balle lancée qui percute une autre Balle
     * @param balleFrappee Balle percutée par la Balle lancée
     *
     */
    public void uneBalleEnMouvement(BalleStructure balleLancee, BalleStructure balleFrappee) {
        double vitesseCollision, angleIncident, angleIncident2;
        //En dév: Si l'angle de collision est quelconque
        //On sauvegarde la vitesse de la Balle lancée au moment de la collision
        vitesseCollision = balleLancee.obtenirVitesseActuelle();
        //Il faut déterminer l'angle auquel il fault lancer balleLancee
        angleIncident = balleLancee.getAngle();
        //Il faut déterminer l'angle auquel il faut lancer la balleFrappee
        if (balleLancee.getVarX() > 0) {
            angleIncident2 = angleIncident - (Math.PI / 2);
        } else {
            angleIncident2 = angleIncident + (Math.PI / 2);
        }
        double vitesse1, vitesse2;
        //Si seulement la balleLancee est en mouvement: application de m1u1 = m1v1 + m2u2
        vitesse1 = vitesseCollision * 0.2;
        vitesse2 = vitesseCollision * 0.8;

        //Lancement de la balleLancee
        balleLancee.prepareToLaunch(angleIncident, vitesse1);
        //Lancement de la balleFrappee
        balleFrappee.prepareToLaunch(angleIncident2, vitesse2);
    }

    /**
     * Méthode qui retourne l'angle de collision
     *
     * @param balleLancee Balle lancée qui percute une autre Balle
     * @param balleFrappee Balle percutée par la Balle lancée
     * @return Angle de collision entre la Balle lancée et la Balle frappée
     */
    public double angleDeCollision(BalleStructure balleLancee, BalleStructure balleFrappee) {
        //Il faut d'abord trouver le commencement en X et en Y de la ligne
        double startX = balleLancee.getBoundsInParent().getMaxX() - balleLancee.getBalle().getRadius();
        double startY = balleLancee.getBoundsInParent().getMaxY() - balleLancee.getBalle().getRadius();
        //Coordonnées en X et en Y de la fin de la ligne
        double endX = balleFrappee.getBoundsInParent().getMaxX() - balleFrappee.getBalle().getRadius();
        double endY = balleFrappee.getBoundsInParent().getMaxY() - balleFrappee.getBalle().getRadius();

        //Calcul de l'angle de la pende de la Line: utilisation de deltaY/deltaX
        double deltaX = endX - startX;
        double deltaY = endY - startY;
        return Math.atan(deltaY / deltaX);

    }

    /**
     * Méthode qui permet de détecter le collisions entre les balles et entre
     * une balle et les bords de la table
     *
     * @param angle Angle auquel la Balle est lancée
     * @param vitesse Vitesse à laquelle la Balle est lancée
     * @param table Table qui représente la table de billard
     */
    public void effectuerTour(double angle, double vitesse, Table table) {
        //Collisions entre les murs de la table et entre les balles
        gestionCollisionsTable(table);
        gestionCollisionsBalle();
    }
    

}
