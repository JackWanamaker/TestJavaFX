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

        createArc(myStackPane);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }

    //Constructor for my Arc
    public void createArc(StackPane myStackPane){
        Arc myArc = new Arc(100,100,100,100,0,360);
        myArc.setFill(Color.GREEN);
        myArc.setType(ArcType.ROUND);
        myStackPane.getChildren().add(myArc);

        myArc.radiusXProperty().bind(myArc.getParent().getScene().heightProperty().divide(2.5));
        myArc.radiusYProperty().bind(myArc.getParent().getScene().heightProperty().divide(2.5));
    }
}
