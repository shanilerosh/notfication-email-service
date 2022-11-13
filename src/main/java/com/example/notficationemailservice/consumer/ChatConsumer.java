package com.example.notficationemailservice.consumer;

import dto.ChatNotificationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author ShanilErosh
 */
@Component
@RequiredArgsConstructor
public class ChatConsumer {

    private final SimpMessagingTemplate template;

    @RabbitListener(queues = {"${queue.name-email}"})
    public void consumeEmailQue(final ChatNotificationDto chatNotificationDto) {
        this.template.convertAndSend("/message",  chatNotificationDto);
    }
}
