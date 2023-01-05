
package com.estudiante.estudiante.Repository;

import com.estudiante.estudiante.Model.CursoTemas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoTemasRepository extends JpaRepository<CursoTemas, Long>{
    
}
