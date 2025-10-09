package ir.ac.weblogg.service.Category;

import ir.ac.weblogg.customExeption.RuleException;
import ir.ac.weblogg.dto.category.CategoryDto;
import ir.ac.weblogg.dto.category.CategorySaveDto;
import ir.ac.weblogg.model.Category;
import ir.ac.weblogg.Repasitory.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategorySaveDto categorySaveDto) {
        Category category = categorySaveDto.convertToCategory();
        categoryRepository.save(category);
        return CategoryDto.convertToDto(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("category.not.found"));
        return CategoryDto.convertToDto(category);
    }

    @Override
    public CategoryDto update(int id, CategorySaveDto categorySaveDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("category.not.found"));

        category.setName(categorySaveDto.getName());
        categoryRepository.save(category);
        return CategoryDto.convertToDto(category);
    }

    @Override
    public void delete(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("category.not.found"));
        categoryRepository.delete(category);
    }

    @Override
    public Optional<Category> findEntityById(int id) {
        return categoryRepository.findById(id);
    }
}