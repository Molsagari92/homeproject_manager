package com.example.demo.services;

import com.example.demo.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private FactoryService factoryService;

    public Integer productAmount(String name) {
        Integer producedAmount = 0;
        for (int i = 0; i < factoryService.products.size(); i++) {
            if (factoryService.products.get(i).getName().equals(name)) {
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
            if (fruitAmount >= 3 && sugarAmount >= 1 && factoryService.getProductivity() >=1) {
                factoryService.products.add(product);
                materialService.removeMaterial(product.getBase().getName(), 3);
                materialService.removeMaterial("Sugar", 1);
                factoryService.setProductivity(factoryService.getProductivity() - 1);
                realProduced++;
            } else if(fruitAmount<3){
                factoryService.messageUpdater("Not enough fruit in the storage");
            } else if(sugarAmount<1){
                factoryService.messageUpdater("Not enough sugar in the storage");
            } else if(factoryService.getProductivity()<1){
                factoryService.messageUpdater("Not enough productivity! Start a new month or hire more workers!");
            }
        }
        factoryService.messageUpdater("You produced " + realProduced + " of " + name);
    }

    public Integer sell(String name, Integer price, Integer amount) {
        ProductModel product = new ProductModel(name);
        Double maximumSellPrice = product.getProductionCost() * 2.5;
        Integer productAmount = 0;
        for (int i = 0; i < factoryService.products.size(); i++) {
            if (factoryService.products.get(i).getName().equals(product.getName())) {
                productAmount++;
            }
        }
        if (price > maximumSellPrice) {
            factoryService.messageUpdater("Too expensive");
        } else if (productAmount < amount) {
            factoryService.messageUpdater("Not enough product in the storage");
        } else {
            Double random = Math.random();
            Integer sold = (int) Math.floor(amount * random);
            factoryService.setMoney(factoryService.getMoney() + (sold * price));
            removeProduct(product.getName(), sold);
            factoryService.messageUpdater("You sold " + sold + " " + name + " for "+ (sold*price)+" HUF");
        }

        return factoryService.getMoney();
    }

    private void removeProduct(String name, int amount) {
        while (amount > 0) {
            for (int i = 0; i < factoryService.products.size(); i++) {
                if (factoryService.products.get(i).getName().equals(name)) {
                    factoryService.products.remove(i);
                    break;
                }
            }
            amount--;
        }
    }
}
