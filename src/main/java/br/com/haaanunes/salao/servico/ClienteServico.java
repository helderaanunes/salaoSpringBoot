package br.com.haaanunes.salao.cliente;

import br.com.haaanunes.salao.modelo.RespostaModelo;
import br.com.haaanunes.salao.modelo.entidade.Cliente;
import br.com.haaanunes.salao.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio clienteRespositorio;

    public Iterable<Cliente> listar() {
        return clienteRespositorio.findAll();
    }
    @Autowired
    private RespostaModelo respostaModelo;

    public ResponseEntity<?> salvar(Cliente cliente, String acao) {
        if (cliente.getNome().equals("")) {
            respostaModelo.setMensagem("O nome é obrigatório.");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("Salvar")) {
                return new ResponseEntity<Cliente>(clienteRespositorio.save(cliente), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Cliente>(clienteRespositorio.save(cliente), HttpStatus.OK);
            }
        }

    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        clienteRespositorio.deleteById(id);
        respostaModelo.setMensagem("Foi removido com sucesso");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
