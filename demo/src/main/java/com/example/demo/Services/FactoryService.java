package com.example.demo.Services;

import com.example.demo.Model.*;
import com.example.demo.Repositories.MaterialRepository;
import com.example.demo.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FactoryService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private ProductService productService;

    private FactoryModel factory = new FactoryModel();
    private Integer workerCounter = 0;
    private Integer producedMoney = factory.getAssets();
    private Integer productivity = factory.getProductivity();
    private String msg2="";
    private String msg="";
    private String actmsg="";


    public int getWorkers() {
        return this.workerCounter;
    }

    public int getMoney() {
        return producedMoney;
    }

    public int getProductivity() {
        return productivity;
    }

    public int getProducedMoney() {
        return producedMoney;
    }

    public void setProducedMoney(int amount) {
        producedMoney = amount;
    }

    public FactoryModel getFactory() {
        return factory;
    }

    public void setFactory(FactoryModel factory) {
        this.factory = factory;
    }

    public void startTurn() {
        workerCounter = factory.getWorkers();
        productService.setProduced(productRepository.getList());
        materialService.setBoughtMaterials(materialRepository.getList());
        producedMoney = factory.getAssets();
        factory.setProductivity(factory.getWorkers() * 30);
        productivity = factory.getProductivity();
        factory.setRoundCounter(factory.getRoundCounter()+1);
    }

    public void endTurn() {
        materialRepository.setList(materialService.getBoughtMaterials());
        productRepository.setList(productService.getProduced());
        producedMoney = producedMoney - (workerCounter * 50000);
        this.factory.setAssets(producedMoney);
        this.factory.setWorkers(workerCounter);
    }

    public Integer[] addWorker() {
        workerCounter++;
        factory.setProductivity(factory.getProductivity() + 30);
        productivity = factory.getProductivity();
        Integer[] result = {workerCounter, productivity};
        messageUpdater("You hired a new worker!");
        return result;
    }

    public Integer[] fireWorker() {
        if (workerCounter > 0) {
            workerCounter--;
            if (factory.getProductivity() >= 30) {
                factory.setProductivity(factory.getProductivity() - 30);
            } else {
                factory.setProductivity(0);
            }
            productivity = factory.getProductivity();
        }
        Integer[] result = {workerCounter, productivity};
        messageUpdater("You fired a worker");
        return result;
    }

    public int setProductivity(int productivity) {
        factory.setProductivity(productivity);
        return factory.getProductivity();
    }

    public void messageUpdater( String message){
        msg2=msg;
        msg=actmsg;
        actmsg=message;
    }

    public String[] messageSender(){
        String[] messages=new String[3];
        messages[0]=msg2;
        messages[1]=msg;
        messages[2]=actmsg;
        return messages;
    }
}
