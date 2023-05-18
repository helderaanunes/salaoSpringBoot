package br.com.haaanunes.salao.repositorio;

import br.com.haaanunes.salao.modelo.entidade.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Long>{
    
}
