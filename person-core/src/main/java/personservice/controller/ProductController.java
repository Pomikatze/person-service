package personservice.controller;

import common.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import personservice.mapper.ProductMapper;
import personservice.model.ProductEntity;
import personservice.service.ProductService;

@Validated
@RestController
@RequestMapping("/admin/product")
public class ProductController {

    ProductMapper productMapper;
    ProductService productService;

    @Autowired
    public ProductController(ProductMapper productMapper, ProductService productService) {
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @GetMapping("/{id}")
    ProductEntity getOneById (@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("/dto/{id}")
    ProductDto getOneDtoById (@PathVariable Long id){
        return productMapper.toDto(productService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Boolean> deleteByid (@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteById(id));
    }

    @PutMapping("/update")
    ProductEntity updateProduct (@RequestBody ProductEntity productEntity){
        return productService.updateProduct(productEntity);
    }
}
