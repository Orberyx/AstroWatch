package io.github.orberyx.astrowatch.dao;

import io.github.orberyx.astrowatch.database.DatabaseConnection;
import io.github.orberyx.astrowatch.model.Aproximacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AproximacaoDAO {

    public void salvar(Aproximacao aproximacao) throws SQLException {

        String sql = """
                INSERT INTO aproximacao (
                    asteroide_id,
                    data_aproximacao,
                    data_aproximacao_completa,
                    velocidade_kmh,
                    distancia_km,
                    distancia_lunar,
                    corpo_orbitado
                )
                VALUES (?, ?, ?, ?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE
                    data_aproximacao = VALUES(data_aproximacao),
                    velocidade_kmh = VALUES(velocidade_kmh),
                    distancia_km = VALUES(distancia_km),
                    distancia_lunar = VALUES(distancia_lunar),
                    corpo_orbitado = VALUES(corpo_orbitado)
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, aproximacao.getAsteroideId());
            statement.setDate(
                    2,
                    Date.valueOf(aproximacao.getDataAproximacao())
            );

            if (aproximacao.getDataAproximacaoCompleta() != null) {
                statement.setTimestamp(
                        3,
                        Timestamp.valueOf(aproximacao.getDataAproximacaoCompleta())
                );
            } else {
                statement.setTimestamp(3, null);
            }

            statement.setDouble(4, aproximacao.getVelocidadeKmh());
            statement.setDouble(5, aproximacao.getDistanciaKm());
            statement.setDouble(6, aproximacao.getDistanciaLunar());
            statement.setString(7, aproximacao.getCorpoOrbitado());

            statement.executeUpdate();
        }
    }
}
