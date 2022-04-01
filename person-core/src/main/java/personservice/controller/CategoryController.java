package personservice.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personservice.model.CategoryEntity;
import personservice.service.CategoryService;


@RestController
@Validated
@RequestMapping("/category")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    CategoryEntity findAll (@PathVariable Long id){
        return categoryService.findById(id);
    }
}
