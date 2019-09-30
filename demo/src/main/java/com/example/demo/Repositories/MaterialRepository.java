package com.example.demo.Repositories;

import com.example.demo.Model.Material;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MaterialRepository {
    ArrayList<Material> materials=new ArrayList<>();

    public int size() {
        return materials.size();
    }

    public Material get(int i) {
        return materials.get(i);
    }

    public ArrayList<Material> getList() {
        return materials;
    }

    public void setList(ArrayList<Material> boughtMaterials) {
        materials=boughtMaterials;
    }
}
