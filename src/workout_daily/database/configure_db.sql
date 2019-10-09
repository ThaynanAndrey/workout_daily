---------------------------- SQL COMMANDS FOR WorkoutDaily PROJECT ----------------------------

-- Creating user 'app_workout_daily' to be owner of database with password 'workout'.
CREATE USER app_workout_daily WITH PASSWORD 'workout';

-- Creating the database 'workout_daily' with owner defined previously.
CREATE DATABASE workout_daily OWNER app_workout_daily;

-- Connecting to database.
\c workout_daily;

-------------------------- CREATING ATHLETE TABLE FOR DATABASE --------------------------

-- Creating Athlete's Table.
CREATE TABLE ATHLETE(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age SMALLINT NOT NULL,
    height REAL NOT NULL,
    weight REAL NOT NULL
);

-- Granting user 'app_workout_daily' access to the ATHLETE table.
GRANT ALL PRIVILEGES ON TABLE ATHLETE TO app_workout_daily;

-- Granting permission to 'app_workout_daily' to create sequences in ATHLETE table.
GRANT USAGE, SELECT ON SEQUENCE ATHLETE_ID_SEQ TO app_workout_daily;

-- Inserting a new entity on ATHLETE table.
INSERT INTO ATHLETE(name, age, height, weight) VALUES('Thaynan Andrey Rocha Nunes', 22, 1.75, 94);

-- Verifying if the new value was inserted.
SELECT * FROM ATHLETE;

-------------------------- CREATING WORKOUT TABLE FOR DATABASE --------------------------

-- Creating WORKOUT's Table.
CREATE TABLE WORKOUT(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    creation_date DATE DEFAULT CURRENT_DATE NOT NULL,
    id_athlete INT NOT NULL,
    FOREIGN KEY (id_athlete) REFERENCES ATHLETE (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Granting user 'app_workout_daily' access to the WORKOUT table.
GRANT ALL PRIVILEGES ON TABLE WORKOUT TO app_workout_daily;

-- Granting permission to 'app_workout_daily' to create sequences in WORKOUT table.
GRANT USAGE, SELECT ON SEQUENCE WORKOUT_ID_SEQ TO app_workout_daily;

-- Inserting a new entity on WORKOUT table which references itself to ATHLETE with id 1.
INSERT INTO WORKOUT(name, id_athlete) VALUES('A', 1);

-------------------------- CREATING EXERCISE TABLE FOR DATABASE --------------------------

-- Creating EXERCISE's Table.
CREATE TABLE EXERCISE(
    id SERIAL PRIMARY kEY,
    name VARCHAR(255) NOT NULL,
    creation_date DATE DEFAULT CURRENT_DATE NOT NULL,
    set SMALLINT NOT NULL,
    repetitions SMALLINT NOT NULL,
    weight REAL,
    note VARCHAR(255),
    id_workout INT NOT NULL,
    FOREIGN KEY (id_workout) REFERENCES WORKOUT (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Granting user 'app_workout_daily' access to the EXERCISE table.
GRANT ALL PRIVILEGES ON TABLE EXERCISE TO app_workout_daily;

-- Granting permission to 'app_workout_daily' to create sequences in EXERCISE table.
GRANT USAGE, SELECT ON SEQUENCE EXERCISE_ID_SEQ TO app_workout_daily;

-- Inserting a new entity on EXERCISE table which references itself to ATHLETE with id 1.
INSERT INTO EXERCISE(name, creation_date, set, repetitions, weight, id_workout) VALUES('Voador', '2019-10-10', 4, 15, 35, 1);