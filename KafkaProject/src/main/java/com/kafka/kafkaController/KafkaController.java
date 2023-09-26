package com.kafka.kafkaController;

import com.kafka.entity.Employee;
import com.kafka.kafkaService.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaService service;

    @PostMapping("send-message/{message}")
    public ResponseEntity<?> sendMessage(@PathVariable String message){
        service.sendMessageToPublisher(message);
        return ResponseEntity.ok("Sent successfully");
    }

    @PostMapping("send-object")
    public ResponseEntity<?> sendObject(@RequestBody Employee employee){
        System.out.println(employee.toString());
        service.sendObjectToPublisher(employee);
        return ResponseEntity.ok("Object sent successfully");
    }
}
