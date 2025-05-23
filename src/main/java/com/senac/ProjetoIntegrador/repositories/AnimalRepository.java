package com.senac.ProjetoIntegrador.repositories;

import com.senac.ProjetoIntegrador.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByAtivoTrue();

    // Busca animais por ID do usuário (tutor)
    List<Animal> findByUsuarioId(Integer id);
}
