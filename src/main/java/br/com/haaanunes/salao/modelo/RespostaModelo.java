package br.com.haaanunes.salao.modelo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class RespostaModelo {
    private String mensagem;
}