package com.example.demo.Model;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



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
