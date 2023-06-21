package com.consumer.controller;

import com.consumer.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "queue.A")
    public void receiveFromA(String message) {
        log.info("Message received from QUEUE A->{}:" + message);
    }

    @RabbitListener(queues = "queue.B")
    public void receiveFromB(Message message) {
        log.info("Message received from QUEUE B->{}:" + message);
    }
}
