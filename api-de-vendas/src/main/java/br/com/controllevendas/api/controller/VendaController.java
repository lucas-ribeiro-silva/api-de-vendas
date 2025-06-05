package br.com.controllevendas.api.controller;

import br.com.controllevendas.api.model.Venda;
import br.com.controllevendas.api.service.VendaService; // Importe o Service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    // Trocamos a injeção do Repository pela injeção do Service
    @Autowired
    private VendaService vendaService;

    // GET /api/vendas - Listar todas as vendas
    @GetMapping
    public List<Venda> listarTodas() {
        // O controller agora só delega a chamada para o service
        return vendaService.listarTodas();
    }

    // POST /api/vendas - Criar uma nova venda
    @PostMapping
    public ResponseEntity<Venda> criar(@RequestBody Venda venda) {
        try {
            Venda novaVenda = vendaService.registrarVenda(venda);
            return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Se o service lançar uma exceção (ex: estoque insuficiente),
            // retornamos um erro 400 Bad Request com a mensagem.
            return ResponseEntity.badRequest().body(null); // Em breve vamos melhorar essa resposta de erro!
        }
    }
}