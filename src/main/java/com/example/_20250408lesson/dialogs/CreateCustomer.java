package com.example._20250408lesson.dialogs;

import com.example._20250408lesson.AccountController;
import com.example._20250408lesson.objects.Account;
import com.example._20250408lesson.objects.Customer;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class CreateCustomer {
    public static Optional<Customer> showAndWait() {
        Dialog<Customer> dialog = new Dialog<>();
        dialog.setTitle("Create a new customer");
        dialog.setHeaderText("Create a customer");

        ButtonType createButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

        TextField nameField = new TextField();
        nameField.setPromptText("Enter name");

        TextField idField = new TextField();
        idField.setPromptText("Enter ID");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Label("Enter name: "), 0, 0);
        grid.add(nameField, 0, 1);
        grid.add(new Label("Enter ID: "), 1, 0);
        grid.add(idField, 1, 1);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButton) {
                try {
                    String name = nameField.getText().trim();
                    int id = Integer.parseInt(idField.getText().trim());
                    return new Customer(id, name);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            }
            return null;
        });

        return dialog.showAndWait();
    }
}
