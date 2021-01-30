package com.example.demo.rabbitmq;

import com.example.demo.entity.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    private final String queueName = "helloQ";

    @RabbitListener(queues = {queueName} )
    public void processMessage(String  orderJsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(orderJsonString, Order.class);
        System.out.println(order);
    }
}
