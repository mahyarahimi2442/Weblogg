package ir.ac.weblogg.service.Category;

import ir.ac.weblogg.dto.CategoryDto;
import ir.ac.weblogg.model.Category;

import java.util.List;

public interface CategoryService {
   void save(Category category);
   List<Category> findAll(int id);
   Category findById(int id);
   void delete(int id);

}
