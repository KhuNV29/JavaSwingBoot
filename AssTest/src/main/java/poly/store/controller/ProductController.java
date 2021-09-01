package poly.store.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.store.dao.CategoryDAO;
import poly.store.dao.ProductDAO;
import poly.store.entity.Category;
import poly.store.entity.Product;
import poly.store.service.ProductService;

@Controller
public class ProductController {
	@Autowired 
	HttpSession session;
	@Autowired
	ProductDAO pdao;
	@Autowired
	CategoryDAO cdao;
	@Autowired
	ProductService productService;
	@RequestMapping("/product/list1")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
//		if(cid.isPresent()) {
//			List<Product> list = productService.findByCategoryId(cid.get());
//			model.addAttribute("items", list);
//		}else {
//			List<Product> list = productService.findAll();
//			model.addAttribute("items", list);
//		}
//		return "product/list";
		if (cid.isPresent()) {
			Pageable pageable = PageRequest.of(0, 12);
			Page<Product> product = pdao.findIdByKeywords(cid.get(), pageable);
			model.addAttribute("items", product);
		} else {
			Pageable pageable = PageRequest.of(0, 12);
			Page<Product> product = pdao.findAll(pageable);
			model.addAttribute("items", product);
		}
		return "product/list";
	}
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product item =productService.findById(id);
		model.addAttribute("item", item);
		return "product/detail";
	}
	@RequestMapping("/product/search")
		public String Search(Model model, @RequestParam("keyword") String kw, @RequestParam("page") Optional<Integer> p) {
			try {
				session.setAttribute("keywords", kw);
				Pageable pageable = PageRequest.of(p.orElse(0), 12);
				Page<Product> page = pdao.findByKeywords("%" + kw + "%", pageable);
				model.addAttribute("items", page);
				List<Category> category = cdao.findAll();
				model.addAttribute("cates", category);
			} catch (Exception e) {
				System.out.println(e);
			}
			return "product/list";
		}

}
