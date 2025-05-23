package com.senac.ProjetoIntegrador.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "animais")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_novoAnimal")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "deficiencias")
    private String deficiencias;

    @Column(name = "intolerancias")
    private String intolerancias;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "sexo", length = 1)
    private String sexo;

    /*@Column(name = "especie")
    private String especie;

    @Column(name = "raca")
    private String raca;*/

    @Column(name = "ativo")
    private boolean ativo = true;

    @OneToMany(mappedBy = "animal")
    private List<Atendimento> atendimentos;

    public Animal() {}

    public Animal(Integer id, Usuario usuario, String nome, String deficiencias, String intolerancias,
                  Date dataNascimento, String sexo, /*String especie, String raca,*/ boolean ativo,
                  List<Atendimento> atendimentos) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.deficiencias = deficiencias;
        this.intolerancias = intolerancias;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        /*this.especie = especie;
        this.raca = raca;*/
        this.ativo = ativo;
        this.atendimentos = atendimentos;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDeficiencias() {
        return deficiencias;
    }

    public void setDeficiencias(String deficiencias) {
        this.deficiencias = deficiencias;
    }

    public String getIntolerancias() {
        return intolerancias;
    }

    public void setIntolerancias(String intolerancias) {
        this.intolerancias = intolerancias;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /*public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }*/

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}
