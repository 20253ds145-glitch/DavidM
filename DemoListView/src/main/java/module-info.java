module com.example.demolistview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.example.demolistview to javafx.fxml;
    opens com.example.demolistview.controllers to javafx.fxml; // <--- Esta línea es la llave

    exports com.example.demolistview;
}