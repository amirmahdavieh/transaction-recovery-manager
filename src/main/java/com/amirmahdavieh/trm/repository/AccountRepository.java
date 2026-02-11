package com.amirmahdavieh.trm.repository;

import com.amirmahdavieh.trm.db.Db;
import com.amirmahdavieh.trm.domain.Account;
import java.sql.Connection;

import java.sql.*;

public class AccountRepository {

    public Long create(Long customerId, long initialBalance) throws Exception {
        String sql = "INSERT INTO account (customer_id, balance) VALUES (?, ?) RETURNING id";

        try (Connection conn = Db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, customerId);
            ps.setLong(2, initialBalance);

            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getLong("id");
        }
    }

    public Account findById(Long id) throws Exception {
        String sql = "SELECT id, customer_id, balance FROM account WHERE id = ?";

        try (Connection conn = Db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Account(
                        rs.getLong("id"),
                        rs.getLong("customer_id"),
                        rs.getLong("balance")
                );
            }
            return null;
        }
    }

    public Account findById(Connection conn, long id) throws Exception {
        String sql = "SELECT id, customer_id, balance FROM account WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Account(
                        rs.getLong("id"),
                        rs.getLong("customer_id"),
                        rs.getLong("balance")
                );
            }
            return null;
        }
    }

    public void updateBalance(Connection conn, long accountId, long newBalance) throws Exception {
        String sql = "UPDATE account SET balance = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, newBalance);
            ps.setLong(2, accountId);
            ps.executeUpdate();
        }
    }
}
