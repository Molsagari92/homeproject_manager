package com.example.demo.Services;

import com.example.demo.Model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private FactoryService factoryService;

    private ArrayList<ProductModel> produced = new ArrayList<>();

    public ArrayList<ProductModel> getProduced() {
        return produced;
    }

    public void setProduced(ArrayList<ProductModel> produced) {
        this.produced = produced;
    }

    public Integer productAmount(String name) {
        Integer producedAmount = 0;
        for (int i = 0; i < produced.size(); i++) {
            if (produced.get(i).getName().equals(name)) {
                producedAmount++;
            }
        }
        return producedAmount;
    }

    public void produce(String name, int amount) {
        ProductModel product = new ProductModel(name);
        Integer realProduced = 0;
        for (int i = 0; i < amount; i++) {
            Integer fruitAmount = materialService.materialAmount(product.getBase().getName());
            Integer sugarAmount = materialService.materialAmount("Sugar");
            if (fruitAmount >= 3 && sugarAmount >= 1 && factoryService.getProductivity() > amount) {
                produced.add(product);
                materialService.removeMaterial(product.getBase().getName(), 3);
                materialService.removeMaterial("Sugar", 1);
                factoryService.getFactory().setProductivity(factoryService.getFactory().getProductivity() - 1);
                realProduced++;
            }
        }
        factoryService.messageUpdater("You produced " + realProduced + " of " + name);
    }

    public Integer sell(String name, Integer price, Integer amount) {
        ProductModel product = new ProductModel(name);
        Double maximumSellPrice = product.getProductionCost() * 2.5;
        Integer productAmount = 0;
        for (int i = 0; i < produced.size(); i++) {
            if (produced.get(i).getName().equals(product.getName())) {
                productAmount++;
            }
        }
        if (price > maximumSellPrice) {
            System.out.println("Too expensive");
        } else if (productAmount < amount) {
            System.out.println("Not enough product in the storage");
        } else {
            Double random = Math.random();
            Integer sold = (int) Math.floor(amount * random);
            factoryService.setProducedMoney(factoryService.getProducedMoney() + (sold * price));
            removeProduct(product.getName(), sold);
            System.out.println("You sold " + sold + " piece of " + product.getName() + " for " + (sold * price));
            factoryService.messageUpdater("You sold " + sold + " of " + name + " for "+ (sold*price));
        }

        return factoryService.getProducedMoney();
    }

    private void removeProduct(String name, int amount) {
        while (amount > 0) {
            for (int i = 0; i < produced.size(); i++) {
                if (produced.get(i).getName().equals(name)) {
                    produced.remove(i);
                    break;
                }
            }
            amount--;
        }
    }
}
