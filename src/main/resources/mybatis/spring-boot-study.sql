/*
 Navicat Premium Data Transfer

 Source Server         : 开发新环境
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 127.0.0.1:28004
 Source Schema         : webchat

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` timestamp(0) NULL DEFAULT NULL,
  `region` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES (1, 'wyc', '男', '2016-05-25 11:19:26', '浙江', '这是测试测试', '干什么是事情哇！');
INSERT INTO `demo` VALUES (2, 'dna', '女', '2016-08-25 11:20:38', '上海', '不是测试', '做什么是事情啊！');
INSERT INTO `demo` VALUES (3, 'wyc3', '男', '2016-05-25 11:19:26', '浙江', '这是测试', '干什么是事情哇！');
INSERT INTO `demo` VALUES (4, 'dna4', '女', '2016-08-25 11:20:38', '上海', '不是测试', '做什么是事情啊！');
INSERT INTO `demo` VALUES (5, 'wyc5', '男', '2016-05-25 11:19:26', '浙江', '这是测试', '干什么是事情哇！');
INSERT INTO `demo` VALUES (6, 'dna6', '女', '2016-08-25 11:20:38', '上海', '不是测试', '做什么是事情啊！');
INSERT INTO `demo` VALUES (7, 'wyc7', '男', '2016-05-25 11:19:26', '浙江', '这是测试', '干什么是事情哇！');
INSERT INTO `demo` VALUES (8, 'dna8', '女', '2016-08-25 11:20:38', '上海', '不是测试', '做什么是事情啊！');
INSERT INTO `demo` VALUES (9, 'wyc9', '男', '2016-05-25 11:19:26', '浙江', '这是测试', '干什么是事情哇！');
INSERT INTO `demo` VALUES (10, 'dna10', '女', '2016-08-25 11:20:38', '上海', '不是测试', '做什么是事情啊！');
INSERT INTO `demo` VALUES (11, 'wyc11', '男', '2016-05-25 11:19:26', '浙江', '这是测试', '干什么是事情哇！');
INSERT INTO `demo` VALUES (12, 'dna12', '女', '2016-08-25 11:20:38', '上海', '不是测试', '做什么是事情啊！');

SET FOREIGN_KEY_CHECKS = 1;
