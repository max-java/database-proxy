create table CLIENT (
    id bigint not null,
    email varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    password varchar(255),
    primary key (id)
);

insert into CLIENT (id, email, first_name, last_name, password) values
    (1, 'email@com', 'John', 'Doe', 'password123'),
    (2, 'email@com', 'Jane', 'Smith', 'password123'),
    (3, 'email@com', 'Alice', 'Johnson', 'password123'),
    (4, 'email@com', 'Bob', 'Brown', 'password123'),
    (5, 'email@com', 'Charlie', 'Davis', 'password123'),
    (6, 'email@com', 'Diana', 'Evans', 'password123'),
    (7, 'email@com', 'Evan', 'Harris', 'password123'),
    (8, 'email@com', 'Fiona', 'Green', 'password123'),
    (9, 'email@com', 'George', 'Hill', 'password123'),
    (10, 'email@com', 'Hannah', 'King', 'password123');
