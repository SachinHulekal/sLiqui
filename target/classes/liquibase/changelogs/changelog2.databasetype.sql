--liquibase formatted sql

--changeset sachin:create-test-table-test15
CREATE TABLE "postgres".test15 (
	product_name varchar(50),
	price int
);
--rollback drop table test1; 

--changeset sachin:create-multiple-test15-rows splitStatements:true endDelimiter:;
INSERT INTO "postgres".test15 (product_name, price) 
VALUES
('Desktop Computer',800),
('Laptop',1200),
('Tablet',200),
('Monitor',350),
('Printer',150)
 
