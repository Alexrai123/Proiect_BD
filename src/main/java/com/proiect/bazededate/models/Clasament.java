package com.proiect.bazededate.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clasament")

public class Clasament {
    @Id
    @GeneratedValue
    private UUID id;

    private Integer locInClasament;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "echipa_id", referencedColumnName = "id")
    private Echipa echipa;

    private Integer puncte;

    private Integer victorii;

    private Integer egaluri;

    private Integer infrangeri;
}
