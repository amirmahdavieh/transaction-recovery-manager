CREATE TABLE IF NOT EXISTS "user" (
  id          BIGSERIAL PRIMARY KEY,
  first_name  VARCHAR(64) NOT NULL,
  last_name   VARCHAR(64) NOT NULL,
  birthdate   DATE NOT NULL
);
