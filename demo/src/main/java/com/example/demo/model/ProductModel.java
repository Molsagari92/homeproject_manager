package com.example.demo.model;


public class ProductModel {
    private String name;
    private Fruit base;
    private Integer productionCost;

    public ProductModel() {
        this.base = null;
        this.name ="";
        this.productionCost = 0;
    }

    public ProductModel(Fruit base) {
        this.base = base;
        this.productionCost = (base.getPrice() * 3) + 200;
        if (base.getName().equals("Cherry")) {
            this.name = "Cherry Jam";
        } else if (base.getName().equals("Apricot")) {
            this.name = "Apricot Jam";
        } else if (base.getName().equals("Strawberry")) {
            this.name = "Strawberry Jam";
        } else {
            this.name = "Garbage";
        }
    }

    public ProductModel(String name) {
        this.name = name;
        if (name.equals("Cherry Jam")) {
            this.base = new Cherry();
        } else if (name.equals("Apricot Jam")) {
            this.base = new Apricot();
        } else if (name.equals("Strawberry Jam")) {
            this.base = new Strawberry();
        } else {
            this.name = "Garbage";
        }
        assert base != null;
        this.productionCost = (base.getPrice() * 3) + 200;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fruit getBase() {
        return base;
    }

    public void setBase(Fruit base) {
        this.base = base;
    }

    public Integer getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(Integer productionCost) {
        this.productionCost = productionCost;
    }
}
