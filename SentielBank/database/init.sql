-- SentinelBank/database/init.sql

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50),
    home_city VARCHAR(50)
);

CREATE TABLE transaction_logs (
    id SERIAL PRIMARY KEY,
    user_id INT,
    amount DECIMAL(10, 2),
    city VARCHAR(50),
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    timestamp BIGINT,
    is_fraud BOOLEAN
);