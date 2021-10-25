package products.and.categories.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import products.and.categories.mvc.models.Category;
import products.and.categories.mvc.models.Product;
import products.and.categories.mvc.repositories.ProductRepository;



@Service 
public class ProductService {
private final ProductRepository repo;
    
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }
 
    public List<Product> allProducts() {
        return repo.findAll();
    }
    
    public Product createProduct(Product p) {
        return repo.save(p);
    }
    
    public Product findProduct(Long id) {
        Optional<Product> opProduct = repo.findById(id);
        if(opProduct.isPresent()) {
            return opProduct.get();
        } else {
            return null;
        }
    }
    
    public Product updateProduct(Long id, String name, String description, float price) {    	
    	Product p = new Product (id, name, description, price);
        return repo.save(p);
    }
    
 
    public Product updateProduct(Product p) {
        return repo.save(p);
    }
    
 
    public void deleteProduct(Long id) {
        Optional<Product> optionalProd = repo.findById(id);
        if(optionalProd.isPresent()) {
            repo.deleteById(id);
        } 
    }
	
    public Product addCategory(Product p, Category c) {
        p.getCategories().add(c);
    	return repo.save(p);
    }
    
    public List<Product> findOtherProd(Category c){
    	return repo.findByCategoriesNotContains(c);
    }
	
	
}
