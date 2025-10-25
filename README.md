# Warehouse Microservice
[🇺🇸 English](./README.en.md) | [🇧🇷 Português](./README.md)

![GitHub License](https://img.shields.io/github/license/emellybmuniz/dio-ecommerce-control)
![GitHub language count](https://img.shields.io/github/languages/count/emellybmuniz/dio-ecommerce-control)
![GitHub last commit](https://img.shields.io/github/last-commit/emellybmuniz/dio-ecommerce-control)
![GitHub repo size](https://img.shields.io/github/repo-size/emellybmuniz/dio-ecommerce-control)
![Project Status](https://img.shields.io/badge/Status%20-%20em%20desenvolvimento%20-%20%23EB3731)
![GitHub Stars](https://img.shields.io/github/stars/emellybmuniz/dio-ecommerce-control?style=social)

Sistema de gerenciamento de estoque baseado em microsserviços, desenvolvido com Spring Boot e mensageria RabbitMQ para sincronização de disponibilidade de produtos em tempo real.

---

### 📋 Índice
- [Visão Geral do Projeto](#-visão-geral-do-projeto)
- [Estrutura de Diretórios](#-estrutura-de-diretórios)
- [Destaques & Funcionalidades](#-destaques--funcionalidades)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação](#-instalação)
- [Configuração](#-configuração)
- [API/Funcionalidades Avançadas](#-apifuncionalidades-avançadas)
- [Contribuição](#-contribuição)
- [Melhorias Futuras](#-melhorias-futuras)
- [Licença](#-licença)
- [Autora](#-autora)

---

## 🚀 Visão Geral do Projeto

O **Warehouse** é um microsserviço de gerenciamento de estoque que faz parte de uma arquitetura distribuída de e-commerce. O sistema utiliza comunicação assíncrona via RabbitMQ para sincronizar a disponibilidade de produtos entre diferentes serviços.

**Contexto e Motivação:**
Este projeto foi desenvolvido como parte de um estudo sobre arquitetura de microsserviços, demonstrando conceitos fundamentais como:
- Comunicação assíncrona entre serviços
- Mensageria com RabbitMQ
- Integração entre microsserviços via REST
- Persistência de dados com JPA/Hibernate
- Documentação de API com OpenAPI/Swagger

**Público-alvo:**
Desenvolvedores interessados em aprender sobre microsserviços, mensageria e arquitetura distribuída.

**Principais Benefícios:**
- Desacoplamento entre serviços de estoque e vitrine
- Sincronização em tempo real da disponibilidade de produtos
- Escalabilidade horizontal facilitada
- Fácil manutenção e evolução independente dos serviços

## 📂 Estrutura de Diretórios

```bash
📦 warehouse/
├── src/
│   └── main/
│       ├── java/br/com/dio/warehouse/
│       │   ├── config/               # Configurações do projeto
│       │   │   ├── AMQPConfig.java  # Configuração RabbitMQ
│       │   │   ├── OpenAPIConfig.java # Configuração Swagger
│       │   │   └── RabbitmqQueueProperties.java
│       │   ├── controller/           # Controladores REST
│       │   │   ├── request/         # DTOs de requisição
│       │   │   └── response/        # DTOs de resposta
│       │   ├── dto/                  # Data Transfer Objects
│       │   ├── entity/               # Entidades JPA
│       │   ├── mapper/               # MapStruct mappers
│       │   ├── repository/           # Repositórios JPA
│       │   ├── service/              # Camada de serviços
│       │   │   └── impl/            # Implementações dos serviços
│       │   └── WarehouseApplication.java # Classe principal
│       └── resources/
│           ├── application.yml       # Configuração principal
│           └── application-dev.yml   # Configuração de desenvolvimento
├── gradle/                           # Wrapper do Gradle
├── build.gradle.kts                  # Configuração de build
├── settings.gradle.kts               # Settings do Gradle
└── README.md                         # Este arquivo
```

## ✨ Destaques & Funcionalidades

### 🎯 **Gerenciamento de Produtos**
- Cadastro e consulta de produtos no estoque
- Atualização automática de disponibilidade via mensageria
- Listagem de produtos ativos ordenados por nome
- Consulta detalhada com integração ao serviço de precificação

### 🔄 **Mensageria Assíncrona**
- Consumo de mensagens RabbitMQ para atualização de status
- Conversão automática JSON com Jackson2JsonMessageConverter
- Listeners configurados para filas específicas
- Processamento de mudanças de disponibilidade em tempo real

### 🌐 **API RESTful Completa**
- Endpoints CRUD para gerenciamento de produtos
- Integração com serviço externo de precificação
- Operação de compra com comunicação entre microsserviços
- Documentação interativa com Swagger UI

### 🗄️ **Persistência de Dados**
- JPA/Hibernate para mapeamento objeto-relacional
- Banco de dados H2 em memória para desenvolvimento
- Repository pattern com Spring Data JPA
- Console H2 habilitado para debug

### 🛠️ **Qualidade de Código**
- MapStruct para mapeamento automático de DTOs
- Lombok para redução de boilerplate
- Separação clara de responsabilidades (Controller → Service → Repository)
- Configuration properties type-safe

## 🛠️ Tecnologias Utilizadas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![H2](https://img.shields.io/badge/H2-0000BB?style=for-the-badge&logo=database&logoColor=white)

### Detalhes Técnicos:
- **Java 21**: Linguagem principal com recursos modernos
- **Spring Boot 3.5.7**: Framework para desenvolvimento de aplicações
  - Spring Web: API REST
  - Spring Data JPA: Acesso a dados
  - Spring AMQP: Integração RabbitMQ
  - Spring DevTools: Desenvolvimento produtivo
- **RabbitMQ**: Broker de mensageria para comunicação assíncrona
- **H2 Database**: Banco de dados em memória para testes
- **MapStruct 1.6.3**: Geração automática de código para mapeamento
- **Lombok**: Redução de código boilerplate
- **SpringDoc OpenAPI**: Documentação automática de APIs
- **Gradle 8.14.3**: Gerenciamento de dependências e build

## ⚙️ Pré-requisitos

**Ferramentas necessárias:**
- Java JDK 21+
- Gradle 8.14+ (ou use o wrapper incluído)
- RabbitMQ Server rodando localmente ou remotamente
- Git para versionamento

**Serviços externos:**
- RabbitMQ rodando em `jaragua:5672` (configurável)
- Microsserviço Storefront rodando em `localhost:8080` (para integração completa)

## 📦 Instalação

```bash
# 1. Clone este repositório
$ git clone https://github.com/emellybmuniz/warehouse.git

# 2. Navegue até o diretório do projeto
$ cd warehouse

# 3. Execute o build do projeto com Gradle
$ ./gradlew build

# 4. Execute a aplicação
$ ./gradlew bootRun
```

**No Windows, use `gradlew.bat` ao invés de `./gradlew`**

**Alternativa - Executar JAR:**
```bash
# Após o build, execute o JAR gerado
$ java -jar build/libs/warehouse-0.0.1-SNAPSHOT.jar
```

## 💡 Como Usar

1. **Inicie o RabbitMQ** - Certifique-se de que o RabbitMQ está rodando e acessível
   ```bash
   # Exemplo com Docker
   docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
   ```

2. **Configure as credenciais** - Ajuste as configurações em `application.yml` se necessário
   - Host: `jaragua` (ou `localhost`)
   - Porta: `5672`
   - Usuário/Senha: `admin/admin`

3. **Inicie a aplicação** - Execute `./gradlew bootRun`

4. **Acesse a documentação da API** - Swagger UI disponível em:
   ```
   http://localhost:8081/storefront/swagger-ui.html
   ```

5. **Teste os endpoints** - Use o Swagger UI ou ferramentas como Postman/cURL

### Exemplos de Uso:

**Criar um novo produto:**
```bash
curl -X POST http://localhost:8081/storefront/products \
  -H "Content-Type: application/json" \
  -d '{
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "name": "Produto Exemplo"
  }'
```

**Listar produtos disponíveis:**
```bash
curl http://localhost:8081/storefront/products
```

**Consultar detalhes de um produto:**
```bash
curl http://localhost:8081/storefront/products/{id}
```

**Realizar compra:**
```bash
curl -X POST http://localhost:8081/storefront/products/{id}/purchase
```

## ⚙️ Configuração

### Configurações Básicas (application.yml):

- **Porta do servidor**: `8081`
- **Context path**: `/storefront`
- **Banco de dados**: H2 em memória (`jdbc:h2:mem:storefront`)
- **Console H2**: Habilitado em `/h2-console`

### Configurações RabbitMQ:

```yaml
spring:
  rabbitmq:
    host: jaragua              # Altere para seu host
    port: 5672
    username: admin
    password: admin
    virtual-host: /

storefront:
  rabbitmq:
    queue:
      product-change-availability: product.change.availability.queue
      warehouse:
        base-path: http://localhost:8080/warehouse
```

### Configurações de Desenvolvimento:

Para habilitar hot reload, crie um arquivo `trigger.txt` em `src/main/resources/` e use o perfil `dev`:

```bash
./gradlew bootRun --args='--spring.profiles.active=dev'
```

## 🔌 API/Funcionalidades Avançadas

### Endpoints Disponíveis:

| Método | Endpoint | Descrição | Parâmetros |
|--------|----------|-----------|------------|
| POST | `/products` | Cria um novo produto | Body: ProductSaveRequest (JSON) |
| GET | `/products` | Lista todos os produtos disponíveis | - |
| GET | `/products/{id}` | Consulta detalhes de um produto | Path: id (UUID) |
| POST | `/products/{id}/purchase` | Realiza compra de um produto | Path: id (UUID) |

### Mensageria:

**Fila de consumo:**
- **Nome**: `product.change.availability.queue`
- **Formato da mensagem**:
  ```json
  {
    "id": "uuid-do-produto",
    "status": "AVAILABLE" ou "UNAVAILABLE"
  }
  ```
- **Comportamento**: Atualiza automaticamente o campo `active` do produto

### Integração com Storefront:

O serviço se comunica com o microsserviço Storefront para:
- Buscar informações de preço dos produtos
- Notificar sobre compras realizadas

**Base URL configurável**: `warehouse.base-path` no `application.yml`

## 🤝 Contribuição

Contribuições são sempre bem-vindas e **muito apreciadas!** Sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_.

### Como contribuir:

1. **Fork** este repositório
2. **Clone** seu fork: `git clone https://github.com/seu-usuario/warehouse.git`
3. **Crie uma branch** para sua feature: `git checkout -b feature/nova-funcionalidade`
4. **Faça suas alterações** e teste completamente
5. **Commit** suas mudanças: `git commit -m 'Adiciona nova funcionalidade'`
6. **Push** para a branch: `git push origin feature/nova-funcionalidade`
7. **Abra um Pull Request** com descrição detalhada das mudanças

### Diretrizes para Contribuição:

- Mantenha o código limpo e bem comentado
- Siga os padrões de código Java e Spring Boot
- Adicione testes unitários para novas funcionalidades
- Atualize a documentação quando necessário
- Use commits semânticos (feat, fix, docs, etc.)

## 🚀 Melhorias Futuras

### Próximas Funcionalidades:

- [x] **Configuração inicial do Warehouse** - Estrutura base do microsserviço
- [x] **Status e criação de entidades** - Modelagem do domínio
- [ ] **Criar services de produto e producer de mensagens no RabbitMQ** - Lógica de negócio e mensageria
- [ ] **Implementando o ProductService** - Serviço principal de produtos
- [ ] **Service de stock e controllers** - Controle de estoque e endpoints REST
- [ ] **Implementando método para o consumo e ProductEntity** - Consumer RabbitMQ
- [ ] **Teste nos microsserviços e subi-los com sucesso** - Validação e2e

## 🔑 Licença

Este projeto está licenciado sob a **Licença MIT** - consulte o arquivo [LICENSE](LICENSE) para obter mais detalhes.

Você é livre para usar, modificar e distribuir este projeto, desde que mantenha os créditos aos autores originais.

## ✍️ Autora

Desenvolvido por **Emelly Beatriz** com ❤️

📬 Entre em contato:

📧 emellybmuniz@gmail.com |
💼 [Linkedin](https://www.linkedin.com/in/emellybmuniz) |
🐙 [Github](https://github.com/emellybmuniz)

---

⭐ **Gostou do projeto?** Deixe uma estrela no repositório para apoiar o desenvolvimento!

**#Microsserviços #SpringBoot #RabbitMQ #Java #Backend #Mensageria #API #REST**
