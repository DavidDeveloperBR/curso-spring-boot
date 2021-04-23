package io.github.davidrodrigues.rest.controller;

import io.github.davidrodrigues.exception.PedidoNaoEncontradoException;
import io.github.davidrodrigues.exception.RegraNegocioException;
import io.github.davidrodrigues.rest.ApiErrors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class AplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(RegraNegocioException ex){

        String menssagemErro = ex.getMessage();

        return new ApiErrors(menssagemErro);



    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErrors handlePedidoNotFound(PedidoNaoEncontradoException ex){


        return new ApiErrors(ex.getMessage());

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex){

        List<String> errors = ex.getBindingResult().getAllErrors().stream().map(erro->
                erro.getDefaultMessage()).collect(Collectors.toList());



        return new ApiErrors(errors);


    }
}
