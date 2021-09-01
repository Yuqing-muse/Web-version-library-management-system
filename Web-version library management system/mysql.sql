/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-22 14:10:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo` (
  `bookid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `quantityNow` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `addby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES ('7101b8dd-593b-4e1c-b767-3d733eec1e1e', '高数', '李伟', '数学', '100.00', '微积分', '无', '10', '10', '无', 'admin');
INSERT INTO `bookinfo` VALUES ('75547712-dfef-4d52-937d-5f90093f7ba7', '软件工程', '高科', '计算机', '100.00', '计算机', '无', '10', '9', '无', 'admin');
INSERT INTO `bookinfo` VALUES ('859a52f6-5b9f-4054-a3df-171a1c9f8925', '高数', '李伟', '数学', '100.30', '无', '10', '100', '100', '1', null);
INSERT INTO `bookinfo` VALUES ('8b473189-15ec-4642-a301-e35132bcaee5', '计组', '王五', '计算机', '100.00', '无', '无', '100', '100', '无', null);
INSERT INTO `bookinfo` VALUES ('8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '软件工程', '张三', '计算机', '100.35', '计算机', '无', '10', '7', '无', null);
INSERT INTO `bookinfo` VALUES ('c5e57d96-623f-4ae4-8c89-79cd0a0970f9', '数据结构', '李四', '计算机', '100.00', '数据', '无', '10', '10', '无', null);
INSERT INTO `bookinfo` VALUES ('cb1ee6d9-6793-4472-8b72-f54d90a473a9', '计算机网络', '刘六', '计算机', '100.00', '网络', '无', '10', '10', '无', null);
INSERT INTO `bookinfo` VALUES ('dea71e4b-1e95-437a-9686-170262380e20', '1', '1', '文学', '1.00', '1', '1', '1', '1', '1', null);
INSERT INTO `bookinfo` VALUES ('fa8b6786-e6ae-47f9-a39b-54bc32d23322', '高数', '1', '数学', '1.00', '1', '1', '1', '1', '1', null);

-- ----------------------------
-- Table structure for borrowinfo
-- ----------------------------
DROP TABLE IF EXISTS `borrowinfo`;
CREATE TABLE `borrowinfo` (
  `borrId` varchar(255) NOT NULL,
  `borrbookid` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `borrowdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `borrowlimit` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `state` varchar(255) DEFAULT NULL,
  `arrearagemoney` double DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`borrId`),
  KEY `bousername` (`username`),
  KEY `borrbookid` (`borrbookid`),
  CONSTRAINT `borrbookid` FOREIGN KEY (`borrbookid`) REFERENCES `bookinfo` (`bookid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `bousername` FOREIGN KEY (`username`) REFERENCES `userinfo` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowinfo
-- ----------------------------
INSERT INTO `borrowinfo` VALUES ('05dc2509-a0c1-41c2-b6d0-8760deae3e63', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-19 19:25:56', '2017-09-19 19:25:56', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('1803721b-5a65-45cd-aa00-fa8ffb7fc0d0', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-19 19:42:19', '2017-09-19 19:42:19', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('1b57eed7-4465-4af7-bb71-2ce898c5aa1b', '859a52f6-5b9f-4054-a3df-171a1c9f8925', '123', '2017-09-21 08:49:17', '2017-09-21 08:49:17', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('2bdec216-fe9f-4003-bec2-04ea1f590246', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-19 19:28:36', '2017-09-19 19:28:36', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('2f85308b-a7c9-41d5-b2b0-2c6b506dcd4a', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-19 19:28:40', '2017-09-19 19:28:40', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('3df8fa12-6b4c-4f76-aef7-d0e3d98356e5', '859a52f6-5b9f-4054-a3df-171a1c9f8925', '123', '2017-09-21 08:54:22', '2017-09-21 08:54:22', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('5b0790ed-219f-42c7-a6e5-accdb2765577', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-19 19:52:13', '2017-09-19 19:52:13', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('5fb5877d-232b-449c-a46e-cad5f66a454f', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-21 12:41:45', '2017-09-21 12:41:45', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('6d887eb6-2f1f-4452-9b3b-2164ee750f9a', '859a52f6-5b9f-4054-a3df-171a1c9f8925', '123', '2017-09-21 08:55:55', '2017-09-21 08:55:55', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('74c955cd-0e7a-4416-a56b-0489643df772', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-21 14:51:48', '2017-09-21 14:51:48', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('91f37df1-c2b1-4e15-beeb-fc91403db357', '859a52f6-5b9f-4054-a3df-171a1c9f8925', '123', '2017-09-21 08:58:54', '2017-09-21 08:58:54', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('9311b2bf-89ab-4dce-96e9-baade7209c57', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-19 19:50:14', '2017-09-19 19:50:14', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('99315d5b-d22f-47f0-9972-fb3ff92ee0f7', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-19 19:47:40', '2017-09-19 19:47:40', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('a3345be7-d45f-44b4-8c49-cbfee24cbb8c', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-19 19:52:19', '2017-09-19 19:52:19', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('c1ab3a78-37cb-48b7-80ab-217659075b78', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-19 19:52:23', '2017-09-19 19:52:23', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('c678f283-0e6b-465f-b91e-f4caa96c22f1', '859a52f6-5b9f-4054-a3df-171a1c9f8925', '123', '2017-09-21 00:00:00', '2017-10-21 00:00:00', 'doing', '0', null);
INSERT INTO `borrowinfo` VALUES ('c8dda178-cd17-4119-ba12-2debcd34dd0d', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-21 00:00:00', '2017-10-21 00:00:00', 'doing', '0', null);
INSERT INTO `borrowinfo` VALUES ('c95c6724-6188-4b69-bb84-2f2dbda151c0', '75547712-dfef-4d52-937d-5f90093f7ba7', '123', '2017-09-21 00:00:00', '2017-10-21 00:00:00', 'doing', '0', null);
INSERT INTO `borrowinfo` VALUES ('cbc2a716-16af-4ab3-a1a4-51abce006a6f', '8e213a32-e307-47b0-b8a5-7d6e01d8dadb', '123', '2017-09-19 19:39:12', '2017-09-19 19:39:12', 'finish', '0', null);
INSERT INTO `borrowinfo` VALUES ('e18cc3e4-1bd8-4957-90a8-b3d69e40fdfd', '859a52f6-5b9f-4054-a3df-171a1c9f8925', '123', '2017-09-21 08:58:56', '2017-09-21 08:58:56', 'finish', '0', null);

-- ----------------------------
-- Table structure for lminfo
-- ----------------------------
DROP TABLE IF EXISTS `lminfo`;
CREATE TABLE `lminfo` (
  `lmusername` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lmusername`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lminfo
-- ----------------------------
INSERT INTO `lminfo` VALUES ('admin', 'admin', null);

-- ----------------------------
-- Table structure for repayinfo
-- ----------------------------
DROP TABLE IF EXISTS `repayinfo`;
CREATE TABLE `repayinfo` (
  `repayid` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `repaydate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`repayid`),
  KEY `repayusername` (`username`),
  CONSTRAINT `repayusername` FOREIGN KEY (`username`) REFERENCES `userinfo` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repayinfo
-- ----------------------------

-- ----------------------------
-- Table structure for returninfo
-- ----------------------------
DROP TABLE IF EXISTS `returninfo`;
CREATE TABLE `returninfo` (
  `returnId` varchar(255) NOT NULL,
  `borrowId` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `returndate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`returnId`),
  KEY `reusername` (`username`),
  KEY `borrid` (`borrowId`),
  CONSTRAINT `borrid` FOREIGN KEY (`borrowId`) REFERENCES `borrowinfo` (`borrId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `reusername` FOREIGN KEY (`username`) REFERENCES `userinfo` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of returninfo
-- ----------------------------
INSERT INTO `returninfo` VALUES ('05070253-45d3-4d5d-9843-7a03959ae6a0', '74c955cd-0e7a-4416-a56b-0489643df772', '123', '2017-09-21 00:00:00', null);
INSERT INTO `returninfo` VALUES ('1be9ad3b-9a39-439f-93fb-851e49a0a7a5', '2bdec216-fe9f-4003-bec2-04ea1f590246', '123', '2017-09-19 00:00:00', null);
INSERT INTO `returninfo` VALUES ('5b44f799-0eec-43a5-affb-c98c34a8a878', '1803721b-5a65-45cd-aa00-fa8ffb7fc0d0', '123', '2017-09-19 00:00:00', null);
INSERT INTO `returninfo` VALUES ('77a4156b-81d2-46b7-a851-5e749ccbe834', '91f37df1-c2b1-4e15-beeb-fc91403db357', '123', '2017-09-21 00:00:00', null);
INSERT INTO `returninfo` VALUES ('7dc04cd5-15b5-45b6-b802-7e6aef83ceae', '99315d5b-d22f-47f0-9972-fb3ff92ee0f7', '123', '2017-09-19 00:00:00', null);
INSERT INTO `returninfo` VALUES ('84b9f1e5-3b38-41d4-99d4-18c0b5610e0f', '5fb5877d-232b-449c-a46e-cad5f66a454f', '123', '2017-09-21 00:00:00', null);
INSERT INTO `returninfo` VALUES ('9919bc99-b5fc-43d0-b21c-e0d2c5c03d0b', 'a3345be7-d45f-44b4-8c49-cbfee24cbb8c', '123', '2017-09-19 00:00:00', null);
INSERT INTO `returninfo` VALUES ('a5fc9f41-222b-4e3b-8fd1-4afd68374c66', 'e18cc3e4-1bd8-4957-90a8-b3d69e40fdfd', '123', '2017-09-21 00:00:00', null);
INSERT INTO `returninfo` VALUES ('b261583f-b25e-4beb-907e-765077f77c92', '5b0790ed-219f-42c7-a6e5-accdb2765577', '123', '2017-09-19 00:00:00', null);
INSERT INTO `returninfo` VALUES ('de228e99-f26e-4974-baf2-facd614e4bc7', '9311b2bf-89ab-4dce-96e9-baade7209c57', '123', '2017-09-19 00:00:00', null);
INSERT INTO `returninfo` VALUES ('de9e5640-a4dd-4387-b3e7-97ada3a09177', 'cbc2a716-16af-4ab3-a1a4-51abce006a6f', '123', '2017-09-19 00:00:00', null);
INSERT INTO `returninfo` VALUES ('fe3d04d4-61e2-40be-a158-916e2a14f236', 'c1ab3a78-37cb-48b7-80ab-217659075b78', '123', '2017-09-19 00:00:00', null);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `borrowNum` int(2) DEFAULT NULL,
  `borrowNumNow` int(3) DEFAULT NULL,
  `dayLimit` int(3) DEFAULT NULL,
  `arrearageMoney` double DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('123', '123', 'M', '10', '8', '30', '0', '');
INSERT INTO `userinfo` VALUES ('46345634', '12', null, '10', '0', '30', '0', '');
