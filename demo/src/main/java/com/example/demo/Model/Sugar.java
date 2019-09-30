package com.example.demo.Model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



public class Sugar extends Material {

    public Sugar() {
        super(200, "Sugar");
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
