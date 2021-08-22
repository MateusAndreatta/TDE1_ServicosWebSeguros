# TDE 1 - Serviços Web Seguros
**Criado por: Mateus Andreatta**

> Com base no código base já existente e aulas realizadas, implemente serviços para uma entidade chamada Produto (ID, NOME, ANOFABRICACAO, EAN )
> 1. Criar um resource chamado ProdutoResource
> 2. Implementar CRUD (Não precisa gravar na base de dados, apenas as chamadas via EndPoint)

> Endpoints:
>|Método| URL | Descrição |
>|-------|-----|--------|
>|GET|         /produto/{id}      |  Consulta de produto por ID
>|GET|         /produto            |  Listagem de produtos
>|POST|      /produto             |  Cadastro de produto
>|PUT|         /produto             |  Atualização de produto
>|DELETE|  /produto/{id}       |  Exclusão de produto

Json de exemplo:
```
{
    "id": 1,
    "nome": "teste",
    "anoFabricacao": 2000,
    "ean": "01321312"
}
```
