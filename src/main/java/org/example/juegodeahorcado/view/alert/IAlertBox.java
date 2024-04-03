package org.example.juegodeahorcado.view.alert;

public interface IAlertBox {
    void showMessage(String title, String header, String content);

    void showMessageRuler(String title, String header, String content);

    void showMessageHint(String title, String header, String content);
}

