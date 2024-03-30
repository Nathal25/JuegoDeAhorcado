package org.example.juegodeahorcado.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import org.example.juegodeahorcado.model.Labels;
import org.example.juegodeahorcado.model.Player;
import org.example.juegodeahorcado.model.SecretWord;
import org.example.juegodeahorcado.view.alert.AlertBox;

public class GameController {
    @FXML
    private AnchorPane anchorPaneHangMan;

    @FXML
    private AnchorPane anchorPaneWord;

    @FXML
    private Label hintsUsed;

    @FXML
    private Label labelTries;

    private SecretWord secretWord;

    private Player player;
    private Labels labels;
    private Label label;

    public void initialize(){
        labels=new Labels();
        label=labels.getLabel();
        label.prefWidth(20);
        label.maxWidth(20);
        label.maxHeight(20);
        label.prefHeight(20);
        label.setLineSpacing(2);
        label.setStyle("-fx-border-color: black;");
        anchorPaneWord.getChildren().add(label);
    }


    @FXML
    void onHandleButtonClic(ActionEvent event) {

        Button botonPresionado = (Button) event.getTarget();
        String textoBoton = botonPresionado.getText();
        secretWord= new SecretWord(textoBoton.toLowerCase(), player);
        Integer result= secretWord.getResultado();
    }
    @FXML
    void onHandleButtonHelp(ActionEvent event) {
        String tittle="Tutorial";
        String header ="Tutorial";
        String content ="El juego de ahorcado consiste de lo siguiente: " +
                "Haz de adivinar una palabra secreta, para ello podrás ver los guiones " +
                "correspondientes a la cantidad de letras que tiene la palabra. E";
        AlertBox alertBox=new AlertBox();
        alertBox.showMessage(tittle,header,content);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}


