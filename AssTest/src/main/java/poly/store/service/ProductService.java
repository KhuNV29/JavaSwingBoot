package poly.store.service;

import java.util.List;

import poly.store.entity.Product;

public interface ProductService {
	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

	Product creat(Product product);

	Product update(Product product);

	void delete(Integer id);
	
}