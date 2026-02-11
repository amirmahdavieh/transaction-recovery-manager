package com.amirmahdavieh.trm;

import com.amirmahdavieh.trm.db.Db;
import com.amirmahdavieh.trm.service.AccountService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("DB OK: " + Db.ping());

        AccountService svc = new AccountService();
        long txId = svc.deposit(1, 5000);

        System.out.println("Deposit done. txId=" + txId);
    }
}
