package com.estudiante.estudiante.DTO;

import java.io.Serializable;
import java.util.Date;

public class CursoDTO implements Serializable{

    private String nombre;
    private String tipo_curso;
    private Date fecha_finalizacion;

    public CursoDTO(String nombre, String tipo_curso, Date fecha_finalizacion) {
        this.nombre = nombre;
        this.tipo_curso = tipo_curso;
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo_curso() {
        return tipo_curso;
    }

    public Date getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    

    @Override
    public String toString() {
        return "{ " + this.nombre + " // Tipo: " + this.tipo_curso + " // Fecha finalizacion: " + this.fecha_finalizacion + " }";
    }
}
