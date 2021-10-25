package products.and.categories.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import products.and.categories.mvc.models.Category;
import products.and.categories.mvc.models.Product;
import products.and.categories.mvc.services.CategoryService;
import products.and.categories.mvc.services.ProductService;

@Controller
public class CategoriesController {
	private final CategoryService serv;
	private final ProductService prodserv;
	 
	 public CategoriesController(CategoryService serv, ProductService prodserv) {
	     this.serv = serv;
	     this.prodserv = prodserv;
	     }
	 
	 @RequestMapping("/categories/new")
	 public String newcategory(@ModelAttribute("category") Category category,Model model) {
	     return "/categories/new.jsp";

	 }
	 
	 @RequestMapping(value="/categories", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/categories/new.jsp";
	     } else {
	         serv.createCategory(category);
	         return "redirect:/categories/new";
	     }
	 }
	 
	 @RequestMapping("/categories/{id}")
	 public String getcategory(@PathVariable("id") Long id, 
			 Model model) {
		 Category category = serv.findCategory(id);
		 List<Product> products_category = category.getProducts();
		 List<Product> products_all = prodserv.findOtherProd(category);
		 model.addAttribute("category",category);
		 model.addAttribute("products_category",products_category);
		 model.addAttribute("products_all",products_all); 
	     return "/categories/show.jsp";

	 } 
	 
	 @RequestMapping(value="/categories/{id}/addProduct", method=RequestMethod.POST)
	 public String create(@PathVariable("id") Long id, @RequestParam (value="product_id") Long product_id) {
	     Category category = serv.findCategory(id);
	     Product product = prodserv.findProduct(product_id);
	     category.getProducts().add(product);
	     serv.createCategory(category);
		return String.format("redirect:/categories/%d",id); 
		 
	 }
	 
	 
}
