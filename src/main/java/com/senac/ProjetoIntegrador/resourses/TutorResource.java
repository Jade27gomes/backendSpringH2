package com.senac.ProjetoIntegrador.resourses;

import com.senac.ProjetoIntegrador.entities.Usuario;
import com.senac.ProjetoIntegrador.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tutor")
public class TutorResource {
    @Autowired
    private UsuarioService tutorService;

    //Pesquisa por RA(ID)
    @GetMapping(value = "/{ra}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer ra){
        Usuario tutor = tutorService.findById(ra);
        return ResponseEntity.ok().body(tutor);
    }

    //Pesquisa por status ativo = true
    @GetMapping(value ="/abertos")
    public ResponseEntity<List<Usuario>> listarAbertos(){
        List<Usuario> tutores =
                tutorService.listarTodosAbertos();
        return ResponseEntity.ok().body(tutores);
    }

    //Pesquisa por status ativo = false
    @GetMapping(value ="/fechados")
    public ResponseEntity<List<Usuario>> listarFechados(){
        List<Usuario> tutores =
                tutorService.listarTodosFechados();
        return ResponseEntity.ok().body(tutores);
    }

    //Pesquisa todos
    @GetMapping
    public List<Usuario> findAll(){
        return tutorService.findAll();
    }

    //consulta por nome
    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Usuario> findByNome(@PathVariable String nome){
        Usuario tutor = tutorService.findByNome(nome);
        return ResponseEntity.ok().body(tutor);
    }

    @PostMapping
    public ResponseEntity<Usuario> gravarTutor(
            @RequestBody Usuario tutor){
        tutor = tutorService.gravarTutor(tutor);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{ra}").
                buildAndExpand(tutor.getRa()).toUri();
        return ResponseEntity.created(uri).body(tutor);
    }

    @DeleteMapping(value = "/{ra}")
    public ResponseEntity<Void> deletar(@PathVariable Integer ra){
        tutorService.deletar(ra);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{ra}")
    public ResponseEntity<Usuario> update(@PathVariable Integer ra,
                                          @RequestBody Usuario tutor){
        Usuario alterado = tutorService.update(ra, tutor);

        return ResponseEntity.ok().body(alterado);
    }





}