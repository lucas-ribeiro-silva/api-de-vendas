package br.com.controllevendas.api.controller;

import br.com.controllevendas.api.model.Produto;
import br.com.controllevendas.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // GET /api/produtos - Listar todos os produtos
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // POST /api/produtos - Criar um novo produto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // GET /api/produtos/{id} - Buscar um produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /api/produtos/{id} - Atualizar um produto
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produtoDetalhes) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoDetalhes.getNome());
                    produto.setDescricao(produtoDetalhes.getDescricao());
                    produto.setPreco(produtoDetalhes.getPreco());
                    produto.setEstoque(produtoDetalhes.getEstoque());
                    Produto produtoAtualizado = produtoRepository.save(produto);
                    return ResponseEntity.ok(produtoAtualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/produtos/{id} - Deletar um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}