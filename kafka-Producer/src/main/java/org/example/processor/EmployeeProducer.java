package org.example.processor;

import org.example.model.EmployeeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class EmployeeProducer {

    @Autowired
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EmployeeProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

public void produceEmployee(EmployeeEvent employeeEvent) {
        try {
            kafkaTemplate.send("employee-event-topic",employeeEvent.getId().toString(), employeeEvent.toString());

            System.out.println("Message send successfully to topic employee-event-topic");
        }
        catch (Exception e)
        {
            System.err.println("Exception occurred:"+e.getMessage());
        }
}
}
