package br.com.controllevendas.api.service;

import br.com.controllevendas.api.model.Produto;
import br.com.controllevendas.api.model.Venda;
import br.com.controllevendas.api.repository.ClienteRepository;
import br.com.controllevendas.api.repository.ProdutoRepository;
import br.com.controllevendas.api.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

// @Service: Anotação que marca esta classe como um componente de serviço do Spring.
@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // @Transactional: Garante que todas as operações com o banco de dados dentro deste método
    // sejam parte de uma única transação. Ou tudo funciona, ou nada é salvo (Atomicidade).
    // Essencial quando modificamos mais de uma tabela (Vendas e Produtos).
    @Transactional
    public Venda registrarVenda(Venda venda) {
        // --- INÍCIO DA LÓGICA DE NEGÓCIO ---

        // 1. Validar se o cliente e o produto existem
        Long clienteId = venda.getCliente().getId();
        Long produtoId = venda.getProduto().getId();

        clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com o ID: " + clienteId));

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com o ID: " + produtoId));

        // 2. Verificar se há estoque suficiente
        int quantidadeVendida = venda.getQuantidade();
        if (produto.getEstoque() < quantidadeVendida) {
            throw new IllegalArgumentException("Estoque insuficiente para o produto: " + produto.getNome());
        }

        // 3. Atualizar o estoque do produto
        produto.setEstoque(produto.getEstoque() - quantidadeVendida);
        produtoRepository.save(produto);

        // 4. Registrar a venda
        venda.setDataVenda(LocalDate.now());
        // --- FIM DA LÓGICA DE NEGÓCIO ---

        return vendaRepository.save(venda);
    }

    // Método para listar todas as vendas (aqui não precisamos de lógica complexa)
    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }
}