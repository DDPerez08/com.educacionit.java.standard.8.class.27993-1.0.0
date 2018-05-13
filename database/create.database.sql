CREATE SCHEMA `educacionit` ;

CREATE TABLE `educacionit`.`customer` (
  `fullname` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`email`));

CREATE TABLE `educacionit`.`product` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `createdAt` DATETIME NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `educacionit`.`product`
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;


INSERT INTO `educacionit`.`product`
(`name`,
`description`,
`createdAt`)
VALUES
('Coca Cola',
'Gaseosa',
now());

INSERT INTO `educacionit`.`product`
(`name`,
`description`,
`createdAt`)
VALUES
('Coca Cola',
'Gaseosa',
now());

INSERT INTO `educacionit`.`product`
(`name`,
`description`,
`createdAt`)
VALUES
('Pepsi Cola',
'Gaseosa',
now());

INSERT INTO `educacionit`.`product`
(`name`,
`description`,
`createdAt`)
VALUES
('Ron',
'Bebida Alcoholica',
now());