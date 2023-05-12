package net.project.kafkaconsumer.kafka;

import net.project.basedomain.entities.EntitiesRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PliConcumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PliConcumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            , groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(EntitiesRequest entitiesRequest){
        LOGGER.info(String.format("Order event received in stock service => %s", entitiesRequest.toString()));


    }
}
