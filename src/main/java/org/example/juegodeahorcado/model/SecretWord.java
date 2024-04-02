package org.example.juegodeahorcado.model;

public class SecretWord {
    private String secretWord;
    private String[] arraySecretWord;

    public SecretWord(String secretWord){
        this.secretWord=secretWord;
        this.arraySecretWord=secretWord.split("");
    }

    public String[] getArraySecretWord() {
        return arraySecretWord;
    }

    public void setArraySecretWord(String[] arraySecretWord) {
        this.arraySecretWord = arraySecretWord;
    }

    public String getSecretWord() {
        return secretWord;
    }
    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }
}
