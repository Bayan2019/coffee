CREATE TABLE coffee(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    recipe TEXT,
    image VARCHAR(1000),
    coffee_beans INT,
    sugar INT,
    chocolate INT,
    water INT,
    milk INT
);

ALTER TABLE coffee
    ADD CONSTRAINT quantity0 CHECK (coffee_beans>=0 AND sugar>=0 AND chocolate>=0 AND water>=0 AND milk>=0);

CREATE TABLE ingridients(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    measure VARCHAR(255),
    quantity INT,
    image VARCHAR(1000)
);

ALTER TABLE ingridients
    ADD CONSTRAINT quantity0 CHECK (quantity>=0);

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

ALTER TABLE orders_coffee
    ADD CONSTRAINT quantity0 CHECK (quantity>0);
