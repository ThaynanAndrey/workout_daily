---------------------------- SQL COMMANDS FOR WorkoutDaily PROJECT ----------------------------

-- Creates user 'app_workout_daily' to be owner of database with password 'workout'.
CREATE USER app_workout_daily WITH PASSWORD 'workout';

-- Creates the database 'workout_daily' with owner defined previously.
CREATE DATABASE workout_daily OWNER app_workout_daily;

-- Connects to database.
\c workout_daily;

-------------------------- CREATING ATHLETE TABLE FOR DATABASE --------------------------

-- Create Athlete's Table.
CREATE TABLE ATHLETE(
    id serial PRIMARY KEY,
    name varchar(255),
    age smallint,
    height real,
    weight real
);

-- Granting user 'app_workout_daily' access to the ATHLETE table.
GRANT ALL PRIVILEGES ON TABLE ATHLETE TO app_workout_daily;

-- Grants permission to 'app_workout_daily' to create sequences in ATHLETE table.
GRANT USAGE, SELECT ON SEQUENCE ATHLETE_ID_SEQ TO app_workout_daily;

-- Inserting a new entity on table ATHLETE.
INSERT INTO ATHLETE(name, age, height, weight) VALUES('Thaynan Andrey Rocha Nunes', 22, 1.75, 94);

-- Verifying if the new value was inserted.
SELECT * FROM ATHLETE;

-------------------------- CREATING WORKOUT TABLE FOR DATABASE --------------------------

-- Create WORKOUT's Tables
CREATE TABLE WORKOUT(
    id serial PRIMARY KEY,
    name varchar(255),
    creation_date date DEFAULT CURRENT_DATE,
    id_athlete int NOT NULL,
    FOREIGN KEY (id_athlete) REFERENCES ATHLETE (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Granting user 'app_workout_daily' access to the WORKOUT table.
GRANT ALL PRIVILEGES ON TABLE WORKOUT TO app_workout_daily;

-- Grants permission to 'app_workout_daily' to create sequences in WORKOUT table.
GRANT USAGE, SELECT ON SEQUENCE WORKOUT_ID_SEQ TO app_workout_daily;

-- Inserts a new entity on table WORKOUT which references itself to ATHLETE with id 1.
INSERT INTO WORKOUT(name, id_athlete) VALUES('A', 1);