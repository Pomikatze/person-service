package personservice.model;

import lombok.Data;

//пролукты

@Data
public class ProductEntity {

    private Long id;

    private String name;

    private Long category;

    private String comment;
}
