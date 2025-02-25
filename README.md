Sistema de Login e Listagem de Usuários

Este é um simples sistema de login em Java utilizando a biblioteca Swing para a interface gráfica, integrado com um banco de dados PostgreSQL para autenticação de usuários e listagem de dados.

Funcionalidades

  Tela de Login: Permite ao usuário realizar login com um nome de usuário e senha.
  Conexão com o Banco de Dados: O sistema se conecta a um banco de dados PostgreSQL para autenticar o usuário e listar dados de estudantes.
  Botões de Ação:
  Login: Verifica as credenciais do usuário no banco de dados. Se as credenciais estiverem corretas, o usuário é redirecionado para uma tela inicial.
  Listar: Exibe os nomes dos estudantes cadastrados no banco de dados.
  Buscar: Exibe todos os dados da tabela estudante.
  Sair: Fecha o aplicativo.
Pré-requisitos

  Java 8 ou superior
  Banco de dados PostgreSQL
  Driver JDBC do PostgreSQL
Instalação

  Configurar o Banco de Dados:
  Crie um banco de dados PostgreSQL (por exemplo, postgres).
  Crie a tabela estudante com a seguinte estrutura:
  CREATE TABLE estudante (
      id SERIAL PRIMARY KEY,
      nome VARCHAR(100),
      senha VARCHAR(100)
  );
  Insira alguns dados na tabela para realizar testes de login:
  INSERT INTO estudante (nome, senha) VALUES ('usuario1', 'senha123');
  INSERT INTO estudante (nome, senha) VALUES ('usuario2', 'senha456');
  Configurar a Conexão no Código:
  O código está configurado para conectar ao banco de dados localmente com o seguinte endereço:
  jdbc:postgresql://localhost:5432/postgres
  O nome de usuário e a senha utilizados na conexão são "postgres" e "root", respectivamente. Caso seja necessário, ajuste esses parâmetros de acordo com as configurações do seu banco de dados.
  Compilar e Executar:
  Compile o código Java com um comando similar a:
  javac UserLogin.java
  Execute o programa:
  java UserLogin
  Estrutura do Código

  Classe UserLogin
  Esta é a classe principal que representa a tela de login do usuário.

Atributos principais:
  campoTexto: Campo de entrada de texto para o nome do usuário.
  campoSenha: Campo de entrada de senha para o usuário.
  btnNovoBotao: Botão de login que valida as credenciais do usuário.
  btnSairBotao: Botão que fecha o aplicativo.
  btnListarUsuarios: Botão que exibe a lista de estudantes registrados no banco de dados.
  btnBuscar: Botão que exibe todos os dados da tabela estudante do banco de dados.
  Conexão com o banco de dados:
  A classe se conecta ao banco de dados PostgreSQL usando o JDBC, realizando operações como validação de login e listagem de dados da tabela estudante.
Interface gráfica:
  Utiliza a biblioteca Swing para construir a interface gráfica, com campos de texto para o nome de usuário e senha, e botões para as ações de login, listagem de usuários, busca e saída.
  Método Principal (main)
  O método main inicializa a aplicação, criando uma instância de UserLogin e tornando a interface visível para o usuário.

Ação dos Botões
  Login: Quando o botão "Login" é pressionado, o sistema verifica se o nome de usuário e a senha correspondem a um registro no banco de dados. Se correto, o usuário é redirecionado para uma tela inicial (UserHome).
  Listar: O botão "Listar" faz uma consulta ao banco de dados para retornar apenas os nomes dos estudantes e exibe em uma tabela.
  Buscar: O botão "Buscar" exibe todos os dados da tabela estudante em uma tabela na interface gráfica.
  Possíveis Melhorias

Tratamento de erros: Melhorar o tratamento de exceções, por exemplo, exibir mensagens mais amigáveis para o usuário em caso de falhas na conexão com o banco de dados.
  Segurança: A senha dos usuários deveria ser armazenada de forma segura, utilizando hash, em vez de ser armazenada em texto simples.
  Interface: A interface gráfica pode ser melhorada com a adição de mais componentes, como barras de progresso, e uma melhor estrutura visual.
  Licença
