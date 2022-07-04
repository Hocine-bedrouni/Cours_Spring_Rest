package aston.demospring.repository;

import aston.demospring.entity.Guitare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// Composant Spring qu'il faut utiliser pour les transactions
@Repository
public interface GuitareRepo extends JpaRepository<Guitare, Long> {

    public List<Guitare> findByModel(String model);

    /*
     *  public List<Guitare> findAll();
     *  public Guitare findbyId(Long Id);
     *  public Guitare create(Guitare obj);
     *  public List<Guitare> createAll(List<Guitare> objs);
     *  public Guitare update(Guitare obj);
     *  public List<Guitare> updateAll(List<Guitare> objs);
     *  public Guitare delete(Guitare obj);
     *  public List<Guitare> deleteAll(List<Guitare> objs);
     */
}