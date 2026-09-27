package io.github.orberyx.astrowatch.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/astrowatch";

    private static final String USER =
            System.getenv("ASTROWATCH_DB_USER");

    private static final String PASSWORD =
            System.getenv("ASTROWATCH_DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
//caso alguém sse esqueça:
        if (USER == null || PASSWORD == null) {
            throw new IllegalStateException(
                    "Variáveis de ambiente do banco não configuradas."
            );
        }

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}
