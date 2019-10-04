package com.example.demo.services;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FactoryService {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private ProductService productService;

    private FactoryModel factory;
    private Integer workers;
    private Integer money;
    private Integer productivity = 0;
    private String msg2;
    private String msg;
    private String actmsg;
    public List<Material> materials = new ArrayList<>();
    public List<ProductModel> products = new ArrayList<>();

    public void startGame() {
        factory = new FactoryModel();
        workers = factory.getWorkers();
        money = factory.getAssets();
        productivity = factory.getProductivity();
        msg2 = "";
        msg = "";
        actmsg = "";
        products.clear();
        materials.clear();
    }


    public Integer getWorkers() {
        return workers;
    }

    public Integer getProductivity() {
        return productivity;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer amount) {
        money = amount;
    }

    public void setProductivity(Integer number) {
        productivity = number;
    }

    public FactoryModel getFactory() {
        return factory;
    }

    public void setFactory(FactoryModel factory) {
        this.factory = factory;
    }

    public void startTurn() {
        workers = factory.getWorkers();
        money = factory.getAssets();
        productivity = factory.getProductivity();
        factory.setRoundCounter(factory.getRoundCounter() + 1);
        messageUpdater("You started round " + factory.getRoundCounter());
    }

    public void endTurn() {
        money = money - (workers * 50000);
        this.factory.setAssets(money);
        this.factory.setWorkers(workers);
        this.factory.setProductivity(workers * 30);
    }

    public Integer[] addWorker() {
        workers++;
        productivity = productivity + 30;
        Integer[] result = {workers, productivity};
        messageUpdater("You hired a new worker!");
        return result;
    }

    public Integer[] fireWorker() {
        if (workers > 0) {
            workers--;
            if (productivity >= 30) {
                productivity = productivity - 30;
            } else {
                productivity = 0;
            }
        }
        Integer[] result = {workers, productivity};
        messageUpdater("You fired a worker");
        return result;
    }


    public void messageUpdater(String message) {
        msg2 = msg;
        msg = actmsg;
        actmsg = message;
    }

    public String[] messageSender() {
        String[] messages = new String[3];
        messages[0] = msg2;
        messages[1] = msg;
        messages[2] = actmsg;
        return messages;
    }

    public Integer[] productPriceSender() {
        Integer[] prices = new Integer[3];
        prices[0] = new ProductModel("Apricot Jam").getProductionCost();
        prices[1] = new ProductModel("Strawberry Jam").getProductionCost();
        prices[2] = new ProductModel("Cherry Jam").getProductionCost();
        return prices;
    }

    public Integer[] materialPriceSender() {
        Integer[] prices = new Integer[4];
        prices[0] = new Apricot().getPrice();
        prices[1] = new Strawberry().getPrice();
        prices[2] = new Cherry().getPrice();
        prices[3] = new Sugar().getPrice();
        return prices;
    }

}
