package products.and.categories.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import products.and.categories.mvc.models.Category;
import products.and.categories.mvc.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	Optional <Product> findById(Long id);
	List<Product> findByCategoriesNotContains(Category category);
}
