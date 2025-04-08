package com.example._20250408lesson.objects;

public class Customer {

    private int id;
    private String name;
    private int discount;

    public int getDiscount() {
        return discount;
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "(" + id + ")";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
