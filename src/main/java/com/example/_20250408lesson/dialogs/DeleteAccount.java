package com.example._20250408lesson.dialogs;

import com.example._20250408lesson.AccountController;
import com.example._20250408lesson.objects.Account;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class DeleteAccount {
    public static Optional<Account> showAndWait() {
        Dialog<Account> dialog = new Dialog<>();
        dialog.setTitle("Delete an account");
        dialog.setHeaderText("Choose account to delete");

        ButtonType createButton = new ButtonType("Delete", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

        ComboBox<Account> comboBox = new ComboBox<>(AccountController.getAccounts());

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Label("Choose account"), 0, 0);
        grid.add(comboBox, 0, 1);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButton) {
                    return comboBox.getValue();
            }
            return null;
        });

        return dialog.showAndWait();
    }
}
