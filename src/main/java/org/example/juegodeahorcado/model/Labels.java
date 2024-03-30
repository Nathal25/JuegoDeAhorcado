package org.example.juegodeahorcado.model;


import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Labels {
    private Label label;
    public Labels(){
        label=new Label("");
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

}
