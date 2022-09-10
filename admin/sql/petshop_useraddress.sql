/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 80026 (8.0.26)
 Source Host           : 121.4.172.43:3306
 Source Schema         : petapp

 Target Server Type    : MySQL
 Target Server Version : 80026 (8.0.26)
 File Encoding         : 65001

 Date: 05/09/2022 15:18:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for useraddress
-- ----------------------------
DROP TABLE IF EXISTS `shop_useraddress`;
CREATE TABLE `shop_useraddress`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NULL DEFAULT NULL,
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tel` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `isDefault` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop_useraddress
-- ----------------------------
INSERT INTO `shop_useraddress` VALUES (1, 19101, '大哥大', '营口市辽宁省盖州市1', '15277980478', b'0');
INSERT INTO `shop_useraddress` VALUES (3, 19101, '小明', '扬州市江苏省高邮市12', '16541896558', b'0');
INSERT INTO `shop_useraddress` VALUES (6, 19106, '越界', '厦门理工458号', '13985547589', b'0');
INSERT INTO `shop_useraddress` VALUES (7, 19101, '小明', '河北省唐县121', '15641856512', b'0');
INSERT INTO `shop_useraddress` VALUES (12, 19101, '12', '北京市东城区12', '12343535454', b'1');
INSERT INTO `shop_useraddress` VALUES (14, 19101, '大明', '朝阳市辽宁省凌源市1号楼', '15757546595', b'0');

SET FOREIGN_KEY_CHECKS = 1;
