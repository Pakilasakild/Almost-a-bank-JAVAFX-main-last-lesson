package com.example._20250408lesson.alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;

public class AlertUtilities {

    /**
     * Display error alert
     *
     * @param content message
     */

    public static void displayError(String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        styleDialog(alert);
        alert.setContentText(content);
        alert.setHeaderText("Error!");
        alert.showAndWait();
    }

    private static void styleDialog(Dialog<?> dialog){
        DialogPane dialogPane = dialog.getDialogPane();
    }
}
