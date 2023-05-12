package net.project.basedomain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntitiesRequest {
        private Client client;
        private Evenement evenement;
        private Offre offre;
        private Pli pli;
        private Partenaire partenaire;
}

