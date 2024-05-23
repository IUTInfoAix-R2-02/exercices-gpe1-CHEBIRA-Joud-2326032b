package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;
    private IntegerProperty nbFois = new SimpleIntegerProperty();
    private StringProperty message = new SimpleStringProperty("");

    private StringProperty couleurPanneau = new SimpleStringProperty("#000000");



    private void createBindings(){
        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty(true);
        pasEncoreDeClic.bind(Bindings.equal(0, nbFois));
        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClic).then("Aucune couleur choisi").otherwise(Bindings.concat(message, " choisi ", nbFois.asString(), " fois")));
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color : ", couleurPanneau));
        texteDuBas.textProperty().bind(Bindings.concat("Le ", message, " est une jolie couleur !"));
        texteDuBas.styleProperty().bind(Bindings.concat("-fx-text-fill : ", couleurPanneau));
    }
    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");
        createBindings();
        /* VOTRE CODE ICI */
        vert.setOnAction(actionEvent -> {
            nbVert++;
            message.set("Vert");
            nbFois.set(nbVert);
            couleurPanneau.set("green");
        });
        rouge.setOnAction(actionEvent -> {
            nbRouge++;
            nbFois.set(nbRouge);
            message.set("Rouge");
            couleurPanneau.set("red");
        });
        bleu.setOnAction(actionEvent -> {
            nbBleu++;
            nbFois.set(nbBleu);
            message.set("Bleu");
            couleurPanneau.set("blue");
        });
        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

