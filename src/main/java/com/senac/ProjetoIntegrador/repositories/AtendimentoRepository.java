package com.senac.ProjetoIntegrador.repositories;

import com.senac.ProjetoIntegrador.entities.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
    List<Atendimento> findByUsuarioId(int usuarioId);
    List<Atendimento> findByAnimalId(int animalId);
    List<Atendimento> findByAtivoTrue();
}
