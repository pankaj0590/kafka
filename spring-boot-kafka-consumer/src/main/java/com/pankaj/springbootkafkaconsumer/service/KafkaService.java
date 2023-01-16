package com.pankaj.springbootkafkaconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @KafkaListener(topics = "products",
            groupId = "id")
    public void publish(String message)
    {
        System.out.println("You have a new message: " + message);
    }
}
