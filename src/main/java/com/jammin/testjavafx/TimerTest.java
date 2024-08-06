package com.jammin.testjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class TimerTest extends Application {

    @Override
    public void start(Stage PrimaryStage) {
        ImageView myImage = new ImageView(new Image("file:img/kurupt.png"));
        TextField myTextField = createTextField();
        TextFormatter<?> myTextFormatter = myTextField.getTextFormatter();

        Arc myArc = createArc();

        myTextField.setOnAction((evt) -> myTextField.getTextFormatter().getValue() != null
                ? myArc.setLength(myTextField.getTextFormatter().getValue()): 0;

        StackPane myStackPane = new StackPane(myImage,createArc());

        VBox myVBox = new VBox(myStackPane, createTextField());

        Scene myScene = new Scene(myVBox);

        PrimaryStage.setScene(myScene);
        PrimaryStage.show();
    }

    public Arc createArc(){
        Arc myArc = new Arc(100,100,100,100,0,360);
        myArc.setFill(Color.GREEN);
        myArc.setType(ArcType.ROUND);
        return myArc;
    }

    public TextField createTextField(){
        TextField myTextField = new TextField("Enter Time 1-60");

        myTextField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 60, this::filter));

        return myTextField;
    }

    public TextFormatter.Change filter(TextFormatter.Change myChange){
        if (myChange.getControlNewText().isEmpty()){
            return null;
        }
        Integer myVal = Integer.parseInt(myChange.getControlNewText());

        return myVal >=0 && myVal <= 60 ? myChange : null;
    }
}
