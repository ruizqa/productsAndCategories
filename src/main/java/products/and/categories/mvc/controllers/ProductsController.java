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
public class ProductsController {
	private final ProductService serv;
	private final CategoryService catserv;
	 
	 public ProductsController(ProductService serv, CategoryService catserv) {
	     this.serv = serv;
	     this.catserv = catserv;
	     }
	 
	 @RequestMapping("/products/new")
	 public String newproduct(@ModelAttribute("product") Product product,Model model) {
	     return "/products/new.jsp";

	 }
	 
	 @RequestMapping(value="/products", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/products/new.jsp";
	     } else {
	         serv.createProduct(product);
	         return "redirect:/products/new";
	     }
	 }
	 
	 @RequestMapping("/products/{id}")
	 public String newproduct(@PathVariable("id") Long id, 
			 Model model) {
		 Product product = serv.findProduct(id);
		 List<Category> categories_product = product.getCategories();
		 List<Category> categories_all = catserv.findOtherCat(product);
		 model.addAttribute("categories_all",categories_all);
		 model.addAttribute("categories_product",categories_product);
		 model.addAttribute("product",product); 
	     return "/products/show.jsp";

	 } 
	 
	 @RequestMapping(value="/products/{id}/addCategory", method=RequestMethod.POST)
	 public String create(@PathVariable("id") Long id, @RequestParam (value="category_id") Long category_id) {
	     Product product = serv.findProduct(id);
	     Category category = catserv.findCategory(category_id);
	     product.getCategories().add(category);
	     serv.createProduct(product);
		return String.format("redirect:/products/%d",id); 
		 
	 }
	 
	 
}
