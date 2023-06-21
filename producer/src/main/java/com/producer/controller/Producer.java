package com.producer.controller;

import com.producer.model.Message;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    DirectExchange exchange;

    @Autowired
    FanoutExchange fanoutExchange;

    @PostMapping("/send")
    public String send(@RequestBody Message message) {
        rabbitTemplate.convertAndSend(exchange.getName(), "routing.A", message);
        return "Message sent successfully";
    }

    @PostMapping("/fanout/send")
    public String fanoutSend(@RequestBody Message message) {
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", message);
        return "Message sent successfully";
    }
}
