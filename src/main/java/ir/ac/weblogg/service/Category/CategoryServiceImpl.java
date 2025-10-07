package ir.ac.weblogg.service.Category;

import ir.ac.weblogg.Repasitory.CategoryRepository;
import ir.ac.weblogg.customExeption.RuleException;
import ir.ac.weblogg.dto.CategoryDto;
import ir.ac.weblogg.model.Category;

import java.time.LocalDateTime;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
       categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll(int id) {
        return  categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(()->new RuleException("category.not.found"));
    }


    @Override
    public void delete(int id) {
        Category category  = categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("exam.not.found"));
        categoryRepository.save(category);

    }
}
