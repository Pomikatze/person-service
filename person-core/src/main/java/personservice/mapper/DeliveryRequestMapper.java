package personservice.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import personservice.dto.DeliveryRequestDto;
import personservice.model.DeliveryRequestEntity;
import personservice.service.ListServiceImpl;

@Component
@NoArgsConstructor
public class DeliveryRequestMapper implements CustomMapper<DeliveryRequestDto, DeliveryRequestEntity> {

    ListServiceImpl listServiceImpl;
    ListMapper listMapper;

    public DeliveryRequestMapper(ListServiceImpl listServiceImpl, ListMapper listMapper) {
        this.listServiceImpl = listServiceImpl;
        this.listMapper = listMapper;
    }

    @Override
    public DeliveryRequestDto toDto(DeliveryRequestEntity entity) {
        DeliveryRequestDto deliveryRequestDto = new DeliveryRequestDto();
        deliveryRequestDto.setStatus(entity.getStatus());
        deliveryRequestDto.setStore(entity.getStore());
        deliveryRequestDto.setRequest_dt(entity.getRequestDt());
        deliveryRequestDto.setList(entity.getList());
        return deliveryRequestDto;
    }

    @Override
    public DeliveryRequestEntity toEntity(DeliveryRequestDto dto) {
        DeliveryRequestEntity deliveryRequestEntity = new DeliveryRequestEntity();
        deliveryRequestEntity.setId(null);
        deliveryRequestEntity.setStatus(dto.getStatus());
        deliveryRequestEntity.setStore(dto.getStore());
        deliveryRequestEntity.setRequestDt(dto.getRequest_dt());
        deliveryRequestEntity.setList(null);
        return deliveryRequestEntity;
    }
}
