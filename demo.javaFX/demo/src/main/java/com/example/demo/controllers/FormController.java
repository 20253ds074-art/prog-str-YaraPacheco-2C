package com.example.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class FormController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;
    @FXML
    private Label lblResultado;

    public void onValidate(ActionEvent event){
        String nombre= txtNombre.getText()== null ? "" : txtNombre.getText();
        String email =txtEmail.getText()== null ? "" : txtEmail.getText();
        String edad =txtEdad.getText()== null ? "" : txtEdad.getText();

        List<String> errores = new ArrayList<>();
        if (nombre.isBlank() || nombre.length()<3){
            errores.add("El nombre ingresado es invalido");
        }
        // validacion del null
        if (email.isBlank() || !email.contains("@") || !email.contains(".")){
            errores.add("El email es invalido");

        }
        int edadValida=0;
        try {
            edadValida =Integer.parseInt(edad);
            if (edadValida<=0 || edadValida>120){
                errores.add("Edad fuera de rango");

            }
        } catch (Exception e){
            errores.add("Dato no numerico");

        }
        if (errores.isEmpty()){
            lblResultado.setText("El formulario es correcto");
            lblResultado.setStyle("-fx-text-fill: green");

        } else {
            lblResultado.setText("Error de:"+ String.join(",", errores) );
            lblResultado.setStyle("-fx-text-fill: red");
        }

    }

}
