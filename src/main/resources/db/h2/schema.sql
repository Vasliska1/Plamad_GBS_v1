DROP TABLE player IF EXISTS;
DROP TABLE game_result IF EXISTS;

CREATE TABLE player(
    id                  INTEGER IDENTITY PRIMARY KEY,
    nickname            VARCHAR(30),
    registration_date   datetime


);

CREATE TABLE game_result(
    id                      INTEGER IDENTITY PRIMARY KEY,
    score                   INTEGER NOT NULL,
    registration_date       datetime,
    player_id               INTEGER NOT NULL

);

ALTER TABLE game_result ADD CONSTRAINT fk_player FOREIGN KEY (player_id) REFERENCES player (id);

