package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(62 * 10);
        fantome.setLayoutY(46 * 10);
        pacman.setLayoutY(2 * 10);
        pacman.setLayoutX(2 * 10);
        Obstacle obst1 = new Obstacle(0, 0, 640, 10);
        Obstacle obst2 = new Obstacle(0, 0, 10, 170);
        Obstacle obst3 = new Obstacle(0, 480, 640, 10);
        Obstacle obst4 = new Obstacle(0, 310, 10, 170);
        Obstacle obst5 = new Obstacle(630, 0, 10, 170);
        Obstacle obst6 = new Obstacle(630, 310, 10, 170);
        Obstacle obst7 = new Obstacle(0, 470, 640, 10);
        Obstacle obst8 = new Obstacle(0, 170, 70, 10);
        Obstacle obst9 = new Obstacle(570, 170, 70, 10);
        Obstacle obst10 = new Obstacle(0, 310, 70, 10);
        Obstacle obst11 = new Obstacle(70, 170, 10, 55);
        Obstacle obst12 = new Obstacle(70, 255, 10, 65);
        Obstacle obst13 = new Obstacle(0, 225, 80, 10);
        Obstacle obst14 = new Obstacle(0, 255, 80, 10);
        Obstacle obst15 = new Obstacle(310, 0, 10, 50);
        Obstacle obst16 = new Obstacle(0, 310, 70, 10);

        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(obst1);
        obstacles.add(obst2);
        obstacles.add(obst3);
        obstacles.add(obst4);
        obstacles.add(obst5);
        obstacles.add(obst6);
        obstacles.add(obst7);
        obstacles.add(obst8);
        obstacles.add(obst9);
        obstacles.add(obst10);
        obstacles.add(obst11);
        obstacles.add(obst12);
        obstacles.add(obst13);
        obstacles.add(obst14);
        obstacles.add(obst15);

        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().addAll(obstacles);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, obstacles);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, List<Obstacle> obstacles) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double xBefore = j1.getLayoutX();
            double yBefore = j1.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());

                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());

                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());

                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());

                    break;
                case Z:
                    j2.deplacerEnHaut();

                    break;
            }

            if (j1.estEnCollision(j2)) {
                System.out.println("Collision....");

            }

            if (j1.estEnCollisionMur(obstacles, j1.getLayoutX(), j1.getLayoutY())){
                j1.setLayoutX(xBefore);
                j1.setLayoutY(yBefore);
            }

        });
    }


}
