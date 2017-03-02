/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author Vittorio Passuello-Dussault
 * @version 1.0
 * @see ArithmeticException
 */
public class VitesseHorsLimiteException extends ArithmeticException{
    

    
    //Attribut
    public final int vitesseMaximale=4;
    public final int vitesseMinimale =0;
    /**Constructeur
     * 
     * @param message 
     */
    public VitesseHorsLimiteException(String message){
        super(message);
    }
}
