package com.example.demo.Model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class Apricot extends Fruit {

    public Apricot() {
        super(300, "Apricot");
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
