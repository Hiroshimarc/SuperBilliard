/*
 * Classe de type contrôleur de l'application qui définit son démarrage et fonctionnement
 */
package controleur;

/**
 *
 * @author Équipe de SuperBillard
 * @see javafx.application.Application
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import vue.MenuPrincipal;
import javafx.scene.image.Image;

public class Launcher extends Application {

    Stage superBillard;
    Scene menuPrincipal;
    
    /**Méthode qui définit le démarrage de l'application
     * 
     * @param stage objet Stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {

        this.superBillard = stage;

        MenuPrincipal unMenu = new MenuPrincipal(superBillard);
        menuPrincipal = unMenu.getMenu();

        superBillard.setResizable(false);
        superBillard.centerOnScreen();


        Image icone = new Image("Icone.png");
        superBillard.getIcons().add(icone);

        stage.setTitle("Super Billard");
        stage.setScene(menuPrincipal);
        stage.show();

    }
    
    /**Méthode main
     * 
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
