package org.example.juegodeahorcado.view.alert;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class AlertBoxHint implements IAlertBoxHint{
    @Override
    public void showMessage(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
