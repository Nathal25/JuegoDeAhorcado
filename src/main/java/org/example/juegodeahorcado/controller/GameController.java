package org.example.juegodeahorcado.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.HBox;
import org.example.juegodeahorcado.model.SecretWord;
import org.example.juegodeahorcado.model.AnalizeLetter;
import org.example.juegodeahorcado.view.alert.AlertBox;

public class GameController {
    @FXML
    private AnchorPane anchorPaneHangMan;
    @FXML
    private Button startGameBtn;
    @FXML
    private HBox hBoxLetters;

    @FXML
    private AnchorPane anchorPaneWord;

    @FXML
    private Label hintsUsed;
    @FXML
    private Label textBase1;

    @FXML
    private Label labelTries;

    private AnalizeLetter analizeLetter;

    private SecretWord secretWord;

    @FXML
    private TextField textFieldLetter;
    private TextField txtLetras;


    @FXML
    void onHandleTextFieldLetter(ActionEvent event) {

        String letraIngresada = textFieldLetter.getText();
        textFieldLetter.setText("");
        analizeLetter = new AnalizeLetter(letraIngresada, this.secretWord);
        Integer resultado = (analizeLetter.getResultado());

        if (resultado==0){
            for(int i=0;i<secretWord.getArraySecretWord().length;i++){
                String verificarSeccion = secretWord.getArraySecretWord()[i];
                // Verifica si la sección actual contiene la letra ingresada
                if (verificarSeccion.contains(letraIngresada)) {
                    System.out.println("La sección " + i + " contiene la letra " + letraIngresada);
                    TextField textField = (TextField) hBoxLetters.getChildren().get(i);
                    textField.setText(letraIngresada);
                }
            }
        }
    }

    @FXML
    void onHandleButtonStartGame(ActionEvent event) {
        for (int i = 0; i < secretWord.getSecretWord().length(); i++) {
            txtLetras = new TextField();
            txtLetras.setEditable(false);
            hBoxLetters.getChildren().add(txtLetras);
        }
        textFieldLetter.setVisible(true); // Hacer textFieldLetter visible cuando startGameBtn se presiona
        textBase1.setVisible(true);
        textBase1.setAlignment(Pos.CENTER);
        secretWord.setControlShow(true);
        startGameBtn.setVisible(false);
    }

    @FXML
    void onHandleButtonHelp(ActionEvent event) {
        String tittle="Tutorial";
        String header ="Tutorial";
        String content ="Aguapanela con limon";
        AlertBox alertBox=new AlertBox();
        alertBox.showMessage(tittle,header,content);
    }

    public void setSecretWord(SecretWord secretWord) {
        this.secretWord = secretWord;
    }
}