package com.example.demo.service;

import com.example.demo.model.ProductItem;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductNameService {

    private static Map<Long, String> productNameMap = new HashMap<Long, String>();

    public ProductNameService() {
        buildProductNameMap();
    }

    private void buildProductNameMap() {
        //productNameMap = new HashMap<Long, String>();
        productNameMap.put(new Long(1), "A");
        productNameMap.put(new Long(2), "B");
        productNameMap.put(new Long(3), "C");
        productNameMap.put(new Long(4), "D");
        productNameMap.put(new Long(5), "E");
    }

    public String getProductNameById(Long productId) {
        return productNameMap.get(productId);
    }

    public void addOrUpdateProduct(Long productId, ProductItem productItem) {
       productNameMap.put(productId, productItem.getName());
    }
}