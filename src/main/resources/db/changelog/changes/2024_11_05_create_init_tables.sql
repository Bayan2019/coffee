CREATE TABLE coffee(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    recipe TEXT,
    image VARCHAR(1000),
    beans INT,
    sugar INT,
    chocolate INT,
    milk INT,
    water INT
);

ALTER TABLE coffee
    ADD CONSTRAINT quantity0 CHECK (beans>=0 AND sugar>=0 AND chocolate>=0 AND water>=0 AND milk>=0);

CREATE TABLE ingridients(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    measure VARCHAR(255),
    image VARCHAR(1000),
    quantity INT
);

ALTER TABLE ingridients
    ADD CONSTRAINT quantity0 CHECK (quantity>=0);

CREATE TABLE orders(
    id BIGSERIAL PRIMARY KEY,
    coffee_id INT REFERENCES coffee(id),
    date TIMESTAMPTZ NOT NULL
);

ALTER TABLE orders
    ADD CONSTRAINT date0817 CHECK (date::TIMESTAMPTZ::time >= '08:00:00' AND 
        date::TIMESTAMPTZ::time <= '17:00:00');
