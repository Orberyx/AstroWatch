package io.github.orberyx.astrowatch;

import io.github.orberyx.astrowatch.database.DatabaseConnection;

import java.sql.Connection;

public class TesteBanco {

    public static void main(String[] args) {

        try (Connection connection =
                     DatabaseConnection.getConnection()) {

            System.out.println("Conectado ao MySQL!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
