--liquibase formatted sql

--changeset sachin:create-test-table-test13
CREATE TABLE "postgres".test13 (
	product_name varchar(50),
	price int
);
--rollback drop table test1; 

--changeset sachin:create-multiple-test13-rows splitStatements:true endDelimiter:;
INSERT INTO "postgres".test13 (product_name, price) 
VALUES
('Desktop Computer',800),
('Laptop',1200),
('Tablet',200),
('Monitor',350),
('Printer',150)
 
--changeset sachin:create-test-table-test23
CREATE TABLE "postgres".test23 (
	product_name varchar(50),
	price int
);


--changeset sachin:create-multiple-test23-rows splitStatements:true endDelimiter:;
INSERT INTO "postgres".test23 (product_name, price) 
VALUES
('Desktop Computer',800),
('Laptop',1200),
('Tablet',200),
('Monitor',350),
('Printer',150)