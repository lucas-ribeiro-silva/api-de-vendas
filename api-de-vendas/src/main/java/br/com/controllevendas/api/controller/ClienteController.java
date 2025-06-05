package br.com.controllevendas.api.controller;

import br.com.controllevendas.api.model.Cliente;
import br.com.controllevendas.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Anotação que combina @Controller e @ResponseBody. Diz ao Spring para tratar retornos como JSON.
@RequestMapping("/api/clientes") // Define a URL base para todos os métodos neste controlador.
public class ClienteController {

    // @Autowired: Injeção de dependência. O Spring vai nos dar uma instância de ClienteRepository.
    @Autowired
    private ClienteRepository clienteRepository;

    // GET /api/clientes - Listar todos os clientes
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // GET /api/clientes/{id} - Buscar um cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        // Se o cliente for encontrado, retorna 200 OK com o cliente. Senão, retorna 404 Not Found.
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/clientes - Criar um novo cliente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Retorna o status HTTP 201 Created em caso de sucesso.
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // PUT /api/clientes/{id} - Atualizar um cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente clienteDetalhes) {
        return clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setNome(clienteDetalhes.getNome());
                    clienteExistente.setEmail(clienteDetalhes.getEmail());
                    clienteExistente.setTelefone(clienteDetalhes.getTelefone());
                    Cliente clienteAtualizado = clienteRepository.save(clienteExistente);
                    return ResponseEntity.ok(clienteAtualizado);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE /api/clientes/{id} - Deletar um cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return ResponseEntity.noContent().build(); // Retorna 204 No Content
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}