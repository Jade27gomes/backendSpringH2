package com.senac.ProjetoIntegrador.repositories;

import com.senac.ProjetoIntegrador.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Pesquisa por RA (id)
    Optional<Usuario> findById(Integer id);

    // Pesquisa por nome
    Optional<Usuario> findByNome(String nome);

    // Pesquisa todos os usuários com "ativo=true"
    @Query("SELECT u FROM Usuario u WHERE u.ativo = true ORDER BY u.nome")
    List<Usuario> listarTodosAbertos();

    // Pesquisa todos os usuários com "ativo=false"
    @Query("SELECT u FROM Usuario u WHERE u.ativo = false ORDER BY u.nome")
    List<Usuario> listarTodosFechados();

    // Pesquisa todos os usuários
    List<Usuario> findAll();
}
