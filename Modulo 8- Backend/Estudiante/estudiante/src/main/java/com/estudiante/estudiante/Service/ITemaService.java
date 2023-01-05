
package com.estudiante.estudiante.Service;

import com.estudiante.estudiante.Model.Tema;
import java.util.List;


public interface ITemaService {

    public void crearTema(Tema nuevoTema);
    public List<Tema> obtenerTemas();
    public Tema obtenerTemaPorId(Long idTema);
    public void eliminarTema(Long idTema);
}
