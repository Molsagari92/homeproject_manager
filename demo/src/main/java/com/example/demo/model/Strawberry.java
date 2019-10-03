package com.example.demo.model;


public class Strawberry extends Fruit {

    public Strawberry() {
        super(900, "Strawberry");
    }

    @Override
    public Integer getPrice() {
        return 900;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
