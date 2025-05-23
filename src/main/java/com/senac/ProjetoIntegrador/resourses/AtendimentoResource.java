package com.senac.ProjetoIntegrador.resources;

import com.senac.ProjetoIntegrador.entities.Atendimento;
import com.senac.ProjetoIntegrador.services.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoResource {
    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping
    public List<Atendimento> listarTodos() {
        return atendimentoService.findAll();
    }

    @GetMapping("/ativos")
    public List<Atendimento> listarAtivos() {
        return atendimentoService.findAtivos();
    }

    @GetMapping("/tutor/{ra}")
    public List<Atendimento> listarPorTutor(@PathVariable int ra) {
        return atendimentoService.findByTutorRa(ra);
    }

    @GetMapping("/animal/{id}")
    public List<Atendimento> listarPorAnimal(@PathVariable int id) {
        return atendimentoService.findByAnimalId(id);
    }

    @PostMapping
    public Atendimento salvar(@RequestBody Atendimento atendimento) {
        return atendimentoService.save(atendimento);
    }

    @PutMapping("/{id}")
    public Atendimento atualizar(@PathVariable Integer id, @RequestBody Atendimento atendimento) {
        return atendimentoService.update(id, atendimento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        atendimentoService.deleteById(id);
    }
}
