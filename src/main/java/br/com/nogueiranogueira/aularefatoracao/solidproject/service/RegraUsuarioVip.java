package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class RegraUsuarioVip implements RegraUsuario {

    @Override
    public boolean isAplicavel(String tipo) {
        return "VIP".equals(tipo);
    }

    @Override
    public Usuario processar(UsuarioDTO dto) {
        if (dto.email() == null || !dto.email().contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        if (dto.idade() < 18) {
            throw new IllegalArgumentException("Usuário deve ser maior de idade");
        }

        Usuario usuario = new Usuario(dto.nome(), dto.email(), dto.tipo());
        usuario.setPontos(100);
        return usuario;
    }
}
