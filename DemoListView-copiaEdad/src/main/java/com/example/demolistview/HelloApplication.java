package com.example.demolistview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/app-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 500, 600);
        stage.setTitle("ListViewDemo");
        stage.setScene(scene);
        stage.show();
    }
}