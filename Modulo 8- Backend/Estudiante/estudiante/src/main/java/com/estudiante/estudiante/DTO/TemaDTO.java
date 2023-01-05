
package com.estudiante.estudiante.DTO;

import java.io.Serializable;


public class TemaDTO implements Serializable{
    
    private Long id_tema;
    private String nombre;
    private String descripcion;

    public TemaDTO(Long id_tema, String nombre, String descripcion) {
        this.id_tema = id_tema;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId_tema() {
        return id_tema;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    
}
