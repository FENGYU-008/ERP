/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : erp

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 05/06/2022 02:04:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `point` int NULL DEFAULT NULL COMMENT '积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exchange
-- ----------------------------
DROP TABLE IF EXISTS exchange_goods;
CREATE TABLE `exchange`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_id` int NULL DEFAULT NULL COMMENT '商品ID',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名',
  `customer_id` int NULL DEFAULT NULL COMMENT '客户ID',
  `order_id` int NULL DEFAULT NULL COMMENT '销售订单ID',
  `exchange_time` date NULL DEFAULT NULL COMMENT '换货时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `exchange_customer_id_fk`(`customer_id`) USING BTREE,
  INDEX `exchange_goods_id_fk`(`goods_id`) USING BTREE,
  INDEX `exchange_order_id_fk`(`order_id`) USING BTREE,
  CONSTRAINT `exchange_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `exchange_goods_id_fk` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `exchange_order_id_fk` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '退货单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类别',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名',
  `production_time` date NULL DEFAULT NULL COMMENT '生产日期',
  `purchase_time` date NULL DEFAULT NULL COMMENT '进货日期',
  `expiration_time` date NULL DEFAULT NULL COMMENT '保质期',
  `unit_price` double NULL DEFAULT NULL COMMENT '单价',
  `inventory` int NULL DEFAULT NULL COMMENT '库存量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_id` int NULL DEFAULT NULL COMMENT '商品ID',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名',
  `customer_id` int NULL DEFAULT NULL COMMENT '客户ID',
  `quantity` int NULL DEFAULT NULL COMMENT '数量',
  `amount_payable` double NULL DEFAULT NULL COMMENT '应付价格',
  `amount_paid` double NULL DEFAULT NULL COMMENT '实付价格',
  `change` double NULL DEFAULT NULL COMMENT '找零',
  `point` int NULL DEFAULT NULL COMMENT '积分',
  `sales_time` date NULL DEFAULT NULL COMMENT '销售时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_customer_id_fk`(`customer_id`) USING BTREE,
  INDEX `order_goods_id_fk`(`goods_id`) USING BTREE,
  CONSTRAINT `order_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_goods_id_fk` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '销售表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_id` int NULL DEFAULT NULL COMMENT '商品ID',
  `supplier` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '供应商',
  `quantity` int NULL DEFAULT NULL COMMENT '数量',
  `purchase_price` double NULL DEFAULT NULL COMMENT '进价',
  `purchase_time` date NULL DEFAULT NULL COMMENT '进货时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `purchase_goods_id_fk`(`goods_id`) USING BTREE,
  CONSTRAINT `purchase_goods_id_fk` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '进货表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for return
-- ----------------------------
DROP TABLE IF EXISTS return_goods;
CREATE TABLE `return`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_id` int NULL DEFAULT NULL COMMENT '商品ID',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名',
  `customer_id` int NULL DEFAULT NULL COMMENT '客户ID',
  `order_id` int NULL DEFAULT NULL COMMENT '销售订单ID',
  `return_time` date NULL DEFAULT NULL COMMENT '退货时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `return_customer_id_fk`(`customer_id`) USING BTREE,
  INDEX `return_goods_id_fk`(`goods_id`) USING BTREE,
  INDEX `return_order_id_fk`(`order_id`) USING BTREE,
  CONSTRAINT `return_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `return_goods_id_fk` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `return_order_id_fk` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '退货单表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
