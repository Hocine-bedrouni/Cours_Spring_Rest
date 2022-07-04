package aston.demospring.repository;

import aston.demospring.entity.Cornemuse;
import aston.demospring.entity.Guitare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CornemuseRepo extends JpaRepository <Cornemuse, Long> {

    public List<Cornemuse> findByModel(String model);




}


