package personservice.model;

import lombok.Data;

//Список товаров необходимых магазину. Прикреплён к заявке на поставку

@Data
public class ListEntity {

    private Long id;

    private Long product;

    private Long count;

    private Long number;
}
