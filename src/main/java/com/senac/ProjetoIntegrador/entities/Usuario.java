package com.senac.ProjetoIntegrador.entities;

import jakarta.persistence.*;
import java.util.Date;

    @Entity
    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_novoUsuario;

        private String a_login;
        private String b_senha;
        private String c_nome;
        private String d_cpf;
        private String e_celular;
        private Date f_data_nascimento;
        private String g_endereco;
        private String h_cidade;
        private String i_estado;
        private String j_cep;

        // Construtor sem parâmetros (padrão)
        public Usuario() {}

        // Construtor com todos os parâmetros
        public Usuario(String a_login, String b_senha, String c_nome, String d_cpf, String e_celular,
                       Date f_data_nascimento, String g_endereco, String h_cidade, String i_estado, String j_cep) {
            this.a_login = a_login;
            this.b_senha = b_senha;
            this.c_nome = c_nome;
            this.d_cpf = d_cpf;
            this.e_celular = e_celular;
            this.f_data_nascimento = f_data_nascimento;
            this.g_endereco = g_endereco;
            this.h_cidade = h_cidade;
            this.i_estado = i_estado;
            this.j_cep = j_cep;
        }

        // Getters e Setters (já fornecido anteriormente)
        public Integer getId_novoUsuario() {
            return id_novoUsuario;
        }

        public void setId_novoUsuario(Integer id_novoUsuario) {
            this.id_novoUsuario = id_novoUsuario;
        }

        public String getA_login() {
            return a_login;
        }

        public void setA_login(String a_login) {
            this.a_login = a_login;
        }

        public String getB_senha() {
            return b_senha;
        }

        public void setB_senha(String b_senha) {
            this.b_senha = b_senha;
        }

        public String getC_nome() {
            return c_nome;
        }

        public void setC_nome(String c_nome) {
            this.c_nome = c_nome;
        }

        public String getD_cpf() {
            return d_cpf;
        }

        public void setD_cpf(String d_cpf) {
            this.d_cpf = d_cpf;
        }

        public String getE_celular() {
            return e_celular;
        }

        public void setE_celular(String e_celular) {
            this.e_celular = e_celular;
        }

        public Date getF_data_nascimento() {
            return f_data_nascimento;
        }

        public void setF_data_nascimento(Date f_data_nascimento) {
            this.f_data_nascimento = f_data_nascimento;
        }

        public String getG_endereco() {
            return g_endereco;
        }

        public void setG_endereco(String g_endereco) {
            this.g_endereco = g_endereco;
        }

        public String getH_cidade() {
            return h_cidade;
        }

        public void setH_cidade(String h_cidade) {
            this.h_cidade = h_cidade;
        }

        public String getI_estado() {
            return i_estado;
        }

        public void setI_estado(String i_estado) {
            this.i_estado = i_estado;
        }

        public String getJ_cep() {
            return j_cep;
        }

        public void setJ_cep(String j_cep) {
            this.j_cep = j_cep;
        }
    }

}
