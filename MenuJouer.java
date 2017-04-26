package vue;

import javafx.scene.text.Font;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javax.swing.JOptionPane;
import modele.Balle;
import modele.BalleStructure;
import modele.EnsembleDeBalles;
import modele.Table;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;
import javafx.scene.shape.ClosePath;

/**
 * Classe qui représente le menu jouer du menu principal
 *
 * @author Édouard Raffis
 * @version 2.0 2017-04-09
 */
public class MenuJouer {

    Stage superBillard;
    Scene menuJouer;
    AnchorPane paneJouer;
    Button boutonMenu;
    Table table;
    Label indicationVitesse;
    Label vitesseActuelle;
    Slider saisieVitesse;
    public static Label attenteTour;
    public static TextField saisieAngle;
    public static TextField visualiserVitesse;
    public static Button appliquerVitesse;
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

    //TextField représentant les unités de l'angle à saisir
    TextField unitAngle;
    Circle shapeUA = new Circle(25);

    //Icônes signalant une erreur de saisie (sera peut-être dirigé vers une classe)
    Font errorFont = new Font("Arial", 45);
    Circle temoinAngleVide;
    Label symboleErreur = new Label("!");
    StackPane indicationErreur;

    //Shape du bouton appliquerVitesse
    Circle shapeAV = new Circle(45);

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

// coordonnÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â©es 2ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¨me sommet du polygone
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

        boutonMenu = new Button("Retourner au menu principal");
        AnchorPane.setRightAnchor(boutonMenu, Double.valueOf(25));
        AnchorPane.setBottomAnchor(boutonMenu, Double.valueOf(10));

        appliquerVitesse = new Button("GO!");
        appliquerVitesse.setShape(shapeAV);
        appliquerVitesse.setPrefSize(45, 45);
        appliquerVitesse.setLayoutX(1180);
        appliquerVitesse.setLayoutY(300);

        indicationVitesse = new Label("Vitesse (m/s):");
        indicationVitesse.setMaxSize(150, 30);
        indicationVitesse.setLayoutX(1070);
        indicationVitesse.setLayoutY(80);

        attenteTour = new Label("Veuillez attendre la fin du tour");
        attenteTour.setMaxSize(200, 40);
        attenteTour.setLayoutX(1070);
        attenteTour.setLayoutY(320);

        vitesseActuelle = new Label("Vitesse actuelle");
        vitesseActuelle.setMaxSize(200, 40);
        vitesseActuelle.setLayoutX(1070);
        vitesseActuelle.setLayoutY(440);

        saisieVitesse = new Slider();
        saisieVitesse.setMaxSize(150, 30);
        saisieVitesse.setLayoutX(1070);
        saisieVitesse.setLayoutY(120);
        saisieVitesse.setMax(4);
        saisieVitesse.setMajorTickUnit(1);
        saisieVitesse.setMinorTickCount(0);
        saisieVitesse.setShowTickMarks(true);
        saisieVitesse.setShowTickLabels(true);

        unitAngle = new TextField("o");
        unitAngle.setShape(shapeUA);
        unitAngle.setCursor(Cursor.DEFAULT);
        unitAngle.setPrefSize(25, 25);
        unitAngle.setLayoutX(1190);
        unitAngle.setLayoutY(210);
        unitAngle.setEditable(false);
        //Message d'aide
        Tooltip.install(
                unitAngle,
                new Tooltip("L'unité de l'angle saisi est en degrés")
        );

        saisieAngle = new TextField("");
        saisieAngle.promptTextProperty().set("Angle");
        saisieAngle.setAlignment(Pos.CENTER);
        saisieAngle.setShape(shapeSA);
        saisieAngle.setPrefSize(100, 100);
        saisieAngle.setLayoutX(1090);
        saisieAngle.setLayoutY(210);

        saisieAngle.textProperty().addListener((observable, oldValue, newValue) -> {
            String validAngleFormat = acceptedSeparator(saisieAngle.getText());
            //Si l'utilisateur supprime sa saisie pour la remplacer, cela crée une erreur indésirabble qu'il faut masquer
            try {
                double angle = Double.parseDouble(validAngleFormat);
                drawDirectionLine(players.tabBalles[0], angle, table);
                //En dév: incliner le texte su même angle que celui qui est en train d'être saisi
                saisieAngle.rotateProperty().set(360 - angle);

            } catch (NumberFormatException retrrALaLigne) {
                //Remettre l'orientation à 0 degrés
                saisieAngle.rotateProperty().set(0);
                drawDirectionLine(players.tabBalles[0], 0, table);
            }
        });
        symboleErreur.setFont(errorFont);
        temoinAngleVide = new Circle(20);
        temoinAngleVide.setStroke(Color.RED);
        temoinAngleVide.setFill(Color.RED);
        indicationErreur = new StackPane();
        indicationErreur.setLayoutX(1200);
        indicationErreur.setLayoutY(245);
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

        boiteBoule = new Rectangle(10, 590, 1000, 125);
        boiteBoule.setFill(Color.WHEAT);
        
         paneJouer.getChildren().addAll(backGround);
        paneJouer.getChildren().addAll(pathList);
        

        paneJouer.getChildren().addAll(table, graduationG, graduationR, graduationY, boiteBoule, boutonMenu, appliquerVitesse,
                indicationVitesse, saisieAngle, saisieVitesse,
                visualiserVitesse, vitesseActuelle, indicationErreur, unitAngle);


        new Thread(() -> {
            Thread.currentThread().setName("Thread qui permet de rendre la balle blanche déplaçable");

            while (balleBlancheDraggable == true) {
                if (players.tabBalles[0].getLayoutX() >= table.getTrouSuperieurGauche().getLayoutX() - table.getTrouSuperieurGauche().getRadius() & players.tabBalles[0].getLayoutX() <= table.getTrouSuperieurGauche().getLayoutX() + table.getTrouSuperieurGauche().getRadius() & players.tabBalles[0].getLayoutY() >= table.getTrouSuperieurGauche().getLayoutY() - table.getTrouSuperieurGauche().getRadius() & players.tabBalles[0].getLayoutY() <= table.getTrouSuperieurGauche().getLayoutY() + table.getTrouSuperieurGauche().getRadius()) {
                    if (players.tabBalles[0].getBalle().getCouleur() == Color.WHITE) {
                        deplacerBalleBlanche(players.tabBalles[0]);

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(null, "Thread Intérrompu"); // À  remplacer avec classe d'erreur
                        }
                    }
                } else if (players.tabBalles[0].getLayoutX() >= table.getTrouSuperieurMilieu().getLayoutX() - table.getTrouSuperieurMilieu().getRadius() & players.tabBalles[0].getLayoutX() <= table.getTrouSuperieurMilieu().getLayoutX() + table.getTrouSuperieurMilieu().getRadius() & players.tabBalles[0].getLayoutY() >= table.getTrouSuperieurMilieu().getLayoutY() - table.getTrouSuperieurMilieu().getRadius() & players.tabBalles[0].getLayoutY() <= table.getTrouSuperieurMilieu().getLayoutY() + table.getTrouSuperieurGauche().getRadius()) {
                    if (players.tabBalles[0].getBalle().getCouleur() == Color.WHITE) {
                        deplacerBalleBlanche(players.tabBalles[0]);

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(null, "Thread Intérrompu"); // À  remplacer avec classe d'erreur
                        }
                    }
                } else if (players.tabBalles[0].getLayoutX() >= table.getTrouSuperieurDroite().getLayoutX() - table.getTrouSuperieurDroite().getRadius() & players.tabBalles[0].getLayoutX() <= table.getTrouSuperieurDroite().getLayoutX() + table.getTrouSuperieurDroite().getRadius() & players.tabBalles[0].getLayoutY() >= table.getTrouSuperieurDroite().getLayoutY() - table.getTrouSuperieurDroite().getRadius() & players.tabBalles[0].getLayoutY() <= table.getTrouSuperieurDroite().getLayoutY() + table.getTrouSuperieurDroite().getRadius()) {
                    if (players.tabBalles[0].getBalle().getCouleur() == Color.WHITE) {
                        deplacerBalleBlanche(players.tabBalles[0]);

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(null, "Thread Intérrompu"); // À  remplacer avec classe d'erreur
                        }
                    }
                } else if (players.tabBalles[0].getLayoutX() >= table.getTrouInferieurGauche().getLayoutX() - table.getTrouInferieurGauche().getRadius() & players.tabBalles[0].getLayoutX() <= table.getTrouInferieurGauche().getLayoutX() + table.getTrouInferieurGauche().getRadius() & players.tabBalles[0].getLayoutY() >= table.getTrouInferieurGauche().getLayoutY() - table.getTrouInferieurGauche().getRadius() & players.tabBalles[0].getLayoutY() <= table.getTrouInferieurGauche().getLayoutY() + table.getTrouInferieurGauche().getRadius()) {
                    if (players.tabBalles[0].getBalle().getCouleur() == Color.WHITE) {
                        deplacerBalleBlanche(players.tabBalles[0]);

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(null, "Thread Intérrompu"); // À  remplacer avec classe d'erreur
                        }
                    }
                } else if (players.tabBalles[0].getLayoutX() >= table.getTrouInferieurMilieu().getLayoutX() - table.getTrouInferieurMilieu().getRadius() & players.tabBalles[0].getLayoutX() <= table.getTrouInferieurMilieu().getLayoutX() + table.getTrouInferieurMilieu().getRadius() & players.tabBalles[0].getLayoutY() >= table.getTrouInferieurMilieu().getLayoutY() - table.getTrouInferieurMilieu().getRadius() & players.tabBalles[0].getLayoutY() <= table.getTrouInferieurMilieu().getLayoutY() + table.getTrouInferieurMilieu().getRadius()) {
                    if (players.tabBalles[0].getBalle().getCouleur() == Color.WHITE) {
                        deplacerBalleBlanche(players.tabBalles[0]);

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(null, "Thread Intérrompu"); // À  remplacer avec classe d'erreur
                        }
                    }
                } else if (players.tabBalles[0].getLayoutX() >= table.getTrouInferieurDroite().getLayoutX() - table.getTrouInferieurDroite().getRadius() & players.tabBalles[0].getLayoutX() <= table.getTrouInferieurDroite().getLayoutX() + table.getTrouInferieurDroite().getRadius() & players.tabBalles[0].getLayoutY() >= table.getTrouInferieurDroite().getLayoutY() - table.getTrouInferieurDroite().getRadius() & players.tabBalles[0].getLayoutY() <= table.getTrouInferieurDroite().getLayoutY() + table.getTrouInferieurDroite().getRadius()) {
                    if (players.tabBalles[0].getBalle().getCouleur() == Color.WHITE) {
                        deplacerBalleBlanche(players.tabBalles[0]);

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(null, "Thread Intérrompu"); // À  remplacer avec classe d'erreur
                        }
                    }
                } else {
                    balleBlancheDraggable = false;
                }
            }
        }).start();

        menuJouer = new Scene(paneJouer, 1250, 725);

        boutonMenu.setOnAction((ActionEvent e) -> {
            MenuPrincipal menuPrincipal = new MenuPrincipal(superBillard);
            superBillard.setScene(menuPrincipal.getMenu());
            superBillard.centerOnScreen();

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
                table.getChildren().remove(visualisation);

                //On vérifie si ce champ est vide. Si c'est le cas, on l'annonce à l'utilisateur
                if (saisieAngle.getText().equals("")) {
                    //On signale à l'utilisateur que ce champ doit obligatoirement être rempli à l'aide du temoinAngleVide
                    indicationErreur.setVisible(true);
                    saisieAngle.setDisable(false);
                    saisieVitesse.setDisable(false);
                    appliquerVitesse.setDisable(false);
                    return;

                } else {
                    indicationErreur.setVisible(false);
                    String validAngleFormat = acceptedSeparator(saisieAngle.getText());
                    double angle = Double.parseDouble(validAngleFormat);
                    //On demande la saisie de la vitesse qui sera considérée comme une vitesse en m/s
                    double vitesse = saisieVitesse.getValue();

                    //TOUR
                    Thread tTour = new Thread() {
                        @Override
                        public void run() {
                            players.tabBalles[0].setVitesse(vitesse);
                            players.tabBalles[0].prepareToLaunch(players.tabBalles[0].angleDeTir(angle), vitesse);
                            while (!players.allImmobiles()) {
                                try {
                                    players.effectuerTour(players.tabBalles[0].angleDeTir(angle), players.tabBalles[0].obtenirVitesseLancement(vitesse), table);
                                    players.actualiserBalles();
                                    Platform.runLater(() -> {
                                        String vObservable = "";
                                        vObservable = (players.tabBalles[0].obtenirVitesseActuelle() + "");
                                        visualiserVitesse.setText(vObservable + " m/s");
                                    });

                                    Thread.sleep(1);
                                } catch (InterruptedException ex) {
                                    break;
                                }
                            }
                            //Débloquage des inputs
                            saisieAngle.setDisable(false);
                            saisieVitesse.setDisable(false);
                            appliquerVitesse.setDisable(false);
                            visualiserVitesse.setText("0 m/s");
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
            pathList.get(i).setVisible(false);
        }

    }
    public void drawDirectionLine(BalleStructure balle, double angle, Table table) {
        if (alreadyDrawnDirectionLine) {
            table.getChildren().remove(visualisation);
            alreadyDrawnDirectionLine = false;
        }
        angle = angle - 270;
        angle = Math.toRadians(angle);

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
     * Méthode qui va permettre de pouvoir déplacer la balle blanche
     *
     * @param uneBalle Balle à déplacer
     */
    public void deplacerBalleBlanche(BalleStructure uneBalle) {
        uneBalle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getSceneX();
                y = event.getSceneY();
                deltX = ((Balle) (event.getSource())).getTranslateX();
                deltY = ((Balle) (event.getSource())).getTranslateY();
            }
        });
        uneBalle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double orgX = event.getSceneX() - x;
                double orgY = event.getSceneY() - y;
                double newOrgX = deltX + orgX;
                double newOrgY = deltX + orgY;
                ((Balle) (event.getSource())).setTranslateX(newOrgX);
                ((Balle) (event.getSource())).setTranslateY(newOrgY);
            }
        });
        EventHandler<MouseEvent> unMouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                balleBlancheDraggable = false;
            }
        };
        uneBalle.setOnMouseReleased(unMouseEvent);
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
        list.add(coteDroite);
        list.add(hautDroite);
        list.add(hautGauche);
        list.add(coteGauche);
        list.add(basDroite);
        list.add(basGauche);
        list.add(coinHG);
        list.add(coinHC);
        list.add(coinHD);
        list.add(coinBG);
        list.add(coinBC);
        list.add(coinBD);

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
