package personservice.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import personservice.model.ProductEntity;

@Mapper
public interface ProductRepository {

    @Select("select * from product where id = #{productId}")
    ProductEntity getById (Long productId);

    @Select("select category from product where name = #{productName}")
    Long getCategoryByProductName (String productName);

    @Select("select name from product where id = #{productId}")
    String getProductNameById (Long productId);

    @Select("select id from product where name = #{productName}")
    Long getIdByName (String productName);

    ProductEntity updateById (ProductEntity productEntity);

    @Delete("delete from product where id = #{productId}")
    Boolean deleteById (Long productId);

    @Select("select category from product where name = #{productId}")
    Long getCategoryById(Long productId);
}
