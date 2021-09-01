package poly.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.store.entity.Dashboard;
import poly.store.entity.OrderDetail;
import poly.store.entity.ReportProduct;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{
	
	@Query("SELECT new ReportProduct(o.product.id,o.product.name,o.product.price, SUM(o.quantity)) FROM OrderDetail o "
			+ "GROUP BY o.product.id,o.product.name,o.product.price "
			+ "ORDER BY SUM(o.quantity) DESC")
	List<ReportProduct> getReportProduct();
	
	@Query("SELECT new Dashboard(YEAR(o.order.createDate), SUM(o.price * o.quantity)) FROM OrderDetail o "
			+ "GROUP BY YEAR(o.order.createDate) "
			+ "ORDER BY SUM(o.price * o.quantity)")
	List<Dashboard> getDashboard();
	

}
