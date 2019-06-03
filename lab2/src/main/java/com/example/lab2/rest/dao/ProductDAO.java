package com.example.lab2.rest.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lab2.rest.model.Product;

@Repository
public interface ProductDAO<T, ID extends Serializable> extends JpaRepository<Product, Long> {

   Product save(Product product);

   Product findById(long id);

}
