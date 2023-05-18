package br.com.haaanunes.salao.controle;

import br.com.haaanunes.salao.modelo.RespostaModelo;
import br.com.haaanunes.salao.modelo.entidade.Cliente;
import br.com.haaanunes.salao.cliente.ClienteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteControle {
    
    @GetMapping("/")
    public String qualquerCoisa(){
        return "Aula no sétimo período.";
    }
    
    @Autowired
    private ClienteServico clienteCliente;
    
    @GetMapping("/clientes")
    public Iterable<Cliente>listar(){
        return clienteCliente.listar();
    }
    
    @PostMapping("/clientes")
    public ResponseEntity<?> salvar ( @RequestBody Cliente cliente){
        return clienteCliente.salvar(cliente,"Salvar");
    }
    @PutMapping("/clientes")
    public ResponseEntity<?> atualizar ( @RequestBody Cliente cliente){
        return clienteCliente.salvar(cliente,"Atualizar");
    }
    
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<RespostaModelo> remover (@PathVariable Long id){
        return clienteCliente.remover(id);
    }
}
