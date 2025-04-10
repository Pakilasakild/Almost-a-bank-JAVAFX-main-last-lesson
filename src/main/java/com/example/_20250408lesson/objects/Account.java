package com.example._20250408lesson.objects;

public class Account {

    private int id;
    private Customer customer;
    private double balance;

    @Override
    public String toString() {
        return customer + " $" + String.format("%.2f", balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

//    public Account(int id, Customer customer, double balance) {
//        this.id = id;
//        this.customer = customer;
//        this.balance = balance;
//    }

    public Account(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }
}
