/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : dnf_union

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 21/05/2019 09:34:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '昵称',
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别\n0 - 女\n1 - 男',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `activation` tinyint(1) NOT NULL DEFAULT 0 COMMENT '激活状态\n0 - 未激活\n1 - 激活',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除\n0 - 否\n1 - 是',
  `created_time` datetime(0) NOT NULL,
  `last_update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ADMIN_USERNAME_UNQ`(`username`) USING BTREE,
  UNIQUE INDEX `ADMIN_EMAIL_AND_MOBILE_UNQ`(`email`, `mobile`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES (1, 'admin', '123456', 'tanxin_java@163.com', '17621197917', '星光', '谭鑫', 1, NULL, 1, 0, '2019-05-16 16:04:15', '2019-05-15 16:04:18');
INSERT INTO `tb_admin` VALUES (2, 'tanxin', '123456', '1@1.com', '', '星光', '谭鑫', 1, NULL, 1, 0, '2019-05-15 16:04:15', '2019-05-15 16:04:18');
INSERT INTO `tb_admin` VALUES (3, 'tx3', '123456', '1@2.com', '', '星光', '谭鑫', 1, NULL, 1, 0, '2019-05-15 10:04:15', '2019-05-15 16:04:18');
INSERT INTO `tb_admin` VALUES (4, 'tx4', '123456', '1@3.com', '', '星光', '谭鑫', 1, NULL, 1, 0, '2019-05-15 13:04:15', '2019-05-15 16:04:18');
INSERT INTO `tb_admin` VALUES (5, 'tx5', '123456', '1@4.com', '', '星光', '谭鑫', 1, NULL, 1, 0, '2019-05-27 16:04:15', '2019-05-15 16:04:18');

-- ----------------------------
-- Table structure for tb_admin_has_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_has_role`;
CREATE TABLE `tb_admin_has_role`  (
  `admin_id` int(11) NOT NULL COMMENT '管理员id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`admin_id`, `role_id`) USING BTREE,
  INDEX `fk_tb_admin_has_tb_role_tb_role1_idx`(`role_id`) USING BTREE,
  INDEX `fk_tb_admin_has_tb_role_tb_admin1_idx`(`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员对应角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin_has_role
-- ----------------------------
INSERT INTO `tb_admin_has_role` VALUES (1, 1);
INSERT INTO `tb_admin_has_role` VALUES (2, 2);
INSERT INTO `tb_admin_has_role` VALUES (3, 2);
INSERT INTO `tb_admin_has_role` VALUES (4, 2);
INSERT INTO `tb_admin_has_role` VALUES (5, 2);

-- ----------------------------
-- Table structure for tb_privilege
-- ----------------------------
DROP TABLE IF EXISTS `tb_privilege`;
CREATE TABLE `tb_privilege`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限名',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限请求地址',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
  `created_time` datetime(0) NOT NULL,
  `last_update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_privilege
-- ----------------------------
INSERT INTO `tb_privilege` VALUES (1, '所有权限', '/**', 0, '2019-05-15 16:38:16', '2019-05-15 16:38:20');
INSERT INTO `tb_privilege` VALUES (2, '列表查看用户', '/back/user/list', 0, '2019-05-15 16:39:33', '2019-05-15 16:39:35');
INSERT INTO `tb_privilege` VALUES (3, '列表查看用户', '/back/user/list', 0, '2019-05-15 16:39:33', '2019-05-15 16:39:35');
INSERT INTO `tb_privilege` VALUES (4, '列表查看用户', '/back/user/list', 0, '2019-05-15 16:39:33', '2019-05-15 16:39:35');
INSERT INTO `tb_privilege` VALUES (5, '列表查看用户', '/back/user/list', 0, '2019-05-15 16:39:33', '2019-05-15 16:39:35');
INSERT INTO `tb_privilege` VALUES (6, '列表查看用户', '/back/user/list', 0, '2019-05-15 16:39:33', '2019-05-15 16:39:35');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色介绍',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除\n0 - 否\n1 - 是',
  `created_time` datetime(0) NOT NULL,
  `last_update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (1, '超级管理员', '最高权限者', 0, '2019-05-15 16:03:18', '2019-05-15 16:03:20');
INSERT INTO `tb_role` VALUES (2, '用户管理员', '管理用户', 0, '2019-05-15 16:41:20', '2019-05-15 16:41:25');
INSERT INTO `tb_role` VALUES (3, '帖子超级管理', '管理帖子的删除', 0, '2019-05-16 15:28:37', '2019-05-16 16:22:49');
INSERT INTO `tb_role` VALUES (4, '帖子管理员2', '管理帖子的删除', 0, '2019-05-16 15:30:26', '2019-05-16 15:30:26');
INSERT INTO `tb_role` VALUES (5, '帖子管理员3', '管理帖子的删除', 0, '2019-05-16 15:30:52', '2019-05-16 15:30:52');

-- ----------------------------
-- Table structure for tb_role_has_privilege
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_has_privilege`;
CREATE TABLE `tb_role_has_privilege`  (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `privilege_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`, `privilege_id`) USING BTREE,
  INDEX `fk_tb_role_has_tb_privilege_tb_privilege1_idx`(`privilege_id`) USING BTREE,
  INDEX `fk_tb_role_has_tb_privilege_tb_role1_idx`(`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色对应权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role_has_privilege
-- ----------------------------
INSERT INTO `tb_role_has_privilege` VALUES (1, 1);
INSERT INTO `tb_role_has_privilege` VALUES (2, 2);
INSERT INTO `tb_role_has_privilege` VALUES (2, 3);
INSERT INTO `tb_role_has_privilege` VALUES (2, 4);
INSERT INTO `tb_role_has_privilege` VALUES (2, 5);
INSERT INTO `tb_role_has_privilege` VALUES (2, 6);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '昵称',
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别\n0 - 女\n1 - 男',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `activation` tinyint(1) NOT NULL DEFAULT 0 COMMENT '激活状态\n0 - 未激活\n1 - 激活',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除\n0 - 否\n1 - 是',
  `created_time` datetime(0) NOT NULL,
  `last_update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `USER_USERNAME_UNQ`(`username`) USING BTREE,
  UNIQUE INDEX `USER_EMAIL_AND_MOBILE_UNQ`(`email`, `mobile`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'user', '123456', 'tanxin_java@163.com', NULL, '星光', '谭鑫', 1, NULL, 1, 0, '2019-05-15 16:04:15', '2019-05-15 16:04:18');

SET FOREIGN_KEY_CHECKS = 1;
