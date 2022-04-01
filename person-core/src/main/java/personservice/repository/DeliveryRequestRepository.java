package personservice.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import personservice.model.DeliveryRequestEntity;

import java.util.List;

@Mapper
public interface DeliveryRequestRepository {

    @Select("select * from delivery_request")
    List<DeliveryRequestEntity> getAll ();

    @Insert("insert into delivery_request value (#{deliveryRequest.id}, #{deliveryRequest.status}," +
            " #{deliveryRequest.store}, #{deliveryRequest.requestDt}, #{deliveryRequest.list})")
    DeliveryRequestEntity save(DeliveryRequestEntity deliveryRequest);

    @Update("update delivery_request set status = #{status} where list = #{listNumber}")
    void updateStatus (Long listNumber, String status);
}
