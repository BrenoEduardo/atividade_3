package br.iftm.edu.pessoaapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.iftm.edu.pessoaapi.domain.Pessoa;
import br.iftm.edu.pessoaapi.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> recuperaTodosRegistros() {
        return ResponseEntity.status(HttpStatus.OK).body(service.todos());
    }

    @PostMapping
    public ResponseEntity<Pessoa>criaNovoRegistro(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(service.novo(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa>buscaUmRegistro(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.busca(id).orElseThrow(() -> new PessoaNaoEncontradaException(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Pessoa> atualizaRegistro(@RequestBody Pessoa pessoa, @PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualiza(pessoa, id));
    }

    @DeleteMapping("/{id}")
    public void excluiRegistro(@PathVariable Integer id) {
        service.exclui(id);
    }
}
