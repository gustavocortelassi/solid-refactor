package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciadorUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private List<RegraUsuario> regras;

    public Usuario criarUsuario(UsuarioDTO dto) {
        for (RegraUsuario regra : regras) {
            if (regra.isAplicavel(dto.tipo())) {
                Usuario usuario = regra.processar(dto);
                return usuarioRepository.save(usuario);
            }
        }

        throw new IllegalArgumentException("Tipo inválido");
    }
}
