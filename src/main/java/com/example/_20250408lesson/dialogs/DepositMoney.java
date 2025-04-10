package com.example._20250408lesson.dialogs;

import com.example._20250408lesson.AccountController;
import com.example._20250408lesson.alerts.AlertUtilities;
import com.example._20250408lesson.objects.Account;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class DepositMoney {
    public static Optional<Account> showAndWait() {
        Dialog<Account> dialog = new Dialog<>();
        dialog.setTitle("Deposit money");
        dialog.setHeaderText("How much money would you like to deposit and to what account?");

        ButtonType createButton = new ButtonType("Deposit", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

        ComboBox<Account> comboBox = new ComboBox<>(AccountController.getAccounts());

        TextField amountField = new TextField();
        amountField.setPromptText("Amount of money");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Label("Choose account: "), 0, 0);
        grid.add(comboBox, 0, 1);
        grid.add(new Label("Amount of money to deposit: "), 1, 0);
        grid.add(amountField, 1, 1);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButton) {
                Account account = comboBox.getValue();
                double amount = Double.parseDouble(amountField.getText().trim());
                if (amount <= 0) {
                    AlertUtilities.displayError("Enter a valid amount.");
                } else {
                    account.setBalance(account.getBalance() + amount);
                    AlertUtilities.displayCongrats("Funds successfully deposited! \n Please refresh page to see changes.");
                    return null;
                }
            }
            return null;
        });

        return dialog.showAndWait();
    }
}
