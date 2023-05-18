package net.project.kafkaconsumer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pli {
    private Long id;
    private Double poids;
    private Double longueur;
    private Double largeur;
    private Double montant;
    private NiveauRecommandation niveauRecommandation;

}
