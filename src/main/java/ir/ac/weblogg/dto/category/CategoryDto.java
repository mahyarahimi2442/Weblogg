package ir.ac.weblogg.dto.category;
import ir.ac.weblogg.model.Category;

public class CategoryDto {

    private final int id;
    private final String name;

    public CategoryDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public static CategoryDto convertToDto(Category category) {

        return new CategoryDto(category.getId(), category.getName());
    }
}

