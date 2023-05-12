package net.project.basedomain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offre {
    private Long id;
    private int codeOffre;
    private int dtyOffre;
    private String description;


}
