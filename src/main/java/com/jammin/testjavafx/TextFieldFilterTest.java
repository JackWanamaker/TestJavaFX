package com.jammin.testjavafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class TextFieldFilterTest extends Application {

    public void start(Stage primaryStage) {


    }

    private TextField createTextField() {
        TextField myTextField = new TextField("My Test TextField");
        myTextField.setAlignment(Pos.CENTER);
        myTextField.setOnAction((evt) -> System.out.println("Did it work? :-)"));

        TextFormatter <Integer> myTextFormatter = new TextFormatter<>(new IntegerStringConverter(), 60, this::filter);
        myTextField.setTextFormatter(myTextFormatter);

        return myTextField;
    }

    private TextFormatter.Change filter(TextFormatter.Change change){

    }
}
