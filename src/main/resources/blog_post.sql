/*
 Navicat Premium Data Transfer

 Source Server         : Localhost_MySql
 Source Server Type    : MySQL
 Source Server Version : 80037
 Source Host           : localhost:3306
 Source Schema         : blogging_platform

 Target Server Type    : MySQL
 Target Server Version : 80037
 File Encoding         : 65001

 Date: 17/12/2024 20:03:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_post
-- ----------------------------
DROP TABLE IF EXISTS `blog_post`;
CREATE TABLE `blog_post`  (
  `id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字体类型',
  `tags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_post
-- ----------------------------
INSERT INTO `blog_post` VALUES ('0de0d2a1be1a45a5bfd5a9d13b5419ca', 'My First Blog Post', 'This is the content of my first blog post', 'Technology', 'Tech,Programming', '2024-12-17 16:26:49', '2024-12-17 16:26:49');
INSERT INTO `blog_post` VALUES ('15d377a992d34276b7613605d7f49334', 'My First Blog Post', 'This is the content of my first blog post', 'Technology', 'Tech,Programming', '2024-12-17 16:26:48', '2024-12-17 16:26:48');
INSERT INTO `blog_post` VALUES ('4bd09f3c46c54ad39bf2f6a8e22e16c0', 'My First Blog Post', 'This is the content of my first blog post', 'Technology', 'Tech,Programming', '2024-12-17 16:26:47', '2024-12-17 16:26:47');
INSERT INTO `blog_post` VALUES ('83bdca45a00542e79f041e51410a84d9', 'My First Blog Post', 'This is the content of my first blog post', 'Technology', 'Tech,Programming', '2024-12-17 16:26:46', '2024-12-17 16:26:46');
INSERT INTO `blog_post` VALUES ('a4534fd3cf704cc6a88466e24e74ab11', 'My Update Blog Post', 'This is the Update of my first blog post', 'Technology', 'Tech,Programming', '2024-12-17 16:15:52', '2024-12-17 16:16:16');
INSERT INTO `blog_post` VALUES ('f541ff81d4b04374be94f428e516f362', 'My First Blog Post', 'This is the content of my first blog post', 'Technology', 'Tech,Programming', '2024-12-17 16:26:50', '2024-12-17 16:26:50');

SET FOREIGN_KEY_CHECKS = 1;
