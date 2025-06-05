# API de Controle de Vendas

![Licença](https://img.shields.io/badge/license-MIT-blue.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x.x-green.svg)

**Status do Projeto: Concluído ✔️**

## 📝 Descrição

API RESTful desenvolvida como um projeto de portfólio para demonstrar habilidades em desenvolvimento backend com Java e Spring Boot. O sistema gerencia clientes, produtos e vendas, incluindo lógica de negócio para controle de estoque e validação de dados.

A aplicação utiliza um banco de dados em memória (H2) para facilitar a execução e os testes, não necessitando de nenhuma configuração externa de banco de dados.

---

## ✨ Funcionalidades

- **CRUD de Clientes**: Operações completas de Criação, Leitura, Atualização e Deleção de clientes.
- **CRUD de Produtos**: Operações completas para gerenciar produtos.
- **Registro de Vendas**: Endpoint para registrar vendas, associando clientes e produtos.
- **Lógica de Negócio**:
  - **Controle de Estoque**: O estoque de um produto é atualizado automaticamente após cada venda.
  - **Validação de Estoque**: Impede a venda de produtos com estoque insuficiente.
- **Validação de Dados**: Utiliza Bean Validation para garantir a integridade dos dados de entrada (ex: e-mail válido, campos não nulos, etc.).

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Web**: Para criação de endpoints RESTful.
- **Spring Data JPA**: Para persistência de dados de forma simplificada.
- **H2 Database**: Banco de dados em memória para ambiente de desenvolvimento e teste.
- **Maven**: Gerenciador de dependências e build do projeto.
- **Bean Validation**: Para validação dos dados de entrada na API.

---

## ⚙️ Como Executar o Projeto

Siga os passos abaixo para executar a API em seu ambiente local.

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:
- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou superior.
- [Maven](https://maven.apache.org/download.cgi) 3.6 ou superior.
- [Git](https://git-scm.com/downloads)

### Rodando a Aplicação

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/lucas-ribeiro-silva/api-de-vendas.git](https://github.com/lucas-ribeiro-silva/api-de-vendas.git)
   ```
   *Substitua `lucas-ribeiro-silva/api-de-vendas` pelo link do seu repositório.*

2. **Navegue até a pasta do projeto:**
   ```bash
   cd nome-da-pasta-do-projeto
   ```

3. **Execute o projeto com o Maven:**
   ```bash
   mvn spring-boot:run
   ```

4. **Pronto!** A API estará rodando em `http://localhost:8080`.

### Acessando o Banco de Dados H2

Para visualizar os dados, tabelas e executar queries SQL diretamente, acesse o console do H2 em seu navegador:

- **URL:** `http://localhost:8080/h2-console`
- Na tela de login, utilize os seguintes dados:
  - **Driver Class:** `org.h2.Driver`
  - **JDBC URL:** `jdbc:h2:mem:vendasdb`
  - **User Name:** `sa`
  - **Password:** `password`

---

## 📖 Documentação da API

Abaixo estão listados os endpoints disponíveis na aplicação.

### Clientes

| Funcionalidade          | Método HTTP | Endpoint              | Corpo (JSON) de Exemplo                                       |
| ----------------------- | ----------- | --------------------- | ------------------------------------------------------------- |
| Listar todos os clientes| `GET`       | `/api/clientes`       | N/A                                                           |
| Buscar cliente por ID   | `GET`       | `/api/clientes/{id}`  | N/A                                                           |
| Criar novo cliente      | `POST`      | `/api/clientes`       | `{"nome": "Clark Kent", "email": "super@dailyplanet.com"}` |
| Atualizar cliente       | `PUT`       | `/api/clientes/{id}`  | `{"nome": "Superman", "email": "superman@justiceleague.com"}`   |
| Deletar cliente         | `DELETE`    | `/api/clientes/{id}`  | N/A                                                           |

### Produtos

| Funcionalidade         | Método HTTP | Endpoint             | Corpo (JSON) de Exemplo                                                      |
| ---------------------- | ----------- | -------------------- | ---------------------------------------------------------------------------- |
| Listar todos os produtos| `GET`       | `/api/produtos`      | N/A                                                                          |
| Buscar produto por ID  | `GET`       | `/api/produtos/{id}` | N/A                                                                          |
| Criar novo produto     | `POST`      | `/api/produtos`      | `{"nome": "Kryptonita", "preco": 999.99, "estoque": 5}`                   |
| Atualizar produto      | `PUT`       | `/api/produtos/{id}` | `{"nome": "Kryptonita (Verde)", "preco": 1099.99, "estoque": 4}`          |
| Deletar produto        | `DELETE`    | `/api/produtos/{id}` | N/A                                                                          |

### Vendas

| Funcionalidade         | Método HTTP | Endpoint          | Corpo (JSON) de Exemplo                                         |
| ---------------------- | ----------- | ----------------- | --------------------------------------------------------------- |
| Listar todas as vendas | `GET`       | `/api/vendas`     | N/A                                                             |
| Registrar nova venda   | `POST`      | `/api/vendas`     | `{"cliente":{"id": 1}, "produto":{"id": 1}, "quantidade": 2}` |

---

## 👨‍💻 Autor

Projeto desenvolvido por **[Lucas Ribeiro Silva]**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/dev-lucasribeirosilva/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/lucas-ribeiro-silva)
