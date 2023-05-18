package br.com.haaanunes.salao.servico;

import br.com.haaanunes.salao.modelo.RespostaModelo;
import br.com.haaanunes.salao.modelo.entidade.Servico;
import br.com.haaanunes.salao.repositorio.ServicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServicoServico {

    @Autowired
    private ServicoRepositorio servicoRespositorio;

    public Iterable<Servico> listar() {
        return servicoRespositorio.findAll();
    }
    @Autowired
    private RespostaModelo respostaModelo;

    public ResponseEntity<?> salvar(Servico servico, String acao) {
        if (servico.getDescricao().equals("")) {
            respostaModelo.setMensagem("O título é obrigatório.");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (servico.getTempo() <= 0) {
            respostaModelo.setMensagem("O tempo deve ser maior que 0.");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("Salvar")) {
                return new ResponseEntity<Servico>(servicoRespositorio.save(servico), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Servico>(servicoRespositorio.save(servico), HttpStatus.OK);
            }
        }

    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        servicoRespositorio.deleteById(id);
        respostaModelo.setMensagem("Foi removido com sucesso");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
