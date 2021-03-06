package com.example.demo.services;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Autowired
    private FactoryService factoryService;

    @Autowired ProductService productService;

    public Integer materialAmount(String name) {
        Integer materialAmount = 0;
        for (int i = 0; i < factoryService.materials.size(); i++) {
            if (factoryService.materials.get(i).getName().equals(name)) {
                materialAmount++;
            }
        }
        return materialAmount;
    }

    public Integer buyMaterial(String name, Integer amount) {
        Material material = createMaterial(name);
        Integer realBought=0;
        for (int i = 0; i < amount; i++) {
            if (factoryService.getMoney() > material.getPrice()) {
                factoryService.materials.add(material);
                factoryService.setMoney(factoryService.getMoney()-material.getPrice());
                realBought++;
            }
        }
        factoryService.messageUpdater("You bought "+ realBought + " of "+ name+" for "+material.getPrice()*realBought+" HUF");
        return factoryService.getMoney();
    }

    public void removeMaterial(String name, int amount) {
        while (amount > 0) {
            for (int i = 0; i < factoryService.materials.size(); i++) {
                if (factoryService.materials.get(i).getName().equals(name)) {
                    factoryService.materials.remove(i);
                    break;
                }
            }
            amount--;
        }

    }

    public Material createMaterial(String name) {
        Material material = null;
        if ("Sugar".equals(name)) {
            material = new Sugar();
        } else if ("Cherry".equals(name)) {
            material = new Cherry();
        } else if ("Apricot".equals(name)) {
            material = new Apricot();
        } else if ("Strawberry".equals(name)) {
            material = new Strawberry();
        }
        return material;
    }
}
