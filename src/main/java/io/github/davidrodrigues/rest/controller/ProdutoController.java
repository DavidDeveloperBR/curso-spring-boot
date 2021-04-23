package io.github.davidrodrigues.rest.controller;

import io.github.davidrodrigues.domain.entity.Produto;
import io.github.davidrodrigues.domain.repository.Produtos;
import io.swagger.annotations.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/produtos")
@Api("Api Produtos")
public class ProdutoController {

    private Produtos repository;

    public ProdutoController( Produtos produtos ) {
        this.repository = produtos;
    }

    @GetMapping("{id}")
    @ApiOperation("Obter detalhes de um produto")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Produto encontrado"),
            @ApiResponse(code = 404, message = "Produto não encontrado para o ID informado")
    })
    public Produto getProdutoById(@PathVariable @ApiParam("Id do produto") Integer id ){
        return repository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(NOT_FOUND,
                                "Produto não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Obter detalhes de um produto")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Produto salvo"),
            @ApiResponse(code = 400, message = "Produto inválido")
    })
    public Produto save( @RequestBody @Valid Produto produto ){
        return repository.save(produto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses({
            @ApiResponse(code = 204, message = "Produto não encontrado para o ID informado")
    })
    public void delete( @PathVariable @ApiParam("Id do produto") Integer id ){
        repository.findById(id)
                .map( produto -> {
                    repository.delete(produto);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Produto não encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody @Valid Produto produto ){
        repository
                .findById(id)
                .map( p -> {
                    produto.setId(p.getId());
                    repository.save(produto);
                    return p;
                }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                "Produto não encontrado") );
    }

    @GetMapping
    public List<Produto> find(Produto filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return repository.findAll(example);
    }


}
