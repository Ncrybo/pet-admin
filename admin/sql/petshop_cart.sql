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

 Date: 05/09/2022 16:34:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NULL DEFAULT NULL,
  `goods_id` int NULL DEFAULT NULL,
  `count` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40017 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `shop_cart` VALUES (40001, 19101, 4, 1);
INSERT INTO `shop_cart` VALUES (40002, 19101, 5, 1);
INSERT INTO `shop_cart` VALUES (40003, 19102, 3, 1);
INSERT INTO `shop_cart` VALUES (40012, 19101, 13, 7);
INSERT INTO `shop_cart` VALUES (40013, 19101, 2, 1);
INSERT INTO `shop_cart` VALUES (40014, 19101, 6, 1);
INSERT INTO `shop_cart` VALUES (40015, 19101, 8, 1);
INSERT INTO `shop_cart` VALUES (40016, 19101, 7, 1);

SET FOREIGN_KEY_CHECKS = 1;
