package utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ColorLabel extends Label {
    private boolean displayName;
    private String name;

    public ColorLabel(String name, String value) {
        this.name = name;
        displayName = true;
        setText(this.name);
        setBackground(value);
        setPrefSize(100, 100);
        setAlignment(Pos.CENTER);
    }//constructor

    public void setName() {
        this.name = name;
        if(displayName)
            setText(this.name);
    }//setText

    public void setBackground(String value) {
        setBackground(new Background(new BackgroundFill(Color.web("0x" + value), CornerRadii.EMPTY, Insets.EMPTY)));
    }//setValue

    public void toggleDisplayName()  {
        displayName = !displayName;
        if(displayName)
            setText(name);
        else
            setText("");
    }//toggleDisplayName
}