package personservice.service;

import org.springframework.stereotype.Service;
import personservice.model.CategoryEntity;
import personservice.repository.CategoryRepository;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity findById (Long id){
        return categoryRepository.getById(id);
    }

    public String findCategoryNameById (Long id){
        return categoryRepository.getCategoryNameById(id);
    }

    public Long findIdByCategoryName (String name){
        return categoryRepository.getIdByName(name);
    }
}
