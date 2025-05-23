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

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Integer id, Usuario usuarioNovo) {
        Usuario existente = findById(id);
        if (existente != null) {
            existente.setLogin(usuarioNovo.getLogin());
            existente.setSenha(usuarioNovo.getSenha());
            existente.setNome(usuarioNovo.getNome());
            existente.setCpf(usuarioNovo.getCpf());
            existente.setCelular(usuarioNovo.getCelular());
            existente.setData_nascimento(usuarioNovo.getData_nascimento());
            existente.setEndereco(usuarioNovo.getEndereco());
            existente.setCidade(usuarioNovo.getCidade());
            existente.setEstado(usuarioNovo.getEstado());
            existente.setCep(usuarioNovo.getCep());
            return usuarioRepository.save(existente);
        }
        return null;
    }
}
