package org.example.juegodeahorcado.model;

public class Player {
    private int id;
    private String secretWord;

    public Player(int id, String secretWord){
        this.id=id;
        this.secretWord=secretWord;
    }
    public int getId(){
        return id;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }
}
