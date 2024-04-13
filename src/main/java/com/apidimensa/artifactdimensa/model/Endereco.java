package com.apidimensa.artifactdimensa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = Endereco.TABLE_NAME)
public class Endereco {
    public static final String TABLE_NAME = "endereco";

    @Id
    @Column(name = "contatoId")
    private Long contatoId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "contatoId")
    @JsonBackReference
    private Contato contato;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "cep")
    private String cep;

    // Constructors


    public Endereco() {
    }

    public Endereco(Long contatoId, Contato contato, String rua, Integer numero, String cep) {
        this.contatoId = contatoId;
        this.contato = contato;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    // Getters and Setters


    public Long getContatoId() {
        return contatoId;
    }

    public void setContatoId(Long contatoId) {
        this.contatoId = contatoId;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
