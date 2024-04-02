package org.example.juegodeahorcado.model;

public class AnalizeLetter {
    private Integer resultado;
    private Integer intentosFallidos;

    public AnalizeLetter(String letra, SecretWord secretWord){
        String palabraSecreta= secretWord.getSecretWord();
        System.out.println(letra);

        // Verificar si la letra está en la palabra secreta
        if (palabraSecreta.contains(letra)) {
            resultado = 0;
            System.out.println("Positivo");
        } else {
            // Si la letra no está en la palabra secreta, disminuir intentosFallidos
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
