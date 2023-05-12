package net.project.kafkaproducer.kafka;

import net.project.basedomain.entities.Client;
import net.project.basedomain.entities.EntitiesRequest;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ClientProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientProducer.class);

    private NewTopic topic;

    private KafkaTemplate<String, EntitiesRequest> kafkaTemplate;

    public ClientProducer(NewTopic topic, KafkaTemplate<String, EntitiesRequest> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(EntitiesRequest entitiesRequest){
        LOGGER.info(String.format("Order event => %s", entitiesRequest.toString()));

        //create message
        Message<EntitiesRequest> message = MessageBuilder
                .withPayload(entitiesRequest)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}
