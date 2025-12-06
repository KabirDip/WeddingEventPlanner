package com.midterm_2320481_8.weeding_event_management.samanta.client;

import javafx.application.Application;
import javafx.stage.Stage;

public class WeddingThemeandDesign extends Application {
    private String preferredtheme;
    private String CustomNotes;
    private String colorpref;


    public WeddingThemeandDesign(String preferredtheme, String customNotes, String colorpref) {
        this.preferredtheme = preferredtheme;
        CustomNotes = customNotes;
        this.colorpref = colorpref;
    }

    public String getPreferredtheme() {
        return preferredtheme;
    }

    public String getCustomNotes() {
        return CustomNotes;
    }

    public String getColorpref() {
        return colorpref;
    }

    public void setPreferredtheme(String preferredtheme) {
        this.preferredtheme = preferredtheme;
    }

    public void setCustomNotes(String customNotes) {
        CustomNotes = customNotes;
    }

    public void setColorpref(String colorpref) {
        this.colorpref = colorpref;
    }

    @Override
    public String toString() {
        return "WeddingThemeandDesign{" +
                "preferredtheme='" + preferredtheme + '\'' +
                ", CustomNotes='" + CustomNotes + '\'' +
                ", colorpref='" + colorpref + '\'' +
                '}';
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
