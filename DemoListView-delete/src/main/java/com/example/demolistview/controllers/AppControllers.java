package com.example.demolistview.controllers;
import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.List;

public class AppControllers {
    @FXML private Label lblMsg;
    @FXML private ListView<String> listView;
    @FXML private TextField txtName;
    @FXML private TextField txtEmail;
    @FXML private TextField txtAge;


    private ObservableList<String> data = FXCollections.observableArrayList();
    private PersonService service = new PersonService();

    @FXML
    public void initialize(){
        loadFromFile();
        listView.setItems(data);
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }
    @FXML
    public void onAdd(){
        try {
            String name = txtName.getText().trim();
            String email = txtEmail.getText().trim();
            String age = txtAge.getText().trim();

            service.addPerson(name, email, age);

            lblMsg.setText("Persona creada con éxito");
            lblMsg.setStyle("-fx-text-fill: green;");

            // LIMPIEZA TOTAL DE CAMPOS
            txtName.clear();
            txtEmail.clear();
            txtAge.clear(); // <-- Te faltaba esta línea

            loadFromFile();
        } catch (Exception e) {
            lblMsg.setText("Error: " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red;");
        }
    }

    private void loadFromFile(){
        try {
            // 1. Obtenemos los datos nuevos del servicio
            List<String> items = service.loadDataForListView();


            data.setAll(items);

            lblMsg.setText("Datos actualizados");
            lblMsg.setStyle("-fx-text-fill: blue;");
        } catch (IOException e){
            lblMsg.setText("Error al cargar datos");
            lblMsg.setStyle("-fx-text-fill: red;");
        }
    }


    @FXML
    public void onDelete() {
        String selected = listView.getSelectionModel().getSelectedItem();

        if (selected != null) {
            boolean ok = service.deletePerson(selected);
            if (ok) {
                onReload();
                lblMsg.setText("Eliminado correctamente.");
                lblMsg.setStyle("-fx-text-fill: green;");
            } else {
                lblMsg.setText("No se encontro en el archivo.");
            }
        } else {
            lblMsg.setText("Selecciona a alguien primero.");
            lblMsg.setStyle("-fx-text-fill: red;");
        }
    }

}