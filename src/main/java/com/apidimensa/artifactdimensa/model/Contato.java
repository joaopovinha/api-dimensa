package com.apidimensa.artifactdimensa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.util.Objects;

@Entity
@Table(name = Contato.TABLE_NAME)
public class Contato {
    public static final String TABLE_NAME = "contato";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contatoId", unique = true)
    private Long contatoId;

    @Column(name = "nome", nullable = false, length = 20)
    @NotBlank
    @Size(min = 2, max = 20)
    private String nome;

    @Column(name = "email", nullable = false)
    @NotBlank
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @Column(name = "telefone", nullable = false, length = 11)
    @NotBlank
    @Size(min = 11, max = 11)
    private String telefone;

    @Column(name = "dataNascimento", nullable = false)
    @NotBlank
    private String dataNascimento;

    @OneToOne(mappedBy = "contato", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private Endereco endereco;


    // Constructors

    public Contato() {
    }

    public Contato(Long contatoId, String nome, String email, String telefone, String dataNascimento) {
        this.contatoId = contatoId;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    // Getters and Setters

    public Long getContatoId() {
        return contatoId;
    }

    public void setContatoId(Long contatoId) {
        this.contatoId = contatoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
