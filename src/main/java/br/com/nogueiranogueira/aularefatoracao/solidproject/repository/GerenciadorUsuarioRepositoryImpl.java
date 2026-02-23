package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public class GerenciadorUsuarioRepositoryImpl implements
        UsuarioCrudRepository,
        UsuarioFiltroRepository,
        UsuarioRelatorioRepository
{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public void excluir(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public List<Usuario> buscarPorFiltroAvançados(String nome, String email, String tipoUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long contarUsuariosPorTipo(String tipoUsuario) {
        return usuarioRepository.countByTipo(tipoUsuario);
    }

    @Override
    public List<Object[]> gerarRelatorioUsuariosPorTipo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
