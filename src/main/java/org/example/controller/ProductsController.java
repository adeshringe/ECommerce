package org.example.controller;

import org.example.entity.Products;
import org.example.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody Products product){
        return ResponseEntity.ok(productsService.addProduct(product));
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity getProductById(@PathVariable String productId){

        if(productId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(productsService.getProductById(productId));
    }

    @GetMapping("/get")
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok(productsService.getAllProducts());
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity updateProduct(@PathVariable String productId, @RequestBody Products product){

        if(productId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(productsService.updateProduct(productId, product));
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity deleteProduct(@PathVariable String productId){

        if(productId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            productsService.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
