package com.estudiante.estudiante.Model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_curso;
    private String nombre;
    private String tipo_curso;
    private Date fecha_finalizacion;

    @OneToMany
    @JoinTable(
        name="curso_temas",
        joinColumns=@JoinColumn(name="id_curso"),
        inverseJoinColumns = @JoinColumn(name="id_tema")
    )
    private List<Tema> listaDeTemas;
}
