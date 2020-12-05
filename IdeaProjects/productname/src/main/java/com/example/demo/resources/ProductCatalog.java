package com.example.demo.resources;

import com.example.demo.model.ProductItem;
import com.example.demo.service.ProductNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductCatalog {

    @Autowired
    private ProductNameService productNameService;

    @RequestMapping("/{productId}")
    public ProductItem getCatalog(@PathVariable ("productId") Long productId) {

        return new ProductItem(productId, productNameService.getProductNameById(productId));

    }

@RequestMapping(method = RequestMethod.POST, value = "/{productId}")
    public  void postCatalog(@RequestBody ProductItem productItem, @PathVariable Long productId) {

        productNameService.addOrUpdateProduct(productId, productItem);

    }
}
