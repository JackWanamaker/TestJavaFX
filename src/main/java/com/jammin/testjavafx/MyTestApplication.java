package com.jammin.testjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class MyTestApplication extends Application {
    public void start(Stage PrimaryStage){


        StackPane myStackPane = new StackPane();

        Scene scene = new Scene(myStackPane,200,200);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
}
