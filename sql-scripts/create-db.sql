DROP SCHEMA IF EXISTS `e_learning_database`;

CREATE SCHEMA `e_learning_database`;

use `e_learning_database`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(80) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` bigint(12) DEFAULT NULL,
  `photo_name` varchar(120) DEFAULT NULL,
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `users`(username, password, enabled, first_name, last_name, email, phone_number)
VALUES 
('vineet','{noop}test',1,'vineet', 'atlani', 'vineetatlani7@gmail.com',9617685500),
('tanya','{noop}test',1,'tanya', 'ramchandani', 'ramchandanitanya@gmail.com',9926471715);

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `authorities` 
VALUES 
('vineet','ROLE_STUDENT'),
('tanya','ROLE_STUDENT');

DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_no` bigint(20) NOT NULL,
  `instructor_username` varchar(50) NOT NULL,
  primary key(`id`),
  CONSTRAINT `users_detail_ibfk_1` FOREIGN KEY (`instructor_username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` int(11) default NULL,
  `syllabus` mediumtext default NULL,
  `duration` int(11) default NULL,
  `instructor_username` varchar(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  primary key(`id`),
  CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`instructor_username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `enrollments`;
CREATE TABLE `enrollments` (
  `student_username` varchar(50) NOT NULL,
  `course_id` int(11) NOT NULL,
  UNIQUE KEY `enrollments_idx_1` (`student_username`,`course_id`),
  CONSTRAINT `student_enrollments_ibfk_1` FOREIGN KEY (`student_username`) REFERENCES `users` (`username`),
  CONSTRAINT `course_enrolled_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  primary key(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `belongs`;
CREATE TABLE `belongs` (
  `category_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  UNIQUE KEY `belongs_idx_1` (`category_id`,`course_id`),
  CONSTRAINT `category_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  CONSTRAINT `course_belongs_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
