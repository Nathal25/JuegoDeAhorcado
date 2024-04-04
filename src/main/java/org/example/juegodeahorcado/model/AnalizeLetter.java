package org.example.juegodeahorcado.model;

import javafx.scene.control.TextField;

import static org.example.juegodeahorcado.controller.WelcomeController.validateWord;

public class AnalizeLetter {
    private Integer resultado;
    private Integer intentosFallidos;


    public AnalizeLetter(String letra, SecretWord secretWord){
        String palabraSecreta= secretWord.getSecretWord();
        System.out.println(letra);

        if (palabraSecreta.contains(letra)){
            resultado = 0;
        } else {
            resultado = 1;
        }
    }

    public Integer getResultado() {
        return resultado;
    }
    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public Integer getIntentosFallidos() {
        return intentosFallidos;
    }
}
