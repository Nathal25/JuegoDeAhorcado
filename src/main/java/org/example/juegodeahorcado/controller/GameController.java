package org.example.juegodeahorcado.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.HBox;
import org.example.juegodeahorcado.model.Loser;
import org.example.juegodeahorcado.model.SecretWord;
import org.example.juegodeahorcado.model.AnalizeLetter;
import org.example.juegodeahorcado.model.Winner;
import org.example.juegodeahorcado.view.alert.AlertBox;

import java.util.List;

public class GameController {
    @FXML
    private AnchorPane anchorPaneHangMan;

    @FXML
    private Button startGameBtn;

    @FXML
    private HBox hBoxLetters;

    @FXML
    private AnchorPane anchorPaneWord;

    @FXML
    private Label hintsUsed;

    @FXML
    private Label textBase1;

    @FXML
    private Label labelTries;

    @FXML
    private TextField textFieldLetter;

    @FXML
    private Button hintBtn;

    @FXML
    private ImageView imgViewAhorcado;

    private AnalizeLetter analizeLetter;
    private SecretWord secretWord;
    private TextField txtLetras;
    private List<String> listaControl;
    private Winner winner;
    private Loser perdedor;

    @FXML
    void onHandleTextFieldLetter(ActionEvent event) {

        String letraIngresada = textFieldLetter.getText().toLowerCase();
        textFieldLetter.setText("");

        // Verifica si la letra ingresada no está en la palabra secreta
        if (!secretWord.getWord().contains(letraIngresada)) {
            Integer cantErrores=secretWord.getErrorCount();
            perdedor=new Loser(cantErrores);
            // Incrementa el contador de errores
            secretWord.incrementErrorCount();
            perdedor.setCantErrores(cantErrores);
            labelTries.setText(String.valueOf(secretWord.getErrorCount()));
            imgViewAhorcado.setImage(perdedor.getImagenAhorcado());

            if (secretWord.getErrorCount() >= 6) {
                // Mostrar mensaje de límite de errores
                hBoxLetters.setVisible(false);
                textFieldLetter.setVisible(false);
                textBase1.setText("lo lamento, has perdido el juego");
                textBase1.setLayoutX(64);
                textBase1.setLayoutY(216);
                System.out.println("Has alcanzado el límite de errores. ¡Perdiste!");
                return; // Salir del método si se alcanza el límite de errores
            }
            System.out.println("El carácter ingresado no está en la palabra secreta. Error: " + secretWord.getErrorCount());

        }
        //analizeLetter sirve para analizar la letra que fue ingresada y, además, verificar si esta pertenece o no a la palabra secreta
        analizeLetter = new AnalizeLetter(letraIngresada, this.secretWord);

        //Esta seccion hace dos cosas: Inicialmente se encarga de verificar el resultado de la letra ingresada, o sea, si pertenece o no a la palabra
        //secreta. De hacerlo, entonces pondrá en un hBox las letras correspondientes.
        //Adicionalmente se creó una lista que contiene los caracteres de la palabra secreta, esta lista permite saber que letras de la palabra no han
        //sido ingresadas, con ello, la pista que se le da al jugador solo mostrara letras que este no haya ingresado.
        //la lista control se divide en dos partes. Una lista que se obtiene como copia directa de un array creado para la palabra secreta
        //y otra lista como copia de la copia. de esta manera ambas listas hacen un ciclo de actualizacion mutua
        if(analizeLetter.getResultado()==0){
            for(int i=0;i<secretWord.getArraySecretWord().length;i++){
                String verificarSeccion = secretWord.getArraySecretWord()[i];
                // Verifica si la sección actual contiene la letra ingresada
                if (verificarSeccion.contains(letraIngresada)) {
//                    System.out.println("La sección " + i + " contiene la letra " + letraIngresada);
                    TextField textField = (TextField) hBoxLetters.getChildren().get(i);
                    textField.setText(letraIngresada);
                }
            }
            int index = 0;
            while (index < listaControl.size()) {
                String charValidador = listaControl.get(index);
                if (charValidador.contains(letraIngresada)) {
                    System.out.println("El elemento eliminado fue: " + charValidador);
                    listaControl.remove(index);
                } else {
                    index++;
                }
            }
            secretWord.setCopiaArray(listaControl);
        }

        //Esta seccion se apoya de listaControl para verificar que el usuario ya haya ingresado todas las letras de la
        //palabra secreta, si es así aparece una imagen de un trofeo y desaparecen elementos de la interfaz
        if (listaControl.isEmpty()){
            winner=new Winner();
            hBoxLetters.setVisible(false);
            textFieldLetter.setVisible(false);
            textBase1.setVisible(false);
            hintBtn.setVisible(false);
            Label ganador=new Label("Felicidades! Has ganado el juego");
            ganador.setAlignment(Pos.CENTER);
            ganador.setPrefWidth(anchorPaneWord.getWidth());
            ImageView imagenGanador=winner.getImageView();
            anchorPaneWord.getChildren().addAll(ganador,imagenGanador);
        }
        System.out.println("La lista control es: "+listaControl);
    }


    @FXML
    void onHandleButtonStartGame(ActionEvent event) {

        for (int i = 0; i < secretWord.getSecretWord().length(); i++) {
            txtLetras = new TextField();
            txtLetras.setEditable(false);
            hBoxLetters.getChildren().add(txtLetras);
        }
        // Hace textFieldLetter visible cuando startGameBtn se presiona
        textFieldLetter.setVisible(true);
        textBase1.setVisible(true);
        secretWord.setControlShow(true);
        hintBtn.setVisible(true);
        startGameBtn.setVisible(false);
        listaControl=secretWord.getCopiaArray();
        imgViewAhorcado=new ImageView();
        imgViewAhorcado.setImage(new Image(String.valueOf(getClass().getResource("/org/example/juegodeahorcado/image/ahorcado0.png"))));
        anchorPaneHangMan.getChildren().add(imgViewAhorcado);
    }
    private Integer cantidadPistas=0;
    @FXML
    void onHandleButtonHelp(ActionEvent event) {

        String tittle="Tutorial";
        String header ="Tutorial";
        String content ="Bienvenida,\nJugarás de la siguiente manera:" +
                "\nPara descubrir cuál es la palabra secreta deberás ingresar una letra del abecedario en la casilla. De esta manera, si escribes una letra que está contenida en la palabra secreta, podrás descubrirla poco a poco. Sin embargo, debes tener en cuenta que solo puedes equivocarte un máximo de 6 veces, si gastas estas oportunidades y no has descubierto la palabra secreta, perderás el juego y el hombre será ahorcado. Para ayudarte a ganar el juego te hemos dispuesto de tres pistas como máximo, una vez el juego sea iniciado da clic en el botón junto a este y obtendrás una de las letras contenida en la palabra secreta." +
                "\n Recuerda que no puedes dejar el campo de texto vacio y que no puedes agregar más de una letra a la vez.";
        AlertBox alertBox=new AlertBox();
        alertBox.showMessageRuler(tittle,header,content);


    }
    @FXML
    void onHandleButtonGiveHint(ActionEvent event) {
        if(cantidadPistas<3){
            Integer listaSize=listaControl.size();
            Integer pistaAleatoria= (int)(Math.random() * listaSize);
            String tittle="Pista";
            String header ="Pista";
            String content ="Hola, jugadora. \nUna de las letras de la palabra es " + listaControl.get(pistaAleatoria)+".";
            AlertBox alertBox=new AlertBox();
            alertBox.showMessageHint(tittle,header,content);

            cantidadPistas++;
            System.out.println("La cantidad de pistas dadas son: "+cantidadPistas);
            hintsUsed.setText(String.valueOf(cantidadPistas));
        }
        else {
            String tittle="Pista";
            String header ="Pista";
            String content ="Hola, jugadora. \nYa no puedes acceder a más pistas";
            AlertBox alertBox=new AlertBox();
            alertBox.showMessageHint(tittle,header,content);
        }

    }

    public void setSecretWord(SecretWord secretWord) {
        this.secretWord = secretWord;
    }
}