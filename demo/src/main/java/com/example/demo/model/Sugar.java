package com.example.demo.model;


public class Sugar extends Material {

    public Sugar() {
        super(200, "Sugar");
    }

    public Integer getPrice(){
        return 200;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
