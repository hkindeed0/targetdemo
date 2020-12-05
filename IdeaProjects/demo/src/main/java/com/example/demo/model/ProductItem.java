package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductItem {

    private Long id;
    private String name;
    private List priceCurrencyList;

    public ProductItem() {

    }

    public ProductItem(Long id, String name, List priceCurrencyList) {
        this.id = id;
        this.name = name;
        this.priceCurrencyList = priceCurrencyList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getPriceCurrencyList() {
        return priceCurrencyList;
    }

    public void setPriceCurrencyList(List priceCurrencyList) {
        this.priceCurrencyList = priceCurrencyList;
    }
}
