package fr.amu.iut.exercice5;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Rectangle {
    public Obstacle(double x, double y, double longueur, double largeur) {
        super(x,y,longueur, largeur);
        setFill(Color.PURPLE);
    }
}
