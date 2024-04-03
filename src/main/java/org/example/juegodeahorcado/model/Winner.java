package org.example.juegodeahorcado.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Winner {
    private ImageView imageView;
    
    public Winner(){
        imageView=new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/juegodeahorcado/image/winner.png"))));
        imageView.setLayoutX(17);
        imageView.setLayoutY(22);
        imageView.setFitHeight(199);
        imageView.setFitWidth(265);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
