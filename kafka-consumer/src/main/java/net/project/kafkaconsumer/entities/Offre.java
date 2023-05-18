package net.project.kafkaconsumer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int codeOffre;
    private int dtyOffre;
    private String description;
    @OneToMany(mappedBy = "offre")
    private List<Pli> plis;
    @ManyToOne
    private Partenaire partenaire;
}
