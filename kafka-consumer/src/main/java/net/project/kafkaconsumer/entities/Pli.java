package net.project.kafkaconsumer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pli {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double poids;
    private Double longueur;
    private Double largeur;
    private Double montant;
    @Enumerated(EnumType.STRING)
    private NiveauRecommandation niveauRecommandation;
    @ManyToOne
    private Offre offre;
    @ManyToOne
    private Evenement evenement;



}
