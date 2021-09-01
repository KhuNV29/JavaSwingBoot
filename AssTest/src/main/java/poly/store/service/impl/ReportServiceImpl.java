package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.OrderDAO;
import poly.store.entity.ReportAccount;
import poly.store.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
	@Autowired
	OrderDAO orDao;
	@Override
	public List<ReportAccount> getReportAccount() {
		// TODO Auto-generated method stub
		return orDao.getReportAccount();
	}

}
