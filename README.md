
# Estudos JAVA

- Criar uma API utilizando SpringBoot 
- Criar um plugin utilizando o stacksopt v1.0.0


## 1. Criar API utilizando SpingBoot

Vamos criar uma API para cadastro (CRUD) de guitaras utilizando o padrão [MVC](https://www.devmedia.com.br/padrao-mvc-java-magazine/21995).

- Controller: O controlador é o componente que lida com as solicitações HTTP feitas pelos clientes e coordena as outras camadas da aplicação para gerar uma resposta apropriada. Ele atua como um intermediário entre a camada de visão e a camada de modelo, processando as entradas do usuário e determinando qual ação deve ser tomada para atendê-las. O controlador geralmente é implementado como uma classe Java anotada com @RestController no Spring MVC.

- Model: O modelo é a camada de negócios da aplicação que contém a lógica de negócios e os dados da aplicação. O modelo geralmente é implementado como uma classe Java simples, mas pode incluir outras classes auxiliares e serviços. A camada de modelo interage com o banco de dados (ou outro meio de armazenamento) para recuperar, atualizar e persistir os dados. Ele também executa a validação e outras operações de lógica de negócios necessárias para gerar uma resposta apropriada.

- Repository: O repositório é a camada de persistência da aplicação que fornece uma interface para acessar e manipular os dados. Ele abstrai a complexidade da comunicação com o banco de dados e fornece uma API de alto nível para o modelo interagir com o banco de dados. O repositório geralmente é implementado como uma interface Java que define os métodos de acesso ao banco de dados.

- Service: O serviço é a camada que contém a lógica de negócios da aplicação. Ele fornece uma interface para a camada de controle interagir com a camada de modelo. O serviço geralmente é implementado como uma classe Java que contém a lógica de negócios e os métodos que manipulam os dados. O serviço pode chamar métodos do repositório para persistir ou recuperar dados, bem como executar outras operações de lógica de negócios necessárias.

Esses quatro componentes trabalham juntos para fornecer uma API RESTful bem projetada e escalável. O controlador lida com as solicitações HTTP, interagindo com o serviço para realizar operações de negócios e recuperar dados do modelo. O serviço usa o repositório para interagir com o banco de dados, e o modelo contém a lógica de negócios e os dados da aplicação. Juntos, esses componentes fornecem uma arquitetura limpa e bem organizada para a sua aplicação.

![mvc](./img/mvc.png)

## 2. Criar plugin utilizando stackspot v1.0.0

### 2.1 Criar Conta
https://docs.stackspot.com/home/stackspot/getting-started#setup-da-conta

### 2.2 Criar Conteudo
https://docs.stackspot.com/create-use/create-content/getting-started

### 2.3 Criar Studio (Portal)
nome: studio stackspot

### 2.4 Criar Plugin (Local)
nome: java-spring-boot
https://docs.stackspot.com/create-use/tutorials/create-plugin-tutorial

### 2.5 Publicar Plugin (Local)
https://docs.stackspot.com/create-use/guides/publish-plugin

### 2.6 Criar Stack
nome: stack-felipe-soares

### 2.7 Criar Starter (Portal)
nome: starter-felipe-soares

### 2.8 Adicionar Plugin no Starter (Portal)




