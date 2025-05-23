package com.senac.ProjetoIntegrador.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "atendimentos")
public class Atendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_novoAtendimento")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_animal", nullable = false)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "descricao", length = 400)
    private String descricao;

    @Column(name = "atendimento_horas")
    private Integer atendimentoHoras;

    @Column(name = "hora_agendada")
    private Time horaAgendada;

    @Column(name = "data_agendada")
    @Temporal(TemporalType.DATE)
    private Date dataAgendada;

    @Column(name = "preco", precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "ativo")
    private boolean ativo;

    public Atendimento() {}

    public Atendimento(Integer id, Animal animal, Usuario usuario, String descricao, Integer atendimentoHoras,
                       Time horaAgendada, Date dataAgendada, BigDecimal preco, boolean ativo) {
        this.id = id;
        this.animal = animal;
        this.usuario = usuario;
        this.descricao = descricao;
        this.atendimentoHoras = atendimentoHoras;
        this.horaAgendada = horaAgendada;
        this.dataAgendada = dataAgendada;
        this.preco = preco;
        this.ativo = ativo;
    }

    // Getters e setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAtendimentoHoras() {
        return atendimentoHoras;
    }

    public void setAtendimentoHoras(Integer atendimentoHoras) {
        this.atendimentoHoras = atendimentoHoras;
    }

    public Time getHoraAgendada() {
        return horaAgendada;
    }

    public void setHoraAgendada(Time horaAgendada) {
        this.horaAgendada = horaAgendada;
    }

    public Date getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(Date dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
