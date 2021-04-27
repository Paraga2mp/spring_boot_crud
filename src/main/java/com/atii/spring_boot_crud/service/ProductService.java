package com.atii.spring_boot_crud.service;

import com.atii.spring_boot_crud.entity.Product;
import com.atii.spring_boot_crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// the class provides the functionality
@Service
public class ProductService {

    // spring injects object dependency to repository when ProductRepository is created
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
       return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);

        return "Product of id "+id + " has been removed";
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return repository.save(existingProduct);
    }





}
