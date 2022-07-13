-- user add
INSERT INTO `inside24`.`users` (`name`, `password`) VALUES ('User', 'INSERT INTO `inside24`.`users` (`id`, `name`, `password`) VALUES (\'1\', \'User\', \'$2a$12$/b9ltFK0DD1queNhAYagDuXEYE8cPfMpfvVL1alrJ6NZTTDACDupW\');\n');

-- roles add
INSERT INTO `inside24`.`roles` (`id`, `name`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `inside24`.`roles` (`id`, `name`) VALUES ('2', 'ROLE_USER');

-- user_role add
INSERT INTO `inside24`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `inside24`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '2');