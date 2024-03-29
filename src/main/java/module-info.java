module com.example.juegodeahorcado {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.juegodeahorcado to javafx.fxml;
    exports org.example.juegodeahorcado;
    exports org.example.juegodeahorcado.controller;
    opens org.example.juegodeahorcado.controller to javafx.fxml;
    exports org.example.juegodeahorcado.model;
    opens org.example.juegodeahorcado.model to javafx.fxml;
    exports org.example.juegodeahorcado.view;
    opens org.example.juegodeahorcado.view to javafx.fxml;
    exports org.example.juegodeahorcado.view.alert;
    opens org.example.juegodeahorcado.view.alert to javafx.fxml;
}