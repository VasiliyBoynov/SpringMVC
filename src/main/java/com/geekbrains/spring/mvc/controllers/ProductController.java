package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Box;
import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService ;
    // GET http://localhost:8189/app/product/all
    @GetMapping("/all")
    public String getAllProduct(Model model) {
        model.addAttribute("frontProduct", productService.getAllProduct());
        return "all_products";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.creat(product);
        return "redirect:/product/all";
    }

}
