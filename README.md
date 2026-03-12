# Sistema LEPIC – Gerenciamento de Treinamentos em Realidade Virtual

Sistema desktop desenvolvido em **Java** para gerenciamento de alunos e acompanhamento de treinamentos em **Realidade Virtual**.

A aplicação permite que tutores realizem login, cadastrem alunos, registrem feedbacks sobre treinamentos e visualizem estatísticas de desempenho dos participantes.

## 👨‍💻 Autor

**Gabriel Diegues Figueiredo Rocha**

Linkedin:
[www.linkedin.com/in/gabrieldiegues](www.linkedin.com/in/gabrieldiegues)


## 📌 Funcionalidades

### 👨‍🎓 Gerenciamento de Alunos

* Cadastrar alunos
* Consultar alunos
* Alterar informações de alunos
* Excluir alunos

### 📝 Gerenciamento de Feedback

* Registrar feedback de treinamentos
* Consultar feedback de alunos
* Alterar feedback existente
* Excluir feedback

### 📊 Visualização de Estatísticas

* Exibição de dados de desempenho do aluno em treinamentos VR
* Informações como:

  * Partidas jogadas
  * Data do treinamento
  * Melhor tempo
  * Horas praticadas
  * Nome do treinamento

### 🔐 Sistema de Login

* Autenticação de tutores
* Validação de credenciais no banco de dados

## 🏗️ Arquitetura do Projeto

O projeto segue uma organização inspirada no padrão **MVC (Model–View–Controller)**.

```
SistemaLEPIC
│
├── controller
│   └── TesteConexao_DB.java
│
├── model
│   ├── CRUD_DAO.java
│   ├── FuncoesGerais_DAO.java
│   ├── Login_DAO.java
│   └── Tabela_DAO.java
│
├── view
│   ├── Login_GUI
│   ├── Aluno_GUI
│   ├── Feedback_GUI
│   └── Tabela_GUI
```

### Controller

Responsável pela **conexão com o banco de dados**.

### Model (DAO)

Responsável pelas **operações no banco**:

* CRUD de alunos
* CRUD de feedback
* validações
* consultas de estatísticas

### View

Interface gráfica desenvolvida com **Java Swing**.

## 🛠️ Tecnologias Utilizadas

* **Java**
* **Java Swing** (interface gráfica)
* **MySQL**
* **JDBC** (Java Database Connectivity)
* **SQL**
* **Arquitetura MVC**
* **DAO (Data Access Object)**

## 🗄️ Banco de Dados

O sistema utiliza um banco de dados MySQL chamado:

```
treinamento_vr
```

### Principais Tabelas

#### aluno

| Campo | Tipo    |
| ----- | ------- |
| rm    | INT     |
| nome  | VARCHAR |
| turma | VARCHAR |

#### tutor

| Campo | Tipo    |
| ----- | ------- |
| pf    | INT     |
| senha | VARCHAR |

#### feedback

| Campo      | Tipo    |
| ---------- | ------- |
| comentario | TEXT    |
| status     | VARCHAR |
| aluno_rm   | INT     |
| tutor_pf   | INT     |

#### estatistica

| Campo            | Tipo    |
| ---------------- | ------- |
| partidas_jogadas | INT     |
| data             | DATE    |
| melhor_tempo     | TIME    |
| horas_praticadas | INT     |
| treinamento_nome | VARCHAR |
| aluno_rm         | INT     |

## ⚙️ Configuração do Projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/GabrielDiegues/SistemaLEPIC.git
```

### 2️⃣ Criar o banco de dados

```sql
CREATE DATABASE treinamento_vr;
```

### 3️⃣ Configurar credenciais do banco

No arquivo:

```
TesteConexao_DB.java
```

configure:

```java
private static final String url = "jdbc:mysql://localhost/treinamento_vr";
private static final String username = "seu_usuario";
private static final String password = "sua_senha";
```

### 4️⃣ Executar o projeto

Abra o projeto em uma IDE Java (como **NetBeans, IntelliJ ou Eclipse**) e execute a aplicação.

## 📊 Exemplo de Fluxo de Uso

1. Tutor realiza login no sistema
2. Tutor cadastra ou consulta alunos
3. Após um treinamento VR, tutor registra feedback
4. Sistema armazena dados no banco
5. Estatísticas podem ser visualizadas na tabela de desempenho

## 🚀 Possíveis Melhorias Futuras

* Implementação de **Prepared Statements seguros** (evitar SQL Injection)
* Sistema de **hash de senha**
* Interface moderna com **JavaFX**
* API REST para integração com outros sistemas
* Dashboard com gráficos de desempenho
* Controle de sessões de usuários
