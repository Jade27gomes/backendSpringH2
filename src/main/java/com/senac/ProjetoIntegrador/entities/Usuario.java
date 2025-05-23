package com.senac.ProjetoIntegrador.entities;

import jakarta.persistence.*;
import java.util.Date;

    @Entity
    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_novoUsuario")
        private Integer id;

        @Column(name = "login")
        private String login;
        @Column(name = "senha")
        private String senha;
        @Column(name = "nome")
        private String nome;
        @Column(name = "cpf")
        private String cpf;
        @Column(name = "celular")
        private String celular;
        @Column(name = "data_nascimento")
        private Date data_nascimento;
        @Column(name = "endereco")
        private String endereco;
        @Column(name = "cidade")
        private String cidade;
        @Column(name = "estado")
        private String estado;
        @Column(name = "cep")
        private String cep;
        @Column(name = "ativo")
        private boolean ativo = true;

        // Construtor sem parâmetros (padrão)
        public Usuario() {}

        // Construtor com todos os parâmetros
        public Usuario(String login, String senha, String nome, String cpf, String celular,
                       Date data_nascimento, String endereco, String cidade, String estado, String cep, boolean ativo) {
            this.login = login;
            this.senha = senha;
            this.nome = nome;
            this.cpf = cpf;
            this.celular = celular;
            this.data_nascimento = data_nascimento;
            this.endereco = endereco;
            this.cidade = cidade;
            this.estado = estado;
            this.cep = cep;
            this.ativo = ativo;
        }

        // Getters e Setters (já fornecido anteriormente)
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getCelular() {
            return celular;
        }

        public void setCelular(String celular) {
            this.celular = celular;
        }

        public Date getData_nascimento() {
            return data_nascimento;
        }

        public void setData_nascimento(Date data_nascimento) {
            this.data_nascimento = data_nascimento;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

        public boolean getAtivo() {
            return ativo;
        }

        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
        }
    }


