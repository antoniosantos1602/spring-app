CREATE DATABASE IF NOT EXISTS userdb;
USE userdb;

CREATE TABLE role (
                      roleid BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(50) NOT NULL
);

CREATE TABLE user (
                      userid BIGINT AUTO_INCREMENT PRIMARY KEY,
                      USER_NAME VARCHAR(50) NOT NULL UNIQUE,
                      FIRST_NAME VARCHAR(50) NOT NULL,
                      LAST_NAME VARCHAR(50) NOT NULL,
                      EMAIL_ADDRESS VARCHAR(50) NOT NULL,
                      SSN VARCHAR(50) NOT NULL UNIQUE,
                      PASSWORD VARCHAR(255),
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_role (
                           userid BIGINT,
                           roleid BIGINT,
                           PRIMARY KEY(userid, roleid),
                           FOREIGN KEY(userid) REFERENCES user(userid),
                           FOREIGN KEY(roleid) REFERENCES role(roleid)
);


INSERT INTO user (userid, USER_NAME, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, SSN, PASSWORD)
VALUES
    (101, 'admin101', 'Antonio', 'Santos', 'admin101@email.com',
     'ssn101', '$2a$10$w.2Z0pQl9K5GOMVT.y2Jz.UW4Au7819nbzNh8nZIYhbnjCi6MG8Qu');

INSERT INTO role (roleid, name) VALUES (201, 'ADMIN');

INSERT INTO user_role (userid, roleid) VALUES (101, 201);
