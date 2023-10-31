DROP DATABASE IF EXISTS proj1031;
CREATE DATABASE proj1031;
USE proj1031;

DROP TABLE post;


CREATE TABLE post(
id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT ,
title char(100) NOT NULL UNIQUE ,
content text,
userId int UNSIGNED NOT NULL
);


CREATE TABLE `user`(
id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT ,
userId char(100) NOT NULL UNIQUE ,
userPW char(100) NOT NULL
);


INSERT INTO post
SET title = "111",
content = "111",
userId = 1;

INSERT INTO post
SET title = "222",
content = "222",
userId = 1;

INSERT INTO post
SET title = "333",
content = "333",
userId = 2;

INSERT INTO post
SET title = "444",
content = "444",
userId = 2;


SELECT * FROM post ;