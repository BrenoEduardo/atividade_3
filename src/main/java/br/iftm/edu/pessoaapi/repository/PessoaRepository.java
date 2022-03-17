package br.iftm.edu.pessoaapi.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.iftm.edu.pessoaapi.domain.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {
    @Override
    List<Pessoa> findAll();
}
