package aston.demospring.service;

import aston.demospring.entity.Guitare;
import aston.demospring.repository.GuitareRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/*
 *Class de service pour les entitées guitare
 */

@Service
public class GuitareService {

    @Autowired
    private GuitareRepo guitareRepo;

    /**
     * methode qui recupère du repo les guitares
     * @return List<Guitare>
     */
    public List<Guitare> findAll() {
        return this.guitareRepo.findAll()
;    }

    /**
     * Methode qui permet de recupérer une guitare par son id
      * @param id Long, id de la guitare recherchée
     * @return Guitare
     */
    public Guitare findById(Long id) {
        Optional<Guitare> optGuitare = this.guitareRepo.findById(id);
        if (optGuitare.isPresent()) {
            return optGuitare.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * methode qui permet de trouver des guitares par model
     * @param model String, model des guitares recherchées
     * @return List<Guitare>
     */
    public List<Guitare> findByModel (String model) {
        return this.guitareRepo.findByModel(model);
    }

    /**
     * Methode qui permet de l'enregistrer une guitare
     * @param newGuitare Guitare, la guitare à enregistrée
     * @return Guitare la guitare enregistrée avec son id
     */
    public Guitare create(Guitare newGuitare){
        return this.guitareRepo.save(newGuitare);
    }

    /**
     * methode qui met à jour une guitare dans ma Bdd
     * @param guitare Guitare, la guitare à mettre à jour
     * @return Guitare, la guitare mise à jour
     */
    public Guitare update(Guitare guitare) {
        if (!this.guitareRepo.existsById(guitare.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver la guitare à mettre à jour");
        }
        return this.guitareRepo.save(guitare);
    }

    /**
     * methode qui supprime une guitare de la bdd si elle y est
     * puis vérifie si elle à bien été supprimée
     * @param id Long, id de la guitare à supprimer
     * @return GuitareDel
     */
    public Guitare delete(Long id) {
        //vérifié si la guitare existe
        if (!this.guitareRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver la guitare à supprimer");
        } else {
            // Recupère la guitare à supprimer, afin de garder des traces de la guitare à supp (facultatif)
            Guitare guitareDel = this.findById(id);
            this.guitareRepo.deleteById(id);
            if (this.guitareRepo.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                        "erreur lors de la suppression de la guitare");
            }
            return guitareDel;
        }
    }

}
