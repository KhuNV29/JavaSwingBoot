package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.ProductDAO;
import poly.store.entity.Product;
import poly.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO dao;
	@Override
	public List<Product> findAll(){
		return dao.findAll();
	}
	@Override
	public Product findById(Integer id) {
		return dao.findById(id).get();
	}
	@Override
	public List<Product> findByCategoryId(String cid) {
		return dao.findByCategoryId(cid);
	}
	@Override
	public Product creat(Product product) {
		// TODO Auto-generated method stub
		return dao.save(product);
	}
	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return dao.save(product);
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);;
	}

}
