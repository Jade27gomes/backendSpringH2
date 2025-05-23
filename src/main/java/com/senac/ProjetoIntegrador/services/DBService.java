package com.senac.ProjetoIntegrador.services;

import com.senac.ProjetoIntegrador.entities.Animal;
import com.senac.ProjetoIntegrador.entities.Atendimento;
import com.senac.ProjetoIntegrador.entities.Usuario;
import com.senac.ProjetoIntegrador.repositories.AnimalRepository;
import com.senac.ProjetoIntegrador.repositories.AtendimentoRepository;
import com.senac.ProjetoIntegrador.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DBService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Bean
    public String instanciarDB() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Criar Usuário (Tutor)
        Usuario tutor = new Usuario();
        tutor.setLogin("lucas123");
        tutor.setSenha("senha123");
        tutor.setNome("Lucas Oliveira");
        tutor.setCpf("123.456.789-00");
        tutor.setCelular("11999999999");
        tutor.setData_nascimento(sdf.parse("01/01/1990"));
        tutor.setEndereco("Rua das Flores, 123");
        tutor.setCidade("São Paulo");
        tutor.setEstado("SP");
        tutor.setCep("01234-567");
        usuarioRepository.save(tutor);

        // Criar Animal vinculado ao Tutor
        Animal pet = new Animal();
        pet.setNome("Thor");
        /*pet.setEspecie("Cachorro");
        pet.setRaca("Labrador");*/
        pet.setDataNascimento(sdf.parse("10/10/2020"));
        pet.setAtivo(true);
        pet.setUsuario(tutor);
        animalRepository.save(pet);

        // Criar Atendimento vinculado ao Animal e Tutor
        Atendimento atendimento = new Atendimento();
        atendimento.setDescricao("Consulta de rotina");
        atendimento.setAtendimentoHoras(1);
        atendimento.setDataAgendada(new Date()); // Data agendada da consulta
        atendimento.setHoraAgendada(new java.sql.Time(System.currentTimeMillis())); // Hora agendada
        atendimento.setPreco(BigDecimal.valueOf(150.00));
        atendimento.setUsuario(tutor); // Tutor associado
        atendimento.setAnimal(pet);    // Animal associado
        atendimento.setAtivo(true);    // Ativo (supondo que a entidade tenha esse campo)
        atendimentoRepository.save(atendimento);

        return "Banco instanciado com sucesso!";
    }
}
