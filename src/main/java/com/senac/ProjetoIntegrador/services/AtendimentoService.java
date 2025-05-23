package com.senac.ProjetoIntegrador.services;

import com.senac.ProjetoIntegrador.entities.Atendimento;
import com.senac.ProjetoIntegrador.repositories.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public Atendimento findById(Integer id) {
        return atendimentoRepository.findById(id).orElse(null);
    }

    public List<Atendimento> findAll() {
        return atendimentoRepository.findAll();
    }

    public List<Atendimento> findByTutorRa(int ra) {
        return atendimentoRepository.findByUsuarioId(ra);
    }

    public List<Atendimento> findByAnimalId(int id) {
        return atendimentoRepository.findByAnimalId(id);
    }

    public List<Atendimento> findAtivos() {
        return atendimentoRepository.findByAtivoTrue();
    }

    public Atendimento save(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public void deleteById(Integer id) {
        atendimentoRepository.deleteById(id);
    }

    public Atendimento update(Integer id, Atendimento novoAtendimento) {
        Atendimento existente = findById(id);
        if (existente != null) {
            existente.setDataAgendada(novoAtendimento.getDataAgendada());
            existente.setHoraAgendada(novoAtendimento.getHoraAgendada());
            existente.setDescricao(novoAtendimento.getDescricao());
            existente.setAtendimentoHoras(novoAtendimento.getAtendimentoHoras());
            existente.setPreco(novoAtendimento.getPreco());
            existente.setAnimal(novoAtendimento.getAnimal());
            existente.setUsuario(novoAtendimento.getUsuario());
            return atendimentoRepository.save(existente);
        }
        return null;
    }
}
