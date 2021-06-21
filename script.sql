CREATE DATABASE bitcoin;
SHOW DATABASES;
USE bitcoin;
CREATE TABLE `User` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`cpf` VARCHAR(14) NOT NULL,
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(100) NOT NULL,
	`role` VARCHAR(55) NOT NULL;
	PRIMARY KEY(`id`)) ENGINE=InnoDB;
	
CREATE TABLE `Order` (
	`id` int NOT NULL AUTO_INCREMENT,
	`value` decimal(6,2) NOT NULL,
	`type` VARCHAR(20) NOT NULL,
	`date` datetime NOT NULL,
	`status` VARCHAR(30) NOT NULL,
	`user_id` int NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)) ENGINE=InnoDB;