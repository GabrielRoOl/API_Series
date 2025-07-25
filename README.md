<h1 align="center" style="font-weight: bold;">API de Integração para Plataforma de Séries 💻</h1>

<p align="center">API desenvolvida como projeto de aprimoramento profissional, integrando com a API pública da IBM 
  para criar um banco de dados completo de séries e filmes, com estrutura própria de episódios e temporadas.
</p>

<h3>🔍 Principais Funcionalidades: </h3>

- Consumo e processamento de dados da API publica da IBM
- Armazenamento em banco de dados PostgreSQL
- Endpoints RESTful para consulta
- Gerenciamento de temporadas e episódios
- Top 5 séries melhor avaliadas no banco de dados
- Filtros por data de lançamento

<h3>🎯 Objetivos do Projeto:</h3>

- Praticar a implementação de API com Java e Spring Boot
- Implementar padrões de arquitetura MVC, POO, ORM e etc.
- Desenvolver queries complexas em banco relacional
- Criar documentação API completa


<p align="center">
 <a href="#tech">Technologies</a> • 
 <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a> •
 <a href="#colab">Collaborators</a> •
 <a href="#contribute">Contribute</a>
</p>

<h2 id="tech">💻 Technologies</h2>


- Java
- PostgreSQL  
- Config Cors
- Spring Boot
- IntelLij
- Designer pattern
- MVC - Model-View-Controller
- POO - Object-Oriented Programming
- ORM - Object-Relational Mapping
- Data base config

<h2 id="started">🚀 Getting started</h2>

<h3> Prerequesites </h3>

- [Java](https://www.java.com/en/download/manual.jsp)
- [JDK](https://www.oracle.com/br/java/technologies/downloads)
- [Spring boot](https://spring.io/projects/spring-boot)
- [PosgreSQL](https://www.postgresql.org)


```bash
git clone https://github.com/GabrielRoOl/API_Series.git
```

<h3> Config .env variables </h3>

Use the `.env.example` as reference to create your configuration file `.env` with your AWS Credentials

```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

<h3>Starting</h3>

How to start your project
```
cd API_Series
```
Run the project
```java
 1 - Buscar séries
 2 - Buscar episódios
 3 - Listar séries buscadas
 4 - Buscar série por título
 5 - Buscar séries por ator e avaliação mínima
 6 - Top 5 séries com melhor avaliação
 7 - Buscar séries pela categoria
 8 - Filtrar séries
 9 - Buscar episodio pro trecho
10 - Top 5 episódios por série
11 - Buscar episódios a partir de uma data

0 - Sair
```
Search for the series you want to add to your database

<h2 id="routes">📍 API Endpoints</h2>

Here you can list the main routes of your API, and what are their expected request bodies.
​
| route                 | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /series</kbd>     | retrieves information from all series [response details](#get-series)
| <kbd>GET /series/top5</kbd>     | retrieves information from the top 5 series [request details](#get-series-top5)
|<kbd>GET /series/lancamentos</kbd> | retrieve series information according to release [request details](#get-series-lancamentos)
|<kbd>GET /series/{id}</kbd> | retrieve information from a series by id [request details](#get-series-id)
|<kbd>GET /{id}/temporadas/todas</kbd> | returns all seasons and all episodes [request details](#get-id-temporadas-todas)
|<kbd>GET /{id}/temporadas/{numero}</kbd> | returns the season by number [request details](#get-id-temporadas-numero)
|<kbd>GET /categoria/{nome}</kbd> | returns the season by number [request details](#get-categoria/acao)

<h3 id="get-series">GET /series</h3>

<h3>RESPONSE</h3>

```json
[
  {
    "id": 1,
    "titulo": "Friends",
    "totalTemporadas": 10,
    "avaliacao": 8.9,
    "escritor": "David Crane, Marta Kauffman",
    "atores": "Jennifer Aniston, Courteney Cox, Lisa Kudrow",
    "poster": "https://m.media-amazon.com/images/M/MV5BOTU2YmM5ZjctOGVlMC00YTczLTljM2MtYjhlNGI5YWMyZjFkXkEyXkFqcGc@._V1_SX300.jpg",
    "sinopse": "https://m.media-amazon.com/images/M/MV5BOTU2YmM5ZjctOGVlMC00YTczLTljM2MtYjhlNGI5YWMyZjFkXkEyXkFqcGc@._V1_SX300.jpg"
  }
]
```

<h3 id="get-series-top5">GET /series/top5</h3>
<h3> RESPONSE </h3>

```json
[
  {
    "id": 1,
    "titulo": "Friends",
    "totalTemporadas": 10,
    "avaliacao": 8.9,
    "escritor": "David Crane, Marta Kauffman",
    "atores": "Jennifer Aniston, Courteney Cox, Lisa Kudrow",
    "poster": "https://m.media-amazon.com/images/M/MV5BOTU2YmM5ZjctOGVlMC00YTczLTljM2MtYjhlNGI5YWMyZjFkXkEyXkFqcGc@._V1_SX300.jpg",
    "sinopse": "https://m.media-amazon.com/images/M/MV5BOTU2YmM5ZjctOGVlMC00YTczLTljM2MtYjhlNGI5YWMyZjFkXkEyXkFqcGc@._V1_SX300.jpg"
  },
  {
    "id":3,
    // ... dados da serie
  },
  {
    "id":7,
    // ... dados da serie
  },
  {
    "id":8,
    // ... dados da serie
  },
  {
    "id":2,
    // ... dados da serie
  }
]
```

<h3 id="get-series-lancamentos">GET /series/lancamentos </h3>
<h3> RESPONSE </h3>

```json
[
  {
    "id":8,
    // ... dados da serie
  }, 
  {
    "id":7,
    // ... dados da serie
  },
  // ...demais series
]
```

<h3 id="get-series-id">GET /series/2 </h3> 
<h3> RESPONSE </h3>

```json
[
  {
    "id": 2,
    "titulo": "How I Met Your Mother",
    "totalTemporadas": 9,
    "avaliacao": 8.3,
    "escritor": "Carter Bays, Craig Thomas",
    "atores": "Josh Radnor, Jason Segel, Cobie Smulders",
    "poster": "https://m.media-amazon.com/images/M/MV5BNjg1MDQ5MjQ2N15BMl5BanBnXkFtZTYwNjI5NjA3._V1_SX300.jpg",
    "sinopse": "https://m.media-amazon.com/images/M/MV5BNjg1MDQ5MjQ2N15BMl5BanBnXkFtZTYwNjI5NjA3._V1_SX300.jpg"
  }
]
```

<h3 id="get-id-temporadas-todas"> GET /1/temporadas/todas </h3>
<h3> RESPONSE </h3>

```json
[
  {
    "temporada": 1,
    "titulo": "The One Where Monica Gets a Roommate",
    "numeroEpisodio": 1
  },
  // ...demais temporadas e episódios
]
```

<h3 id="get-id-temporadas-numero">GET /1/temporadas/1 </h3>
<h3> RESPONSE </h3>

```json
[
  {
    "temporada": 1,
    "titulo": "The One Where Monica Gets a Roommate",
    "numeroEpisodio": 1
  },
  // ...demais temporadas e episódios
]
```

<h2 id="colab">🤝 Collaborators</h2>


<h2 id="contribute">Contribute</h2>