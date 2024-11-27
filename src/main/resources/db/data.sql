-- TRUNCATE TABLE wallet;
-- TRUNCATE TABLE customer;
INSERT INTO wallet (balance, id, account_number) VALUES
 (205.00,200, '1234567890'),
 (0.00,201,'1234567890'),
 (100.00,202,'1234567890');

INSERT INTO customer (id, wallet_id) VALUES
   (1,200),
   (2,202);
