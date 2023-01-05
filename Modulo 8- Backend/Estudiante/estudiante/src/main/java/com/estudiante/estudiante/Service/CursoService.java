package com.estudiante.estudiante.Service;

import com.estudiante.estudiante.Model.Curso;
import com.estudiante.estudiante.Model.Tema;
import com.estudiante.estudiante.Repository.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private CursoRepository repoCurso;

    @Override
    public void crearCurso(Curso nuevoCurso) {
        repoCurso.save(nuevoCurso);
    }

    @Override
    public List<Curso> obtenerCursos() {
        List<Curso> cursos = repoCurso.findAll();

        return cursos;
    }

    @Override
    public List<Tema> obtenerTemasDeCurso(Long idCurso) {
        Curso curso = repoCurso.findById(idCurso).orElse(null);

        return curso.getListaDeTemas();
    }

    @Override
    public Curso obtenerCursoPorId(Long idCurso) {

        return repoCurso.findById(idCurso).orElse(null);
    }

    @Override
    public void eliminarCurso(Long idCurso) {
        repoCurso.deleteById(idCurso);
    }

}
