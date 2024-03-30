package org.example.juegodeahorcado.model;

import org.example.juegodeahorcado.model.Player;

public class SecretWord {

    private Integer resultado;

    public SecretWord(String letra, Player player){
        String palabraSecreta= player.getSecretWord();
        System.out.println(letra);

        if(palabraSecreta.contains(letra)){
            resultado=0;
            System.out.println("Positivo");
        }else {
            resultado=1;
            System.out.println("Negativo");
        }

    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }
}
