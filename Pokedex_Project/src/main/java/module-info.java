module org.example {
    requires javafx.controls;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires javafx.fxml;
    requires commons.io;

    opens org.example to javafx.fxml;
    exports org.example;
}