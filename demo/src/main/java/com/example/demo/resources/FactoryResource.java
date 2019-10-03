package com.example.demo.resources;

import com.example.demo.model.DTOs.BuyDTO;
import com.example.demo.model.DTOs.ProduceDTO;
import com.example.demo.model.DTOs.SellDTO;
import com.example.demo.services.FactoryService;
import com.example.demo.services.MaterialService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class FactoryResource {

    @Autowired
    private FactoryService factoryService;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private ProductService productService;


    @GetMapping("/startmonth")
    public void startMonth() {
        factoryService.startTurn();
    }

    @GetMapping("/endmonth")
    public void endMonth() {
        factoryService.endTurn();
    }

    @GetMapping("/getbasics")
    public Integer[] getBasics() {
        Integer[] data = new Integer[3];
        data[0] = factoryService.getWorkers();
        data[1] = factoryService.getMoney();
        data[2] = factoryService.getProductivity();
        return data;
    }

    @GetMapping("/getmaterials")
    public Integer[] getMaterials() {
        Integer[] data = new Integer[4];
        data[0] = materialService.materialAmount("Apricot");
        data[1] = materialService.materialAmount("Strawberry");
        data[2] = materialService.materialAmount("Cherry");
        data[3] = materialService.materialAmount("Sugar");
        return data;
    }

    @GetMapping("/getproducts")
    public Integer[] getProducts() {
        Integer[] data = new Integer[3];
        data[0] = productService.productAmount("Apricot Jam");
        data[1] = productService.productAmount("Strawberry Jam");
        data[2] = productService.productAmount("Cherry Jam");
        return data;
    }

    @GetMapping("/startgame")
    public void startGame() {
        factoryService.startGame();
    }

    @GetMapping("/hireworker")
    public Integer[] hireWorker() {
        return factoryService.addWorker();
    }

    @GetMapping("/fireworker")
    public Integer[] fireworker() {
        return factoryService.fireWorker();
    }

    @PostMapping("/buymaterial")
    public Integer buyMaterial(@RequestBody BuyDTO buyDTO) {
        materialService.buyMaterial(buyDTO.getName(), buyDTO.getAmount());
        return factoryService.getMoney();
    }

    @PostMapping("/createproduct")
    public Integer createProduct(@RequestBody ProduceDTO produceDTO) {
        productService.produce(produceDTO.getName(), produceDTO.getAmount());
        return factoryService.getProductivity();
    }

    @PostMapping("/sellproduct")
    public Integer sellProduct(@RequestBody SellDTO sellDTO) {
        productService.sell(sellDTO.getName(), sellDTO.getPrice(), sellDTO.getAmount());
        return factoryService.getMoney();
    }

    @GetMapping("/messages")
    public String[] sendMessages() {
        return factoryService.messageSender();
    }

    @GetMapping("/productprices")
    public Integer[] sendProductPrices() {
        Integer[] prices = factoryService.productPriceSender();
        return prices;
    }

    @GetMapping("/materialprices")
    public Integer[] sendMaterialPrices() {
        Integer[] prices = factoryService.materialPriceSender();
        return prices;
    }
}
