<div align="center">
  <h1>API de Autenticação e Gerenciamento de Usuários</h1>
  <p>
    <strong>Uma API RESTful completa construída com Spring Boot e Spring Security para gerenciar usuários com autenticação baseada em JWT e controle de acesso por papéis.</strong>
  </p>

  <p>
    <img alt="Java" src="https://img.shields.io/badge/Java-17 | 21-blue.svg?style=for-the-badge&logo=openjdk">
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring_Boot-3.x.x-success.svg?style=for-the-badge&logo=spring">
    <img alt="Maven" src="https://img.shields.io/badge/Maven-4.0.0-red.svg?style=for-the-badge&logo=apachemaven">
    <img alt="License" src="https://img.shields.io/badge/Licença-Estudo-informational.svg?style=for-the-badge">
  </p>
</div>

---

## 📋 Tabela de Conteúdos

1.  [Visão Geral](#-visão-geral)
2.  [Principais Funcionalidades](#-principais-funcionalidades)
3.  [Tecnologias](#-tecnologias)
4.  [Como Executar](#-como-executar)
    - [Pré-requisitos](#pré-requisitos)
    - [Instalação e Execução](#instalação-e-execução)
    - [Acesso ao Banco H2](#acesso-ao-banco-h2)
5.  [Endpoints da API](#-endpoints-da-api)
    - [Autenticação (Público)](#autenticação-público)
    - [Usuários (Protegido)](#usuários-protegido)
6.  [Configurações](#-configurações)
7.  [Observações](#-observações)
8.  [Licença](#-licença)

---

## 🎯 Visão Geral

Esta é uma API RESTful desenvolvida em **Spring Boot** que implementa um sistema de cadastro, autenticação e gerenciamento de usuários. A segurança é garantida pelo **Spring Security**, com autenticação via **Tokens JWT** e controle de acesso baseado em papéis (`ROLE_USER` e `ROLE_ADMIN`).

---

## ✨ Principais Funcionalidades

-   🔐 **Autenticação Segura:** Login de usuários com geração de token JWT.
-   👤 **Cadastro de Usuários:** Permite o registro de usuários com papéis `USER` ou `ADMIN`.
-   🛡️ **Controle de Acesso por Papel (Role):**
    -   **ADMIN:** Acesso total para listar, buscar, editar e excluir qualquer usuário.
    -   **USER:** Acesso restrito para visualizar e editar apenas o seu próprio perfil.
-   🛠️ **Gerenciamento de Usuários (CRUD):** Endpoints protegidos para operações de gerenciamento.
-   🔒 **Endpoints Protegidos:** Rotas sensíveis são protegidas e exigem um token JWT válido.

---

## 🛠️ Tecnologias

-   **Java 17+** (ou 21)
-   **Spring Boot**
-   **Spring Security** (para autenticação e autorização)
-   **Spring Data JPA** (para persistência de dados)
-   **JSON Web Token (JWT)** (para gerenciamento de sessão stateless)
-   **H2 Database** (banco de dados em memória para ambiente de desenvolvimento)
-   **Maven** (gerenciador de dependências e build)

---

## 🚀 Como Executar

### Pré-requisitos

-   **JDK 17** ou superior instalado.
-   **Maven** instalado e configurado no PATH do sistema.
-   Um cliente de API como **Postman** ou **Insomnia** para testar os endpoints.

### Instalação e Execução

1.  **Clone o repositório:**
    ```sh
    git clone <url-do-repositorio>
    cd <nome-da-pasta-do-projeto>
    ```

2.  **Execute a aplicação com o Maven Wrapper:**

    *No Linux/macOS:*
    ```sh
    ./mvnw spring-boot:run
    ```

    *No Windows:*
    ```sh
    mvnw.cmd spring-boot:run
    ```
    A aplicação estará disponível em `http://localhost:8080`.

### Acesso ao Banco H2

Para visualizar o banco de dados em memória durante o desenvolvimento:

1.  Acesse a URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2.  Preencha os campos da seguinte forma:
    -   **JDBC URL:** `jdbc:h2:mem:user_auth_db`
    -   **User Name:** `sa`
    -   **Password:** (deixe em branco)
3.  Clique em **Connect**.

---

## 🌐 Endpoints da API

### Autenticação (Público)

| Método | Endpoint                    | Descrição                          | Body (Exemplo)                                                               |
| :----- | :-------------------------- | :--------------------------------- | :--------------------------------------------------------------------------- |
| `POST` | `/api/v1/authentication/register`        | Registra um novo usuário (USER).   | `{"username": "user", "email": "user@email.com", "password": "senha123"}`    |
| `POST` | `/api/v1/authentication/register/adm`  | Registra um novo usuário (ADMIN).  | `{"username": "admin", "email": "admin@email.com", "password": "senha123"}` |
| `POST` | `/api/v1/authentication/login`           | Autentica um usuário e retorna JWT.| `{"username": "user", "password": "senha123"}`                               |

### Usuários (Protegido)

> **Todos os endpoints abaixo exigem o header:** `Authorization: Bearer <seu_token_jwt>`

| Método   | Endpoint              | Descrição                                 | Acesso Permitido       |
| :------- | :-------------------- | :---------------------------------------- | :--------------------- |
| `GET`    | `/api/v1/users/profile`  | Busca os dados do perfil do usuário logado. | `USER`, `ADMIN`        |
| `PUT`    | `/api/v1/users/profile`  | Atualiza os dados do perfil do usuário logado.| `USER`, `ADMIN`        |
| `GET`    | `/api/v1/users`          | Lista todos os usuários cadastrados.      | `ADMIN`                |
| `GET`    | `/api/v1/users/{id}`     | Busca um usuário por seu ID.              | `ADMIN`                |
| `PUT`    | `/api/v1/users/{id}`     | Atualiza os dados de um usuário por ID.   | `ADMIN`                |
| `DELETE` | `/api/v1/users/{id}`     | Deleta um usuário por ID.                 | `ADMIN`                |

---

## ⚙️ Configurações

-   **Porta do Servidor:** A porta padrão é `8080`. Pode ser alterada no arquivo `application.properties`.
-   **Configurações do JWT:** O segredo (`jwt.secret`) e o tempo de expiração (`jwt.expiration`) do token estão definidos no arquivo `application.properties`. **É altamente recomendável alterar o segredo para um valor mais seguro.**

---
