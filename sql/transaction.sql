CREATE TABLE IF NOT EXISTS "transaction" (
    id BIGSERIAL PRIMARY KEY,

    account_id BIGINT NOT NULL
        REFERENCES account(id)
        ON DELETE RESTRICT,

    type VARCHAR(16) NOT NULL
        CHECK (type IN ('DEPOSIT', 'WITHDRAW', 'TRANSFER')),

    amount BIGINT NOT NULL
        CHECK (amount > 0),

    balance_before BIGINT NOT NULL
        CHECK (balance_before >= 0),

    balance_after BIGINT NOT NULL
        CHECK (balance_after >= 0),

    status VARCHAR(16) NOT NULL
        CHECK (status IN ('PENDING', 'COMMITTED', 'ABORTED')),

    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);
