package com.jammin.testjavafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
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
        WebView myWebView = new WebView();
        myWebView.getEngine().loadContent(SVGString.getString());

        StackPane myStackPane = new StackPane(myWebView);

        Scene myScene = new Scene(myStackPane);

        stage.setScene(myScene);

        myScene.heightProperty().addListener(new ChangeListener<Number>() {
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
        });

        stage.setAlwaysOnTop(true);

        stage.show();

    }
}