module com.example.practicaexamen3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.practicaexamen3.controllers to javafx.fxml;
    opens com.example.practicaexamen3.model to javafx.fxml;

    exports com.example.practicaexamen3;
    exports com.example.practicaexamen3.controllers;
    exports com.example.practicaexamen3.model;
}
