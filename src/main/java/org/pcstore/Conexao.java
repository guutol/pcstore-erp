package org.pcstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {

    public static void main(String[] args) {
        try {
            // PreparedStatement = INSERT INTO
            // ResultSet = SELECT

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pcstore_db",
                    "root",
                    "root123"
            );
            System.out.println("Conectado com sucesso!");
        } catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
