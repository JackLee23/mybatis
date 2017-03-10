CREATE TABLE `students` (
  `stud_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`stud_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `students` VALUES (1, 'Student1', 'student1@gmail.com', '1983-6-25');
INSERT INTO `students` VALUES (2, 'Student2', 'student2@gmail.com', '1983-6-25');
INSERT INTO `students` VALUES (3, 'student_3', 'student_3@gmail.com', '2017-2-24');
