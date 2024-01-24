--liquibase formatted sql

--changeset sachin:create-multiple-test13-rows splitStatements:true endDelimiter:;
INSERT INTO "postgres".test13 (product_name, price) 
VALUES
('Desktop Computer1',800),
('Laptop1',1200),
('Tablet1',200),
('Monitor',350),
('Printer',150)
 
