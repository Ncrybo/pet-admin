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

 Date: 05/09/2022 15:39:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods`;
CREATE TABLE `shop_goods`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shop_name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `img` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `price` double NULL DEFAULT NULL,
  `describes` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `amount` int NULL DEFAULT NULL,
  `type` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `shop_goods` VALUES (1, '英国皇家小猫', '喵小一', '/images/pet/cat1.jpg', 3458, '暂无描述', NULL, 'pet');
INSERT INTO `shop_goods` VALUES (2, '英短金渐层', '喵宅', '/images/pet/cat2.jpg', 3999, '暂无描述', NULL, 'pet');
INSERT INTO `shop_goods` VALUES (3, '哈士奇', '淘宠', '/images/pet/dog1.jpg', 1280, '暂无描述', NULL, 'pet');
INSERT INTO `shop_goods` VALUES (4, '萨摩耶', '淘宠', '/images/pet/dog2.jpg', 3680, '暂无描述', NULL, 'pet');
INSERT INTO `shop_goods` VALUES (5, '柯基', '淘宠', '/images/pet/dog3.jpg', 2680, '暂无描述', NULL, 'pet');
INSERT INTO `shop_goods` VALUES (6, '冰种蓝猫', '喵宅', '/images/pet/cat1.jpg', 3688, '暂无描述', NULL, 'pet');
INSERT INTO `shop_goods` VALUES (7, '英短银渐层', '喵小一', '/images/pet/cat3.jpg', 6888, '暂无描述', NULL, 'pet');
INSERT INTO `shop_goods` VALUES (8, '孟加拉豹猫', '喵的', '/images/pet/cat3.jpg', 9888, '暂无描述', NULL, 'pet');
INSERT INTO `shop_goods` VALUES (9, '猫粮', '喵的', '/images/foods/猫粮1.jpg', 99, '暂无描述', NULL, 'food');
INSERT INTO `shop_goods` VALUES (10, '全阶段全价猫粮成猫专用', '喵小一', '/images/foods/猫粮2.jpg', 27, '精品猫粮 7.15至7.30买一送一', 245, 'food');
INSERT INTO `shop_goods` VALUES (11, '幼猫猫粮 1-12月 共5斤', '喵小一', '/images/foods/猫粮3.jpg', 19.9, '佳洁士猫粮 官方直营 富含幼猫所需各种营养成分', 199, 'food');
INSERT INTO `shop_goods` VALUES (12, 'WoWo喔喔幼猫粮奶糕猫咪幼猫专用羊初乳英短美短布偶营养无谷3斤', '喵小一', '/images/foods/猫粮3.jpg', 29.9, '佳洁士猫粮 官方直营 富含幼猫所需各种营养成分', 256, 'food');
INSERT INTO `shop_goods` VALUES (13, '小猫精致洗澡澡', '喵小一', '/images/service/小猫洗澡.jpg', 50, '给小猫最精致的呵护', 999, 'serve');

SET FOREIGN_KEY_CHECKS = 1;
