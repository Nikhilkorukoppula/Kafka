package com.kafka.service;

import com.kafka.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    Logger log= LoggerFactory.getLogger(KafkaConsumerService.class);
//    @KafkaListener(topics = "Nikhil",groupId = "consumer-group")
//    public void consumer(String message){
//        System.out.println("consumed message : "+message);
//    }

    @KafkaListener(topics = "Nikhil-topic",groupId = "object-group")
    public void consumerObject( Employee employee){
        System.out.println("received successfully");
        log.info("Consumer consumes message {} ", employee.toString());
        //System.out.println("consumed message : "+ employee.toString());
    }

}
