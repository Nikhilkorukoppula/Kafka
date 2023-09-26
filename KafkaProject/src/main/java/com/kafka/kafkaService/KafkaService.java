package com.kafka.kafkaService;

import com.kafka.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,Object>template;

    public void sendMessageToPublisher(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("Nikhil", message);
        System.out.println(message);

        future.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println("message :"+message+" with offset :"+result.getRecordMetadata().offset());
            }
            else{
                System.out.println("unable to send data : "+ex.getMessage());
            }
        });
    }

    public void sendObjectToPublisher(Employee employee){
        CompletableFuture<SendResult<String, Object>> future = template.send("Nikhil-topic", employee);

        future.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println("message :"+employee.toString()+" with offset :"+result.getRecordMetadata().offset());
            }
            else{
                System.out.println("unable to send data : "+ex.getMessage());
            }
        });
    }
}
