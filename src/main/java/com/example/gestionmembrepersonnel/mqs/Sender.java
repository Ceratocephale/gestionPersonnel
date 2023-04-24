package com.example.gestionmembrepersonnel.mqs;

import com.example.gestionmembrepersonnel.models.entity.Person;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    private final RabbitTemplate personTemplate;


    public Sender(@Qualifier("personRabbitTemplate") RabbitTemplate personTemplate) {
        this.personTemplate = personTemplate;
    }

    public void send(Person person) {
        this.personTemplate.convertAndSend("person", "", person);
    }
}
