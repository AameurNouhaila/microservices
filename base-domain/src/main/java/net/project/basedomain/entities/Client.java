package net.project.basedomain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Long id;
    private String nom;
    private String prenom;
    private String cin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private String adresse;

}
