package br.iftm.edu.pessoaapi.controller;

public class PessoaNaoEncontradaException extends RuntimeException {

    public PessoaNaoEncontradaException(Integer id) {
        super("Não encontrei pessoa " + id);
    }
    public PessoaNaoEncontradaException(String msg) {
        super(msg);
    }

}
