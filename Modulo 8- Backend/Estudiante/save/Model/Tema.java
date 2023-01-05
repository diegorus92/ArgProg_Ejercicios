package com.estudiante.estudiante.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="tema")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_tema;
    private String nombre;
    private String descripcion;
}
