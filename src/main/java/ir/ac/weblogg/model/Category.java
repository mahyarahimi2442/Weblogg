package ir.ac.weblogg.model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    private String name;
    private String description;
    private String slug;

    public Category() {}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
