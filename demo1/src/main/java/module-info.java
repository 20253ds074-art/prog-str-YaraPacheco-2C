module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo1 to javafx.fxml;
    opens com.example.demo1.repositories to javafx.fxml;
    opens com.example.demo1.services to javafx.fxml;
    opens com.example.demo1.controllers to javafx.fxml;

    exports com.example.demo1;
    exports com.example.demo1.controllers;
    exports com.example.demo1.services;
    exports com.example.demo1.repositories;
}