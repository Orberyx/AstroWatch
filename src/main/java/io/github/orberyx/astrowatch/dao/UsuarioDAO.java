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
