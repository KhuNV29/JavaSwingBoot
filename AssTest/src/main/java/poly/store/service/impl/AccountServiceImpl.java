package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.AccountDAO;
import poly.store.entity.Account;
import poly.store.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDAO dao;

	@Override
	public Account findById(String username) {
		return dao.findById(username).get();
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Account> getAdministrators() {
		return dao.getAdministrators();
	}

	@Override
	public Account creat(Account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}

	@Override
	public void delete(String username) {
		dao.deleteById(username);
		
	}
	
	
}
