package personservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import personservice.model.UserEntity;

import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("select * from public.user where name = #{UserName}")
    Optional<UserEntity> findByUserName (String userName);
}
