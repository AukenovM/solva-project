create table currency
(
    id                 bigserial
        primary key
        unique,
    from_currency_code text,
    to_currency_code   text,
    exchange_rate      text
);


create table accounts
(
    id             bigserial
        primary key,
    account_number text,
    balance        double precision,
    balance_kzt    double precision,
    balance_rub    double precision,
    created_date   date,
    modified_date  date,
    limit_usd      double precision default 0 not null
);

create table account_transaction
(
    id                   bigserial
        primary key,
    account_from         text             not null,
    account_to           text             not null,
    transfer_sum         double precision not null,
    transaction_currency text             not null,
    transfer_description text,
    transaction_date     date,
    limit_exceeded       boolean
);