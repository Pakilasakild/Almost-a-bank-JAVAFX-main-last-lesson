package com.example._20250408lesson.dialogs;

import com.example._20250408lesson.AccountController;
import com.example._20250408lesson.alerts.AlertUtilities;
import com.example._20250408lesson.objects.Account;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class WithdrawMoney {
    public static Optional<Account> showAndWait() {
        Dialog<Account> dialog = new Dialog<>();
        dialog.setTitle("Withdraw money");
        dialog.setHeaderText("How much money would you like to withdraw and from what account?");

        ButtonType createButton = new ButtonType("Withdraw", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

        ComboBox<Account> comboBox = new ComboBox<>(AccountController.getAccounts());

        TextField amountField = new TextField();
        amountField.setPromptText("Amount of money");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Label("Choose account: "), 0, 0);
        grid.add(comboBox, 0, 1);
        grid.add(new Label("Amount of money to withdraw: "), 1, 0);
        grid.add(amountField, 1, 1);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButton) {
                Account account = comboBox.getValue();
                double amount = Double.parseDouble(amountField.getText().trim());
                if (account.getBalance() < amount) {
                    AlertUtilities.displayError("Funds too low!");
                } else {
                    account.setBalance(account.getBalance() - amount);
                    AlertUtilities.displayCongrats("Funds successfully withdrawn!");
                    return null;
                }
            }
            return null;
        });

        return dialog.showAndWait();
    }
}
