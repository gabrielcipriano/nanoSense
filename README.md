# nanoSense
## A RESTful API  to manage sensors and data streams

## [Documentação](https://documenter.getpostman.com/view/6547296/TzeXk7G2) da API:
https://documenter.getpostman.com/view/6547296/TzeXk7G2

O projeto foi modelado seguindo o padrão REST e utilizando os conceitos de DTO (_Data Transfer Objects_) para estabelecer comunicação entre o Controller e a camada de serviço quando necessário, podendo assim, "filtrar" os cambos/atributos que aparecerão para os usuários da API.

A API foi implementada em Java com Spring Data REST, utilizando Dozer para mapeamento entre entidades e DTO's.

## Utilização:

O banco de dados configurado é o MySql (versão 8 ou maior). As configurações do banco de dados estão em `application.properties`, sendo então uma tabela de nome `nanosense` na porta `3306`:

`spring.datasource.url=jdbc:mysql://localhost:3306/nanosense?useTimezone=true&serverTimezone=UTC`
`spring.datasource.username=root`
`spring.datasource.password=075147`

O projeto pode ser compilado utilizando Maven, ou exportado para o __Eclipse__ e executado por lá.
