package personservice.rabbitMQ.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import personservice.dto.DeliveryRequestDto;
import personservice.model.DeliveryRequestEntity;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class MessageController {

    Logger logger = LoggerFactory.getLogger(MessageController.class);
    String hostname = "Unknown";

    private final AmqpTemplate template;

    @Autowired
    public MessageController(AmqpTemplate template) {
        this.template = template;
    }

    @PostMapping("/rabbit/send")
    public ResponseEntity<String> send(@RequestBody DeliveryRequestEntity message) {
        logger.info("Sending to person-service");
        template.convertAndSend("person-service", message);

        try {
            InetAddress address;
            address = InetAddress.getLocalHost();
            hostname = address.getHostName();

        } catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }

        return ResponseEntity.ok(hostname + ": " + "Success sent to queue");
    }
}
