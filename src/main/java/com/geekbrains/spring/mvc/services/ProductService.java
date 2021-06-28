package com.geekbrains.spring.mvc.services;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.view();
    }

    public void creat(Product product){
        productRepository.creat(product);
    }

    public Product read (long id){
        return productRepository.read(id);
    }

    public void update(Product product){
        productRepository.update(product);
    }

    public void delte(long id){
        productRepository.delte(id);
    }

    public long count(){
        return productRepository.count();
    }

    public float avr(){
        return productRepository.avr();
    }



}
