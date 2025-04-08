package com.example._20250408lesson;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

import java.io.IOException;

public class MainController {

    @FXML
    public MenuItem account_menu;
    @FXML
    public MenuItem invoice_menu;
    @FXML
    public MenuItem quit_menu;
    @FXML
    public MenuItem deposit_menu;
    @FXML
    public MenuItem withdraw_menu;
    @FXML
    public MenuItem transfer_menu;






    @FXML
    public void onQuitMenu(){
        Platform.exit();
    }
    @FXML
    public void onInvoiceMenu(){
        try {
            Application.setContent("invoice.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onAccountMenu(){
        try {
            Application.setContent("account.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onTransferMenu(){
        try {
            Application.setContent("transfer.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onCustomerMenu(){
        try {
            Application.setContent("customer.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
