CREATE TABLE IF NOT EXISTS account (
  id           BIGSERIAL PRIMARY KEY,
  customer_id  BIGINT NOT NULL REFERENCES "user"(id),
  balance      BIGINT NOT NULL CHECK (balance >= 0)
);
