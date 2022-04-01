package personservice.mapper;

import common.dto.CategoryDto;
import org.springframework.stereotype.Component;
import personservice.model.CategoryEntity;

@Component
public class CategoryMapper implements CustomMapper<CategoryDto, CategoryEntity> {

    @Override
    public CategoryDto toDto(CategoryEntity entity) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(entity.getName());
        categoryDto.setComment(entity.getComment());
        return categoryDto;
    }

    @Override
    public CategoryEntity toEntity(CategoryDto dto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(null);
        categoryEntity.setName(dto.getName());
        categoryEntity.setComment(dto.getComment());
        return categoryEntity;
    }
}
