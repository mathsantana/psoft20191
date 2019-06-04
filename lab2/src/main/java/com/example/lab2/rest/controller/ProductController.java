package com.example.lab2.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab2.rest.service.ProductService;
import com.example.lab2.exceptions.product.ProductNotFoundException;
import com.example.lab2.rest.model.Product;

@RestController
@RequestMapping({"/v1/products"})
public class ProductController {

   private ProductService productService;
   
   ProductController(ProductService productService) {
       this.productService = productService;
   }
   
   @GetMapping(value = "/{id}")
   @ResponseBody
   public ResponseEntity<Product> findById(@PathVariable long id) {

       Product product = productService.findById(id);

       if (product == null) {
           throw new ProductNotFoundException("Product not found");
       }
       return new ResponseEntity<Product>(product, HttpStatus.OK);
   }
   
   @GetMapping(value = "/")
   @ResponseBody
   public ResponseEntity<List<Product>> findAll() {

       List<Product> listProducts = productService.findAll();

       if (listProducts == null) {
           throw new ProductNotFoundException("Product not found");
       }
       return new ResponseEntity<List<Product>>(listProducts, HttpStatus.OK);
   }
   
   @PostMapping(value = "/")
   @ResponseBody
   public ResponseEntity<Product> create(@RequestBody Product product  ) {

       Product newProduct = productService.create(product);

       if (newProduct == null) {
           //500?!?!
           throw  new InternalError("Something went wrong");
      }

       return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
   }
   
   @DeleteMapping(value = "/{id}")
   public ResponseEntity delete(@PathVariable long id) {

       try {
           productService.delete(id);
           return new ResponseEntity(HttpStatus.OK);
       } catch (Exception e) {
           throw new InternalError("Something went wrong");
       }
   }
   
   @PutMapping(value = "/")
   public ResponseEntity<Product> update(@RequestBody Product product) {

       try {
           Product updated = productService.update(product);
           return new ResponseEntity<>(updated, HttpStatus.OK);
       } catch (Exception e) {
    	   throw  new InternalError("Something went wrong");
       }

   }
   
   @PatchMapping(value = "/{id}")
   @ResponseBody
   public ResponseEntity<Product> partialUpdate(@PathVariable long id, @RequestBody Product product) {
	   try {
		   product.setId(id);
		   Product newProduct = this.productService.partialUpdate(product);
		   return new ResponseEntity<Product>(newProduct, HttpStatus.OK);
	   } catch (Exception e) {
		   throw new InternalError("Your PATCH went wrong!");
	   }
   }
}