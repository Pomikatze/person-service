package personservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import personservice.model.CategoryEntity;

@Mapper
public interface CategoryRepository {

    @Select("select * from category where id = #{categoryId}")
    CategoryEntity getById (Long categoryId);

    @Select("select name from category where id = #{categoryId}")
    String getCategoryNameById (Long categoryId);

    @Select("select id from category where name = #{categoryName}")
    Long getIdByName (String categoryName);
}
