package net.project.kafkaproducer.controller;

import net.project.kafkaconsumer.entities.*;
import net.project.kafkaproducer.kafka.ClientProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

import static net.project.kafkaconsumer.entities.NiveauRecommandation.S1;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private ClientProducer clientProducer;

    public MessageController(ClientProducer clientProducer) {
        this.clientProducer = clientProducer;

    }

    @GetMapping("/message")
    public String placePli(){
        for (int i = 1; i <= 5; i++) {

            // Client class
            Client client = new Client(
                    (long) i,
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    "123456789",
                    new Date(),
                    UUID.randomUUID().toString().substring(0, 8));

            // Event class
             Evenement event = new Evenement(
                    (long) i,
                    new Date(),
                    false);

            // Package class
           Pli pli = new Pli(
                    (long) i,
                    10.5,
                    2.0,
                    2.5,
                    20.0,
                   S1
                    );

            // PackageBox class
            Offre offre = new Offre(
                    (long) i,
                    12345,
                    2,
                    "Box for fragile items");

            // Package Processor class
            Partenaire partenaire = new Partenaire(
                    (long) i,
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 12));

            clientProducer.sendMessage(client);
            clientProducer.sendMessage(event);
            clientProducer.sendMessage(pli);
            clientProducer.sendMessage(offre);
            clientProducer.sendMessage(partenaire);


        }


        return "data saved successfully...";
    }
}
