package testrebonds;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.*;

public class TestRebonds extends Application{

    public static Sphere circle;
    public static Pane  canvas;
    double x,y,deltX,deltY;

    @Override
    public void start(final Stage primaryStage) {

        canvas = new Pane();
        final Scene scene = new Scene(canvas, 800, 600);

        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Image image = new Image("Queue.png");

        circle = new Sphere(10);
        circle.relocate(243, 100);
        circle.setCursor(Cursor.OPEN_HAND);
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("("+(int)event.getScreenX()+","+(int)event.getScreenY()+")");
            }
        });
        Rectangle table = new Rectangle(20, 20, 475, 325);
        Rectangle horsTable = new Rectangle (0,0,530,380);
        Rectangle ombreTable = new Rectangle(13,13,490,340);
        Circle trou1 = new Circle(17, Color.BLACK);
        Circle trou2 = new Circle(17, Color.BLACK);
        Circle trou3 = new Circle(17, Color.BLACK);
        Circle trou4 = new Circle(17, Color.BLACK);
        Circle trou5 = new Circle(17, Color.BLACK);
        Circle trou6 = new Circle(17, Color.BLACK);
        Circle trou7 = new Circle(17, Color.BLACK);
        Circle trou8 = new Circle(17, Color.BLACK);
        trou1.relocate(5, 5);
        trou2.relocate(243,5);
        trou3.relocate(481,5);
        trou4.relocate(5,168);
        trou5.relocate(5,331);
        trou6.relocate(243,331);
        trou7.relocate(481,331);
        trou8.relocate(481,168);
        //horsTable.setFill(Color.TRANSPARENT);
        horsTable.setFill(Color.BROWN);
        //ombreTable.setFill(Color.TRANSPARENT);
        ombreTable.setFill(Color.rgb(128,0,0));
        table.setFill(Color.TRANSPARENT);
        table.setFill(Color.GREEN);
        
        canvas.getChildren().addAll(horsTable);
        canvas.getChildren().addAll(ombreTable);
        canvas.getChildren().addAll(table);
        canvas.getChildren().addAll(trou1);
        canvas.getChildren().addAll(trou2);
        canvas.getChildren().addAll(trou3);
        canvas.getChildren().addAll(trou4);
        canvas.getChildren().addAll(trou5);
        canvas.getChildren().addAll(trou6);
        canvas.getChildren().addAll(trou7);
        canvas.getChildren().addAll(trou8);
        canvas.getChildren().addAll(circle);
        
        /*EventHandler<MouseEvent> circleOnMousePressedEventHandler = 
                new EventHandler<MouseEvent>(){
                    
                @Override
                public void handle(MouseEvent event){
                    x = event.getSceneX();
                    y = event.getSceneY();
                    deltX = ((Circle)(event.getSource())).getTranslateX();
                    deltY = ((Circle)(event.getSource())).getTranslateY(); 
                }
        };
        EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = 
                new EventHandler<MouseEvent>(){
                    
                @Override
                public void handle(MouseEvent event){
                    double tonCulX = event.getSceneX() - x;
                    double tonCulY = event.getSceneY() - y;
                    double newCulX = deltX + tonCulX;
                    double newCulY = deltX + tonCulY;
                    ((Circle)(event.getSource())).setTranslateX(newCulX);
                    ((Circle)(event.getSource())).setTranslateY(newCulY); 
            }
        };
        
        circle.setOnMousePressed(circleOnMousePressedEventHandler);
        circle.setOnMouseDragged(circleOnMouseDraggedEventHandler);*/
        
        circle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getSceneX();
                y = event.getSceneY();
                deltX = ((Sphere)(event.getSource())).getTranslateX();
                deltY = ((Sphere)(event.getSource())).getTranslateY();
            }
        });
        circle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double tonCulX = event.getSceneX() - x;
                double tonCulY = event.getSceneY() - y;
                double newCulX = deltX + tonCulX;
                double newCulY = deltX + tonCulY;
                ((Sphere)(event.getSource())).setTranslateX(newCulX);
                ((Sphere)(event.getSource())).setTranslateY(newCulY);
            }
        });

        /*What is love?
        Baby don't hurt me
        Dont't hurt me
        No more*/
        
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            double deltaX = 0;
            double deltaY = 0;
            int count=0;

            @Override
            public void handle(final ActionEvent t) {
                circle.setLayoutX(circle.getLayoutX() + deltaX);
                circle.setLayoutY(circle.getLayoutY() + deltaY);
                //System.out.println("("+circle.getLayoutX()+","+circle.getLayoutY()+")");

                final Bounds bounds = table.getBoundsInLocal();
                final boolean atRightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
                final boolean atLeftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
                final boolean atBottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
                final boolean atTopBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());
                

                if (atRightBorder || atLeftBorder) {
                    deltaX *= -0.9;
                    count++;
                    /*if(count == 3){
                        deltaX=0;
                    }*/
                }
                if (atBottomBorder || atTopBorder) {
                    deltaY *= -1;
                }
                if(circle.getLayoutX()==5 & circle.getLayoutY()==5){
                    deltaX=0;
                    deltaY=0;
                    canvas.getChildren().remove(circle);
                }
                else if(circle.getLayoutX()==258 & circle.getLayoutY()==35){
                        deltaX=0;
                        deltaY=0;
                        canvas.getChildren().remove(circle);
                }
                    else if(circle.getLayoutX()==35 & circle.getLayoutY()==183){
                            deltaX=0;
                            deltaY=0;
                            canvas.getChildren().remove(circle);
                        }
                        else if(circle.getLayoutX()==258 & circle.getLayoutY()==331){
                                deltaX=0;
                                deltaY=0;
                                canvas.getChildren().remove(circle);
                            }
                            else if(circle.getLayoutX()==481 & circle.getLayoutY()==183){
                                    deltaX=0;
                                    deltaY=0;
                                    canvas.getChildren().remove(circle);
                                }   
            }
        }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
