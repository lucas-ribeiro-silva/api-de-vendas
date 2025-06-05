package br.com.controllevendas.api.repository;

import br.com.controllevendas.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// A anotação @Repository é opcional, mas ajuda a identificar a função da interface.
// JpaRepository<TipoDaEntidade, TipoDoID>
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // O Spring Data JPA já nos fornece métodos como:
    // save(), findById(), findAll(), deleteById(), etc.
    // Se precisarmos de buscas mais específicas, como "buscar cliente por email",
    // poderíamos declarar o método aqui:
    // Optional<Cliente> findByEmail(String email);
}