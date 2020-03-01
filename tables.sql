CREATE TABLE artist (
    artistid bigint Primary Key,
    firstname varchar(20) not null,
    lastname varchar(20) not null,
    popularity float(5) not null 
);

CREATE TABLE location(
    city varchar(20) not null,
    street varchar(100) not null,
    popularity float(5) not null,
    country varchar(20) not null,
    Primary key (city,street)
);

create table scen(
    scenid bigint primary key,
    scename varchar(50) not null,
    city varchar(20) not null,
    street varchar(100) not null,
    CONSTRAINT fk_scen_land_stad FOREIGN KEY (city,street) REFERENCES location(city,street)
);

CREATE TABLE konsert (
    date date not null,
    time time not null,
    scenid bigint not null,
    artistid bigint not null,
    state varchar(10) not null check (state in ('cancelled','active','passed' )),
    primary key (date,scenid),
    UNIQUE (date,artistid),
    CONSTRAINT fK_konsert_scenid FOREIGN key (scenid) REFERENCES scen(scenid),
    CONSTRAINT fk_konsert_artistid FOREIGN key (artistid) REFERENCES artist(artistid)
);

CREATE TABLE ticket(
    date date not null,
    scenid bigint not null,
    pris integer not null,
    storage integer not null check (storage >= 0),
    primary key (date,scenid),
    CONSTRAINT fk_ticket_scenid_date FOREIGN key (date,scenid) REFERENCES konsert(date,scenid)
);

CREATE TABLE peseta(
    pesetakontor bigserial primary key,
    balance integer not null check (balance >=0)
);

CREATE TABLE customer(
    username varchar(50) primary key,
    pesetakontor bigserial not null,
    CONSTRAINT fk_customer_pesetakontor FOREIGN KEY (pesetakontor) REFERENCES peseta(pesetakontor)
);

CREATE TABLE kupong(
    kupongid bigserial primary key,
    username varchar not null,
    date date not null,
    invaliddate date not null,
    CONSTRAINT fk_kuppong_username FOREIGN key (username) REFERENCES customer (username)
);

CREATE TABLE booking(
    orderid bigserial primary key,
    date date not null,
    scenid bigint not null,
    username varchar(50) not null,
    kupongid bigserial not null,
    CONSTRAINT fk_booking_date_scenid FOREIGN key (date, scenid) REFERENCES konsert(date,scenid),
    CONSTRAINT fk_bokking_username FOREIGN key(username) REFERENCES customer(username),
    CONSTRAINT fk_booking_kupongid FOREIGN key (kupongid) REFERENCES kupong(kupongid)    
);
