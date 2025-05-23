package com.senac.ProjetoIntegrador.services;

import com.senac.ProjetoIntegrador.entities.Usuario;
import com.senac.ProjetoIntegrador.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class UsuarioService {

        @Autowired
        private UsuarioRepository usuarioRepository;

        // Buscar por ID (RA)
        public Usuario findById(Integer id) {
            Optional<Usuario> usuario = usuarioRepository.findById(id);
            return usuario.orElse(null);
        }

        // Buscar todos os usuários com ativo = true
        public List<Usuario> listarTodosAbertos() {
            return usuarioRepository.findByAtivoTrue(); // Você deve criar esse método
        }

        // Buscar todos os usuários com ativo = false
        public List<Usuario> listarTodosFechados() {
            return usuarioRepository.findByAtivoFalse(); // Você deve criar esse método
        }

        // Buscar todos
        public List<Usuario> findAll() {
            return usuarioRepository.findAll();
        }

        // Buscar por nome
        public Usuario findByNome(String nome) {
            Optional<Usuario> usuario = usuarioRepository.findByNome(nome);
            return usuario.orElse(null);
        }

        // Cadastrar
        public Usuario gravarUsuario(Usuario usuario) {
            return usuarioRepository.save(usuario);
        }

        // Deletar
        public void deletar(Integer id) {
            usuarioRepository.deleteById(id);
        }

        // Atualizar
        public Usuario update(Integer id, Usuario novoUsuario) {
            Usuario atual = findById(id);
            if (atual != null) {
                atual.setNome(novoUsuario.getNome());
                atual.setDataNascimento(novoUsuario.getDataNascimento());
                atual.setAtivo(novoUsuario.isAtivo());
                return usuarioRepository.save(atual);
            }
            return null;
        }
    }
