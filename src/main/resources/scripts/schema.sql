    drop table if exists book;
    drop table if exists book_seq;
    DROP SEQUENCE IF EXISTS book_seq;
    CREATE SEQUENCE book_seq START WITH 1 INCREMENT BY 50;
    create table book (
        id bigint not null DEFAULT nextval('book_seq'),
        isbn varchar(255),
        publisher varchar(255),
        title varchar(255),
        primary key (id)
    );
    create table book_seq (
        next_val bigint
    );

    insert into book_seq values (1);

-- DROP TABLE IF EXISTS book;
-- DROP SEQUENCE IF EXISTS book_seq;
-- drop table if exists book_seq;

-- CREATE SEQUENCE book_seq START WITH 1 INCREMENT BY 1;

-- CREATE TABLE book (
--     id BIGINT NOT NULL DEFAULT nextval('book_seq'),
--     isbn VARCHAR(255),
--     publisher VARCHAR(255),
--     title VARCHAR(255),
--     PRIMARY KEY (id)
-- );
-- -- create table book_seq (
-- --         next_val bigint
-- -- );

-- insert into book_seq values (50);
