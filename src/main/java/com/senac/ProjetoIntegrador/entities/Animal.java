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

    // Relacionamento com atendimentos
    @OneToMany(mappedBy = "animal")
    private List<Atendimento> atendimentos;

    public Animal() {}

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

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public Animal(Integer id, Usuario usuario, String nome, String deficiencias, String intolerancias, Date dataNascimento, String sexo, List<Atendimento> atendimentos) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.deficiencias = deficiencias;
        this.intolerancias = intolerancias;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.atendimentos = atendimentos;
    }
// Getters e Setters
}
