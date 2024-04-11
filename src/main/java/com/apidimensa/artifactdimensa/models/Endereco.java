package com.apidimensa.artifactdimensa.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = Endereco.TABLE_NAME)
public class Endereco {
    public static final String TABLE_NAME = "Endereco";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "rua", nullable = false)
    @NotBlank
    private String rua;

    @Column(name = "numero", nullable = false)
    @NotBlank
    private Integer numero;

    @Column(name = "cep", nullable = false)
    @NotBlank
    private Integer cep;

    @OneToMany(mappedBy = "endereco")
    private List<Contato> contatos;

    // Constructors

    public Endereco() {
    }

    public Endereco(Integer id, String rua, Integer numero, Integer cep) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
