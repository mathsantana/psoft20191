package com.example.lab2.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lab2.exceptions.product.ProductNotFoundException;
import com.example.lab2.rest.dao.ProductDAO;
import com.example.lab2.rest.model.Product;

@Service
public class ProductService {

	private final ProductDAO productDAO;

	ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public Product create(Product product) {
		return productDAO.save(product);
	}

	public Product update(Product productToUpdate) throws ProductNotFoundException {
		Product product = productDAO.findById(productToUpdate.getId());
		if (product == null)
			throw new ProductNotFoundException("Could not update. The product does not exist.");

		return productDAO.save(productToUpdate);
	}

	public void delete(long id) {
		productDAO.deleteById(id);
	}

	public Product findById(long id) {
		return productDAO.findById(id);
	}

	public List<Product> findAll() {
		return productDAO.findAll();
	}

	public Product partialUpdate(Product product) {
		
		Product productToUpdate = this.productDAO.findById(product.getId());
		
		if (productToUpdate == null) 
			throw new ProductNotFoundException("O produto não está cadastrado");
		
		if (product.getName() != null) { productToUpdate.setName(product.getName()); }
		if (product.getDescription() != null) { productToUpdate.setDescription(product.getDescription()); }
		if (product.getPrice() != 0) { productToUpdate.setPrice(product.getPrice()); }
		
		return productDAO.save(productToUpdate);
	}

}
