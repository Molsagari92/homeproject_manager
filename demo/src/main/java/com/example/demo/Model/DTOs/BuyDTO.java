package com.example.demo.Model.DTOs;

public class BuyDTO {
    private String name;
    private Integer amount;

    public BuyDTO(String material, Integer amount) {
        this.name = material;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String material) {
        this.name = material;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
