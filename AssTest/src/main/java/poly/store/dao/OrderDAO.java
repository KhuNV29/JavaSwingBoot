package poly.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.store.entity.Order;
import poly.store.entity.ReportAccount;
public interface OrderDAO extends JpaRepository<Order, Long>{
	@Query("SELECT o FROM Order o Where o.account.username=?1")
	List<Order> findByUsername(String username);
	
	@Query("SELECT new ReportAccount(o.account.username,o.account.fullname,o.account.email, COUNT(o.id) ) FROM Order o "
			+ "GROUP BY o.account.username,o.account.fullname,o.account.email "
			+ "ORDER BY COUNT(o.id) DESC")
	List<ReportAccount> getReportAccount();
	
	@Query("SELECT o FROM Order o WHERE o.status=1")
	List<Order> getUnresolved();
	
	@Query("SELECT o FROM Order o WHERE o.status=2")
	List<Order> getProcessing();
	
	@Query("SELECT o FROM Order o WHERE o.status=3")
	List<Order> getProcessed();
	
	@Query("SELECT o FROM Order o WHERE o.status=4")
	List<Order> getCompleted();
	


	
	
	


}
