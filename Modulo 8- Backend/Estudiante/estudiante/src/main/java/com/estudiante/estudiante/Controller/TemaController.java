
package com.estudiante.estudiante.Controller;

import com.estudiante.estudiante.DTO.TemaDTO;
import com.estudiante.estudiante.Model.Curso;
import com.estudiante.estudiante.Model.Tema;
import com.estudiante.estudiante.Service.ICursoService;
import com.estudiante.estudiante.Service.ITemaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {
    
    @Autowired
    ITemaService interTemaService;
    
    @Autowired 
    ICursoService interCursoService;

    @PostMapping("/temas/crear/{idcurso}")
    public String postearTema(@RequestBody Tema nuevoTema, @PathVariable Long idcurso){
        Curso curso = interCursoService.obtenerCursoPorId(idcurso);
        curso.getListaDeTemas().add(nuevoTema);
        
        nuevoTema.setCurso(curso);

        interTemaService.crearTema(nuevoTema);
        
        return "Tema nuevo creado";
    }

    @GetMapping("/temas/traer")
    public List<TemaDTO> getTemas(){
        List <Tema> temas = interTemaService.obtenerTemas();
        List<TemaDTO> temaDTO = new ArrayList();
            
        for(Tema t : temas){
            temaDTO.add(new TemaDTO(t.getId_tema(), t.getNombre(), t.getDescripcion()));
        }
            
        return temaDTO;
    }

    @GetMapping("/temas/traer/{idtema}")
    public Tema getTamaPorId(@PathVariable Long idtema){
        return interTemaService.obtenerTemaPorId(idtema);
    }

    @PutMapping("/temas/editar/{idtema}")
    public String updateTema(@PathVariable Long idtema,
        @RequestParam("nombre") String nombre,
        @RequestParam("descripcion") String descripcion
    ){
        Tema tema = interTemaService.obtenerTemaPorId(idtema);
    
        tema.setNombre(nombre);
        tema.setDescripcion(descripcion);

        interTemaService.crearTema(tema);

        return "Tema modificado";
    }

    @DeleteMapping("temas/eliminar/{idtema}")
    public String deleteTema(@PathVariable Long idtema){
        interTemaService.eliminarTema(idtema);

        return "Tema eliminado";
    }
}
