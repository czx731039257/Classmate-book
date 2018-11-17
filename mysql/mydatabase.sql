/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : mydatabase

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2018-11-17 11:13:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) NOT NULL,
  `saddress` varchar(200) DEFAULT NULL,
  `sphone` varchar(11) DEFAULT NULL,
  `sweixing` varchar(20) DEFAULT NULL,
  `sqq` varchar(11) DEFAULT NULL,
  `sself` varchar(200) DEFAULT NULL,
  `spassword` varchar(10) NOT NULL,
  `semail` varchar(20) DEFAULT NULL,
  `smark` varchar(10) NOT NULL,
  PRIMARY KEY (`sid`),
  UNIQUE KEY `sname` (`sname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
