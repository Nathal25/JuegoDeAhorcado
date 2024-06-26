package org.example.juegodeahorcado.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeStage extends Stage {
    private WelcomeStage welcomeStage;

    public WelcomeStage() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/org/example/juegodeahorcado/welcome-view.fxml"));
        Parent parent = loader.load();
        setTitle("Hangman");
        Scene scene=new Scene(parent);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/org/example/juegodeahorcado/image/favicon.png"))));
        setScene(scene);
        setResizable(false);
        show();
    }
    private static class WelcomeStageHolder{
        private static WelcomeStage INSTANCE;
    }
    public static WelcomeStage getInstance() throws IOException {
        return WelcomeStageHolder.INSTANCE = new WelcomeStage();
    }
    public static void deleteInstance() {
        WelcomeStageHolder.INSTANCE.close();
        WelcomeStageHolder.INSTANCE = null;
    }

}
