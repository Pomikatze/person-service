package personservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import personservice.model.ListEntity;

import java.util.List;

@Mapper
public interface ListRepository {

    @Select("select * from list")
    List<ListEntity> getAll();

    @Select("select * from list where id = #{listId}")
    ListEntity getById (Long listId);

    @Select("select id from list where number = #{listNumber}")
    Long getIdByNumber (Long listNumber);

    @Select("select * from list where number = #{number}")
    List<ListEntity> getAllByNumber (Long number);

    int insertAll (@Param("listList") List<ListEntity> list);
}
