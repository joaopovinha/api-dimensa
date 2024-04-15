# API RESTful da Dimensa

Esta é uma API RESTful desenvolvida como parte do desafio técnico proposto pela empresa Dimensa. Ela permite realizar operações CRUD em um banco de dados MySQL, utilizando SpringFramework e Java 21.

A aplicação interage com um banco de dados que possui duas tabelas: `contato` e `endereco`. A tabela `contato` contém os campos: `contatoid` como chave primária, `nome`, `email`, `telefone`, `dataNascimento` e o campo `endereco` (via tabela `endereco`). A tabela `endereco` possui os campos: `contatoId` como chave primária e estrangeira, `rua`, `numero` e `cep`.

## Endpoints

A API possui os seguintes endpoints:

### 1. Criação de Contato
- **POST** `/contato`

    Cria um novo contato no banco de dados. O usuário deve informar os seguintes campos no corpo da requisição:
    - `nome`: String
    - `email`: String
    - `telefone`: String
    - `dataNascimento`: String
    
    Após informar todos os campos e enviar a requisição, a API retorna o status 201 e passa o `id` gerado para o novo contato via header, se a operação foi bem-sucedida.

### 2. Criação de Endereço para um Contato
- **POST** `/contato/{contatoId}/endereco`

    Cria um endereço para o contato cujo `id` foi informado no POST. O usuário deve informar os seguintes campos no corpo da requisição:
    - `rua`: String
    - `numero`: String
    - `cep`: String

### 3. Obter todos os Contatos com seus Endereços
- **GET** `/contato`

    Retorna todos os contatos cadastrados no banco de dados, incluindo seus dados e respectivos endereços.

### 4. Obter um Contato pelo ID
- **GET** `/contato/{contatoId}`

    Retorna todos os dados do contato cujo `id` foi informado na requisição.

### 5. Atualização de Contato
- **PUT** `/contato/{contatoId}`

    Permite atualizar os dados de um contato informado via `id` na requisição.

### 6. Exclusão de Contato
- **DELETE** `/contato/{contatoId}`

    Realiza a exclusão do contato informado via `id` na requisição e todos os seus dados.

## Documentação via Swagger

A aplicação conta com uma documentação via OpenAPI (Swagger) para facilitar a interação e testes dos endpoints. Para acessar o Swagger da aplicação, basta utilizar o seguinte endereço: [INSERIR AQUI O ENDEREÇO].

## Hospedagem e Banco de Dados

A API está atualmente hospedada na AWS através de uma instância EC2 e utiliza um banco de dados hospedado na nuvem via RDS.

Para qualquer dúvida ou sugestão, entre em contato comigo.

---
Este projeto faz parte do desafio técnico da empresa Dimensa. Desenvolvido por João Bomfim Povinha.
