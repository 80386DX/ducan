package com.boki.ducan.controller;
import com.boki.ducan.exception.ResourceNotFoundException;
import com.boki.ducan.model.Product;
import com.boki.ducan.service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    ProductService service;
    
    @GetMapping
    public List <Product> getAllProducts() {
        return service.listAll();
    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "productId")Integer id) throws ResourceNotFoundException{
        return service.getProductById(id);
    }
    
    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable(value = "productId") Integer id)throws ResourceNotFoundException{
        Product updatedProduct = service.getProductById(id);
        updatedProduct.setName(product.getName());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setCategory(product.getCategory());
        
        return service.saveProduct(updatedProduct);
    }
}
