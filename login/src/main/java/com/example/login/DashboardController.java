package com.example.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML private Label lblMensaje;

    public void setMensaje(String texto) {
        lblMensaje.setText(texto);
    }
}