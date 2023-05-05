CREATE TABLE car (id SERIAL PRIMARY KEY, brand TEXT, model TEXT, amount NUMERIC);

CREATE TABLE people (id SERIAL PRIMARY KEY, name TEXT, age INTEGER, driver_license BOOLEAN, car_id INTEGER);
