package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane bdp = new BorderPane();
        Menu mFile = new Menu("File");
        Menu mEdit = new Menu("Edit");
        Menu mHelp = new Menu("Help");
        MenuItem mNew = new MenuItem("New");
        MenuItem mOpen = new MenuItem("Open");
        MenuItem mSave = new MenuItem("Save");
        MenuItem mClose = new MenuItem("Close");
        mFile.getItems().addAll(mNew, mOpen, mClose, mSave);
        MenuItem mCut = new MenuItem("Cut");
        MenuItem mCopy = new MenuItem("Copy");
        MenuItem mPaste = new MenuItem("Paste");
        mEdit.getItems().addAll(mCut, mCopy, mPaste);
        MenuBar mBar = new MenuBar(mFile,mEdit,mHelp);
        Label lbBottom = new Label("Ceci est un label de bas de page");
        Separator sep3 = new Separator(Orientation.HORIZONTAL);
        VBox vbBottom = new VBox();
        vbBottom.getChildren().addAll(sep3, lbBottom);
        VBox vb = new VBox();
        Label lbBoutons = new Label("Boutons :");
        Button btn1 = new Button("Bouton 1");
        Button btn2 = new Button("Bouton 2");
        Button btn3 = new Button("Bouton 3");
        Separator sep1 = new Separator(Orientation.HORIZONTAL);
        Separator sep2 = new Separator(Orientation.VERTICAL);

        vb.getChildren().addAll(lbBoutons, btn1, btn2, btn3);
        HBox hbLeft = new HBox();
        hbLeft.getChildren().addAll(vb, sep2);
        VBox.setMargin(vb, new Insets(10.0d));
        GridPane gP = new GridPane();
        HBox hbBoutons = new HBox();
        VBox vbCenter = new VBox();

        Button btnSubmit = new Button("Submit");
        Button btnCancel = new Button("Cancel");
        hbBoutons.getChildren().addAll(btnSubmit, btnCancel);
        vbCenter.getChildren().addAll(gP, hbBoutons);

        Label lbName = new Label("Name :");
        Label lbEmail = new Label("Email :");
        Label lbPass = new Label("Password :");
        var nameField = new TextField();
        var emailField = new TextField();
        var passField = new TextField();
        GridPane.setConstraints(lbName, 0, 0);
        GridPane.setConstraints(nameField, 1, 0);
        GridPane.setConstraints(lbEmail, 0, 1);
        GridPane.setConstraints(emailField, 1, 1);
        GridPane.setConstraints(lbPass, 0, 2);
        GridPane.setConstraints(passField, 1, 2);
        gP.getChildren().addAll(lbName, nameField, lbEmail, emailField, lbPass, passField);
        hbBoutons.setSpacing(8);
        vb.setSpacing(10);
        GridPane.setMargin(lbName, new Insets(10.0d));
        GridPane.setMargin(lbEmail, new Insets(10.0d));
        GridPane.setMargin(lbPass, new Insets(10.0d));
        vbCenter.setAlignment(Pos.CENTER);
        gP.setAlignment(Pos.CENTER);
        hbBoutons.setAlignment(Pos.CENTER);
        vb.setAlignment(Pos.CENTER);
        lbBottom.setTextAlignment(TextAlignment.CENTER);
        vbBottom.setAlignment(Pos.CENTER);

        bdp.setLeft(hbLeft);
        bdp.setCenter(vbCenter);
        bdp.setBottom(vbBottom);
        bdp.setTop(mBar);
        Scene sc = new Scene(bdp);
        primaryStage.setScene(sc);
        primaryStage.setWidth(600);
        primaryStage.setHeight(450);
        primaryStage.setTitle("Exercice1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

