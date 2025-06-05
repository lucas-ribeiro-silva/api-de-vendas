package br.com.controllevendas.api.repository;

import br.com.controllevendas.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Todos os métodos CRUD já estão disponíveis.
}