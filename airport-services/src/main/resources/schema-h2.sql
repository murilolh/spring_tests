create table airport (
    id integer not null generated always as identity (start with 1, increment by 1),
    name varchar(256) not null,
    city varchar(256),
    country varchar(256) not null,
    iatacode varchar(3),
    icaocode varchar(4),
    latitude double,
    longitude double,
    altitude double,
    offsetutc integer,
    dstcode char(1),
    timezone varchar(128)
);

create index iata_unq on airport(iatacode);
create index city_idx on airport(city);
create index country_idx on airport(country);