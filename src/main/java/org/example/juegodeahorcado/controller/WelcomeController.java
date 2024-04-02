package org.example.juegodeahorcado.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.juegodeahorcado.view.alert.AlertBox;
import org.example.juegodeahorcado.view.GameStage;
import org.example.juegodeahorcado.model.SecretWord;
import org.example.juegodeahorcado.view.WelcomeStage;

import java.io.IOException;

public class WelcomeController {
    SecretWord secretWord;

    @FXML
    private TextField textFieldSecretWord;

    @FXML
    void onHandleButtonPlay(ActionEvent event) throws IOException {
        String palabraSecreta = textFieldSecretWord.getText();
        secretWord =new SecretWord(palabraSecreta);
        GameStage.getInstance().getGameController().setSecretWord(secretWord);
        WelcomeStage.deleteInstance();
    }
    @FXML
    void onHandleButtonHowToPlay(ActionEvent event) {
        String tittle="Instrucciones del juego";
        String header ="Bienvenida";
        String content ="Bienvenida en este juego podrás jugar de la siguiente manera: Primero lanzarás los dados y obtendran dos resultados con valores del 1 al 6";
        AlertBox alertBox=new AlertBox();
        alertBox.showMessage(tittle,header,content);
    }

    public void setSecretWord(SecretWord secretWord) {
        this.secretWord = secretWord;
    }
}

