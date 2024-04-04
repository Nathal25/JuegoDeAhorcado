package org.example.juegodeahorcado.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WinnerLoserImage {
    private ImageView imageViewWinner,imageViewLoser;
    
    public WinnerLoserImage(){
        imageViewWinner =new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/juegodeahorcado/image/winner.png"))));
        imageViewWinner.setLayoutX(17);
        imageViewWinner.setLayoutY(22);
        imageViewWinner.setFitHeight(199);
        imageViewWinner.setFitWidth(265);
        imageViewLoser =new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/juegodeahorcado/image/perdedor.png"))));
        imageViewLoser.setLayoutX(17);
        imageViewLoser.setLayoutY(22);
        imageViewLoser.setFitHeight(199);
        imageViewLoser.setFitWidth(265);
    }

    public ImageView getImageViewWinner() {
        return imageViewWinner;
    }

    public ImageView getImageViewLoser() {
        return imageViewLoser;
    }
}
