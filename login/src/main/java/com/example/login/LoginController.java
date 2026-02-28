package com.example.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField txtUser, txtEmail;
    @FXML private PasswordField txtPass;
    @FXML private Label lblError;

    @FXML
    protected void onLoginButtonClick() {
        String user = txtUser.getText();
        String email = txtEmail.getText();
        String pass = txtPass.getText();

        if (user.length() < 4) {
            lblError.setText("pon al menos 4 caracteres");
        } else if (!email.contains("@") || !email.contains(".")) {
            lblError.setText("Correo inválido ");
        } else if (pass.length() < 6) {
            lblError.setText("mín 6 caracteres");
        } else {
            irADashboard(user);
        }
    }

    private void irADashboard(String usuario) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DashboardView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            DashboardController controller = fxmlLoader.getController();
            controller.setMensaje("Bienvenido, " + usuario);

            Stage stage = (Stage) lblError.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}