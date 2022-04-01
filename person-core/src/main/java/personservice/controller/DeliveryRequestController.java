package personservice.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import personservice.dto.DeliveryRequestDto;
import personservice.mapper.DeliveryRequestMapper;
import personservice.model.DeliveryRequestEntity;
import personservice.rabbitMQ.controller.MessageController;
import personservice.service.DeliveryRequestService;

import java.net.http.HttpRequest;
import java.util.List;

/**
 * На фронте составляется таблица с необходимыми товарами и
 * составляется заявка на поставку
 * @save - на эндпоинт поступает заявка, сохраняется в БД и отправляет на склад через RabbitMQ
 */

@RestController
@Validated
@RequestMapping("/delivery")
public class DeliveryRequestController {

    DeliveryRequestService deliveryRequestService;
    DeliveryRequestMapper deliveryRequestMapper;
    MessageController messageController;

    public DeliveryRequestController(MessageController messageController,
                                     DeliveryRequestService deliveryRequestService,
                                     DeliveryRequestMapper deliveryRequestMapper) {
        this.deliveryRequestService = deliveryRequestService;
        this.deliveryRequestMapper = deliveryRequestMapper;
        this.messageController = messageController;
    }

    @GetMapping("/")
    List<DeliveryRequestEntity> findAll (){
        return deliveryRequestService.findAll();
    }

    @PostMapping("/save")
    ResponseEntity<DeliveryRequestDto> save (@RequestBody DeliveryRequestDto deliveryRequestDto){
        DeliveryRequestEntity deliveryRequestEntity = deliveryRequestMapper.toEntity(deliveryRequestDto);
        deliveryRequestService.save(deliveryRequestEntity);
        messageController.send(deliveryRequestEntity);
        return ResponseEntity.ok(deliveryRequestDto);
    }
}
