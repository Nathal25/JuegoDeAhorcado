package org.example.juegodeahorcado.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.HBox;
import org.example.juegodeahorcado.model.SecretWord;
import org.example.juegodeahorcado.model.AnalizeLetter;
import org.example.juegodeahorcado.view.alert.AlertBox;

import java.util.List;

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
    @FXML
    private Button hintBtn;
    private TextField txtLetras;

    private List<String> listaControl;


    @FXML
    void onHandleTextFieldLetter(ActionEvent event) {

        String letraIngresada = textFieldLetter.getText().toLowerCase();

        textFieldLetter.setText("");
        analizeLetter = new AnalizeLetter(letraIngresada, this.secretWord);
        listaControl=secretWord.getCopiaArray();


        if(analizeLetter.getResultado()==0){
            for(int i=0;i<secretWord.getArraySecretWord().length;i++){
                String verificarSeccion = secretWord.getArraySecretWord()[i];
                // Verifica si la sección actual contiene la letra ingresada
                if (verificarSeccion.contains(letraIngresada)) {
//                    System.out.println("La sección " + i + " contiene la letra " + letraIngresada);
                    TextField textField = (TextField) hBoxLetters.getChildren().get(i);
                    textField.setText(letraIngresada);
                }
            }
            int index = 0;
            while (index < listaControl.size()) {
                String charValidador = listaControl.get(index);
                if (charValidador.contains(letraIngresada)) {
                    System.out.println("El elemento eliminado fue: " + charValidador);
                    listaControl.remove(index);
                } else {
                    index++;
                }
            }
            secretWord.setCopiaArray(listaControl);
        }
        System.out.println("La lista control es: "+listaControl);
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
        secretWord.setControlShow(true);
        hintBtn.setVisible(true);
        startGameBtn.setVisible(false);
    }

    @FXML
    void onHandleButtonHelp(ActionEvent event) {
        String tittle="Tutorial";
        String header ="Tutorial";
        String content ="Bienvenida,\nJugarás de la siguiente manera:" +
                "\nPara descubrir cuál es la palabra secreta deberás ingresar una letra del abecedario en la casilla. De esta manera, si escribes una letra que está contenida en la palabra secreta, podrás descubrirla poco a poco. Sin embargo, debes tener en cuenta que solo puedes equivocarte un máximo de 6 veces, si gastas estas oportunidades y no has descubierto la palabra secreta, perderás el juego y el hombre será ahorcado. Para ayudarte a ganar el juego te hemos dispuesto de tres pistas como máximo, una vez el juego sea iniciado da clic en el botón junto a este y obtendrás una de las letras contenida en la palabra secreta." +
                "\n Recuerda que no puedes dejar el campo de texto vacio y que no puedes agregar más de una letra a la vez.";
        AlertBox alertBox=new AlertBox();
        alertBox.showMessageRuler(tittle,header,content);
    }
    @FXML
    void onHandleButtonGiveHint(ActionEvent event) {
        Integer numPistas=0;
        Integer listaSize=listaControl.size();
        Integer pistaAleatoria= (int)(Math.random() * listaSize);
        String tittle="Pista";
        String header ="Pista";
        String content ="Hola, jugadora. \n Una de las letras de la palabra es " + listaControl.get(pistaAleatoria);
        AlertBox alertBox=new AlertBox();
        alertBox.showMessageHint(tittle,header,content);
    }

    public void setSecretWord(SecretWord secretWord) {
        this.secretWord = secretWord;
    }
}