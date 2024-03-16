package org.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Consumer {

    @KafkaListener(topics="employee-event-topic", groupId = "group_id")
    public void listen(String message)
    {
        System.out.println("Receive message"+message);
//        String[] str = message.split(",");
//        System.out.println("Receive message"+str[0]);
    }

//    public ConsumerFactory<String,String> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//
//    }



}
