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
    FOREIGN KEY (user_id) REFERENCES inside24.users (id)
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



