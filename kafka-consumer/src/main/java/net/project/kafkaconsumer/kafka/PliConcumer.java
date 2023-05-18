package net.project.kafkaconsumer.kafka;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.project.kafkaconsumer.entities.*;
import net.project.kafkaconsumer.repositories.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedHashMap;

@Service
public class PliConcumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PliConcumer.class);
    private final ClientRepository clientRepository;
    private final EvenementRepository evenementRepository;
    private final OffreRepository offreRepository;
    private final PartenaireRepository partenaireRepository;
    private final PliRepository pliRepository;

    @Autowired
    public PliConcumer(ClientRepository clientRepository, EvenementRepository evenementRepository,
                       OffreRepository offreRepository, PartenaireRepository partenaireRepository,
                       PliRepository pliRepository) {
        this.clientRepository = clientRepository;
        this.evenementRepository = evenementRepository;
        this.offreRepository = offreRepository;
        this.partenaireRepository = partenaireRepository;
        this.pliRepository = pliRepository;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            , groupId = "${spring.kafka.consumer.group-id}"
    )
    public void receiveObject(ConsumerRecord<?, ?> message) {

        LOGGER.info("Received message from Kafka: " + message);


            ObjectMapper objectMapper = new ObjectMapper();
            Object entity = objectMapper.convertValue(message.value().toString(), Object.class);
            saveEntity(entity);

    }

    private void saveEntity(Object entity) {
        if (entity instanceof Client) {
            clientRepository.save((Client) entity);
        } else if (entity instanceof Evenement) {
            Evenement evenement = (Evenement) entity;
            evenement.setClient(clientRepository.findById(evenement.getClient().getId()).orElse(null));
            evenementRepository.save(evenement);
        } else if (entity instanceof Offre) {
            Offre offre = (Offre) entity;
            offre.setPartenaire(partenaireRepository.findById(offre.getPartenaire().getId()).orElse(null));
            offreRepository.save(offre);
        } else if (entity instanceof Partenaire) {
            partenaireRepository.save((Partenaire) entity);
        } else if (entity instanceof Pli) {
            Pli pli = (Pli) entity;
            pli.setOffre(offreRepository.findById(pli.getOffre().getId()).orElse(null));
            pliRepository.save(pli);
        } else {
            LOGGER.warn("Unknown entity type: " + entity.getClass().getSimpleName());
        }
    }
}






