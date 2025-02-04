# API TODO List
 API para sistema de gerenciamento de tarefas (To-Do List) que permita ao usuário criar, listar, editar e excluir tarefas.
# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
## Implantação em produção
- Back end: Java
- Banco de dados: SQL Server

## A documentação da API está presente no Swagger através do link #localhost:PORTA_DO_BANCO/swagger-ui.html
![image](https://github.com/user-attachments/assets/0b1d7839-10aa-435d-bffe-323576903d43)

# Como executar o projeto

## Back end
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/eltonips/API-TODO-List.git

## configurar Banco de dados no arquivo application.properties que está no caminho todolist/src/main/resources
## os scripts são rodados automaticamente pelo migration em tempo de execução da aplicação

# entrar na pasta do projeto back end
cd API-TODO-List

# executar o projeto
./mvnw spring-boot:run
