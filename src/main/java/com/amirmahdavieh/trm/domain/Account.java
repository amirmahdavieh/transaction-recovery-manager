package com.amirmahdavieh.trm.domain;

public class Account {

    private Long id;
    private Long customerId;
    private long balance;

    public Account(Long id, Long customerId, long balance) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
    }

    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public long getBalance() { return balance; }
}
