package com.example.demo.resources;

import com.example.demo.model.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductCatalog {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("")
    public List<ProductItem> getCompleteCatalog() {

        List<ProductItem> productItemList = new ArrayList<ProductItem>();
        ProductItem productNameItem;
        ProductItem productPriceItem;

        for (int productId = 1; productId <= 5 ; productId++) {

            productNameItem = restTemplate.getForObject("http://localhost:8082/products/" + productId,
                    ProductItem.class);

            productPriceItem = restTemplate.getForObject("http://localhost:8083/products/" + productId + "/price",
                    ProductItem.class);

            productItemList.add(new ProductItem(new Long(productId), productNameItem.getName(), productPriceItem.getPriceCurrencyList()));

        }

        return productItemList;
    }

    @RequestMapping("/{productId}")
    public ProductItem getCatalog(@PathVariable ("productId") Long productId) {

        ProductItem productNameItem = restTemplate.getForObject("http://localhost:8082/products/" + productId,
                ProductItem.class);

        ProductItem productPriceItem = restTemplate.getForObject("http://localhost:8083/products/" + productId + "/price",
                ProductItem.class);

        return new ProductItem(productId, productNameItem.getName(), productPriceItem.getPriceCurrencyList());
    }
}
