-- liquibase formatted sql
-- changeset Pro100:1
-- 2024-03-31--create-table-document
-- comment: Create tables for measurements and methods

create table if not exists t_methods (
    method_id bigserial primary key not null,
    class_name VARCHAR(255) NOT NULL,
    method_name VARCHAR(255) NOT NULL
);

CREATE TABLE t_measurements (
    measurement_id bigserial primary key not null,
    execution_time BIGINT NOT NULL,
    date timestamp NOT NULL,
    method_id BIGINT NOT NULL,
    CONSTRAINT fk_method_id FOREIGN KEY (method_id) REFERENCES t_methods(method_id)
);

