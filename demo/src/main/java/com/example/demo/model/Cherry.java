package com.example.demo.model;


public class Cherry extends Fruit {

    public Cherry() {
        super(500, "Cherry");
    }


    @Override
    public Integer getPrice() {
        return 500;
    }
    @Override
    public String getName() {
        return super.getName();
    }
}
