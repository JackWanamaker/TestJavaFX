package com.jammin.testjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MyTestApplication extends Application {
    public void start(Stage PrimaryStage){
        WebView myWebView = new WebView();
        String svgPath = getClass().getResource("/img/svg_logo.svg").toExternalForm();
        String svgContent = "<html><body><img src = '" + svgPath + "'></body></html>";
        myWebView.getEngine().loadContent(svgContent);

        StackPane myStackPane = new StackPane(myWebView);

        Scene scene = new Scene(myStackPane,500,500);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
}
