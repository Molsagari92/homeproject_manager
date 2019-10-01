package com.example.demo.Model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


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
