# 📘 User CRUD API

![Java](https://img.shields.io/badge/Java-17-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.8-blue)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-orange)
![H2 Database](https://img.shields.io/badge/DB-H2-yellow)

API RESTful para gerenciamento de usuários, desenvolvida em **Java com Spring Boot**, utilizando **arquitetura em camadas**, **DTOs**, **MapStruct** e banco de dados **H2 em memória**.  
A documentação da API é feita com **Swagger/OpenAPI**, permitindo fácil exploração e testes dos endpoints.

---

## 🚀 Tecnologias utilizadas

- **Java 17+**
- **Spring Boot** (Web, Data JPA, Validation)
- **H2 Database** (banco em memória)
- **MapStruct** (mapeamento entre entidades e DTOs)
- **Lombok** (boilerplate reduction)
- **Swagger / OpenAPI** (documentação interativa da API)

---

## 📂 Arquitetura do projeto

O projeto segue uma **arquitetura em camadas**, garantindo separação de responsabilidades e facilidade de manutenção:

src/main/java/com/seuprojeto
├── controller -> Camada de entrada (exposição da API REST)
├── service -> Regras de negócio
├── repository -> Acesso ao banco de dados (Spring Data JPA)
├── dto -> Objetos de transferência de dados (DTOs)
├── mapper -> Conversões entre entidades e DTOs (MapStruct)
└── config -> Configurações (Swagger, etc.)


---

## 📑 Endpoints principais

- **GET** `/usuario/buscar` → Busca usuário por Email ( via requestParam )
- **POST** `/usuario` → Cria novo usuário  
- **PUT** `/usuario/{id}` → Atualiza usuário existente  
- **DELETE** `/usuario/{email}` → Remove usuário  

---

## 📖 Documentação da API (Swagger)

Após iniciar o projeto, acesse a interface do Swagger UI:

👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

A especificação OpenAPI em JSON está disponível em:  
👉 [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## 🛠️ Como rodar o projeto

### Pré-requisitos
- **Java 17+**
- **Maven 3+**

### Passos
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-projeto.git
   cd seu-projeto

2. Execute a aplicação com Maven:
   ```Terminal
   mvn spring-boot:run
   
3. Acesse o H2 Console em:
   ```Console do navegador
   👉 http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:testdb
   User: sa
   Password: (em branco)

🧩 Conceitos aplicados

CRUD completo (Create, Read, Update, Delete)

Arquitetura em camadas

DTOs + MapStruct para desacoplar entidade da API

Validações com javax.validation

Banco H2 em memória (ideal para testes rápidos)

Swagger/OpenAPI para documentação e testes interativos
