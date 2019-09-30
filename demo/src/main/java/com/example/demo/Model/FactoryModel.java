package com.example.demo.Model;

import org.springframework.stereotype.Component;

@Component
public class FactoryModel {
    private Integer assets;
    private Integer roundCounter;
    private Integer workers;
    private Integer productivity;

    public FactoryModel() {
        this.assets = 1000000;
        this.roundCounter = 1;
        this.workers = 0;
        this.productivity = 0;
    }

    public Integer getAssets() {
        return assets;
    }

    public void setAssets(Integer assets) {
        this.assets = assets;
    }

    public Integer getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(Integer roundCounter) {
        this.roundCounter = roundCounter;
    }

    public Integer getWorkers() {
        return workers;
    }

    public void setWorkers(Integer workers) {
        this.workers = workers;
    }

    public Integer getProductivity() {
        return productivity;
    }

    public void setProductivity(Integer productivity) {
        if (productivity >= 0) {
            this.productivity = productivity;
        }
    }
}
