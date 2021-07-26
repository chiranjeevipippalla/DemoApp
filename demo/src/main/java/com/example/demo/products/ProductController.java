package com.example.demo.products;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public String addProduct(@RequestBody Product product)
    {
        System.out.println(product.toString());
        productService.save(product);
        return "Product Added Successfully!";
    }

    @GetMapping(value = { "", "/view" })
    public @NotNull
    Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }}
