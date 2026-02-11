package com.amirmahdavieh.trm.repository;

import com.amirmahdavieh.trm.domain.TransactionStatus;
import com.amirmahdavieh.trm.domain.TransactionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionRepository {

    public long insert(Connection conn,
                       long accountId,
                       TransactionType type,
                       long amount,
                       long balanceBefore,
                       long balanceAfter,
                       TransactionStatus status) throws Exception {

        String sql =
                "INSERT INTO \"transaction\" " +
                "(account_id, type, amount, balance_before, balance_after, status) " +
                "VALUES (?, ?, ?, ?, ?, ?) " +
                "RETURNING id";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, accountId);
            ps.setString(2, type.name());
            ps.setLong(3, amount);
            ps.setLong(4, balanceBefore);
            ps.setLong(5, balanceAfter);
            ps.setString(6, status.name());

            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getLong("id");
        }
    }
}
