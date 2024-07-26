module com.jammin.testjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jammin.testjavafx to javafx.fxml;
    exports com.jammin.testjavafx;
}