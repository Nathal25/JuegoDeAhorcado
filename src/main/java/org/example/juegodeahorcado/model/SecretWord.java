package org.example.juegodeahorcado.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecretWord {
    private boolean controlShow;
    private String secretWord;
    private String[] arraySecretWord;
    private List<String> copiaArray;

    public SecretWord(String secretWord){
        this.secretWord=secretWord;
        this.arraySecretWord=secretWord.split("");
        //controlShow ayuda a verificar que si se presione INICIAR JUEGO antes de comenzar el juego
        this.controlShow=false;

        copiaArray = new ArrayList<>();

        for (int i = 0; i < secretWord.length(); i++) {
            // Agrega cada caracter de la palabra como un elemento de la lista
            copiaArray.add(Character.toString(secretWord.charAt(i)));
        }
        // Imprime la lista resultante
        System.out.println("Lista de caracteres:");
        for (String caracter : copiaArray) {
            System.out.println(caracter);
        }
    }

    public String[] getArraySecretWord() {
        return arraySecretWord;
    }

    public void setArraySecretWord() {
        this.arraySecretWord = arraySecretWord;
    }

    public String getSecretWord() {
        return secretWord;
    }
    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public boolean getControlShow() {
        return controlShow;
    }

    public void setControlShow(boolean controlShow) {
        this.controlShow = controlShow;
    }

    public List<String> getCopiaArray() {
        return copiaArray;
    }

    public void setCopiaArray(List<String> copiaArray) {
        this.copiaArray = copiaArray;
    }
}
