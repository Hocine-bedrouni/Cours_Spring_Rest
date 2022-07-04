package aston.demospring.controller;

import aston.demospring.entity.Guitare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import aston.demospring.service.GuitareService;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


/*
 *Class controller pour les services de Guitare 
 */
@RestController
@RequestMapping("/guitares")
public class GuitareController {

    @Autowired
    private GuitareService guitareService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Guitare> findAll() {
        return this.guitareService.findAll();
    }

    // Récuperation de l'id depuis l'adresse, et injection dans l'id en paramètre (Long id)
    @GetMapping ("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
     public Guitare findById(@PathVariable Long id) {
        return this.guitareService.findById(id);
     }

     @GetMapping("/model/{model}")
     @ResponseStatus(code = HttpStatus.OK)
     public List<Guitare> findBymodel(@PathVariable String model) {
        return this.guitareService.findByModel(model);
     }


     //pas besoin de péciser plus, meme adresse que la "get" mais pas la meme methode ici en post
    @PostMapping("") // dans le corps de la requete il y a un model d'objet de type guitare en Json pour créer l'objet
    @ResponseStatus(code = HttpStatus.CREATED)
     public Guitare create (@RequestBody Guitare newGuitare) {
        return this.guitareService.create(newGuitare);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Guitare update( @RequestBody Guitare guitare, @PathVariable Long id) {
        if (!id.equals(guitare.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mauvaise guitare a mettre à jour");
        }
        return this.guitareService.update(guitare);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Guitare delette (@PathVariable Long id) {
        return this.guitareService.delete(id);
    }
    
    
}
