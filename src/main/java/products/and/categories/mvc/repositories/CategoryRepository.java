package products.and.categories.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import products.and.categories.mvc.models.Category;
import products.and.categories.mvc.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	Optional <Category> findById(Long id);
	List<Category> findByProductsNotContains(Product product);
}
