package personservice.model;

import lombok.Data;

import java.time.LocalDate;

//TODO: доделать логирование

@Data
public class Log {

    private Long id;

    private String operation;

    private String person;

    private LocalDate logDt;
}
