package personservice.model;

import lombok.Data;

//категории товаров

@Data
public class CategoryEntity {

    private Long id;

    private String name;

    private String comment;
}
