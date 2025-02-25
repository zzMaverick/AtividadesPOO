# Sistema de Login e Listagem de Usuários

Este é um simples sistema de login em Java utilizando a biblioteca Swing para a interface gráfica, integrado com um banco de dados PostgreSQL para autenticação de usuários e listagem de dados.

## Funcionalidades

- **Tela de Login**: Permite ao usuário realizar login com um nome de usuário e senha.
- **Conexão com o Banco de Dados**: O sistema se conecta a um banco de dados PostgreSQL para autenticar o usuário e listar dados de estudantes.
- **Botões de Ação**:
  - **Login**: Verifica as credenciais do usuário no banco de dados. Se as credenciais estiverem corretas, o usuário é redirecionado para uma tela inicial.
  - **Listar**: Exibe os nomes dos estudantes cadastrados no banco de dados.
  - **Buscar**: Exibe todos os dados da tabela estudante.
  - **Sair**: Fecha o aplicativo.

## Pré-requisitos

- **Java 8 ou superior**
- **Banco de dados PostgreSQL**
- **Driver JDBC do PostgreSQL**

## Instalação

### 1. Configurar o Banco de Dados

1. Crie um banco de dados PostgreSQL (por exemplo, `postgres`).
2. Crie a tabela `estudante` com a seguinte estrutura:
    ```sql
    CREATE TABLE estudante (
        id SERIAL PRIMARY KEY,
        nome VARCHAR(100),
        senha VARCHAR(100)
    );
    ```

3. Insira alguns dados na tabela para realizar testes de login:
    ```sql
    INSERT INTO estudante (nome, senha) VALUES ('usuario1', 'senha123');
    INSERT INTO estudante (nome, senha) VALUES ('usuario2', 'senha456');
    ```

### 2. Configurar a Conexão no Código

- O código está configurado para conectar ao banco de dados localmente com o seguinte endereço:
    ```
    jdbc:postgresql://localhost:5432/postgres
    ```

- O nome de usuário e a senha utilizados na conexão são **"postgres"** e **"root"**, respectivamente. Caso seja necessário, ajuste esses parâmetros de acordo com as configurações do seu banco de dados.

### 3. Compilar e Executar

1. Compile o código Java com o comando:
    ```bash
    javac UserLogin.java
    ```

2. Execute o programa com o comando:
    ```bash
    java UserLogin
    ```

## Estrutura do Código

### Classe UserLogin

Esta é a classe principal que representa a tela de login do usuário.

#### Atributos principais:

- **campoTexto**: Campo de entrada de texto para o nome do usuário.
- **campoSenha**: Campo de entrada de senha para o usuário.
- **btnNovoBotao**: Botão de login que valida as credenciais do usuário.
- **btnSairBotao**: Botão que fecha o aplicativo.
- **btnListarUsuarios**: Botão que exibe a lista de estudantes registrados no banco de dados.
- **btnBuscar**: Botão que exibe todos os dados da tabela estudante do banco de dados.

#### Conexão com o banco de dados:

- A classe se conecta ao banco de dados PostgreSQL usando o JDBC, realizando operações como validação de login e listagem de dados da tabela estudante.

#### Interface gráfica:

- Utiliza a biblioteca Swing para construir a interface gráfica, com campos de texto para o nome de usuário e senha, e botões para as ações de login, listagem de usuários, busca e saída.

### Método Principal (main)

- O método `main` inicializa a aplicação, criando uma instância de `UserLogin` e tornando a interface visível para o usuário.

## Ação dos Botões

- **Login**: Quando o botão "Login" é pressionado, o sistema verifica se o nome de usuário e a senha correspondem a um registro no banco de dados. Se correto, o usuário é redirecionado para uma tela inicial (`UserHome`).
- **Listar**: O botão "Listar" faz uma consulta ao banco de dados para retornar apenas os nomes dos estudantes e exibe em uma tabela.
- **Buscar**: O botão "Buscar" exibe todos os dados da tabela estudante em uma tabela na interface gráfica.
