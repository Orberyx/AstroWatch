package io.github.orberyx.astrowatch.dao;

import io.github.orberyx.astrowatch.database.DatabaseConnection;
import io.github.orberyx.astrowatch.model.Asteroide;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AsteroideDAO {

    public void salvar(Asteroide asteroide) throws SQLException {

        String sql = """
                INSERT INTO asteroide (
                    id_nasa,
                    nome,
                    diametro_min_km,
                    diametro_max_km,
                    magnitude_absoluta,
                    potencialmente_perigoso,
                    nasa_jpl_url,
                    objeto_sentry
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE
                    nome = VALUES(nome),
                    diametro_min_km = VALUES(diametro_min_km),
                    diametro_max_km = VALUES(diametro_max_km),
                    magnitude_absoluta = VALUES(magnitude_absoluta),
                    potencialmente_perigoso = VALUES(potencialmente_perigoso),
                    nasa_jpl_url = VALUES(nasa_jpl_url),
                    objeto_sentry = VALUES(objeto_sentry)
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, asteroide.getIdNasa());
            statement.setString(2, asteroide.getNome());
            statement.setDouble(3, asteroide.getDiametroMinKm());
            statement.setDouble(4, asteroide.getDiametroMaxKm());
            statement.setDouble(5, asteroide.getMagnitudeAbsoluta());
            statement.setBoolean(6, asteroide.isPotencialmentePerigoso());
            statement.setString(7, asteroide.getNasaJplUrl());
            statement.setBoolean(8, asteroide.isObjetoSentry());

            statement.executeUpdate();
        }
    }
}
