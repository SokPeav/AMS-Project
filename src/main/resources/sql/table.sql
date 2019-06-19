-- CREATE TABLE category
-- (
--     cate_id   INT  NOT NULL auto_increment,
--     cate_name varchar
-- );
--
-- CREATE TABLE article
-- (
--     id           INT  NOT NULL auto_increment,
--     title        varchar,
--     description  varchar,
--     author       varchar,
--     thumbnail    varchar,
--     created_date timestamp not null default CURRENT_TIMESTAMP,
--     cate_id      INT REFERENCES category (cate_id)
--
-- );
--

CREATE TABLE IF NOT EXISTS category
(
    cate_id   serial PRIMARY KEY NOT NULL,
    cate_name varchar(255)
);

CREATE TABLE IF NOT EXISTS article
(
    id           serial PRIMARY KEY NOT NULL,
    title        varchar(255),
    description  text,
    author       varchar(255),
    thumbnail    varchar(255),
    created_date timestamp          not null default CURRENT_TIMESTAMP,
    cate_id      int4 REFERENCES category (cate_id) ON UPDATE CASCADE ON DELETE CASCADE
);
--
