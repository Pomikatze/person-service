package personservice.model;

import lombok.Data;

import java.time.LocalDate;

//Заявка на поставку из магазина

@Data
public class DeliveryRequestEntity {

    private Long id;

    private String status;

    private String store;

    private LocalDate requestDt;

    private Long list;
}
