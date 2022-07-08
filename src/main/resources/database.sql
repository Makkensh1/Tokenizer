-- New schema
CREATE SCHEMA `inside24`;

-- Table: users
Create TABLE  inside24.users (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    password varchar(255) NOT NULL
);


-- Table: messages
Create TABLE inside24.messages (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    text TEXT not null,
    user_id BIGINT NOT NULL,
    date DATETIME NOT NULL,
    FOREIGN KEY (user_id) REFERENCES inside24.Users (id)
);

-- Table: roles
CREATE TABLE `inside24`.`roles` (
                                    `id` BIGINT(255) NOT NULL AUTO_INCREMENT,
                                    `name` VARCHAR(100) NOT NULL,
                                    PRIMARY KEY (`id`),
                                    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

-- Table: user_roles
CREATE TABLE `inside24`.`user_roles` (
                                         `user_id` BIGINT(255) NOT NULL,
                                         `role_id` BIGINT(255) NOT NULL,
                                         PRIMARY KEY (`user_id`, `role_id`),
                                         INDEX `role_id_idx` (`role_id` ASC) VISIBLE,
                                         CONSTRAINT `role_id`
                                             FOREIGN KEY (`role_id`)
                                                 REFERENCES `inside24`.`roles` (`id`)
                                                 ON DELETE NO ACTION
                                                 ON UPDATE NO ACTION,
                                         CONSTRAINT `user_id`
                                             FOREIGN KEY (`user_id`)
                                                 REFERENCES `inside24`.`users` (`id`)
                                                 ON DELETE NO ACTION
                                                 ON UPDATE NO ACTION);

-- user add
INSERT INTO `inside24`.`users` (`name`, `password`) VALUES ('User', 'INSERT INTO `inside24`.`users` (`id`, `name`, `password`) VALUES (\'1\', \'User\', \'$2a$12$/b9ltFK0DD1queNhAYagDuXEYE8cPfMpfvVL1alrJ6NZTTDACDupW\');\n');

-- roles add
INSERT INTO `inside24`.`roles` (`id`, `name`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `inside24`.`roles` (`id`, `name`) VALUES ('2', 'ROLE_USER');

-- user_role add
INSERT INTO `inside24`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `inside24`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '2');

