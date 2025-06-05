package br.com.controllevendas.api.repository;

import br.com.controllevendas.api.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    // Todos os métodos CRUD já estão disponíveis.
}