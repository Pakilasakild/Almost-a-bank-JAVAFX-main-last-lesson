package com.example._20250408lesson.dialogs;

import com.example._20250408lesson.AccountController;
import com.example._20250408lesson.CustomerController;
import com.example._20250408lesson.alerts.AlertUtilities;
import com.example._20250408lesson.objects.Account;
import com.example._20250408lesson.objects.Customer;
import com.example._20250408lesson.objects.Invoice;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class CreateAccount {

    public static Optional<Account> showAndWait() {
        Dialog<Account> dialog = new Dialog<>();
        dialog.setTitle("Create new account");
        dialog.setHeaderText("Create a new account");

        ButtonType createButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

        ComboBox<Customer> comboBox = new ComboBox<>(CustomerController.getCustomers());

        TextField idField = new TextField();
        idField.setPromptText("Account ID");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Label("Choose customer"), 0, 0);
        grid.add(comboBox, 0, 1);
        grid.add(new Label("Enter the account ID: "), 1, 0);
        grid.add(idField, 1, 1);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButton) {
                try {
                    Customer customer = comboBox.getValue();
                    int id = Integer.parseInt(idField.getText().trim());
                    return new Account(id, customer);
                } catch (NumberFormatException e) {
                    AlertUtilities.displayError("Enter correct numbers!");
                    System.out.println(e);
                }
            }
            return null;
        });

        return dialog.showAndWait();
    }
}
