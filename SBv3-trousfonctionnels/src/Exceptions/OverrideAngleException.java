/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**Cette classe permet de limiter l'angle saisi par l'utilisateur à 360 degrés et 2PI radians
 *
 * @author Vittorio Passuello-Dussault
 * @see ArithmeticException
 * @version 1.1
 * 2017-04-20
 */
public class OverrideAngleException extends ArithmeticException {
    //Constructeur
    public OverrideAngleException(String limiteBas, String limiteHaut, String entree){
        super("Vous vouliez entrer: "+entree+". Veuillez entrer une valeur d'angle comprise entre "+limiteBas+" et "+limiteHaut);
    }
}
