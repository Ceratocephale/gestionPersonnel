package mqs;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    private final RabbitTemplate userTemplate;
    

    public Sender(@Qualifier("userRabbitTemplate") RabbitTemplate userTemplate) {
        this.userTemplate = userTemplate;
    }

    public void send(String user) {
        this.userTemplate.convertAndSend("user", "", user);
    }
}
