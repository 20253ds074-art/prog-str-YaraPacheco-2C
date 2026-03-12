package com.example.demolistviewfile.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.util.List;

public class AppController {
    @FXML
    private label lblMsg;
    @FXML
    private listView<String> listView;
    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonService service = new PersonService();
    @FXML
    public void initialize(){
        listView.setItems(data);
        loadFromFile();
    }
    private void loadFromFile(){
        try{
            List<String> items = service.loadFordListView();
            lblMsg.setText("Datos cargados correctamente");
            lblMsg.setStyle("-fx-text-fill:green");

        } catch (IDException e){
            lblMsg.setText("Error:"+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}
