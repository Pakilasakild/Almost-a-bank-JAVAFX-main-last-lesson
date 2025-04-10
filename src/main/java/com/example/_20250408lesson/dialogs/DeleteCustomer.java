package com.example._20250408lesson.dialogs;

import com.example._20250408lesson.AccountController;
import com.example._20250408lesson.CustomerController;
import com.example._20250408lesson.alerts.AlertUtilities;
import com.example._20250408lesson.objects.Customer;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class DeleteCustomer {
    public static Optional<Customer> showAndWait() {
        Dialog<Customer> dialog = new Dialog<>();
        dialog.setTitle("Delete a customer");
        dialog.setHeaderText("Delete a customer");

        ButtonType createButton = new ButtonType("Remove", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

        ComboBox<Customer> comboBox = new ComboBox<>(CustomerController.getCustomers());

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Label("Choose customer: "), 0, 0);
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
