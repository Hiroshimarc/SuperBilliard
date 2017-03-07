package Modèle;

import javafx.scene.paint.Color;

/**
 * 2017-02-28
 * @author Vittorio Passuello-Dussault
 * @see Balle
 * @version 1.0
 */
public class BalleBlanche extends Balle{
    public BalleBlanche(double rayon,Table surfaceDeJeu){
       this.setPositionInitialeX(surfaceDeJeu.getWidth()/3);
       this.setPositionInitialeY(surfaceDeJeu.getHeight()/2);
       this.setCouleur(Color.WHITE);
       this.setEnMouvement(false);
       this.setRayon(rayon);
    }
    public BalleBlanche(){
        
    }
}
