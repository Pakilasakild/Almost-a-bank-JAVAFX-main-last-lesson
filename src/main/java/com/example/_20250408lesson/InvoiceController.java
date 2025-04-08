package com.example._20250408lesson;

import com.example._20250408lesson.dialogs.InvoiceDialog;
import com.example._20250408lesson.objects.Customer;
import com.example._20250408lesson.objects.Invoice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class InvoiceController {

    @FXML
    public Button btn_create;
    @FXML
    public TableView<Invoice> invoice_tableview;
    @FXML
    public TableColumn<Invoice, Customer> customer_data_column;
    @FXML
    public TableColumn<Invoice, Integer> invoice_id_column;
    @FXML
    public TableColumn<Invoice, Double> amount_paid_column;
    @FXML
    public static ObservableList<Invoice> invoices = FXCollections.observableArrayList(
            new Invoice(1, new Customer(1, "Demo"), 50)
    );


    public void initialize(){

        customer_data_column.setCellValueFactory(new PropertyValueFactory<>("customer"));
        invoice_id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
        amount_paid_column.setCellValueFactory(new PropertyValueFactory<>("amount"));

        invoice_tableview.setItems(invoices);
    }

    public void onCreateButton(){
        Optional<Invoice> newInvoice = InvoiceDialog.showAndWait();
        newInvoice.ifPresent(invoice -> {
            invoices.add(invoice);
            invoice_tableview.refresh();
        });
    }
}
