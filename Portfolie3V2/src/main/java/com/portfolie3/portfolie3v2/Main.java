package com.portfolie3.portfolie3v2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.IOException;

public class Main extends Application {

    private Model model=new Model();
    private Controller con=new Controller(model,this);
    private TextField field=new TextField();
    private TextArea area=new TextArea();

    public ComboBox combo_box = new ComboBox();


    void setArea(String s){area.setText(s);}
    void clearField(){field.setText("");}

    @Override
    public void start(Stage stage) throws IOException {

        con.initArea();
        //field.setOnAction(e->con.enterText(field.getText()));

        //field.setOnAction(e->con.enterText(field.getText()));

        ComboBox comboBoxFrom= new ComboBox(FXCollections
                .observableArrayList(model.fromport()));
        ComboBox comboBoxTo = new ComboBox(FXCollections
                .observableArrayList(model.toport()));

        TextArea text = new TextArea();
        Button search = new Button("Search");

        // Create horizontal view in FX
        TilePane tile_pane = new TilePane();
        tile_pane.getChildren().addAll(comboBoxFrom, comboBoxTo, text, search);

        Scene scene = new Scene(tile_pane, 500, 700);
        stage.setTitle("JavaFX Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}