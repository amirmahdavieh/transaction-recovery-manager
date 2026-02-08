package com.amirmahdavieh.trm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRepository {

    private static final String INSERT_USER_SQL =
            "INSERT INTO users (username, pin_hash) VALUES (?, ?)";

    public static void insertUser(String username, String pinHash) throws Exception {
        try (Connection conn = Db.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_USER_SQL)) {

            ps.setString(1, username);
            ps.setString(2, pinHash);

            ps.executeUpdate();
        }
    }
}
