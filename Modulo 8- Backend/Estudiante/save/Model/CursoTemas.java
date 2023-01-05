package com.estudiante.estudiante.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "curso_temas")
public class CursoTemas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_curso_temas;

    @ManyToOne
    @JoinColumn(name="id_curso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name="id_tema")
    private Tema tema;
}
