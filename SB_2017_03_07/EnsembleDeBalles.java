/*
 * Ensemble des balles 
 */
package Modèle;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import Modèle.Table;
import java.awt.Window;
import vue.MenuJouer;

/**
 * 2017-02-27
 * @author Vittorio Passuello-Dussault
 * @version 1.0
 * @see Balle
 */
public class EnsembleDeBalles extends BalleBlanche{
    
    //Attributs
    public ArrayList<Balle> balles = new ArrayList<>();
    Balle balle1,balle2,balle3,balle4,balle5,balle6,balle7,balle9,balle10,balle11,balle12,balle13,balle14,balle15;
    public BalleBlanche balleBlanche;
    Color motif = Color.WHITE;
    
    /**Constructeur de l'EnsembleDeBalles à placer sur une surface de jeu précise
     * 
     * @param surfaceDeJeu Tapis de jeu
     */
    public EnsembleDeBalles(Table surfaceDeJeu){
            
            balleBlanche = new BalleBlanche(15,surfaceDeJeu);
        
            balle9 = new Balle(9,15,Color.RED,surfaceDeJeu.getLayoutBounds().getMinX()+50,60);
            //balle9.setStroke(motif);
            
            balle10 = new Balle(10,15,Color.BLUE,surfaceDeJeu.getLayoutBounds().getMinX()+50,90);
            //balle10.setStroke(motif);

            balle11 = new Balle(11,15,Color.YELLOW,surfaceDeJeu.getLayoutBounds().getMinX()+50,120);
            //balle11.setStroke(motif);
            
            balle12 = new Balle(12,15,Color.CYAN,surfaceDeJeu.getLayoutBounds().getMinX()+50,150);
            //balle12.setStroke(motif);
            
            balle13 = new Balle(13,15,Color.PURPLE,surfaceDeJeu.getLayoutBounds().getMinX()+50,180);
            //balle13.setStroke(motif);
            
            balle14 = new Balle(14,15,Color.CHARTREUSE,surfaceDeJeu.getLayoutBounds().getMinX()+50,210);
            //balle14.setStroke(motif);
            
            balle15 = new Balle(15,15,Color.DARKGOLDENROD,surfaceDeJeu.getLayoutBounds().getMinX()+50,240);
            //balle15.setStroke(motif);
            
            //Balles sans motifs
            balle1 = new Balle(1,15,Color.RED,surfaceDeJeu.getLayoutBounds().getMaxX()-50,60);
            //balle1.setStroke(Color.RED);
            
            balle2 = new Balle(2,15,Color.BLUE,surfaceDeJeu.getLayoutBounds().getMaxX()-50,90);
            //balle2.setStroke(Color.BLUE);
            
            balle3 = new Balle(3,15,Color.YELLOW,surfaceDeJeu.getLayoutBounds().getMaxX()-50,120);
            //balle3.setStroke(Color.YELLOW);
            
            balle4 = new Balle(4,15,Color.CYAN,surfaceDeJeu.getLayoutBounds().getMaxX()-50,150);
            //balle4.setStroke(Color.CYAN);
            
            balle5 = new Balle(5,15,Color.PURPLE,surfaceDeJeu.getLayoutBounds().getMaxX()-50,180);
            //balle5.setStroke(Color.PURPLE);
            
            balle6 = new Balle(6,15,Color.CHARTREUSE,surfaceDeJeu.getLayoutBounds().getMaxX()-50,210);
            //balle6.setStroke(Color.CHARTREUSE);
            
            balle7 = new Balle(7,15,Color.DARKGOLDENROD,surfaceDeJeu.getLayoutBounds().getMaxX()-50,240);
            //balle7.setStroke(Color.DARKGOLDENROD);
            
            balles.add(balleBlanche);
            /*balles.add(balle1);
            balles.add(balle2);
            balles.add(balle3);
            balles.add(balle4);
            balles.add(balle5);
            balles.add(balle6);
            balles.add(balle7);
            balles.add(balle9);
            balles.add(balle10);
            balles.add(balle11);
            balles.add(balle12);
            balles.add(balle13);
            balles.add(balle14);
            balles.add(balle15);*/
            
        for(int count=0;count<balles.size();count++){
            surfaceDeJeu.getChildren().add(balles.get(count));
        }
    }
    
    /**Méthode qui permet de positionner les balles pour le premier coup
     * 
     */
    public void initialiserBalles(Table surfaceDeJeu){
        
        balle9.setPositionInitialeY(surfaceDeJeu.getHeight()/2);
        balle9.setPositionInitialeX(2*(surfaceDeJeu.getWidth()/3));
        
        balle7.setPositionInitialeY((surfaceDeJeu.getHeight()/2)-balle9.getRayon());
        balle7.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+2*(balle9.getRayon()));
        
        balle12.setPositionInitialeY((surfaceDeJeu.getHeight()/2)+balle9.getRayon());
        balle12.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+2*(balle9.getRayon()));
        
        balle15.setPositionInitialeY((surfaceDeJeu.getHeight()/2)-(2*(balle9.getRayon())));
        balle15.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+4*(balle9.getRayon()));
        
        balle1.setPositionInitialeY((surfaceDeJeu.getHeight()/2)+(2*(balle9.getRayon())));
        balle1.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+4*(balle9.getRayon()));
        
        balle6.setPositionInitialeY((surfaceDeJeu.getHeight()/2)-(3*(balle9.getRayon())));
        balle6.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+6*(balle9.getRayon()));
        
        balle10.setPositionInitialeY((surfaceDeJeu.getHeight()/2)-balle9.getRayon());
        balle10.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+6*(balle9.getRayon()));
        
        balle3.setPositionInitialeY((surfaceDeJeu.getHeight()/2)+balle9.getRayon());
        balle3.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+6*(balle9.getRayon()));
        
        balle14.setPositionInitialeY((surfaceDeJeu.getHeight()/2)+(3*(balle9.getRayon())));
        balle14.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+6*(balle9.getRayon()));
        
        balle11.setPositionInitialeY((surfaceDeJeu.getHeight()/2)-(4*(balle9.getRayon())));
        balle11.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+8*(balle9.getRayon()));
        
        balle2.setPositionInitialeY((surfaceDeJeu.getHeight()/2)-(2*(balle9.getRayon())));
        balle2.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+8*(balle9.getRayon()));
        
        balle13.setPositionInitialeY((surfaceDeJeu.getHeight()/2));
        balle13.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+8*(balle9.getRayon()));
        
        balle4.setPositionInitialeY((surfaceDeJeu.getHeight()/2)+(2*(balle9.getRayon())));
        balle4.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+8*(balle9.getRayon()));
        
        balle5.setPositionInitialeY((surfaceDeJeu.getHeight()/2)+(4*(balle9.getRayon())));
        balle5.setPositionInitialeX((2*(surfaceDeJeu.getWidth()/3))+8*(balle9.getRayon()));
    }
    
    /**Méthode qui gère les collisions entre les balles
     * 
     */
    public void collisionsBalles(Table surfaceDeJeu, double angle, double vitesse){
        new Thread(()->{
            Thread.currentThread().setName("Détection de collisions entre les balles");
            while(!Thread.interrupted()){
                //synchronized(balles){
                    for(int i=0;i<balles.size();i++){
                        for(int j=i+1;j<balles.size();j++){
                            Balle a = balles.get(i);
                            Balle b = balles.get(j);
                            double dx = b.getPositionInitialeX() - a.getPositionInitialeX();
                            double dy = b.getPositionInitialeY() - a.getPositionInitialeY();
                            double distance = Math.sqrt(dx*dx + dy*dy);
                            
                            
                            if(a.getBoundsInParent().intersects(b.getBoundsInParent())){
                                //collision
                                a.varX = -a.varX;
                                b.launch(180-(a.angle), vitesse, surfaceDeJeu);
                            }
                        }
                    }
                //}
            }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    
                }
            }).start();
    }
    
}
