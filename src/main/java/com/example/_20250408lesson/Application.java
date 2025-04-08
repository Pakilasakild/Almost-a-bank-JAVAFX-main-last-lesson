package com.example._20250408lesson;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(Application.class.getResource("main.fxml"));
        BorderPane root = loader.load();
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Account management");
        stage.show();
    }

    public static void setContent(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(Application.class.getResource(fxmlPath));
        Parent content = loader.load();
        BorderPane root = (BorderPane) primaryStage.getScene().getRoot();
        root.setCenter(content);
        root.setBottom(null);
    }

    public static void main(String[] args) {
        launch();
    }
}