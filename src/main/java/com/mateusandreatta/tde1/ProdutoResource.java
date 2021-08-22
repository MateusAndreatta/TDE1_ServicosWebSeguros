package com.mateusandreatta.tde1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
Com base no código base já existente e aulas realizadas, implemente serviços para uma entidade chamada Produto (ID, NOME, ANOFABRICACAO, EAN )
1 - Criar um resource chamado ProdutoResource
2 - Implementar CRUD (Não precisa gravar na base de dados, apenas as chamadas via EndPoint)

endpoints:

GET         /produto/{id}      |  Consulta de produto por ID
GET         /produto            |  Listagem de produtos
POST      /produto             |  Cadastro de produto
PUT         /produto             |  Atualização de produto
DELETE  /produto/{id}       |  Exclusão de produto

Json de exemplo:
{
    "id": 1,
    "nome": "teste",
    "anoFabricacao": 2000,
    "ean": "01321312"
}
* */
@RestController
@RequestMapping("/produto")
public class ProdutoResource {

    // Mock para dados de testes
    private ArrayList<Produto> produtos = new ArrayList<>();

    @GetMapping("/{id}")
    public ResponseEntity consulta(@PathVariable("id") int id){
        Produto byId = getById(id);
        if(byId == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId);
    }

    @GetMapping()
    public List<Produto> listar(){
        return produtos;
    }

    @PostMapping
    public Produto incluir(@RequestBody Produto produto){
        produtos.add(produto);
        return produto;
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody Produto produto){
        Produto byId = getById(produto.getId());
        if(byId != null){
            byId.setNome(produto.getNome());
            byId.setAnoFabricacao(produto.getAnoFabricacao());
            byId.setEan(produto.getEan());
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        Produto byId = getById(id);
        if(byId == null){
            return ResponseEntity.notFound().build();
        }
        produtos.remove(byId);
        return ResponseEntity.ok().build();
    }

    private Produto getById(int id){
        for (Produto produto : produtos) {
            if(produto.getId() == id){
                return produto;
            }
        }
        return null;
    }

}
