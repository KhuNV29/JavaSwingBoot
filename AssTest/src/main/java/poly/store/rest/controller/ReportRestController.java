package poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.store.dao.OrderDAO;
import poly.store.dao.OrderDetailDAO;
import poly.store.entity.Dashboard;
import poly.store.entity.ReportAccount;
import poly.store.entity.ReportProduct;
import poly.store.service.ReportService;

@CrossOrigin("*")
@RestController
public class ReportRestController {
	@Autowired
	ReportService reportService;
	@Autowired
	OrderDAO orDAO;
	@Autowired
	OrderDetailDAO ordtDAO;
	
	@GetMapping("/rest/reportsAccount")
	public List<ReportAccount> getReportAccount() {
		List<ReportAccount> a = orDAO.getReportAccount();
		return a;
		
	}
	@GetMapping("/rest/reportsProduct")
	public List<ReportProduct> getReportProduct() {
		List<ReportProduct> p = ordtDAO.getReportProduct();
		return p;
		
	}
	@GetMapping("/rest/dashboard")
	public List<Dashboard> getDashboard() {
		List<Dashboard> p = ordtDAO.getDashboard();
		return p;
		
	}

}
