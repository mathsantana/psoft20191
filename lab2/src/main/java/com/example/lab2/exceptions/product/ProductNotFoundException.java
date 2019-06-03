package com.example.lab2.exceptions.product;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

   public ProductNotFoundException(String msg) {
       super(msg);
   }

}
