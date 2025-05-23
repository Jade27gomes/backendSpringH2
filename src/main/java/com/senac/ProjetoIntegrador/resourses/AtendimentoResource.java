package com.senac.ProjetoIntegrador.resources;

import com.senac.ProjetoIntegrador.entities.Atendimento;
import com.senac.ProjetoIntegrador.services.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoResource {

    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping
    public List<Atendimento> findAll() {
        return atendimentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> findById(@PathVariable Integer id) {
        Atendimento atendimento = atendimentoService.findById(id);
        if (atendimento != null) {
            return ResponseEntity.ok().body(atendimento);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Atendimento insert(@RequestBody Atendimento atendimento) {
        return atendimentoService.save(atendimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> update(@PathVariable Integer id, @RequestBody Atendimento atendimento) {
        Atendimento updated = atendimentoService.update(id, atendimento);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        atendimentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
