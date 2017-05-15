/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.swing.JOptionPane;
import vue.MenuJouer;
import vue.MenuPrincipal;

/**
 *
 * @author usager
 */
public class GestionPartie {

    Joueur joueur1, joueur2;
    String tour;

    public void debutterPartie() {

        joueur1 = new Joueur(JOptionPane.showInputDialog(null, "Entrer le nom du joueur 1"));
        joueur2 = new Joueur(JOptionPane.showInputDialog(null, "Entrer le nom du joueur 2"));
        JOptionPane.showMessageDialog(null, "Les deux joueurs ont été enregistrés. Bonne partie!" + "\nC'est le tour du joueur : " + joueur1.nom);
        this.tour = joueur1.getNom();
    }

    public void assignerTypeBalle(String unType, Joueur unJoueur) {
        if (unJoueur.getNom().equals(joueur1.getNom())) {
            joueur1.setTypeBalle(unType);
            //joueur2.setTypeBalle(autreType);
        } else {
            //joueur1.setTypeBalle(autreType);
            joueur2.setTypeBalle(unType);
        }
    }

    public void balleEmpochée(String unType, Joueur unJoueur) {
        if (unType == "balle noir") {
            if (unJoueur.getNbBalles() != 7) {
                JOptionPane.showMessageDialog(null, "Le joueur: " + unJoueur.getNom()
                        + " a perdu la partie, car il a empopché la balle noir.");
                resetGame();
            } else {
                JOptionPane.showMessageDialog(null, "Le joueur: " + unJoueur.getNom()
                        + " a remporté la victoire!");
                resetGame();
            }
        } else if (unType == "balle blanche") {
            JOptionPane.showMessageDialog(null, "Le joueur: " + unJoueur.getNom()
                    + " a empoché la balle blanche c'est donc le tour de l'autre joueur");

            changerDeTour(unJoueur);
        } else if (unJoueur.getTypeBalle().equals(unType)) {
            JOptionPane.showMessageDialog(null, "Le joueur: " + unJoueur.getNom()
                    + " a empoché le mauvais type de balle c'est donc le tour de l'autre joueur");
            changerDeTour(unJoueur);
        }
    }

    public void changerDeTour(Joueur unJoueur) {
        if (unJoueur.getNom().equals(joueur1.getNom())) {
            tour = joueur2.getNom();
        } else {
            tour = joueur1.getNom();
        }
    }

    public Joueur getJoueur(String unTour) {
        this.tour = unTour;
        Joueur unJoueur;
        if (joueur1.getNom().equals(tour)) {
            unJoueur = joueur1;
        } else {
            unJoueur = joueur2;
        }
        return unJoueur;
    }

    public void resetGame() {
        int reponse = 0;
        reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous démarer une nouvelle partie?", "Super Billard", JOptionPane.YES_NO_OPTION);
        if (reponse == 0) {
            MenuPrincipal.boutonJouer.fire();
        } else {
            MenuJouer.boutonMenu.fire();
        }
    }
}
