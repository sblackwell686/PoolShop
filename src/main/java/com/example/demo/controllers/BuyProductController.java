package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") long productId) {
        Product product = productService.findById((int) productId);

        if (product != null && product.getInv() > 0) {
            product.setInv(product.getInv() - 1);
            productService.save(product);
            return "redirect:/purchaseSuccess";
        } else {
            return "redirect:/purchaseError";
        }
    }

    @GetMapping("/purchaseSuccess")
    public String displayPurchaseSuccess() {
        return "purchaseSuccess";
    }

    @GetMapping("/purchaseError")
    public String displayPurchaseError() {
        return "purchaseError";
    }
}

