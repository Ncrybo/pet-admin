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

 Date: 05/09/2022 15:10:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `petshop_user`;
CREATE TABLE `petshop_user`  (
  `id` int NOT NULL,
  `uname` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `psw` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `img` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `phone` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `third_id` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `petshop_user` VALUES (19101, '小明', '123456', '/images/用户头像/tou1.jpg', '1008611', NULL);
INSERT INTO `petshop_user` VALUES (19102, '小杜', '123456', '/images/用户头像/tou1.jpg', '911666', NULL);
INSERT INTO `petshop_user` VALUES (19103, '小库', '123456', '/images/用户头像/tou2.jpg', '110888', NULL);
INSERT INTO `petshop_user` VALUES (19104, '小詹', '123456', '/images/用户头像/tou3.jpg', '120999', NULL);
INSERT INTO `petshop_user` VALUES (19105, 'MDHDPbgye49CzFjJvEc4DfL3hKMK37ckzLSqtbzlmJZyzA', 'fdvSRGdsft', 'https://upfile-drcn.platform.hicloud.com/787Q5UET7S1VxHcAtxQ5wA.kpo9EZpkcX_F4vcAIrdvjRbDY3bVJVBelpHNs6yV4TfWl50q3mp3WQ3soDT7WxNLEwl-PbT9qz1NbzZwd8CUGA-8UGusZ6WEWlw402jNRUAnxOZd6A.106595639.jpg', NULL, '越界');
INSERT INTO `petshop_user` VALUES (19106, '越界', 'fdvSRGdsft', 'https://upfile-drcn.platform.hicloud.com/787Q5UET7S1VxHcAtxQ5wA.kpo9EZpkcX_F4vcAIrdvjRbDY3bVJVBelpHNs6yV4TfWl50q3mp3WQ3soDT7WxNLEwl-PbT9qz1NbzZwd8CUGA-8UGusZ6WEWlw402jNRUAnxOZd6A.106595639.jpg', NULL, 'MDHDPbgye49CzFjJvEc4DfL3hKMK37ckzLSqtbzlmJZyzA');
INSERT INTO `petshop_user` VALUES (19107, '152******78', 'fdvSRGdsft', '', NULL, 'MDHdWkjvcpj8BfCBWcKaiaR9xcXIjbwAM9tf3GYZjn9lJeA');

SET FOREIGN_KEY_CHECKS = 1;
