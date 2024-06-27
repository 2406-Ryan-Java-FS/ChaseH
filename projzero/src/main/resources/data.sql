drop table if exists videogames;

CREATE table  videogames (
    game_id SERIAL PRIMARY KEY,
    game_name varchar(255) NOT NULL,
    rating INTEGER
);


insert into videogames (game_name, rating) values ('Destiny 2', 9);
insert into videogames (game_name, rating) values ('World of Warcraft', 10);

select * from videogames;
