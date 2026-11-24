package io.github.orberyx.astrowatch.dao;

import io.github.orberyx.astrowatch.database.DatabaseConnection;
import io.github.orberyx.astrowatch.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public String buscarSenhaHash(String username) {

        String sql = """
                SELECT senha_hash
                FROM usuario
                WHERE username = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return rs.getString("senha_hash");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Usuario buscarUsuario(String username) {

        String sql = """
                SELECT id, nome, username
                FROM usuario
                WHERE username = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String user = rs.getString("username");
                    return new Usuario(id, nome, user);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}