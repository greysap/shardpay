CREATE TABLE payment (
    payer bigint,
    payment_id serial,
    payee bigint NOT NULL,
    amount bigint NOT NULL,
    PRIMARY KEY(payer, payment_id)
);