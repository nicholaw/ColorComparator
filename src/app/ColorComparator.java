package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import utils.ColorGroup;
import utils.ColorHandler;
import utils.ColorLabel;
import utils.ColorRow;

public class ColorComparator extends Application {
    private GridPane colorPane;
    private ColorRow reds;
    private ColorRow oranges;
    private ColorRow yellows;
    private ColorRow greens;
    private ColorRow blues;
    private ColorRow violets;
    private ColorRow misc;

    public void start(Stage stage){
        //Instantiate member variables
        colorPane = new GridPane();
        colorPane.addRow(0, reds = new ColorRow());
        colorPane.addRow(1, oranges = new ColorRow());
        colorPane.addRow(2, yellows = new ColorRow());
        colorPane.addRow(3, greens = new ColorRow());
        colorPane.addRow(4, blues = new ColorRow());
        colorPane.addRow(5, violets = new ColorRow());
        colorPane.addRow(6, misc = new ColorRow());

        //Read data in xml document to create scene elements
        try {
            var file = new File("resources/colors.xml");
            var fac = SAXParserFactory.newInstance();
            var parser = fac.newSAXParser();
            var handler = new ColorHandler(this);
            parser.parse(file, handler);
        } catch(Exception e) {
            e.printStackTrace();
        }

        //Add elements to scene and set stage
        var contentPane = new BorderPane();
        contentPane.setCenter(colorPane);
        var scene = new Scene(contentPane);
        stage.setScene(scene);
        stage.setTitle("Color Comparator");
        stage.show();
    }//start

    /**
     * Adds a colored label to the grid displaying labels.
     * @param colorName     name of the color to be added
     * @param colorValue    value of the color to be added
     * @param colorGroup    group to which the color belongs
     */
    public void addColorLabel(String colorName, String colorValue, ColorGroup colorGroup) {
        var label = new ColorLabel(colorName, colorValue);
        switch (colorGroup) {
            case RED:
                reds.getChildren().add(label);
                break;
            case ORANGE:
                oranges.getChildren().add(label);
                break;
            case YELLOW:
                yellows.getChildren().add(label);
                break;
            case GREEN:
                greens.getChildren().add(label);
                break;
            case BLUE:
                blues.getChildren().add(label);
                break;
            case VIOLET:
                violets.getChildren().add(label);
                break;
            default:
                misc.getChildren().add(label);
        }//switch(colorGroup)
    }//addColorLabel

    /**
     * Main method which launches this application.
     * @param args arguments for this application
     */
    public static void main(String[] args){
        launch(args);
    }
}//ColorComparator