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
        String letraIngresada= textFieldLetter.getText();
        System.out.println("La letra ingresada fue: "+letraIngresada);
       textFieldLetter.setText("");
       secretWord=new SecretWord(letraIngresada,this.player);
//       String resultado= String.valueOf(secretWord.getResultado());

    }

    public void initialize(){
        /*
        box=new Box();
        hBox=box.gethBox();
        anchorPaneWord.getChildren().add(hBox);

         */
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


