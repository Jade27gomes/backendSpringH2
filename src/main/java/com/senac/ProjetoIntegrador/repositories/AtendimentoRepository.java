package com.senac.ProjetoIntegrador.repositories;

import com.senac.ProjetoIntegrador.entities.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
    List<Atendimento> findByUsuarioId(Integer id);
    List<Atendimento> findByAnimalId(Integer id);
    List<Atendimento> findByAtivoTrue();
}
