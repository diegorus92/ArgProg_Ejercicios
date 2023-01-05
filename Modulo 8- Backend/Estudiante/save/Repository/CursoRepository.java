
package com.estudiante.estudiante.Repository;

import com.estudiante.estudiante.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}
