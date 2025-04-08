package com.example._20250408lesson;

import com.example._20250408lesson.objects.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerController {
    @FXML
    public TableView<Customer> customer_tableview;
    @FXML
    public TableColumn<Customer, String> name_column;
    @FXML
    public TableColumn<Customer, Integer> id_column;
    @FXML
    public Button btn_create_customer;
    @FXML
    public Button btn_delete_customer;
    @FXML
    public static ObservableList<Customer> customers = FXCollections.observableArrayList(
            new Customer(1, "Paulius"),
            new Customer(2, "Jonas"),
            new Customer(3, "Rimas")
    );


    @FXML
    public static ObservableList<Customer> getCustomers(){
        return customers;
    }

    @FXML
    public void initialize(){
        id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));

        customer_tableview.setItems(customers);
    }
}
