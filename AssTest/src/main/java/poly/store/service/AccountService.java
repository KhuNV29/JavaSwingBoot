package poly.store.service;

import java.util.List;

import poly.store.entity.Account;

public interface AccountService {
	List<Account> findAll();
	Account findById(String username);
	List<Account> getAdministrators();
	Account creat(Account account);
	Account update(Account account);
	void delete(String username);
}
