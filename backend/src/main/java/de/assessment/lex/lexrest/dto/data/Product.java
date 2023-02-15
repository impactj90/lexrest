package de.assessment.lex.lexrest.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id private String id;
    @NonNull private String EAN;
    @NonNull private String name;
    @NonNull private String description;
    @NonNull private String producer;
    @NonNull private String category;

    public Product(@NonNull String EAN,
                   @NonNull String name,
                   @NonNull String description,
                   @NonNull String producer,
                   @NonNull String category) {
        this.EAN = EAN;
        this.name = name;
        this.description = description;
        this.producer = producer;
        this.category = category;
    }

}
