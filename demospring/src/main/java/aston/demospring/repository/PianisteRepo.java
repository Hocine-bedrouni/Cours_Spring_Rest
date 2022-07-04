package aston.demospring.repository;

import aston.demospring.entity.Guitariste;
import aston.demospring.entity.Pianiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PianisteRepo extends JpaRepository<Pianiste, Long>{

    public List<Pianiste> findByNom(String nom);

    @Query("select pt from Pianiste pt left join pt.piano p where p.model =:modelpiano")
    public List<Pianiste> findByModelPiano(@Param("modelpiano") String model);



}