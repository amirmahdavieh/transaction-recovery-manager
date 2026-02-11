package com.amirmahdavieh.trm.domain;

import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    private Long accountId;
    private String type;
    private long amount;
    private long balanceBefore;
    private long balanceAfter;
    private String status;
    private LocalDateTime createdAt;

    public Transaction(Long id,
                       Long accountId,
                       String type,
                       long amount,
                       long balanceBefore,
                       long balanceAfter,
                       String status,
                       LocalDateTime createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public Long getAccountId() { return accountId; }
    public String getType() { return type; }
    public long getAmount() { return amount; }
    public long getBalanceBefore() { return balanceBefore; }
    public long getBalanceAfter() { return balanceAfter; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
