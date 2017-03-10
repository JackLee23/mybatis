CREATE TABLE `student` (
  `STUD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PHONE` varchar(50) DEFAULT NULL,
  `ADDR_ID` int(11) DEFAULT NULL,
  `GENDER` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`STUD_ID`),
  KEY `ADD_ID` (`ADDR_ID`),
  CONSTRAINT `ADD_ID` FOREIGN KEY (`ADDR_ID`) REFERENCES `addresses` (`ADDR_ID`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO `student` VALUES (1, 'John', 'john@gmail.com', '123-456-7890', 1, 'MALE');
INSERT INTO `student` VALUES (2, 'Jack', 'jack@gmail.com', '111-222-3333', 2, 'MALE');
INSERT INTO `student` VALUES (5, 'Tom', 'tom@gmail.com', '789-456-1236', 1, 'MALE');
INSERT INTO `student` VALUES (6, 'Mary', 'mary@gmail.com', '789-951-7536', 2, 'FEMALE');
INSERT INTO `student` VALUES (7, 'Tony', 'tony@gmail.com', '548-625-51269', 1, NULL);
INSERT INTO `student` VALUES (8, 'Tony', 'tony@gmail.com', '548-625-51269', 1, NULL);
INSERT INTO `student` VALUES (9, 'XXX', 'xxx@gmail.com', '741-963-15769', 1, 'MALE');
