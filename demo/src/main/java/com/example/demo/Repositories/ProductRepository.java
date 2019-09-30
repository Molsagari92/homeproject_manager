package com.example.demo.Repositories;

import com.example.demo.Model.ProductModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    ArrayList<ProductModel> products=new ArrayList<>();

    public int size() {
        return products.size();
    }

    public ProductModel get(int i) {
        return products.get(i);
    }

    public ArrayList<ProductModel> getList(){ return products;}

    public void setList(ArrayList<ProductModel> newlist){ products=newlist;}

}
