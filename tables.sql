create table min.artist (
	artistid int primary key,
	firstname varchar(255) not null,
	lastname varchar (255) not null,
	popularity int not null check (popularity in (0,1,2,3,4,5))
);

create table min.location (
	city varchar(255) not null,
	street varchar(255) not null,
	popularity int not null check (popularity in (0,1,2,3,4,5)),
    primary key(city,street)
);

CREATE TABLE min.admin(
    adID int primary key,
    name varchar(50) not null,
    login varchar(50) not null
);


create table min.scene (
	sceneid int primary key,
	city varchar(255) not null,
	street varchar(255) not null,
	scenename varchar(255) not null,
	capacity int not null check (capacity >=0),
    CONSTRAINT FK_scene_city_street FOREIGN KEY (street, city) REFERENCES min.location(street, city)
);


create table min.customer (
	customerid int primary key,
	customername varchar(255) not null,
	login varchar(255) not null
);

CREATE TABLE min.concert(
    concertid bigint not null,
    name varchar(255) not null,
    date timestamp not null,
    state varchar(255) not null check (state in ('active', 'cancelled')),
    primary key(concertid, date)
);

CREATE TABLE min.ticket(
    serials bigserial primary key,  
    concertid bigint not null,
    date timestamp not null,
    CONSTRAINT FK_ticket_concertid_date FOREIGN KEY (concertid, date) REFERENCES min.concert(concertid, date)
);


CREATE TABLE min.pesetaaccount(
    pesetaaccount int primary key,
    balance integer not null check (balance >=0),
    CONSTRAINT FK_pesetaaccount FOREIGN KEY (pesetaaccount) REFERENCES  min.customer(pesetaaccount)
);

CREATE TABLE min.coupon(
    couponID bigserial primary key,
    value varchar(50) not null,
    date date not null,
    invaliddate date not null
);

CREATE TABLE min.participate(
    adID int not null,
    artistid int not null,
    concertid bigint not null,
    date timestamp not null,
    primary key(artistid, adID, concertid, date),
    CONSTRAINT FK_participate_artistid FOREIGN KEY (artistid) REFERENCES min.artist(artistid),
    CONSTRAINT FK_participate_concerid_date FOREIGN KEY (concertid, date) REFERENCES min.concert(concertid, date),
    CONSTRAINT FK_participate_adID FOREIGN KEY (adID) REFERENCES min.admin(adID)

);

CREATE TABLE min.hold(
    sceneid int not null,
    concertid bigint not null,
    date timestamp not null,
    primary key(sceneid,concertid,date),
    unique(sceneid,date),
    CONSTRAINT FK_hold_sceneid FOREIGN KEY (sceneid) REFERENCES  min.scene(sceneid),
    CONSTRAINT FK_hold_concerid_date FOREIGN KEY (concertid, date) REFERENCES min.concert(concertid, date)
);

CREATE TABLE min.coupontoCustomer(
    couponID bigserial primary key,
    customerid int not null,
    CONSTRAINT FK_coupontoCustomer_customerid FOREIGN KEY (customerid) REFERENCES  min.customer(customerid),
    CONSTRAINT FK_coupontoCustomer_adID FOREIGN KEY (adID) REFERENCES min.admin(adID)
);

CREATE TABLE min.order(
    serials bigserial primary key, 
    customerid int not null,
    CONSTRAINT FK_order_customerid FOREIGN KEY (customerid) REFERENCES  min.customer(customerid),
    CONSTRAINT FK_order_serials FOREIGN KEY (serials) REFERENCES min.ticket(serials)
);

