package org.example.juegodeahorcado.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Loser {
    private ImageView imageViewAhorcado;
    private Image imagenAhorcado;
    private Integer cantErrores;
    private SecretWord secretWord;
    public Loser(Integer cantErrores){
        this.cantErrores=cantErrores;
        imageViewAhorcado = new ImageView();
        //String valorErrores = String.valueOf(cantErrores);
        List<String> urlPartesAhorcado = new ArrayList<>();
        urlPartesAhorcado.add("/org/example/juegodeahorcado/image/ahorcado1.png");
        urlPartesAhorcado.add("/org/example/juegodeahorcado/image/ahorcado2.png");
        urlPartesAhorcado.add("/org/example/juegodeahorcado/image/ahorcado3.png");
        urlPartesAhorcado.add("/org/example/juegodeahorcado/image/ahorcado4.png");
        urlPartesAhorcado.add("/org/example/juegodeahorcado/image/ahorcado5.png");
        urlPartesAhorcado.add("/org/example/juegodeahorcado/image/ahorcado6.png");


        //String imageUrl = urlPartesAhorcado.get(0); // Obtenemos la URL de la imagen
        imagenAhorcado = new Image(getClass().getResource(urlPartesAhorcado.get(cantErrores)).toString());
        imageViewAhorcado.setImage(imagenAhorcado);
    }

    public ImageView getImageViewAhorcado() {
        return imageViewAhorcado;
    }

    public void setImageViewAhorcado(ImageView imageViewAhorcado) {
        this.imageViewAhorcado = imageViewAhorcado;
    }

    public Image getImagenAhorcado() {
        return imagenAhorcado;
    }

    public void setImagenAhorcado(Image imagenAhorcado) {
        this.imagenAhorcado = imagenAhorcado;
    }

    public void setCantErrores(Integer cantErrores) {
        this.cantErrores = cantErrores;
    }

    public Integer getCantErrores() {
        return cantErrores;
    }
}
