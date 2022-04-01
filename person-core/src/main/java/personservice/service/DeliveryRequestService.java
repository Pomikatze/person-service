package personservice.service;

import org.springframework.stereotype.Service;
import personservice.model.DeliveryRequestEntity;
import personservice.repository.DeliveryRequestRepository;

import java.util.List;

@Service
public class DeliveryRequestService {

    DeliveryRequestRepository deliveryRequestRepository;

    public DeliveryRequestService(DeliveryRequestRepository deliveryRequestRepository) {
        this.deliveryRequestRepository = deliveryRequestRepository;
    }

    public List<DeliveryRequestEntity> findAll (){
        return deliveryRequestRepository.getAll();
    }

    public DeliveryRequestEntity save (DeliveryRequestEntity deliveryRequest){
        return deliveryRequestRepository.save(deliveryRequest);
    }

    public void updateStatus (Long listNumber, String status){
        deliveryRequestRepository.updateStatus(listNumber, status);
    }
}
