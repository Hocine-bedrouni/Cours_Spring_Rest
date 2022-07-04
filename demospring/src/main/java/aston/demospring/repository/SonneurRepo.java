package aston.demospring.repository;

import aston.demospring.entity.Sonneur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SonneurRepo extends JpaRepository<Sonneur, Long> {

    public List<Sonneur> findByNom(String nom);

    @Query("select sn from Sonneur sn left join sn.cornemuse c where c.model =:modelcornemuse")
    public List<Sonneur> findByModelCornemuse(@Param("modelcornemuse") String model);

}
