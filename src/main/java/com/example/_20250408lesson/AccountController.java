package com.example._20250408lesson;

import com.example._20250408lesson.alerts.AlertUtilities;
import com.example._20250408lesson.dialogs.CreateAccount;
import com.example._20250408lesson.dialogs.DeleteAccount;
import com.example._20250408lesson.objects.Account;
import com.example._20250408lesson.objects.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class AccountController {
    @FXML
    public static ObservableList<Account> accounts = FXCollections.observableArrayList(new Account(1, new Customer(1, "Demo")));
    @FXML
    public Button btn_create_account;
    @FXML
    public Button btn_delete_account;
    @FXML
    public TableColumn<Account, Integer> balance_column;
    @FXML
    public TableColumn<Account, Customer> customer_column;
    @FXML
    public TableColumn<Account, Integer> id_column;
    @FXML
    public TableView<Account> accounts_tableview;
    @FXML
    public Button btn_refresh;

    public static ObservableList<Account> getAccounts() {
        return accounts;
    }

    @FXML
    public static void accountDelete(Customer customer) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getCustomer().getId() == customer.getId()) {
                accounts.remove(i);
            }
        }
    }

    @FXML
    public void initialize() {
        balance_column.setCellValueFactory(new PropertyValueFactory<>("balance"));
        customer_column.setCellValueFactory(new PropertyValueFactory<>("customer"));
        id_column.setCellValueFactory(new PropertyValueFactory<>("id"));

        accounts_tableview.setItems(accounts);
    }

    @FXML
    public void onCreateButton() {
        if (CustomerController.getCustomers().isEmpty()){
            AlertUtilities.displayError("No customers to create accounts.");
            return;
        }
        Optional<Account> newAccount = CreateAccount.showAndWait();
        newAccount.ifPresent(account -> {
            accounts.add(account);
        });
    }

    @FXML
    public void onDeleteButton() {
        if (AccountController.getAccounts().isEmpty()){
            AlertUtilities.displayError("No accounts to delete.");
            return;
        }
        Optional<Account> delAccount = DeleteAccount.showAndWait();
        delAccount.ifPresent(account -> {
            accounts.remove(account);
            accounts_tableview.refresh();
        });
    }

    @FXML
    public void onRefresh() {
        accounts_tableview.refresh();
    }
}
