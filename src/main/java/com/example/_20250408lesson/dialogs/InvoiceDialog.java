package com.example._20250408lesson.dialogs;

import com.example._20250408lesson.AccountController;
import com.example._20250408lesson.alerts.AlertUtilities;
import com.example._20250408lesson.objects.Account;
import com.example._20250408lesson.objects.Customer;
import com.example._20250408lesson.objects.Invoice;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class InvoiceDialog {
    public static Optional<Invoice> showAndWait() {
        Dialog<Invoice> dialog = new Dialog<>();
        dialog.setTitle("Create new invoice");
        dialog.setHeaderText("Create a new invoice");

        ButtonType createButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

        ComboBox<Account> comboBox = new ComboBox<>(AccountController.getAccounts());

        TextField idField = new TextField();
        idField.setPromptText("Invoice ID");

        TextField amountField = new TextField();
        amountField.setPromptText("Amount paid");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Label("Choose account"), 0, 0);
        grid.add(comboBox, 0, 1);
        grid.add(new Label("Enter the invoice ID: "), 1, 0);
        grid.add(idField, 1, 1);
        grid.add(new Label("Enter amount paid: "), 2, 0);
        grid.add(amountField, 2, 1);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButton) {
                try {
                    Customer customer = comboBox.getValue().getCustomer();
                    int id = Integer.parseInt(idField.getText().trim());
                    double amount = Double.parseDouble(amountField.getText().trim());
                    return new Invoice(id, customer, amount);
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
