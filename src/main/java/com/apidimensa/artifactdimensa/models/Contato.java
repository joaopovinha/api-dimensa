package com.apidimensa.artifactdimensa.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = Contato.TABLE_NAME)
public class Contato {
    public static final String TABLE_NAME = "contato";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

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
    private Integer telefone;

    @Column(name = "dataNascimento", nullable = false)
    @NotBlank
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false, updatable = false)
    private Endereco endereco;

    // Constructors

    public Contato() {
    }

    public Contato(Integer id, String nome, String email, Integer telefone, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
