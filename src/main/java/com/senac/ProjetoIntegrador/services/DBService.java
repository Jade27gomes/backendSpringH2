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
        tutor.setA_login("lucas123");
        tutor.setB_senha("senha123");
        tutor.setC_nome("Lucas Oliveira");
        tutor.setD_cpf("123.456.789-00");
        tutor.setE_celular("11999999999");
        tutor.setF_data_nascimento(sdf.parse("01/01/1990"));
        tutor.setG_endereco("Rua das Flores, 123");
        tutor.setH_cidade("São Paulo");
        tutor.setI_estado("SP");
        tutor.setJ_cep("01234-567");

        usuarioRepository.save(tutor);

        // Criar Animal vinculado ao Tutor
        Animal pet = new Animal();
        pet.setNome("Thor");
        pet.setEspecie("Cachorro");
        pet.setRaca("Labrador");
        pet.setDataNascimento(sdf.parse("10/10/2020"));
        pet.setAtivo(true);
        pet.setUsuario(tutor); // associando o tutor
        animalRepository.save(pet);

        // Criar Atendimento vinculado ao Animal e ao Tutor
        Atendimento atendimento = new Atendimento();
        atendimento.setDescricao("Consulta de rotina");
        atendimento.setAtivo(true);
        atendimento.setDataAtendimento(new Date()); // data atual
        atendimento.setUsuario(tutor);
        atendimento.setAnimal(pet);
        atendimentoRepository.save(atendimento);

        return "Banco instanciado com sucesso!";
    }
}
