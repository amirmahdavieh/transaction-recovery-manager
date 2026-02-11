package com.amirmahdavieh.trm.domain;

public class Account {

    private Long id;
    private Long customerId;
    private long balance;
    private long lsn;

    public Account(Long id, Long customerId, long balance, long lsn) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
        this.lsn = lsn;
    }

    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public long getBalance() { return balance; }
    public long getLsn() { return lsn; }
}
