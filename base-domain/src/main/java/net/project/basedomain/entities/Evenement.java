package net.project.basedomain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evenement {
    private Long id;
    private Date dateEvent;
    private Boolean extract;

}
