package com.senac.ProjetoIntegrador.resources;

import com.senac.ProjetoIntegrador.entities.Animal;
import com.senac.ProjetoIntegrador.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalResource {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> listarTodos() {
        return animalService.findAll();
    }

    @GetMapping("/ativos")
    public List<Animal> listarAtivos() {
        return animalService.findAll().stream().filter(Animal::isAtivo).toList();
    }

    @GetMapping("/tutor/{ra}")
    public List<Animal> listarPorTutor(@PathVariable int ra) {
        return animalService.findByTutorRa(ra);
    }

    @PostMapping
    public Animal salvar(@RequestBody Animal animal) {
        return animalService.save(animal);
    }

    @PutMapping("/{id}")
    public Animal atualizar(@PathVariable Integer id, @RequestBody Animal animal) {
        return animalService.update(id, animal);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        animalService.deleteById(id);
    }
}
