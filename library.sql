/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-05 16:45:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `ClassifyNo` varchar(30) NOT NULL COMMENT '分类号',
  `Bname` varchar(50) NOT NULL COMMENT '书名',
  `Bwriter` varchar(30) NOT NULL COMMENT '作者',
  `BpubAdr` varchar(30) NOT NULL COMMENT '出版社',
  `BpubDate` date NOT NULL COMMENT '出版日期',
  `Bprice` smallint(6) NOT NULL COMMENT '价格',
  `Btype` varchar(20) NOT NULL COMMENT '类别',
  `BtotalNum` smallint(11) NOT NULL DEFAULT '0' COMMENT '总量',
  `BborrowedNum` smallint(11) NOT NULL DEFAULT '0' COMMENT '借出量默认为0',
  PRIMARY KEY (`ClassifyNo`,`BpubDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('TS0700640', 'Java EE设计模式 Spring企业级开发最佳实践', 'Dhrubojyoti Kayal', '人民邮电出版社', '2010-02-01', '46', '计算机', '7', '0');
INSERT INTO `book` VALUES ('TS0876988', '算法', 'Robert Sedgewick Kevin Wayne', '人民邮电出版社', '2018-06-09', '999', '计算机', '1', '1');
INSERT INTO `book` VALUES ('TS1158966', '玩转支付宝理财', '庞金玲', '中国商业出版社', '1998-04-29', '5', '金融', '4', '0');

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Uno` varchar(11) NOT NULL,
  `ClassifyNo` varchar(30) NOT NULL,
  `UBorrowDate` datetime NOT NULL,
  `UReborrowTimes` tinyint(4) NOT NULL DEFAULT '0' COMMENT '从userbook中读取续借次数',
  `ReturnDate` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`,`Uno`,`ClassifyNo`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('9', '20160102173', 'TS1158965', '2018-04-08 17:38:58', '1', '2018-04-08 00:00:00');
INSERT INTO `log` VALUES ('10', '20160102173', 'TS1158965', '2018-04-09 16:01:30', '0', '2018-04-09 16:04:38');
INSERT INTO `log` VALUES ('11', '20160102173', 'TS1158966', '2018-04-21 19:48:40', '0', '2018-04-21 19:52:30');
INSERT INTO `log` VALUES ('12', '20160102173', 'TS1158966', '2018-04-21 19:53:28', '0', '2018-04-21 19:53:54');
INSERT INTO `log` VALUES ('13', '20160102173', 'TS1158966', '2018-04-21 22:30:14', '1', '2018-04-22 13:40:18');
INSERT INTO `log` VALUES ('14', '20160102175', 'TS1158966', '2018-04-21 22:37:32', '1', '2018-04-22 12:26:49');
INSERT INTO `log` VALUES ('15', '20160102177', 'TS1158966', '2018-04-22 12:58:10', '1', '2018-04-23 18:47:20');
INSERT INTO `log` VALUES ('16', '20160102173', 'TS1158966', '2018-04-23 15:11:15', '1', '2018-04-23 15:13:45');
INSERT INTO `log` VALUES ('17', '20160102173', 'TS1158966', '2018-04-23 18:47:07', '1', '2018-04-23 18:47:57');
INSERT INTO `log` VALUES ('18', '20160102173', 'TS1158966', '2018-04-23 18:57:18', '1', '2018-04-23 18:57:45');
INSERT INTO `log` VALUES ('19', '20160102173', 'TS1158966', '2018-04-23 19:07:41', '1', '2018-04-23 19:13:30');
INSERT INTO `log` VALUES ('20', '20160102173', 'TS1158966', '2018-04-23 19:13:41', '1', '2018-06-05 16:07:36');
INSERT INTO `log` VALUES ('21', '20160102175', 'TS1158966', '2018-04-29 13:23:46', '1', '2018-04-29 17:57:25');
INSERT INTO `log` VALUES ('22', '20160102001', 'TS0700640', '2018-05-02 21:02:41', '1', '2018-05-07 15:49:46');
INSERT INTO `log` VALUES ('23', '20160102175', 'TS0700640', '2018-05-04 17:23:13', '1', '2018-05-06 10:49:36');
INSERT INTO `log` VALUES ('24', '20160102173', 'TS0876988', '2018-05-17 20:23:47', '1', null);
INSERT INTO `log` VALUES ('25', '20160102173', 'TS0700640', '2018-06-05 15:19:58', '1', '2018-06-05 15:20:24');
INSERT INTO `log` VALUES ('26', '20160102173', 'TS0700640', '2018-06-05 16:00:07', '0', '2018-06-05 16:04:24');

-- ----------------------------
-- Table structure for `sys`
-- ----------------------------
DROP TABLE IF EXISTS `sys`;
CREATE TABLE `sys` (
  `Sno` varchar(30) NOT NULL,
  `Spwd` varchar(30) NOT NULL,
  PRIMARY KEY (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys
-- ----------------------------
INSERT INTO `sys` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Uno` varchar(11) NOT NULL,
  `Upwd` varchar(30) NOT NULL,
  `Uname` varchar(8) NOT NULL,
  `Usex` char(2) NOT NULL,
  `Ubirth` date NOT NULL,
  `Uphone` char(15) NOT NULL,
  `UPosition` varchar(10) NOT NULL,
  PRIMARY KEY (`Uno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('20160102173', '2222', '崔庆浩', '男', '1998-04-29', '17862716711', '学生');
INSERT INTO `user` VALUES ('20160102175', '20160102175', '小明', '男', '2018-04-30', '15318140508', '学生');

-- ----------------------------
-- Table structure for `userbook`
-- ----------------------------
DROP TABLE IF EXISTS `userbook`;
CREATE TABLE `userbook` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Uno` varchar(11) NOT NULL,
  `ClassifyNo` varchar(30) NOT NULL,
  `UBorrowDate` datetime NOT NULL,
  `UReborrowTimes` tinyint(4) NOT NULL DEFAULT '0',
  `UExpectedReturnDate` datetime NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userbook
-- ----------------------------
INSERT INTO `userbook` VALUES ('10', '20160102173', 'TS0876988', '2018-05-17 20:23:47', '1', '2018-07-17 20:23:47');
