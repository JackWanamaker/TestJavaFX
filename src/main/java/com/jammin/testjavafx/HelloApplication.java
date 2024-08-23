package com.jammin.testjavafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.*;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        StackPane myStackPane = new StackPane();

        Scene myScene = new Scene(myStackPane,400,400);

        ImageView myImageView = new ImageView(new Image("file:src/main/resources/img/timer_ticks.png"));
        myImageView.fitHeightProperty().bind(myScene.heightProperty());
        myImageView.fitWidthProperty().bind(myScene.widthProperty());
        myImageView.setPreserveRatio(true);

        myStackPane.getChildren().addAll(myImageView);

        Arc arc = createArc(myStackPane, myScene);

        stage.setScene(myScene);

        /*myScene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                SVGString.changeSVGHeight(t1.intValue());
                myWebView.getEngine().loadContent(SVGString.getString());
            }
        });

        myScene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                SVGString.changeSVGWidth(t1.intValue());
                myWebView.getEngine().loadContent(SVGString.getString());
            }
        });*/

        stage.setAlwaysOnTop(true);

        stage.show();

    }

    //Constructor for my Arc
    public Arc createArc(StackPane myStackPane, Scene myScene){
        Arc myArc = new Arc(100,100,100,100,0,360);
        myArc.setFill(Color.GREEN);
        myArc.setType(ArcType.ROUND);
        myStackPane.getChildren().add(myArc);

        myScene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (t1.doubleValue() <= myScene.getHeight()){
                    myArc.setRadiusX(t1.doubleValue()/2.9);
                    myArc.setRadiusY(t1.doubleValue()/2.9);
                }
            }
        });

        myScene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (t1.doubleValue() <= myScene.getWidth()){
                    myArc.setRadiusX(t1.doubleValue()/2.9);
                    myArc.setRadiusY(t1.doubleValue()/2.9);
                }
            }
        });

        return myArc;
    }
}