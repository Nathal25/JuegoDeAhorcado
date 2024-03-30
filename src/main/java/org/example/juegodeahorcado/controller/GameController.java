package org.example.juegodeahorcado.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.HBox;
import org.example.juegodeahorcado.model.Box;
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

    @FXML
    private TextField textFieldLetter;

    private HBox hBox;
    private Box box;

    @FXML
    void onHandleTextFieldLetter(ActionEvent event) {
        Label label;
        String letraIngresada= textFieldLetter.getText();


        textFieldLetter.setText("");
        secretWord=new SecretWord(letraIngresada,this.player);
        String resultado= String.valueOf(secretWord.getResultado());
        System.out.println(resultado);
        secretWord.getIntentosFallidos();
        labelTries.setText(String.valueOf(secretWord.getIntentosFallidos()));
    }

    public void initialize(){
        hBox=new HBox();
        Label label1=new Label("Hola ");
        Label label2=new Label("mundo");
        hBox.getChildren().addAll(label1, label2);
        anchorPaneWord.getChildren().add(hBox);

    }


    @FXML
    void onHandleButtonHelp(ActionEvent event) {
        String tittle="Tutorial";
        String header ="Tutorial";
        String content ="Aguapanela con limon";
        AlertBox alertBox=new AlertBox();
        alertBox.showMessage(tittle,header,content);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}


