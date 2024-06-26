package org.example.juegodeahorcado.view.alert;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class AlertBox implements IAlertBox{
    @Override
    public void showMessage(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    @Override
    public void showMessageHint(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.setGraphic(new ImageView(String.valueOf(getClass().getResource("/org/example/juegodeahorcado/image/hintImage.png"))));
        alert.showAndWait();
    }
    @Override
    public void showMessageRuler(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.setGraphic(new ImageView(String.valueOf(getClass().getResource("/org/example/juegodeahorcado/image/LogoRuler.png"))));
        alert.showAndWait();

    }

}
