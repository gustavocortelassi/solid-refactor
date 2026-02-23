package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMailSenderService usuarioMailSenderService;

    public void criarUsuario(Usuario usuario){
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalStateException("E-mail já cadastrado");
        }

        usuarioRepository.save(usuario);

        usuarioMailSenderService.enviarEmailBoasVindas(usuario.getEmail());
    }
}

