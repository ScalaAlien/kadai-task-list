DROP DATABASE IF EXISTS `task_manager`;
CREATE DATABASE `task_manager` DEFAULT CHARSET utf8 COLLATE utf8_bin;
GRANT ALL PRIVILEGES ON `task_manager`.* TO task_manager@localhost IDENTIFIED BY 'password';