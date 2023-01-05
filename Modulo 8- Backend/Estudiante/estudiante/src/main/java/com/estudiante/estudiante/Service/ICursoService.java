
package com.estudiante.estudiante.Service;

import com.estudiante.estudiante.Model.Curso;
import com.estudiante.estudiante.Model.Tema;
import java.util.List;


public interface ICursoService {

    public void crearCurso(Curso nuevoCurso);
    public List<Curso> obtenerCursos();
    public List<Tema> obtenerTemasDeCurso(Long idCurso);
    public Curso obtenerCursoPorId(Long idCurso);
    public void eliminarCurso(Long idCurso);
}
