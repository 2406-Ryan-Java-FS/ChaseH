drop table if exists videogames;

CREATE table  videogames (
    game_id SERIAL PRIMARY KEY,
    game_name varchar(255) NOT NULL,
    rating INTEGER,
    genre varchar(25)
);


insert into videogames (game_name, rating, genre) values ('Destiny 2', 9, 'FPS');
insert into videogames (game_name, rating, genre) values ('World of Warcraft', 10, 'MMORPG');