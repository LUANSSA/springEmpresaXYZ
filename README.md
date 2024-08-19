# Projeto EmpresaXYZ

Este é um projeto de exemplo que utiliza Docker para configurar uma aplicação Spring Boot e um banco de dados MySQL. Este guia explica como inicializar o projeto e quais configurações você deve substituir para torná-lo um projeto real.

## Requisitos

Antes de iniciar, verifique se você tem os seguintes softwares instalados:

- [Docker Desktop](https://www.docker.com/products/docker-desktop) (para Windows, Mac ou Linux)
- [Docker Compose](https://docs.docker.com/compose/) (geralmente incluído com Docker Desktop)

## Estrutura do Projeto

O projeto consiste em dois principais serviços:

- **app**: Uma aplicação Spring Boot.
- **db**: Um banco de dados MySQL.

### Arquivo `docker-compose.yml`

O arquivo `docker-compose.yml` configura e executa os contêineres Docker para a aplicação e o banco de dados.

```yaml
version: '1.0.0'  # Define a versão do formato do arquivo Docker Compose.

services:
  app:
    build: .  # Constrói a imagem Docker a partir do Dockerfile no diretório atual.
    container_name: empresaXYZ-app  # Nome do contêiner para a aplicação.
    ports:
      - "8080:8080"  # Mapeia a porta 8080 do contêiner para a porta 8080 do host.
    depends_on:
      - db  # Garante que o banco de dados 'db' seja iniciado antes da aplicação.
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/meubanco  # URL de conexão do banco de dados MySQL.
      SPRING_DATASOURCE_USERNAME: meuuser  # Nome de usuário para conexão com o banco de dados.
      SPRING_DATASOURCE_PASSWORD: minhasenha  # Senha para o usuário do banco de dados.

  db:
    image: mysql:8  # Imagem do MySQL versão 8.0.
    container_name: empresaXYZ-db  # Nome do contêiner para o banco de dados.
    environment:
      MYSQL_DATABASE: meubanco          # Nome do banco de dados a ser criado.
      MYSQL_USER: meuuser               # Nome do usuário não-root a ser criado.
      MYSQL_PASSWORD: minhasenha        # Senha para o usuário não-root.
      MYSQL_ROOT_PASSWORD: rootpass     # Senha para o usuário root.
    ports:
      - "3306:3306"  # Mapeia a porta 3306 do contêiner para a porta 3306 do host.
    volumes:
      - db-data:/var/lib/mysql  # Volume persistente para armazenar dados do MySQL.

volumes:
  db-data:  # Define o volume persistente 'db-data'.
