package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String roundNumber;

    @Column
    private String assets;

    @Column
    private String workers;

    @Column
    private String productivity;

    public Turn(String roundNumber, String assets, String workers, String productivity) {
        this.roundNumber = roundNumber;
        this.assets = assets;
        this.workers = workers;
        this.productivity = productivity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }

    public String getWorkers() {
        return workers;
    }

    public void setWorkers(String workers) {
        this.workers = workers;
    }

    public String getProductivity() {
        return productivity;
    }

    public void setProductivity(String productivity) {
        this.productivity = productivity;
    }
}
