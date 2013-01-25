package org.jbundle.javafx.example.helloworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloWorldJavaFXApp extends Application {
    public void start(Stage stage) {
        Scene scene = HelloWorldJavaFX.createScene();

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }
}
