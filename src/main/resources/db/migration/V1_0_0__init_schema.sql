CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS payment_category (
    category_id SERIAL PRIMARY KEY,
    category_name character varying(255),
    icon character varying(255),
    parent_category_id bigint REFERENCES payment_category (category_id),
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE IF NOT EXISTS account_details (
    account_details_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    bank_name          character varying(255),
    bik                character varying(255),
    correction_account character varying(255),
    inn                character varying(255),
    number             character varying(255)
);

CREATE TABLE IF NOT EXISTS payment_infos (
    payment_info_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    category_id        bigint references payment_category (category_id),
    account_details_id   UUID references account_details (account_details_id),
    minAmount          double precision,
    created_at timestamp,
    updated_at timestamp,
    published boolean default false
);


CREATE TABLE IF NOT EXISTS payment_field (
    payment_field_id SERIAL PRIMARY KEY,
    payemnt_info UUID REFERENCES payment_infos (payment_info_id),
    field_name text,
    description text,
    field_type character varying(255),
    required boolean,
    hidden boolean,
    read_only boolean,
    field_order integer
);

CREATE TABLE IF NOT EXISTS payment_field_choice (
    payment_field_choice_id SERIAL PRIMARY KEY,
    payment_field_id bigint REFERENCES payment_field (payment_field_id),
    choice_text text
);