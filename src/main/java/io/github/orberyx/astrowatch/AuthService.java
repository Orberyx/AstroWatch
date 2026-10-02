package io.github.orberyx.astrowatch.auth;

import io.github.orberyx.astrowatch.dao.UsuarioDAO;
import io.github.orberyx.astrowatch.model.Usuario;
import io.github.orberyx.astrowatch.session.Sessao;

public class AuthService {

    private final UsuarioDAO usuarioDAO;

    public AuthService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean login(String username, String senha) {

        if (username == null || username.isBlank()) {
            return false;
        }

        if (senha == null || senha.isBlank()) {
            return false;
        }

        String senhaHash = usuarioDAO.buscarSenhaHash(username);

        if (senhaHash == null) {
            return false;
        }

        if (!verificarSenha(senha, senhaHash)) {
            return false;
        }

        Usuario usuario = usuarioDAO.buscarUsuario(username);

        if (usuario == null) {
            return false;
        }

        Sessao.iniciar(usuario);

        return true;
    }

    public void logout() {
        Sessao.encerrar();
    }

    private boolean verificarSenha(String senha, String hash) {
      
        return false;
    }
}
