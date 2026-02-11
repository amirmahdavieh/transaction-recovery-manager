package com.amirmahdavieh.trm.service;

import com.amirmahdavieh.trm.db.Db;
import com.amirmahdavieh.trm.domain.Account;
import com.amirmahdavieh.trm.domain.TransactionStatus;
import com.amirmahdavieh.trm.domain.TransactionType;
import com.amirmahdavieh.trm.repository.AccountRepository;
import com.amirmahdavieh.trm.repository.TransactionRepository;

public class AccountService {

    private final AccountRepository accountRepo = new AccountRepository();
    private final TransactionRepository txRepo = new TransactionRepository();

    public long deposit(long accountId, long amount) throws Exception {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be > 0");
        }

        return Db.inTransaction(conn -> {
            Account acc = accountRepo.findById(conn, accountId);
            if (acc == null) {
                throw new IllegalArgumentException("Account not found: " + accountId);
            }

            long before = acc.getBalance();
            long after = before + amount;

            // 1) Update account balance
            accountRepo.updateBalance(conn, accountId, after);

            // 2) Insert transaction record
            return txRepo.insert(conn, accountId, TransactionType.DEPOSIT, amount, before, after, TransactionStatus.COMMITTED);
        });
    }
}
