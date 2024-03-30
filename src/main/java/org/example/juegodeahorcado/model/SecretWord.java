package org.example.juegodeahorcado.model;

import org.example.juegodeahorcado.model.Player;

public class SecretWord {

    private Integer resultado;

    private Integer intentosFallidos;

    public SecretWord(String letra, Player player){
        String palabraSecreta= player.getSecretWord();
        System.out.println(letra);

        intentosFallidos = 6;

        // Verificar si la letra está en la palabra secreta
        if (palabraSecreta.contains(letra)) {
            resultado = 0;
            System.out.println("Positivo");
        } else {
            // Si la letra no está en la palabra secreta, disminuir intentosFallidos
            intentosFallidos--;
            resultado = 1;
            System.out.println("Negativo");
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
