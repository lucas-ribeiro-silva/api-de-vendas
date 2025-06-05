package br.com.controllevendas.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Anotação que informa ao JPA que esta classe é uma entidade do banco de dados.
@Table(name = "clientes") // Define o nome da tabela no banco de dados.
public class Cliente {

    @Id // Marca o campo como a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática do ID.
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    // Getters e Setters (métodos para acessar e modificar os atributos)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}