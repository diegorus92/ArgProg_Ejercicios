package com.estudiante.estudiante.Service;

import com.estudiante.estudiante.Model.Tema;
import com.estudiante.estudiante.Repository.TemaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService {

    @Autowired
    private TemaRepository repoTema;

    @Override
    public void crearTema(Tema nuevoTema) {
        repoTema.save(nuevoTema);
    }

    @Override
    public List<Tema> obtenerTemas() {

        return repoTema.findAll();
    }

    @Override
    public Tema obtenerTemaPorId(Long idTema) {

        return repoTema.findById(idTema).orElse(null);
    }

    @Override
    public void eliminarTema(Long idTema) {
        repoTema.deleteById(idTema);
    }
}
