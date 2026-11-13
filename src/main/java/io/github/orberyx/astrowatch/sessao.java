package io.github.orberyx.astrowatch.session;

import io.github.orberyx.astrowatch.model.Usuario;

public class Sessao {

    private static Usuario usuarioLogado;

    public static void iniciar(Usuario usuario) {
        usuarioLogado = usuario;
    }

    public static Usuario getUsuario() {
        return usuarioLogado;
    }

    public static boolean estaLogado() {
        return usuarioLogado != null;
    }

    public static void encerrar() {
        usuarioLogado = null;
    }
}
