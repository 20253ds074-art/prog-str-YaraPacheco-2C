package com.example.practicaexamen3.controllers;

import com.example.practicaexamen3.model.Contacto;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Controller {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cmbParentesco;
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;

    private ObservableList<String> data = FXCollections.observableArrayList();

    private List<Contacto> contactos=new ArrayList<>();
    private final String[] parentescos={
            "Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela",
            "Tio", "Tia"
    };
    @FXML
    public void initialize(){
        cmbParentesco.getItems().addAll(parentescos);
        listView.setItems(data);


    }
    @FXML
    public void refreshListView(){
        data.clear();
        for (Contacto c: contactos){
            data.add(c.toString());
        }
    }
    @FXML
    public void onAgregar(){
        try {
            validarDatos();
            String nombre = txtNombre.getText().trim();
            String telefono= txtTelefono.getText().trim();
            String parentesco = cmbParentesco.getValue();

            for (Contacto c : contactos){
                if (c.getNombre().equalsIgnoreCase(nombre)){
                    throw new IllegalArgumentException("Ya existe un contacto con ese nombre");
                }
            }
            Contacto nuevo = new Contacto(nombre, telefono, parentesco);
            contactos.add(nuevo);
            refreshListView();
            limpiarCampos();
            mostrarMensaje("Contacto agregado correctamente", true);

        } catch (IllegalArgumentException e){
            mostrarMensaje(e.getMessage(), false);

        }
    }
    @FXML
    public void onBuscar() {
        String nombre = txtNombre.getText().trim();
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                txtTelefono.setText(c.getTelefono());
                cmbParentesco.setValue(c.getParentesco());
                mostrarMensaje("Contacto encontrado", true);
                return;
            }
        }
        mostrarMensaje("No se encontró el contacto", false);
    }
    @FXML
    public void onActualizar() {
        try {
            validarDatos();
            String nombre = txtNombre.getText().trim();
            for (Contacto c : contactos) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    c.setTelefono(txtTelefono.getText().trim());
                    c.setParentesco(cmbParentesco.getValue());
                    refreshListView();
                    mostrarMensaje("Contacto actualizado correctamente", true);
                    return;
                }
            }
            mostrarMensaje("No se encontró el contacto para actualizar", false);
        } catch (IllegalArgumentException e) {
            mostrarMensaje(e.getMessage(), false);
        }
    }
    @FXML
    public void onEliminar() {
        String nombre = txtNombre.getText().trim();
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(c);
                refreshListView();
                limpiarCampos();
                mostrarMensaje("Contacto eliminado correctamente", true);
                return;
            }
        }
        mostrarMensaje("No se encontró el contacto para eliminar", false);
    }
    @FXML
    public void onLimpiar() {
        limpiarCampos();
        mostrarMensaje("Campos limpiados", true);
    }
    private void validarDatos() {
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String parentesco = cmbParentesco.getValue();

        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no debe estar vacío");
        }
        if (telefono.isEmpty()) {
            throw new IllegalArgumentException("El teléfono no debe estar vacío");
        }
        if (!telefono.matches("\\d{10}")) {
            throw new IllegalArgumentException("El teléfono debe tener exactamente 10 dígitos");
        }
        if (parentesco == null) {
            throw new IllegalArgumentException("Debe seleccionar un parentesco");
        }
    }

    // Limpiar campos
    private void limpiarCampos() {
        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.getSelectionModel().clearSelection();
    }

    // Mostrar mensajes
    private void mostrarMensaje(String msg, boolean ok) {
        lblMsg.setText(msg);
        lblMsg.setStyle(ok ? "-fx-text-fill: green" : "-fx-text-fill: red");
    }
}
