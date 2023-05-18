package br.com.haaanunes.salao.controle;

import br.com.haaanunes.salao.modelo.RespostaModelo;
import br.com.haaanunes.salao.modelo.entidade.Servico;
import br.com.haaanunes.salao.servico.ServicoServico;
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
public class ServicoControle {
    
    @GetMapping("/")
    public String qualquerCoisa(){
        return "Aula no sétimo período.";
    }
    
    @Autowired
    private ServicoServico servicoServico;
    
    @GetMapping("/servicos")
    public Iterable<Servico>listar(){
        return servicoServico.listar();
    }
    
    @PostMapping("/servicos")
    public ResponseEntity<?> salvar ( @RequestBody Servico servico){
        return servicoServico.salvar(servico,"Salvar");
    }
    @PutMapping("/servicos")
    public ResponseEntity<?> atualizar ( @RequestBody Servico servico){
        return servicoServico.salvar(servico,"Atualizar");
    }
    
    @DeleteMapping("/servicos/{id}")
    public ResponseEntity<RespostaModelo> remover (@PathVariable Long id){
        return servicoServico.remover(id);
    }
}
