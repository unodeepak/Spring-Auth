package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collation = "orders")
public class Order {
    @Id
    private String id;
    private int orderNumber;
    private String orderName;
    private int amount;

    /* Setters and Getters Method */
    public String getid() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    /* Order Number */
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /* Amount */
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /* order Name */
    public String getOrderName() {
        return orderName;
    }
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
