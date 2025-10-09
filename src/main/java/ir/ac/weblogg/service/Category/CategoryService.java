package ir.ac.weblogg.service.Category;

import ir.ac.weblogg.dto.category.CategoryDto;
import ir.ac.weblogg.dto.category.CategorySaveDto;
import ir.ac.weblogg.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {


      CategoryDto save(CategorySaveDto categorySaveDto);

      List<CategoryDto> findAll();

      Category findById(int id);

      CategoryDto update(int id, CategorySaveDto categorySaveDto);

      void delete(int id);

      Optional<Category> findEntityById(int id); // برای ارتباط با PostService
   }


