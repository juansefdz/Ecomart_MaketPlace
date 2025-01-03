package com.juansefdz.ecomart.api.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juansefdz.ecomart.infraestructure.Services.ProductGeneratorService;

@RestController
@RequestMapping("/product-generator")
public class ProductGeneratorController {

    private final ProductGeneratorService productGeneratorService;

    public ProductGeneratorController(ProductGeneratorService productGeneratorService) {
        this.productGeneratorService = productGeneratorService;
    }

    @GetMapping
    public String ProductGenerator() {
        String question = "Generate 5 ecological products";
        return productGeneratorService.generateProducts(question);
    }
}
