/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author usager
 */
public class Joueur {

    String nom;
    String typeBalle;
    int nbBalles;

    public Joueur(String unNom) {
        this.nom = unNom;
    }

    public String getTypeBalle() {
        return this.typeBalle;
    }

    public void setTypeBalle(String unType) {
        this.typeBalle = unType;
    }

    public int getNbBalles() {
        return this.nbBalles;
    }

    public void setNbBalles(int unNbBalles) {
        this.nbBalles = unNbBalles;
    }

    public String getNom() {
        return this.nom;
    }

}
