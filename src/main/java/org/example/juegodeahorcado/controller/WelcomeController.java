package org.example.juegodeahorcado.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.juegodeahorcado.view.alert.AlertBox;
import org.example.juegodeahorcado.view.GameStage;
import org.example.juegodeahorcado.model.Player;
import org.example.juegodeahorcado.view.WelcomeStage;

import java.io.IOException;

public class WelcomeController {
    private Player player;
    @FXML
    private TextField textFieldSecretWord;

    @FXML
    void onHandleButtonPlay(ActionEvent event) throws IOException {
        String secretWord = textFieldSecretWord.getText();
        Player player=new Player(1,secretWord);
        GameStage.getInstance().getGameController().setPlayer(player);
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

    public void setPlayer(Player player) {
        this.player = player;
    }
}

