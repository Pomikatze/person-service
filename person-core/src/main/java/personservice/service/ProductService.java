package personservice.service;

import org.springframework.stereotype.Service;
import personservice.model.ProductEntity;
import personservice.repository.ProductRepository;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity findById (Long id){
        return productRepository.getById(id);
    }

    public Long findCategoryByProductName (String name){
        return productRepository.getCategoryByProductName(name);
    }

    public String findNameById (Long id){
        return productRepository.getProductNameById(id);
    }

    public Long findIdByName (String name){
        return productRepository.getIdByName(name);
    }

    public Boolean deleteById (Long id){
        return productRepository.deleteById(id);
    }

    public ProductEntity updateProduct (ProductEntity productEntity){
        return productRepository.updateById(productEntity);
    }

    public Long findCategoryById (Long id){
        return productRepository.getCategoryById(id);
    }
}
