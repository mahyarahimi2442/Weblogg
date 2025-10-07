
    package ir.ac.weblogg.controller;
import ir.ac.weblogg.dto.category.CategoryDto;
import ir.ac.weblogg.dto.category.CategorySaveDto;
import ir.ac.weblogg.dto.SaveDto;
import ir.ac.weblogg.service.Category.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping("/categories")
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    public class CategoryController {

        private final CategoryService categoryService;

        public CategoryController(CategoryService categoryService) {
            this.categoryService = categoryService;
        }

        @PostMapping
        public ResponseEntity<CategoryDto> save(@Valid @RequestBody CategorySaveDto categorySaveDto) {
            CategoryDto categoryDto = categoryService.save(categorySaveDto);
            return ResponseEntity.ok(categoryDto);
        }


        @GetMapping
        public ResponseEntity<List<CategoryDto>> findAll() {
            List<CategoryDto> categories = categoryService.findAll();
            return ResponseEntity.ok(categories);
        }


        @GetMapping("/{id}")
        public ResponseEntity<CategoryDto> findById(@PathVariable int id) {
            CategoryDto categoryDto = categoryService.findById(id);
            return ResponseEntity.ok(categoryDto);
        }


        @PutMapping("/{id}")
        public ResponseEntity<CategoryDto> update(@PathVariable int id,
                                                  @Valid @RequestBody CategorySaveDto categorySaveDto) {
            CategoryDto categoryDto = categoryService.update(id, categorySaveDto);
            return ResponseEntity.ok(categoryDto);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<SaveDto> delete(@PathVariable int id) {
            categoryService.delete(id);
            return ResponseEntity.ok(new SaveDto(id));
        }
    }

