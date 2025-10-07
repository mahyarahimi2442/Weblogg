package ir.ac.weblogg.dto.category;

import ir.ac.weblogg.model.Category;
import jakarta.validation.constraints.NotBlank;


public class CategorySaveDto {
    private final String name;

    public CategorySaveDto(String name) {
        this.name = name;
    }

    @NotBlank(message = "category.save.dto.name.blank")
    public String getName() {
        return name;
    }

    public Category convertToCategory() {
        Category category = new Category();
        category.setName(name);
        return category;
    }
}
