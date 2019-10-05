-- ----------------------- SQL COMMANDS FOR WorkoutDaily PROJECT -----------------------

-- Creates user 'app_workout_daily' to be owner of database with password 'workout'.
CREATE USER app_workout_daily WITH PASSWORD 'workout';

-- Creates the database 'workout_daily' with owner defined previously.
CREATE DATABASE workout_daily OWNER app_workout_daily;

-- Connects to database.
\c workout_daily;

-- Create User's Table.
CREATE TABLE WORKOUT_USER(
    id serial PRIMARY KEY,
    name varchar(255),
    age smallint,
    height real,
    weight real
);

-- Granting user 'app_workout_daily' access to the WORKOUT_USER table.
GRANT ALL PRIVILEGES ON TABLE WORKOUT_USER TO app_workout_daily;

-- Grants permission to 'app_workout_daily' to create sequences in WORKOUT_USER table.
GRANT USAGE, SELECT ON SEQUENCE WORKOUT_USER_ID_SEQ TO app_workout_daily;

-- Inserting a new entity on table WORKOUT_USER.
INSERT INTO WORKOUT_USER(name, age, height, weight) VALUES('Thaynan Andrey Rocha Nunes', 22, 1.75, 94);

-- Verifying if the new value was inserted.
SELECT * FROM WORKOUT_USER;