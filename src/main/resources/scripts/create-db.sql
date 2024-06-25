CREATE DATABASE bookdb WITH ENCODING 'UTF8';
-- Create the admin user
CREATE USER super_user WITH PASSWORD 'admin123';
-- Create the limited user
CREATE USER just_user WITH PASSWORD 'limited123';
-- Grant all privileges on the database to the admin user
GRANT ALL PRIVILEGES ON DATABASE bookdb TO super_user;
-- Grant usage on the schema
GRANT USAGE ON SCHEMA public TO just_user;

-- Grant select, insert, update, and delete on all tables in the schema to the limited user
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO just_user;

-- Ensure the limited user can access future tables
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO just_user;

--create book sequence abd increment by 50.   
--TODO: CREATE increment by random number.
drop sequence if exists book_seq;
create sequence book_seq start with 1 increment by 50;

-- Grant permissions on the sequence to the just user (optional)
-- Since just_user doesn't need to modify the sequence, granting usage might be sufficient.
GRANT USAGE ON SEQUENCE book_seq TO just_user;

-- Grant ALL PRIVILEGES on the sequence to the admin user (for full control)
grant all privileges on sequence book_seq to admin_user;


-- create the book table
DROP TABLE IF EXISTS book;
CREATE TABLE book (
    id BIGINT PRIMARY KEY DEFAULT nextval('book_seq'),
    title VARCHAR(255) NULL,
    isbn VARCHAR(255) null,
    publisher VARCHAR(255) NULL
);

-- Grant ALL PRIVILEGES on the book table to admin user
grant all privileges on table book to admin_user;
grant select, insert, update, delete on table book to just_user;

