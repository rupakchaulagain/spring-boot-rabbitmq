//package com.producer.configuration;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfiguration {
//
//    public static String ROUTING_A = "routing.A";
//    public static String ROUTING_B = "routing.B";
//
//    //create a queue
//    @Bean
//    Queue queueA() {
//        return new Queue("queue.A", false);
//    }
//
//    @Bean
//    Queue queueB() {
//        return new Queue("queue.B", false);
//    }
//
//
//    //direct exchange
//    @Bean
//    DirectExchange exchange() {
//        return new DirectExchange("exchange.direct");
//    }
//
//    @Bean
//    Binding binding(Queue queueA, DirectExchange exchange) {
//        return BindingBuilder.bind(queueA).to(exchange).with(ROUTING_A);
//    }
//
//    @Bean
//    Binding bindingB(Queue queueB, DirectExchange exchange) {
//        return BindingBuilder.bind(queueB).to(exchange)
//                .with(ROUTING_B);
//    }
//
//    @Bean
//    MessageConverter messageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(messageConverter());
//
//        return rabbitTemplate;
//    }
//}