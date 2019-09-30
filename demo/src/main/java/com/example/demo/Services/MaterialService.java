package com.example.demo.Services;

import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MaterialService {

    @Autowired
    private FactoryService factoryService;

    @Autowired ProductService productService;

    private ArrayList<Material> boughtMaterials = new ArrayList<>();

    public ArrayList<Material> getBoughtMaterials() {
        return boughtMaterials;
    }

    public void setBoughtMaterials(ArrayList<Material> boughtMaterials) {
        this.boughtMaterials = boughtMaterials;
    }

    public Integer materialAmount(String name) {
        Integer materialAmount = 0;
        for (int i = 0; i < boughtMaterials.size(); i++) {
            if (boughtMaterials.get(i).getName().equals(name)) {
                materialAmount++;
            }
        }
        return materialAmount;
    }

    public Integer buyMaterial(String name, Integer amount) {
        Material material = createMaterial(name);
        Integer realBought=0;
        for (int i = 0; i < amount; i++) {
            if (factoryService.getProducedMoney() > material.getPrice()) {
                boughtMaterials.add(material);
                factoryService.setProducedMoney(factoryService.getProducedMoney()-material.getPrice());
                realBought++;
            }
        }
        factoryService.messageUpdater("You bought "+ realBought + " of "+ name+" for "+material.getPrice()*realBought);
        return factoryService.getProducedMoney();
    }

    public void removeMaterial(String name, int amount) {
        while (amount > 0) {
            for (int i = 0; i < boughtMaterials.size(); i++) {
                if (boughtMaterials.get(i).getName().equals(name)) {
                    boughtMaterials.remove(i);
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
