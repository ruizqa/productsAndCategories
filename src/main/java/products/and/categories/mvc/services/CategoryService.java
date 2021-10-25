package products.and.categories.mvc.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import products.and.categories.mvc.models.Category;
import products.and.categories.mvc.models.Product;
import products.and.categories.mvc.repositories.CategoryRepository;



@Service 
public class CategoryService {
	private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }
 
    public List<Category> allCategories() {
        return repo.findAll();
    }
    
    public Category createCategory(Category c) {
        return repo.save(c);
    }
    
    public Category findCategory(Long id) {
        Optional<Category> opCategory = repo.findById(id);
        if(opCategory.isPresent()) {
            return opCategory.get();
        } else {
            return null;
        }
    }
    
    public Category updateCategory(Long id, String name) {    	
    	Category c = new Category (id,name);
        return repo.save(c);
    }
    
  
    public void deleteCategory(Long id) {
        Optional<Category> optionalCategory = repo.findById(id);
        if(optionalCategory.isPresent()) {
            repo.deleteById(id);
        } 
    }
    
    public List<Category> findOtherCat(Product p){
    	return repo.findByProductsNotContains(p);
    }
    
}
