DROP TABLE IF EXISTS CARS;

CREATE TABLE CARS (
    id INTEGER NOT NULL,
    brand varchar(20) NOT NULL,
    model varchar(20) NOT NULL,
    modelYear INTEGER NOT NULL,
    transmissionType varchar(20) NOT NULL,
    fuelType varchar(20) NOT NULL,
    bodyType varchar(20) NOT NULL,
    sitingCapacity int NOT NULL,
    kmDriven INTEGER NOT NULL,
    color varchar(20) NOT NULL,
    price FLOAT NOT NULL,
    PRIMARY KEY (id)
);