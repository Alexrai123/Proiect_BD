package com.proiect.bazededate.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meci")

public class Meci {
    @Id
    @GeneratedValue
    private UUID id;

    private LocalDate dateMeciului;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gazde_id", referencedColumnName = "id")
    private Echipa gazde;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "oaspeti_id", referencedColumnName = "id")
    private Echipa oaspeti;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stadion_id", referencedColumnName = "id")
    private Stadion locatie;
}
