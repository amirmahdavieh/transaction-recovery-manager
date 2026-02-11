package com.amirmahdavieh.trm.repository;

import com.amirmahdavieh.trm.db.Db;
import com.amirmahdavieh.trm.domain.User;

import java.sql.*;
import java.time.LocalDate;

public class UserRepository {

    public Long save(User user) throws Exception {
        String sql = "INSERT INTO \"user\" (first_name, last_name, birthdate) VALUES (?, ?, ?) RETURNING id";

        try (Connection conn = Db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setDate(3, Date.valueOf(user.getBirthdate()));

            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getLong("id");
        }
    }
}
