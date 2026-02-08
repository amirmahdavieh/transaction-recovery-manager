package com.amirmahdavieh.trm;

import com.amirmahdavieh.trm.db.Db;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Transaction Recovery Manager starting...");
        System.out.println("DB OK: " + Db.ping());
    }
}
