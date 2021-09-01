package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.CategoryDAO;
import poly.store.entity.Category;
import poly.store.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO dao;

	@Override
	public List<Category> findAll() {
		return dao.findAll();
	}

	@Override
	public Category creat(Category category) {
		// TODO Auto-generated method stub
		return dao.save(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return dao.save(category);
	}

	@Override
	public void delete(String id) {
		dao.deleteById(id);
		
	}
	
	

}
