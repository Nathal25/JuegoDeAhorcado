package org.example.juegodeahorcado.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.example.juegodeahorcado.model.Player;
import org.example.juegodeahorcado.view.alert.AlertBox;

public class GameController {
    @FXML
    private AnchorPane anchorPaneHangMan;

    @FXML
    private AnchorPane anchorPaneWord;
    @FXML
    private Button btnA;

    @FXML
    private Button btnB;

    @FXML
    private Button btnC;

    @FXML
    private Button btnD;

    @FXML
    private Button btnE;

    @FXML
    private Button btnF;

    @FXML
    private Button btnG;

    @FXML
    private Button btnH;

    @FXML
    private Button btnI;

    @FXML
    private Button btnJ;

    @FXML
    private Button btnK;

    @FXML
    private Button btnL;

    @FXML
    private Button btnM;

    @FXML
    private Button btnN;

    @FXML
    private Button btnNI;

    @FXML
    private Button btnO;

    @FXML
    private Button btnP;

    @FXML
    private Button btnQ;

    @FXML
    private Button btnR;

    @FXML
    private Button btnS;

    @FXML
    private Button btnT;

    @FXML
    private Button btnU;

    @FXML
    private Button btnV;

    @FXML
    private Button btnW;

    @FXML
    private Button btnX;

    @FXML
    private Button btnY;

    @FXML
    private Button btnZ;
    private Player player;
    @FXML
    void onHandleButtonHelp(ActionEvent event) {
        String tittle="Tutorial";
        String header ="Tutorial";
        String content ="El juego de ahorcado consiste de lo siguiente: " +
                "Haz de adivinar una palabra secreta, para ello podrás ver los guiones " +
                "correspondientes a la cantidad de letras que tiene la palabra. E";
        AlertBox alertBox=new AlertBox();
        alertBox.showMessage(tittle,header,content);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}


