package br.com.haaanunes.salao.repositorio;

import br.com.haaanunes.salao.modelo.entidade.Servico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepositorio extends CrudRepository<Servico, Long>{
    
}
