package vue;

import Exceptions.OverrideAngleException;
import controleur.Launcher;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modele.Balle;
import modele.BalleStructure;
import modele.EnsembleDeBalles;
import modele.GestionPartie;
import modele.Table;

/**
 * Classe qui représente le menu jouer du menu principal
 *
 * @author Édouard Raffis
 * @version 2.5 2017-04-20
 */
public class MenuJouer {

    public static String background;

    Stage superBillard;
    Scene menuJouer;
    AnchorPane paneJouer;
    Table table;
    Label indicationVitesse;
    Label vitesseActuelle;
    Slider saisieVitesse;
    public static Label attenteTour;
    public static TextField saisieAngle;
    public static TextField visualiserVitesse;
    public static Button appliquerVitesse, boutonMenu, boutonMusique, boutonDemarrer;
    Rectangle graduationG;
    Rectangle graduationY;
    Rectangle graduationR;
    Rectangle boiteBoule;
    Line visualisation;
    boolean alreadyDrawnDirectionLine = false; // Si une ligne indicatrice est déj<a tracée
    double x, y, deltX, deltY;
    boolean balleBlancheDraggable = true;

    //Forme du TextField de saisie de l'angle
    Circle shapeSA = new Circle(100);
    //Police de la saisie de l'angle
    Font angleFont = new Font("Comic Sans MS", 25);

    //TextField représentant les unités de l'angle à saisir
    Button unitAngle;
    Circle shapeUA = new Circle(25);

    //Icônes signalant une erreur de saisie (sera peut-être dirigé vers une classe)
    Font errorFont = new Font("Arial", 45);
    Circle temoinAngleVide;
    Label symboleErreur = new Label("!");
    StackPane indicationErreur;

    //Shape du bouton appliquerVitesse
    Circle shapeAV = new Circle(45);

    //Bouton de l'unité de la vitesse entrée
    Button unitVitesse;

    //Définition du Button qui permet d'ajouter PI lorsque la saisie de l'angle est en rads (pratique pour angles précis)
    Button addPI;
    Circle shapeAddPI = new Circle(35);

    //Label qui s'affiche près du Label vitesse qui affiche la vitesse pointée par le curseur saisieVitesse
    Label draggedV = new Label();

    /**
     * Constructeur de l'objet MenuJouer
     *
     * @param stage stage
     */
    public MenuJouer(Stage stage) {
        table = new Table(10, 10, 1000, 500, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT);
        table.setVisible(true);
        
        int k=50;
        Image imageTable = new Image("table.png", 1175, 550, true, true);
        ImageView backGround = new ImageView(imageTable);
        backGround.setX(59-k);
        backGround.setY(23);
        backGround.setFitWidth(1000);
        backGround.setFitHeight(552);
        
        

        ClosePath cP = new ClosePath();
        ArrayList<Path> pathList = new ArrayList<>();
        remplirPathList(pathList);

        List<Double> coordList = new ArrayList<>();
        remplirCoordList(coordList);
        
        
        for (int i = 0; i < pathList.size(); i++) {
            if (i <= 5) {

                pathList.get(i).getElements().add(new MoveTo(coordList.get((10 * i))-k, coordList.get((10 * i) + 1)));           // coordonnÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â©es point dÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â©part du polygone
                pathList.get(i).getElements().add(new LineTo(coordList.get((10 * i) + 2)-k, coordList.get((10 * i) + 3)));		// coordonnÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â©es 1er sommet du polygone
                pathList.get(i).getElements().add(new LineTo(coordList.get((10 * i) + 4)-k, coordList.get((10 * i) + 5)));
                pathList.get(i).getElements().add(new LineTo(coordList.get((10 * i) + 6)-k, coordList.get((10 * i) + 7)));
                pathList.get(i).getElements().add(new LineTo(coordList.get((10 * i) + 8)-k, coordList.get((10 * i) + 9)));
                pathList.get(i).getElements().add(cP);

            } else {
                for (int j = 0; j < pathList.size() - 6; j++) {
                    pathList.get(i).getElements().add(new MoveTo(coordList.get((j * 6 + 60))-k, coordList.get(j * 6 + 61)));
                    pathList.get(i).getElements().add(new CubicCurveTo(coordList.get((j * 6 + 60))-k, coordList.get((j * 6 + 61)), coordList.get((j * 6 + 62))-k, coordList.get((j * 6 + 63)), coordList.get((j * 6 + 64))-k, coordList.get((j * 6 + 65))));                   
                    pathList.get(i).getElements().add(cP);
                }
            }
        }

        cacherPathList(pathList);
        
        this.superBillard = stage;
        paneJouer = new AnchorPane();

        EnsembleDeBalles players = new EnsembleDeBalles(table);
        players.initialiserBalles(table);


        //Message d'aide
        Tooltip.install(
                boutonMenu,
                new Tooltip("Revenir au menu principal")
        );
        boutonMenu = new Button("Retourner au menu principal");
        boutonDemarrer = new Button("Démarer une partie");
        boutonMusique = new Button("", new ImageView(new Image("musicLogo.png", 15, 15, true, true)));

        AnchorPane.setRightAnchor(boutonMenu, Double.valueOf(45));
        AnchorPane.setBottomAnchor(boutonMenu, Double.valueOf(5));

        AnchorPane.setRightAnchor(boutonDemarrer, Double.valueOf(30));
        AnchorPane.setTopAnchor(boutonDemarrer, Double.valueOf(25));

        AnchorPane.setBottomAnchor(boutonMusique, Double.valueOf(0));
        AnchorPane.setRightAnchor(boutonMusique, Double.valueOf(0));

        if (Launcher.mp.getStatus() == MediaPlayer.Status.PLAYING) {

            boutonMusique.setStyle("-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                    + " -fx-text-fill: black;"
                    + "-fx-font-size: 15px;"
                    + "-fx-pref-width: 15px;");
        } else {
            boutonMusique.setStyle("-fx-border-color:red;"
                    + "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                    + " -fx-text-fill: black;"
                    + "-fx-font-size: 15px;"
                    + "-fx-pref-width: 15px;");
        }

        boutonDemarrer.setStyle(
                "-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);"
                + " -fx-text-fill: white;"
                + "-fx-font-size: 10px;"
                + "-fx-pref-width: 150px;"
        );

        boutonMenu.setStyle(
                "-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);"
                + " -fx-text-fill: white;"
                + "-fx-font-size: 10px;"
                + "-fx-pref-width: 150px;"
        );

        appliquerVitesse = new Button("GO!");
        appliquerVitesse.setShape(shapeAV);
        appliquerVitesse.setPrefSize(45, 45);
        appliquerVitesse.setLayoutX(1180);
        appliquerVitesse.setLayoutY(300);
        appliquerVitesse.setCursor(Cursor.HAND);
        //Message d'aide
        Tooltip.install(
                appliquerVitesse,
                new Tooltip("Commencer le tour")
        );

        addPI = new Button("π");
        addPI.setShape(shapeAddPI);
        addPI.setPrefSize(35, 35);
        addPI.setLayoutX(1200);
        addPI.setLayoutY(250);
        addPI.setCursor(Cursor.HAND);
        addPI.setVisible(false);

        indicationVitesse = new Label("Vitesse:");
        indicationVitesse.setMaxSize(150, 30);
        indicationVitesse.setLayoutX(1070);
        indicationVitesse.setLayoutY(80);

        draggedV.setLayoutX(1135);
        draggedV.setLayoutY(80);
        draggedV.setMaxSize(150, 30);
        draggedV.setText("0");

        unitVitesse = new Button("m/s");
        unitVitesse.setLayoutX(1170);
        unitVitesse.setLayoutY(80);
        unitVitesse.setCursor(Cursor.HAND);
        //Message d'aide
        Tooltip.install(
                unitVitesse,
                new Tooltip("Unité de la vitesse entrée")
        );

        attenteTour = new Label("Veuillez attendre la fin du tour");
        attenteTour.setMaxSize(200, 40);
        attenteTour.setLayoutX(1070);
        attenteTour.setLayoutY(320);

        vitesseActuelle = new Label("Vitesse actuelle");
        vitesseActuelle.setMaxSize(200, 40);
        vitesseActuelle.setLayoutX(1070);
        vitesseActuelle.setLayoutY(440);
        //Message d'aide
        Tooltip.install(
                vitesseActuelle,
                new Tooltip("Vitesse actuelle de la balle blanche")
        );

        saisieVitesse = new Slider();
        saisieVitesse.setMaxSize(150, 30);
        saisieVitesse.setLayoutX(1070);
        saisieVitesse.setLayoutY(120);
        saisieVitesse.setMax(4);
        saisieVitesse.setMajorTickUnit(1);
        saisieVitesse.setMinorTickCount(0);
        saisieVitesse.setShowTickMarks(true);
        saisieVitesse.setShowTickLabels(true);
        saisieVitesse.setCursor(Cursor.HAND);
        saisieVitesse.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                //Arrondissement: Peut-être en faire une méthode
                String vArrondie = "";
                try {
                    vArrondie = String.valueOf(saisieVitesse.getValue()).substring(0, 6);
                } catch (StringIndexOutOfBoundsException sioobe) {
                    if (vArrondie.length() < 6) {
                        if (vArrondie.length() < 5) {
                            if ((vArrondie.length() < 4)) {
                                if (vArrondie.length() < 3) {
                                    if (vArrondie.length() < 2) {
                                        if (vArrondie.length() < 1) {
                                            vArrondie = saisieVitesse.getValue() + "";
                                        }
                                    } else {
                                        vArrondie = String.valueOf(saisieVitesse.getValue()).substring(0, 2);
                                    }
                                } else {
                                    vArrondie = String.valueOf(saisieVitesse.getValue()).substring(0, 3);
                                }
                            } else {
                                vArrondie = String.valueOf(saisieVitesse.getValue()).substring(0, 4);
                            }
                        } else {
                            vArrondie = String.valueOf(saisieVitesse.getValue()).substring(0, 5);
                        }
                    }
                } finally {
                    draggedV.textProperty().setValue(vArrondie);
                }
            }
        });
        //Message d'aide
        Tooltip.install(
                saisieVitesse,
                new Tooltip("Sélectionnez une vitesse entre 0 m/s et 4 m/s")
        );

        unitAngle = new Button("o");
        unitAngle.setShape(shapeUA);
        unitAngle.setCursor(Cursor.HAND);
        unitAngle.setPrefSize(25, 25);
        unitAngle.setLayoutX(1190);
        unitAngle.setLayoutY(210);
        //Message d'aide
        Tooltip.install(
                unitAngle,
                new Tooltip("Unité de l'angle saisi")
        );

        saisieAngle = new TextField("");
        saisieAngle.promptTextProperty().set("Angle");
        saisieAngle.setFont(angleFont);
        saisieAngle.setAlignment(Pos.CENTER);
        saisieAngle.setShape(shapeSA);
        saisieAngle.setPrefSize(100, 100);
        saisieAngle.setLayoutX(1090);
        saisieAngle.setLayoutY(210);
        //Message d'aide
        Tooltip.install(
                saisieAngle,
                new Tooltip("Entrez l'angle auquel sera lancé la balle blanche")
        );

        saisieAngle.textProperty().addListener((observable, oldValue, newValue) -> {
            String validAngleFormat = acceptedSeparator(saisieAngle.getText());
            double nbMultiplicationsParPI = 0;

            //Si l'utilisateur supprime sa saisie pour la remplacer, cela crée une erreur indésirabble qu'il faut masquer
            try {
                //On regarde de combien il faut multiplier l'angle pour considérer correctement les pi CE CODE SE RÉPÈTE PLUS TARD = PEUT-ÊTRE EN FAIRE UNE MÉTHODE
                double piMultiply;
                if (nbMultiplicationsParPI == 0) {
                    piMultiply = Double.parseDouble(validAngleFormat);
                } else {
                    piMultiply = Double.parseDouble(validAngleFormat) * (nbMultiplicationsParPI * Math.PI);
                }
                double angle = piMultiply;
                drawDirectionLine(players.getTabBalles()[0], angle, table);

                //Vérification de l'unité de l'angle entré
                if (unitAngle.getText().equals("o")) {
                    saisieAngle.rotateProperty().set(360 - angle);
                } else {

                }
                if (Double.parseDouble(saisieAngle.getText()) < 0 || Double.parseDouble(saisieAngle.getText()) > 360) {
                    if (unitAngle.getText().equals("o")) {
                        throw new OverrideAngleException("0", "360", saisieAngle.getText());
                    } else if (unitAngle.getText().equals("r")) {
                        throw new OverrideAngleException("0", "2π", saisieAngle.getText());
                    }
                }

            } catch (NumberFormatException retrrALaLigne) {
                //On vérifie si le symbole PI se retrouve dans saisieAngle,getText()
                if (containsPI(validAngleFormat)) {
                    //On regarde combien de fois le symbole PI se retrouve dans validAngleFormat
                    nbMultiplicationsParPI = numberOfPiIn(validAngleFormat);
                    //On modifie le String validAngleFormat pour supprimer les symboles PI
                    validAngleFormat = removePI(validAngleFormat);

                    double piMultiply = Double.parseDouble(validAngleFormat) * (nbMultiplicationsParPI * Math.PI);
                    drawDirectionLine(players.getTabBalles()[0], piMultiply, table);
                    saisieAngle.rotateProperty().set(Math.toDegrees((2 * Math.PI) - piMultiply));
                } else {
                    //Remettre l'orientation à 0 degrés
                    saisieAngle.rotateProperty().set(0);
                    drawDirectionLine(players.getTabBalles()[0], 0, table);
                }

            } catch (OverrideAngleException oae) {
                JOptionPane.showMessageDialog(null, oae.getMessage());
                saisieAngle.setText(saisieAngle.getText().substring(0, saisieAngle.getText().length() - 1));
            }
        });

        symboleErreur.setFont(errorFont);
        temoinAngleVide = new Circle(20);
        temoinAngleVide.setStroke(Color.RED);
        temoinAngleVide.setFill(Color.RED);
        indicationErreur = new StackPane();
        indicationErreur.setLayoutX(1060);
        indicationErreur.setLayoutY(190);
        indicationErreur.setCursor(Cursor.CROSSHAIR);
        indicationErreur.getChildren().addAll(temoinAngleVide, symboleErreur);
        //Message d'aide concernant l'erreur
        Tooltip.install(
                indicationErreur,
                new Tooltip("Veuillez remplir le champ «Angle» avant de pouvoir effectuer votre tour.")
        );
        //Initialement, on ne signale pas à l'utilisateur qu'il n'a pas entré de valeur d'angle
        indicationErreur.setVisible(false);

        visualiserVitesse = new TextField("");
        visualiserVitesse.setMaxSize(150, 30);
        visualiserVitesse.setLayoutX(1070);
        visualiserVitesse.setLayoutY(470);
        visualiserVitesse.setEditable(false);
        visualiserVitesse.setCursor(Cursor.DEFAULT);
        visualiserVitesse.setText("0 m/s");
        //Message d'aide
        Tooltip.install(
                visualiserVitesse,
                new Tooltip("Vitesse actuelle de la balle blanche")
        );

        graduationG = new Rectangle(1070, 120, 50, 15);
        graduationG.setFill(Color.GREEN);
        graduationY = new Rectangle(1120, 120, 50, 15);
        graduationY.setFill(Color.YELLOW);
        graduationR = new Rectangle(1170, 120, 50, 15);
        graduationR.setFill(Color.RED);

        boiteBoule = new Rectangle(10, 590, 1000, 30);//Version 3
        boiteBoule.setFill(Color.TRANSPARENT);
        boiteBoule.setStroke(Color.BLACK);
        
        paneJouer.getChildren().addAll(backGround);
        paneJouer.getChildren().addAll(pathList);
        
        paneJouer.getChildren().addAll(table, graduationG, graduationR, graduationY, boiteBoule, boutonMenu, appliquerVitesse,
                indicationVitesse, saisieAngle, saisieVitesse,
                visualiserVitesse, vitesseActuelle, indicationErreur, unitAngle, unitVitesse, addPI, draggedV,boutonDemarrer,boutonMusique);
        
        
        boutonDemarrer.setOnAction((ActionEvent e) -> {
            GestionPartie gestion = new GestionPartie();
            gestion.debutterPartie();
            boutonDemarrer.setVisible(false);
        });

        boutonMusique.setOnAction((ActionEvent e) -> {
            if (Launcher.mp.getStatus() == MediaPlayer.Status.PLAYING) {
                Launcher.mp.pause();
                boutonMusique.setStyle("-fx-border-color: red;"
                        + "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                        + " -fx-text-fill: black;"
                        + "-fx-font-size: 15px;"
                        + "-fx-pref-width: 15px;");
            }
            if (Launcher.mp.getStatus() == MediaPlayer.Status.PAUSED) {
                Launcher.mp.play();
                boutonMusique.setStyle("-fx-border-color:null;"
                        + "-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc),  linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                        + " -fx-text-fill: black;"
                        + "-fx-font-size: 15px;"
                        + "-fx-pref-width: 15px;");
            }
        });

        if (background == "Or") {
            Image or = new Image("Or.jpg", true);
            BackgroundImage orFond = new BackgroundImage(or, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            paneJouer.setBackground(new Background(orFond));
        }
        if (background == "Tapis" | background == null) {
            Image feutre = new Image("Feutre.jpg", true);
            BackgroundImage feutreFond = new BackgroundImage(feutre, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            paneJouer.setBackground(new Background(feutreFond));
        }

        if (background == "Glace") {
            Image glace = new Image("Glace.jpg", true);
            BackgroundImage glaceFond = new BackgroundImage(glace, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            paneJouer.setBackground(new Background(glaceFond));
        }
        if (background == "Asphalte") {
            Image asphalte = new Image("Asphalte.jpg", true);
            BackgroundImage asphalteFond = new BackgroundImage(asphalte, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            paneJouer.setBackground(new Background(asphalteFond));
        }

        menuJouer = new Scene(paneJouer, 1250, 725);
        
        deplacerBalleBlanche(players.getTabBalles()[0]);
        
        boutonMenu.setOnAction((ActionEvent e) -> {
            MenuPrincipal menuPrincipal = new MenuPrincipal(superBillard);
            superBillard.setScene(menuPrincipal.getMenu());
            superBillard.centerOnScreen();

        });

        unitAngle.setOnAction((ActionEvent e) -> {
            //On permet à l'utilisateur de choisir l'unité de l'angle qu'il va entrer
            if (unitAngle.getText().equals("o")) {
                unitAngle.setText("r");
                //On affiche le bouton qui permet d'entrer la valeur exacte de PI
                addPI.setVisible(true);
            } else {
                unitAngle.setText("o");
                addPI.setVisible(false);
            }
        });

        addPI.setOnAction((ActionEvent e) -> {
            //On ajoute le symbole PI au TextField saisieAngle
            saisieAngle.setText(saisieAngle.getText() + "π");
        });

        unitVitesse.setOnAction((ActionEvent e) -> {
            //On permet à l'utilisateur de choisir l'unité de l'angle qu'il va entrer
            if (unitVitesse.getText().equals("m/s")) {
                unitVitesse.setText("km/h");
                //Modification des limites du slider saisieVitesse
                saisieVitesse.setMax(14.4);
                visualiserVitesse.setText("0 km/h");
            } else {
                unitVitesse.setText("m/s");
                //Modification des limites du slider saisieVitesse
                saisieVitesse.setMax(4);
                visualiserVitesse.setText("0 m/s");
            }
        });

        Image imageFond = new Image("Feutre.jpg", true);
        BackgroundImage fond = new BackgroundImage(imageFond, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        paneJouer.setBackground(new Background(fond));

        boutonMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                paneJouer.getChildren().clear();
                MenuPrincipal menuPrincipal = new MenuPrincipal(superBillard);
                superBillard.setScene(menuPrincipal.menuPrincipal);

            }
        }
        );

        appliquerVitesse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Blocage des input
                saisieAngle.setDisable(true);
                saisieVitesse.setDisable(true);
                appliquerVitesse.setDisable(true);
                unitAngle.setDisable(true);
                unitVitesse.setDisable(true);
                table.getChildren().remove(visualisation);

                //On vérifie si ce champ est vide. Si c'est le cas, on l'annonce à l'utilisateur
                if (saisieAngle.getText().equals("")) {
                    //On signale à l'utilisateur que ce champ doit obligatoirement être rempli à l'aide du temoinAngleVide
                    indicationErreur.setVisible(true);
                    saisieAngle.setDisable(false);
                    saisieVitesse.setDisable(false);
                    appliquerVitesse.setDisable(false);
                    unitAngle.setDisable(false);
                    unitVitesse.setDisable(false);
                    return;

                } else {
                    indicationErreur.setVisible(false);
                    double nbMultiplicationsParPI = 0;
                    String validAngleFormat = acceptedSeparator(saisieAngle.getText());
                    //On vérifie si le symbole PI se retrouve dans saisieAngle,getText()
                    if (containsPI(validAngleFormat)) {
                        //On regarde combien de fois le symbole PI se retrouve dans validAngleFormat
                        nbMultiplicationsParPI = numberOfPiIn(validAngleFormat);
                        //On modifie le String validAngleFormat pour supprimer les symboles PI
                        validAngleFormat = removePI(validAngleFormat);
                    }
                    //On regarde de combien il faut multiplier l'angle pour considérer correctement les pi
                    double piMultiply;
                    if (nbMultiplicationsParPI == 0) {
                        piMultiply = Double.parseDouble(validAngleFormat);
                    } else {
                        piMultiply = Double.parseDouble(validAngleFormat) * (nbMultiplicationsParPI * Math.PI);
                    }
                    double angle = piMultiply;
                    //On demande la saisie de la vitesse qui sera considérée comme une vitesse en m/s

                    //TOUR
                    Thread tTour = new Thread() {
                        @Override
                        public void run() {
                            double vitesse = saisieVitesse.getValue();
                            //En Dév: Implémenter la vitesse en km/h
                            //Vérification des unités de l'angle
                            boolean degres = false;
                            if (unitAngle.getText().equals("o")) {
                                degres = true;
                            }
                            //Vérification de la vitesse en km/h
                            boolean vitesseMs = false;
                            if (unitVitesse.getText().equals("m/s")) {
                                vitesseMs = true;
                            } else {
                                //Conversion de la vitesse en km/h en m/s
                                vitesse = fromKMHtoMS(vitesse);
                            }

                            players.getTabBalles()[0].setVitesse(vitesse);

                            //Traitement des unités à compléter
                            if (degres) {
                                players.getTabBalles()[0].prepareToLaunch(players.getTabBalles()[0].angleDeTir(angle), vitesse);
                            } else {
                                players.getTabBalles()[0].prepareToLaunch(angle, vitesse);
                            }

                            while (!players.allImmobiles()) {
                                try {
                                    if (degres) {
                                        players.effectuerTour(players.getTabBalles()[0].angleDeTir(angle), players.getTabBalles()[0].obtenirVitesseLancementFromMS(vitesse), table, pathList);
                                    } else {
                                        players.effectuerTour(angle, players.getTabBalles()[0].obtenirVitesseLancementFromMS(vitesse), table, pathList);

                                    }
                                    players.actualiserBalles();
                                    Platform.runLater(() -> {
                                        //Vérification de la vitesse en km/h
                                        boolean vitesseMsLater = false;
                                        if (unitVitesse.getText().equals("m/s")) {
                                            vitesseMsLater = true;
                                        }
                                        String vObservable = "";
                                        String arrVo="";

                                        vObservable = (players.getTabBalles()[0].obtenirVitesseActuelle() + "");
                                        //Vérification des unités
                                        if (vitesseMsLater) {
                                            try {
                                                arrVo = String.valueOf(vObservable).substring(0, 6);
                                            } catch (StringIndexOutOfBoundsException sioobe) {
                                                if (arrVo.length() < 6) {
                                                    if (arrVo.length() < 5) {
                                                        if ((arrVo.length() < 4)) {
                                                            if (arrVo.length() < 3) {
                                                                if (arrVo.length() < 2) {
                                                                    if (arrVo.length() < 1) {
                                                                        arrVo = vObservable + "";
                                                                    }
                                                                } else {
                                                                    arrVo = String.valueOf(vObservable).substring(0, 2);
                                                                }
                                                            } else {
                                                                arrVo = String.valueOf(vObservable).substring(0, 3);
                                                            }
                                                        } else {
                                                            arrVo = String.valueOf(vObservable).substring(0, 4);
                                                        }
                                                    } else {
                                                        arrVo = String.valueOf(vObservable).substring(0, 5);
                                                    }
                                                }
                                            } finally {
                                                visualiserVitesse.setText(arrVo+ " m/s");
                                            }
                                        } else {
                                            try {
                                                arrVo = String.valueOf(vObservable).substring(0, 6);
                                            } catch (StringIndexOutOfBoundsException sioobe) {
                                                if (arrVo.length() < 6) {
                                                    if (arrVo.length() < 5) {
                                                        if ((arrVo.length() < 4)) {
                                                            if (arrVo.length() < 3) {
                                                                if (arrVo.length() < 2) {
                                                                    if (arrVo.length() < 1) {
                                                                        arrVo = vObservable + "";
                                                                    }
                                                                } else {
                                                                    arrVo = String.valueOf(vObservable).substring(0, 2);
                                                                }
                                                            } else {
                                                                arrVo = String.valueOf(vObservable).substring(0, 3);
                                                            }
                                                        } else {
                                                            arrVo = String.valueOf(vObservable).substring(0, 4);
                                                        }
                                                    } else {
                                                        arrVo = String.valueOf(vObservable).substring(0, 5);
                                                    }
                                                }
                                            } finally {
                                                visualiserVitesse.setText(fromMStoKMH(Double.parseDouble(arrVo)) + " km/h");
                                            }
                                            
                                        }

                                    });

                                    Thread.sleep(0,00000000001);
                                } catch (InterruptedException ex) {
                                    break;
                                }
                            }
                            //Arrêt des balles:
                            for (BalleStructure tabBalle : players.getTabBalles()) {
                                tabBalle.stopBalle();
                            }
                            //Débloquage des inputs
                            saisieAngle.setDisable(false);
                            saisieVitesse.setDisable(false);
                            appliquerVitesse.setDisable(false);
                            unitAngle.setDisable(false);
                            unitVitesse.setDisable(false);
                            //vérification des unités de la vitesse
                            if (vitesseMs) {
                                visualiserVitesse.setText("0 m/s");
                            } else {
                                visualiserVitesse.setText("0 km/h");
                            }
                        }
                    };
                    tTour.setDaemon(true);
                    tTour.setName("SB: Tour");
                    tTour.start();

                }
            }
        }
        );

    }

    /**
     * Méthode qui permet de retourner l'objet MenuJouer
     *
     * @return Objet MenuJouer
     */
    public Scene getMenu() {
        return menuJouer;
    }

    /**
     * Méthode qui permet de corriger une erreur courante lors de la saisie des
     * nombres à décimales (remplace les virgules et les momayyez par des points
     * pour assurer un bon fonctionnement du code)
     *
     * @author Vittorio Passuello-Dussault
     * @param angleInput
     * @return acceptedFormat (valeur booléenne qui indique si le format de
     * saisie est acceptable) Source des séparateurs mondiaux :
     * https://fr.wikipedia.org/wiki/S%C3%A9parateur_d%C3%A9cimal
     */
    public String acceptedSeparator(String angleInput) {
        final char possibleSeparator1 = ',', possibleSeparator2 = '٫', separator = '.';
        StringBuilder correct = new StringBuilder(angleInput);
        for (int count = 0; count < angleInput.length(); count++) {
            switch (angleInput.charAt(count)) {
                case possibleSeparator1:
                    correct.setCharAt(count, separator);
                case possibleSeparator2:
                    correct.setCharAt(count, separator);
            }
        }
        return correct.toString();
    }
    
    /**
     * Méthode qui permet de tracer la ligne de direction
     *
     * @param balle Balle qui est lancée
     * @param angle Angle auquel la Balle est lancée
     * @param table Objet Table qui représente la table de billard
     * @author Vittorio Passuello-Dussault
     */
    

    private void cacherPathList(ArrayList<Path> pathList) {
        for (int i = 0; i < pathList.size(); i++) {
            pathList.get(i).setVisible(true);
        }
    }

    /**
     * Méthode qui détecte la présence du symbole "π" dans saisieAngle.getText()
     *
     * @param angleInput
     * @return valeur booléenne signalant s'il faut multiplier le scalaire par
     * Math.PI
     */
    public boolean containsPI(String angleInput) {
        boolean PiInside = false;
        for (int count = 0; count < angleInput.length(); count++) {
            if (angleInput.charAt(count) == 'π') {
                PiInside = true;
                break;
            }
        }
        return PiInside;
    }

    /**
     * Méthode qui retourne le nombre de fois que le symbole "π" se retrouve
     * dans saisieAngle.getText() pour savoir combien de temps multiplier le
     * scalaire par Math.PI
     *
     * @param angleInput String entrée par l'utilisateur pour l'angle du lancé
     * @return Nombre de fois que le symbole "π" est répété dans angleInput
     */
    public int numberOfPiIn(String angleInput) {
        int nbPi = 0;
        for (int count = 0; count < angleInput.length(); count++) {
            if (angleInput.charAt(count) == 'π') {
                nbPi++;
            }
        }
        return nbPi;
    }

    /**
     * Méthode qui retire les symboles PI d'un String afin d'en extraire le
     * scalaire
     */
    public String removePI(String angleInput) {
        StringBuilder scalaire = new StringBuilder(angleInput);
        final char symbolePI = 'π';
        for (int count = 0; count < angleInput.length(); count++) {
            switch (angleInput.charAt(count)) {
                case symbolePI:
                    scalaire.deleteCharAt(count);
            }
        }
        return scalaire.toString();
    }

    /**
     * Méthode qui permet de tracer la ligne de direction
     *
     * @param balle Balle qui est lancée
     * @param angle Angle auquel la Balle est lancée
     * @param table Objet Table qui représente la table de billard
     * @author Vittorio Passuello-Dussault
     */
    public void drawDirectionLine(BalleStructure balle, double angle, Table table) {
        if (alreadyDrawnDirectionLine) {
            table.getChildren().remove(visualisation);
            alreadyDrawnDirectionLine = false;
        }

        //Vérification de l'unité de l'angle entré pour dessiner la ligne directrice
        if (unitAngle.getText().equals("o")) {
            angle = angle - 270;
            angle = Math.toRadians(angle);
        } else {
            angle = (angle) - (3 * (Math.PI / 2));
            System.out.println("angle donné à la droite: " + angle);
        }

        //Distance entre la balle et le côté droit de la table
        double dbr = table.getBoundsInLocal().getMaxX() - 342;
        //Distance entre la balle et le côté gauche de la table
        double dbl = table.getBoundsInLocal().getMinX() + 303;
        //Distance entre la balle et le haut de la table
        //double dbu = 

        //Les points de débuts de la ligne sont les coordonnées de la balle
        double startX = balle.getBoundsInParent().getMaxX() - balle.getBalle().getRadius();
        double startY = balle.getBoundsInParent().getMaxY() - balle.getBalle().getRadius();

        //Calcul de la coordonnée finale en X avec hypothénuse arbitraire
        double endX = startX + dbl * (Math.sin(angle));
        double endY = startY + dbl * (Math.cos(angle));
        //Création de la Line
        visualisation = new Line(startX, startY, endX, endY);
        visualisation.setFill(Color.WHITE);
        visualisation.setStroke(Color.WHITE);
        table.getChildren().add(visualisation);
        alreadyDrawnDirectionLine = true;
    }

    /**
     * Méthode qui converti une vitesse en km/h en une vitesse en m/s
     *
     * @param vitesse vitesse en km/h
     * @return vitesse en m/s
     */
    public double fromKMHtoMS(double vitesse) {
        return vitesse / 3.6;
    }

    /**
     * Méthode qui converti une vitesse en m/s en une vitesse en km/h
     *
     * @param vitesse vitesse en m/s
     * @return vitesse en km/h
     */
    public double fromMStoKMH(double vitesse) {
        return vitesse * 3.6;
    }

    /**
     * Méthode qui va permettre de pouvoir déplacer la balle blanche
     *
     * @param uneBalle Balle à déplacer
     */
    public void deplacerBalleBlanche(BalleStructure uneBalle) {
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {//Version 3
                    @Override
                    public void handle(MouseEvent event){
                        if (uneBalle.getBalle().isBalleEntree() == false){
                            JOptionPane.showMessageDialog(null,"Vous ne pouvez pas déplacer la balle blanche!");
                        }
                        else{
                            uneBalle.setLayoutX(event.getX());
                            uneBalle.setLayoutY(event.getY());
                            uneBalle.getBalle().setBalleEntree(false);
                        }
                    }
                });
    }
    
    private void remplirPathList(ArrayList<Path> list) {

        Path coteDroite = new Path();
        Path hautDroite = new Path();
        Path hautGauche = new Path();
        Path coteGauche = new Path();
        Path basDroite = new Path();
        Path basGauche = new Path();
        Path coinHG = new Path();
        Path coinHC = new Path();
        Path coinHD = new Path();
        Path coinBG = new Path();
        Path coinBC = new Path();
        Path coinBD = new Path();
        list.add(coteDroite);//0
        list.add(hautDroite);//1
        list.add(hautGauche);//2
        list.add(coteGauche);//3
        list.add(basDroite);//4
        list.add(basGauche);//5
        list.add(coinHG);//6
        list.add(coinHC);//7
        list.add(coinHD);//8
        list.add(coinBG);//9
        list.add(coinBC);//10
        list.add(coinBD);//11

    }

    private void remplirCoordList(List<Double> list) {

        //coord coteDroite
        list.add(100.0);
        list.add(100.0);
        list.add(100.0);
        list.add(498.0);
        list.add(112.0);
        list.add(486.0);
        list.add(112.0);
        list.add(111.0);
        list.add(100.0);
        list.add(100.0);

        //coord hautDroite
        list.add(1018.0);
        list.add(100.0);
        list.add(1018.0);
        list.add(498.0);
        list.add(1006.0);
        list.add(486.0);
        list.add(1006.0);
        list.add(111.0);
        list.add(1018.0);
        list.add(100.0);

        //hautGauche
        list.add(584.0);
        list.add(63.0);
        list.add(984.0);
        list.add(63.0);
        list.add(972.0);
        list.add(75.0);
        list.add(587.0);
        list.add(75.0);
        list.add(584.0);
        list.add(63.0);

        //coord coteGauche
        list.add(137.0);
        list.add(63.0);
        list.add(537.0);
        list.add(63.0);
        list.add(533.0);
        list.add(75.0);
        list.add(148.0);
        list.add(75.0);
        list.add(137.0);
        list.add(63.0);

        //coord basDroite
        list.add(584.0);
        list.add(535.0);
        list.add(984.0);
        list.add(535.0);
        list.add(972.0);
        list.add(523.0);
        list.add(587.0);
        list.add(523.0);
        list.add(584.0);
        list.add(535.0);

        //coord basGauche
        list.add(137.0);
        list.add(535.0);
        list.add(537.0);
        list.add(535.0);
        list.add(533.0);
        list.add(523.0);
        list.add(148.0);
        list.add(523.0);
        list.add(137.0);
        list.add(535.0);

        //coord coinHG
        list.add(100.0);
        list.add(100.0);
        list.add(140.0);
        list.add(100.0);
        list.add(137.0);
        list.add(63.0);

        //coord coinHC
        list.add(537.0);
        list.add(63.0);
        list.add(560.5);
        list.add(85.0);
        list.add(584.0);
        list.add(63.0);

        //coord coinHD
        list.add(984.0);
        list.add(63.0);
        list.add(990.0);
        list.add(95.0);
        list.add(1018.0);
        list.add(100.0);

        //coord coinBG
        list.add(100.0);
        list.add(498.0);
        list.add(125.0);
        list.add(500.0);
        list.add(137.0);
        list.add(535.0);

        //coord coinBC
        list.add(537.0);
        list.add(535.0);
        list.add(560.5);
        list.add(513.0);
        list.add(584.0);
        list.add(535.0);

        //coord coinBD
        list.add(984.0);
        list.add(535.0);
        list.add(990.0);
        list.add(500.0);
        list.add(1018.0);
        list.add(498.0);

    }
}
