package com.jammin.testjavafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class StackPaneTest extends Application {
    @Override
    public void start(Stage PrimaryStage) throws IOException {
        StackPane myStackPane = new StackPane();

        Image background = new Image("file:img/skibidi.jpg");
        Image foreground = new Image("file:img/kurupt.png");

        ImageView backgroundView = new ImageView(background);
        ImageView foregroundView = new ImageView(foreground);

        StackPane.setAlignment(foregroundView, Pos.TOP_RIGHT);
        myStackPane.getChildren().setAll(backgroundView, foregroundView);

        Scene myScene = new Scene(myStackPane);

        PrimaryStage.setScene(myScene);
        PrimaryStage.show();

    }
}
