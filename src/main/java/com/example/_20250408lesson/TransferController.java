package com.example._20250408lesson;

import com.example._20250408lesson.alerts.AlertUtilities;
import com.example._20250408lesson.objects.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TransferController {
    @FXML
    public ComboBox<Account> from_acc_combo;
    @FXML
    public ComboBox<Account> to_acc_combo;
    @FXML
    public TextField amount_field;
    @FXML
    public Button btn_confirm;

    @FXML
    public void initialize() {
        from_acc_combo.setItems(AccountController.getAccounts());
        to_acc_combo.setItems(AccountController.getAccounts());
    }

    @FXML
    public void onConfirmButton() {
        double amount = Double.parseDouble(amount_field.getText().trim());
        if (from_acc_combo.getValue().getBalance() < amount) {
            AlertUtilities.displayError("Funds too low!");
        } else if (from_acc_combo.getValue() == to_acc_combo.getValue()) {
            AlertUtilities.displayError("Cannot transfer to the same account.");
        } else {
            from_acc_combo.getValue().setBalance(from_acc_combo.getValue().getBalance() - amount);
            to_acc_combo.getValue().setBalance(to_acc_combo.getValue().getBalance() + amount);
            AlertUtilities.displayCongrats("Operation completed successfully.");
        }
        from_acc_combo.setValue(null);
        to_acc_combo.setValue(null);
    }
}
