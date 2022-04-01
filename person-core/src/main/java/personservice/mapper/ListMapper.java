package personservice.mapper;

import org.springframework.stereotype.Component;
import personservice.dto.ListDto;
import personservice.model.ListEntity;
import personservice.service.ProductService;

@Component
public class ListMapper implements CustomMapper<ListDto, ListEntity> {

    ProductService productService;

    public ListMapper(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ListDto toDto(ListEntity entity) {
        ListDto listDto = new ListDto();
        listDto.setProduct(productService.findById(entity.getProduct()).getName());
        listDto.setCount(entity.getCount());
        return listDto;
    }

    @Override
    public ListEntity toEntity(ListDto dto) throws RuntimeException{
        ListEntity listEntity = new ListEntity();
        listEntity.setId(null);
        if (productService.findIdByName(dto.getProduct()) == null){
            throw new RuntimeException("некорректное имя");
        } else {
            listEntity.setProduct(productService.findIdByName(dto.getProduct()));
        }
        listEntity.setCount(dto.getCount());
        return listEntity;
    }
}
