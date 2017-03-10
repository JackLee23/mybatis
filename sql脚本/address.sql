CREATE TABLE `addresses` (
  `ADDR_ID` int(11) NOT NULL,
  `STREET` varchar(50) DEFAULT NULL,
  `CITY` varchar(50) DEFAULT NULL,
  `STATE` varchar(50) DEFAULT NULL,
  `ZIP` int(10) DEFAULT NULL,
  `COUNTRY` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ADDR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `addresses` VALUES (1, 'Naperville', 'CHICAGO', 'IL', 60515, 'USA');
INSERT INTO `addresses` VALUES (2, 'Paul', 'CHICAGO', 'IL', 60515, 'USA');
