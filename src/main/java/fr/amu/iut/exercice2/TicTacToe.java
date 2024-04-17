package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Random;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {
        ImageView croix = new ImageView("exercice2/Croix.png");
        ImageView rond = new ImageView("exercice2/Rond.png");
        ImageView vide = new ImageView("exercice2/Vide.png");
        GridPane gP = new GridPane();
        gP.setStyle("-fx-grid-lines-visible: true");
        Random random = new Random();
        for (int k = 0; k < 3; k++) {
            for (int kk = 0; kk < 3; kk++) {
                System.out.println(kk);
                int nbrImage = random.nextInt(3);
                System.out.println("r :" + nbrImage);
                Label l = new Label();
                switch (nbrImage) {
                    case 0:
                        l.setGraphic(croix);
                        break;

                    case 1:
                        l.setGraphic(rond);
                        break;

                    case 2:
                        l.setGraphic(vide);
                        break;

                    default :
                        System.out.println("Erreur");
                }
                GridPane.setConstraints(l, k, kk);
                gP.getChildren().add(l);
            }
        }
        System.out.println("aa");
        Scene sc = new Scene(gP);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Exercice2");
        primaryStage.show();
    }

}

