CREATE TABLE coffee(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    recipe TEXT,
    image VARCHAR(1000)
);

CREATE TABLE ingridients(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    quantity NUMERIC,
    measure VARCHAR(255)
);

ALTER TABLE ingridients
    ADD CONSTRAINT quantity0 CHECK (quantity>=0);

CREATE TABLE recipes(
    coffee_id INT REFERENCES coffee(id),
    ingridient_id INT REFERENCES ingridients(id),
    quantity NUMERIC
);

ALTER TABLE recipes
    ADD CONSTRAINT quantity0 CHECK (quantity>0);

CREATE TABLE orders(
    id BIGSERIAL PRIMARY KEY,
    date TIMESTAMPTZ NOT NULL
);

ALTER TABLE orders
    ADD CONSTRAINT date0817 CHECK (date::TIMESTAMPTZ::time >= '08:00:00' AND 
        date::TIMESTAMPTZ::time <= '17:00:00');

CREATE TABLE orders_coffee(
    order_id BIGINT REFERENCES orders(id),
    coffee_id INT REFERENCES coffee(id),
    quantity INT
);