package com.amirmahdavieh.trm.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public final class Db {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = Db.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (in == null) {
                throw new IllegalStateException("application.properties not found in src/main/resources");
            }
            props.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load DB properties", e);
        }
    }

    private Db() {}

    public static Connection getConnection() throws Exception {
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        if (url == null || user == null || password == null) {
            throw new IllegalStateException("Missing db.url/db.user/db.password in application.properties");
        }

        return DriverManager.getConnection(url, user, password);
    }

    public static int ping() throws Exception {
        try (Connection c = getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery("SELECT 1")) {

            rs.next();
            return rs.getInt(1);
        }
    }

    public static <T> T inTransaction(SqlFunction<Connection, T> work) throws Exception {
        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);
            try {
                T result = work.apply(conn);
                conn.commit();
                return result;
            } catch (Exception e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    @FunctionalInterface
    public interface SqlFunction<C, R> {
        R apply(C conn) throws Exception;
    }

}
