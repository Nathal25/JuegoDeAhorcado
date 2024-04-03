package org.example.juegodeahorcado.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.juegodeahorcado.model.SecretWord;
import org.example.juegodeahorcado.view.GameStage;
import org.example.juegodeahorcado.view.WelcomeStage;
import org.example.juegodeahorcado.view.alert.AlertBox;
import org.example.juegodeahorcado.view.alert.AlertBoxRuler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WelcomeController {
    private SecretWord secretWord;
    @FXML
    private TextField textFieldSecretWord;

    @FXML
    private Label textLabelChek;

    // Function which validates only letters
    public static boolean validateWord(String word){
        String charactersLowerCase = word.toLowerCase();
        return charactersLowerCase.matches("[a-zñ]*");
    }

    //Conditional
    @FXML
    void onHandleButtonPlay(ActionEvent event) throws IOException{
        String palabraSecreta = textFieldSecretWord.getText().toLowerCase();
        //secretWorldLowerCase = secretWord.toLowerCase();

        if(palabraSecreta.length() < 6 || palabraSecreta.length() > 10 ) {
            textLabelChek.setText("Palabra no admitida");
        } else if ((!validateWord(palabraSecreta))) {
            textLabelChek.setText("Palabra no admitida");

        } else {

            secretWord = secretWord;
            secretWord =new SecretWord(palabraSecreta);
            GameStage.getInstance().getGameController().setSecretWord(secretWord);
            WelcomeStage.deleteInstance();
            System.out.println("Palabra en minúsculas: " + palabraSecreta);

        }

    }

    @FXML
    void onHandleButtonHowToPlay(ActionEvent event) {
        String tittle="Instrucciones del juego";
        String header ="Bienvenida";
        String content ="Bienvenida en este juego podrás jugar de la siguiente manera: Primero lanzarás los dados y obtendran dos resultados con valores del 1 al 6";
        AlertBox alertBox=new AlertBox();
        alertBox.showMessage(tittle,header,content);
    }

    @FXML
    void onHandleButtonRuler(ActionEvent event){
        String tittle="Reglas del juego";
        String header ="Reglas";
        String content = "Bienvenida,\nLa regla de este juego son las siguientes:\n - deberas ingresar una palabra sin numeros y sin simbolos \n - Debes ingresar la palabra con caracteres mayor a 5 y menor a 10 \n - No se puede dejar la entrada donde se escribe vacia";
        AlertBoxRuler alertBox=new AlertBoxRuler();
        alertBox.showMessage(tittle,header,content);

    }


    public void setSecretWord(SecretWord secretWord) {
        this.secretWord = secretWord;
    }
}
