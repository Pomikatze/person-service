package personservice.mapper;

import common.dto.ProductDto;
import org.springframework.stereotype.Component;
import personservice.model.ProductEntity;
import personservice.service.CategoryService;
import personservice.service.ProductService;

@Component
public class ProductMapper implements CustomMapper<ProductDto, ProductEntity> {

    ProductService productService;
    CategoryService categoryService;

    public ProductMapper(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public ProductDto toDto(ProductEntity entity) {
        ProductDto productDto = new ProductDto();
        productDto.setName(entity.getName());
        productDto.setCategory(categoryService.findCategoryNameById(entity.getCategory()));
        productDto.setComment(entity.getComment());
        return productDto;
    }

    @Override
    public ProductEntity toEntity(ProductDto dto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(null);
        productEntity.setName(dto.getName());
        productEntity.setCategory(productService.findCategoryByProductName(dto.getName()));
        productEntity.setComment(dto.getComment());
        return productEntity;
    }
}
