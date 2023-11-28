
# Estudos JAVA

- Criar uma API utilizando SpringBoot 
- Criar um plugin utilizando o stacksopt v1.0.0


## 1. Criar API utilizando SpingBoot

[Spring Boot](https://spring.io/projects/spring-boot)

[Spring Framework: Unraveling the @Service Annotation](https://medium.com/@AlexanderObregon/spring-framework-unraveling-the-service-annotation-363f7d1e55e6)

Vamos criar uma API para cadastro (CRUD) de guitaras utilizando o padrão [MVC](https://www.devmedia.com.br/padrao-mvc-java-magazine/21995).

- Controller: O controlador é o componente que lida com as solicitações HTTP feitas pelos clientes e coordena as outras camadas da aplicação para gerar uma resposta apropriada. Ele atua como um intermediário entre a camada de visão e a camada de modelo, processando as entradas do usuário e determinando qual ação deve ser tomada para atendê-las. O controlador geralmente é implementado como uma classe Java anotada com @RestController no Spring MVC.

- Model: O modelo é a camada de negócios da aplicação que contém a lógica de negócios e os dados da aplicação. O modelo geralmente é implementado como uma classe Java simples e anotada com @Entity no Spring Data JPA indicando que é uma entidade JPA, mas pode incluir outras classes auxiliares e serviços. A camada de modelo interage com o banco de dados (ou outro meio de armazenamento) para recuperar, atualizar e persistir os dados. Ele também executa a validação e outras operações de lógica de negócios necessárias para gerar uma resposta apropriada.

- Repository: O repositório é a camada de persistência da aplicação que fornece uma interface para acessar e manipular os dados. Ele abstrai a complexidade da comunicação com o banco de dados e fornece uma API de alto nível para o modelo interagir com o banco de dados. O repositório geralmente é implementado como uma interface Java que define os métodos de acesso ao banco de dados.

- Service: O serviço é a camada que contém a lógica de negócios da aplicação. Ele fornece uma interface para a camada de controle interagir com a camada de modelo. O serviço geralmente é implementado como uma classe Java e é anotada com @Service no Spring, nela contém a lógica de negócios e os métodos que manipulam os dados. O serviço pode chamar métodos do repositório para persistir ou recuperar dados, bem como executar outras operações de lógica de negócios necessárias.

Esses quatro componentes trabalham juntos para fornecer uma API RESTful bem projetada e escalável. O controlador lida com as solicitações HTTP, interagindo com o serviço para realizar operações de negócios e recuperar dados do modelo. O serviço usa o repositório para interagir com o banco de dados, e o modelo contém a lógica de negócios e os dados da aplicação. Juntos, esses componentes fornecem uma arquitetura limpa e bem organizada para a sua aplicação.

![mvc](./img/mvc.png)


### 1.1 Mysql

[Referencia](https://hub.docker.com/_/mysql)

[Configure a DataSource](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#data.sql.datasource)

Vamos utilizar o Mysql como DB.

Para subir um container rodando o Mysql execute o comand abaixo;

```
docker run -d -p 3306:3306 \
--name db-01 \
--network dev \
-e MYSQL_ROOT_PASSWORD=rootpasswd \
-e MYSQL_DATABASE=db_guitar \
-e MYSQL_USER=app_user \
-e MYSQL_PASSWORD=apppasswd \
-e MYSQL_ROOT_PASSWORD=rootpasswd \
mysql:8.0
```

### 1.1 Build

[Referencia](https://anywhere.epam.com/en/blog/how-to-dockerize-spring-boot-application)

[DockerDocs](https://docs.docker.com/language/java/develop/)

[Main commands for Spring Boot with Maven](https://gustavopeiretti.com/spring-boot-with-maven-wrapper/)


#### 1.1.1 Local

Para buildar a aplicação e executar pela sua IDE pode executar um dos comandos abaixo;

```
./mvnw clean install
```
ou
```
./mvnw spring-boot:run
```

Ira gerar o arquivo jemguitar-0.0.1.jar na pasta **target/** .

#### 1.1.2 Docker

Para buildar e executar a aplicação utilizando docker usamos o **Multi-Stage Dockerfile** (esta na raiz do projeto), que isra fazer os estagios;

- ***base*** -> Apartir de uma imagem base com o jdk copia os arquivos e diretorios necessarios para o build.
- ***build*** -> Apartir de estagio **base** executa o build da aplicação.
- ***production*** -> Apartir do estagio **build** é disponibilizado a execução da aplicação.

Para criar a imagem execute o comando abaixo;

```
docker build -t felipe3b/api-java-guitar:latest .
```

Para verificar a imagem digite o comando abaixo;

```
docker image ls
```
Com a imagem gerada execute o comando abaixo para rodar a imagem em um container;

***OBS: Lembrando que para aplicação subir o DB precisa estar em execução.***

```
docker run --rm -d \
--name api-java-guitar \
--network dev \
-p 8080:8080 felipe3b/api-java-guitar:latest
```

#### 1.1.3 Observability

Para observability vamos usar os seguintes stack/ferramentas;

- [Spring Actuator](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator) para disponibilizar metricas e saude da aplicação.

- [Prometheus](https://prometheus.io/) para coletar as metricas da aplicação.

- [Grafana](https://grafana.com/) para vizualizar em dashboars as metricas coletadas.

- [Java Memory Leaks](https://medium.com/@AlexanderObregon/java-memory-leaks-detection-and-prevention-25d1c09eaebe)

- trabalhando com logs https://youtu.be/tCErZHxaTxg?si=MfmRmQIl8kLbJ-tE , https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.logging

- terminar de assistir https://www.youtube.com/watch?v=K_EI1SxVQ5Q&t=508s e continuar apartir de 14:22 para criar o container do prometheus.


Para exucutar o prometheus;
```
docker run \
-d -p 9090:9090 \
--name prometheus-dev \
--network dev \
-v ~/projetos/api-java-guitar/config/prometheus.yml:/etc/prometheus/prometheus.yml \
prom/prometheus
```
#### 1.1.4 Docker Compose

Outra alternativa para executar a aplicação é utilizar o **compose.yaml** (esta na raiz do projeto), dessa maneira os containers do DB, Aplicação e Observability são executados com um unico comando.

Para subir os serviços (containers);
```
docker-compose up -d
```

Para visualizar o status dos serviços (containers);
```
docker-compose ps
```

Para parar remover os serviços (containers);
```
docker-compose down
```

## 2. Criar plugin utilizando stackspot v1.0.0


