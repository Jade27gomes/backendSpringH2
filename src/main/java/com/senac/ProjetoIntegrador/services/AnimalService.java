package com.senac.ProjetoIntegrador.services;

import com.senac.ProjetoIntegrador.entities.Animal;
import com.senac.ProjetoIntegrador.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Animal findById(Integer id) {
        return animalRepository.findById(id).orElse(null);
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public List<Animal> findByTutorRa(int ra) {
        return animalRepository.findByTutorRa(ra);
    }

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteById(Integer id) {
        animalRepository.deleteById(id);
    }

    public Animal update(Integer id, Animal novoAnimal) {
        Animal existente = findById(id);
        if (existente != null) {
            existente.setNome(novoAnimal.getNome());
            existente.setEspecie(novoAnimal.getEspecie());
            existente.setRaca(novoAnimal.getRaca());
            existente.setDataNascimento(novoAnimal.getDataNascimento());
            existente.setAtivo(novoAnimal.isAtivo());
            existente.setTutor(novoAnimal.getTutor());
            return animalRepository.save(existente);
        }
        return null;
    }
}
