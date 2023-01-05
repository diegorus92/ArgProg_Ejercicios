
package com.estudiante.estudiante.Controller;

import com.estudiante.estudiante.DTO.CursoDTO;
import com.estudiante.estudiante.Model.Curso;
import com.estudiante.estudiante.Model.Tema;
import com.estudiante.estudiante.Service.ICursoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {
    
    @Autowired
    ICursoService interCursoService;

    @PostMapping("/cursos/crear")
    public String postearCurso(@RequestBody Curso nuevoCurso){
        interCursoService.crearCurso(nuevoCurso);

        return "Curso nuevo creado";
    }

    //Este provoca una excepción de recursion, por que que se usó con patrón DTO para evitarlo
    /*@GetMapping("/cursos/traer")
    public List<Curso> getCursos(){
        return interCursoService.obtenerCursos();
    }*/

    //Con DTO
    @GetMapping("/cursos/traer")
    @ResponseBody
    public List<CursoDTO> getCursos(){
        List <Curso> cursos = interCursoService.obtenerCursos();
        List<CursoDTO> cursosDTO = new ArrayList();
            
        for(Curso c : cursos){
            cursosDTO.add(new CursoDTO(c.getNombre(), c.getTipo_curso(), c.getFecha_finalizacion()));
        }
            
        return cursosDTO;
    }

    @GetMapping("/temas/curso/{idcurso}")
    public List<Tema> getTemasDeCurso(@PathVariable Long idcurso){
        return interCursoService.obtenerTemasDeCurso(idcurso);
    }

    @PutMapping("/cursos/editar/{idcurso}")
    public String updateCurso(@PathVariable Long idcurso, 
        @RequestParam("nombre") String nombre, 
        @RequestParam("tipo_curso") String tipo,
        @RequestParam("fecha_finalizacion") Date fechaFin
    ){
        Curso curso = interCursoService.obtenerCursoPorId(idcurso);

        curso.setNombre(nombre);
        curso.setTipo_curso(tipo);
        curso.setFecha_finalizacion(fechaFin);

        interCursoService.crearCurso(curso);

        return "Curso modificado";
    }

    @DeleteMapping("/cursos/eliminar/{idcurso}")
    public String deleteCurso(@PathVariable Long idcurso){
        interCursoService.eliminarCurso(idcurso);

        return "Curso eliminado";
    }
}
