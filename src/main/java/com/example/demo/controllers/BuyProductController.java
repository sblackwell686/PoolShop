package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class BuyProductController {

    private final ProductRepository productRepository;

    @Autowired
    public BuyProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") Long productId, RedirectAttributes redirectAttributes) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            if (product.getInv() > 0) {
                product.setInv(product.getInv() - 1);
                productRepository.save(product);
                redirectAttributes.addFlashAttribute("successMessage", "Product purchased successfully!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Product is out of stock.");
            }
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Product not found.");
        }


        // Redirect to the mainscreen after processing the purchase
        return "redirect:/mainscreen";
    }

}
