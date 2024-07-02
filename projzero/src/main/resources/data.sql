drop table if exists videogames;
drop table if exists accounts;


create table accounts(
	account_id serial primary key,
	username varchar(255) not null unique,
	password varchar(255)
);


CREATE table videogames (
    game_id SERIAL PRIMARY KEY,
    game_name varchar(255),
    rating INTEGER,
    genre varchar(25),
    account_id integer references accounts(account_id)
);

insert into accounts values (default, 'user1', 'password');
insert into accounts values (default, 'user2', '1234');

insert into videogames (game_name, rating, genre, account_id) values ('Destiny 2', 9, 'FPS', 1);
insert into videogames (game_name, rating, genre, account_id) values ('World of Warcraft', 10, 'MMORPG', 2);