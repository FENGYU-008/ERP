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

 Date: 08/06/2022 05:07:36
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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
                             `point` int NULL DEFAULT NULL COMMENT '积分',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '玲娜贝尔', 10);
INSERT INTO `customer` VALUES (2, '冰墩墩', 20);
INSERT INTO `customer` VALUES (3, '大耳狗', 0);
INSERT INTO `customer` VALUES (4, '噗噗', 0);

-- ----------------------------
-- Table structure for exchange_goods
-- ----------------------------
DROP TABLE IF EXISTS `exchange_goods`;
CREATE TABLE `exchange_goods`  (
                                   `id` int NOT NULL AUTO_INCREMENT,
                                   `goods_id` int NULL DEFAULT NULL COMMENT '商品ID',
                                   `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名',
                                   `customer_id` int NULL DEFAULT NULL COMMENT '客户ID',
                                   `order_id` int NULL DEFAULT NULL COMMENT '销售订单ID',
                                   `exchange_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '换货时间',
                                   `state` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '待审核' COMMENT '状态',
                                   PRIMARY KEY (`id`) USING BTREE,
                                   INDEX `exchange_customer_id_fk`(`customer_id`) USING BTREE,
                                   INDEX `exchange_goods_id_fk`(`goods_id`) USING BTREE,
                                   INDEX `exchange_order_id_fk`(`order_id`) USING BTREE,
                                   CONSTRAINT `exchange_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                   CONSTRAINT `exchange_goods_id_fk` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                   CONSTRAINT `exchange_order_id_fk` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '换货单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exchange_goods
-- ----------------------------
INSERT INTO `exchange_goods` VALUES (1, 2, 'POKAL 博克尔', 2, 3, '2022-06-07 01:19:53', '已审核');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `category` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类别',
                          `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名',
                          `production_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '生产日期',
                          `purchase_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '进货日期',
                          `expiration_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '保质期',
                          `unit_price` double NULL DEFAULT NULL COMMENT '单价',
                          `inventory` int NULL DEFAULT NULL COMMENT '库存量',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '毛绒玩具', 'BLÅHAJ 布罗艾', '2022-05-20', '2022-06-01', '2030-01-01', 129, 20);
INSERT INTO `goods` VALUES (2, '杯子', 'POKAL 博克尔', '2022-05-01', '2022-06-01', '2030-01-01', 7.99, 40);
INSERT INTO `goods` VALUES (3, '毛绒玩具', 'LIVLIG 里夫利', '2022-05-20', '2022-06-01', '2030-01-01', 99, 100);
INSERT INTO `goods` VALUES (4, '饮料', 'PÅTÅR 滤压咖啡', '2022-06-01', '2022-06-06', '2023-06-01', 59.99, 0);
INSERT INTO `goods` VALUES (5, '饼干', 'KAFFEREP 燕麦饼干', '2022-06-01', '2022-06-06', '2022-06-10', 32.99, 0);
INSERT INTO `goods` VALUES (6, '甜品', 'KAFFEREP 肉桂面包', '2022-06-01', '2022-06-01', '2022-06-07', 32.99, 0);

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
                          `sales_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '销售时间',
                          `state` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单状态',
                          PRIMARY KEY (`id`) USING BTREE,
                          INDEX `order_customer_id_fk`(`customer_id`) USING BTREE,
                          INDEX `order_goods_id_fk`(`goods_id`) USING BTREE,
                          CONSTRAINT `order_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                          CONSTRAINT `order_goods_id_fk` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '销售表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 1, 'BLÅHAJ 布罗艾', 1, 10, 1290, 1300, 10, 10, '2022-06-06 19:49:00', '已完成');
INSERT INTO `order` VALUES (2, 2, 'POKAL 博克尔', 2, 10, 79.9, 79.9, 0, 10, '2022-06-07 00:30:59', '已完成');
INSERT INTO `order` VALUES (3, 2, 'POKAL 博克尔', 2, 10, 79.9, 79.9, 0, 10, '2022-06-07 00:30:59', '已完成');

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
                             `purchase_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '进货时间',
                             PRIMARY KEY (`id`) USING BTREE,
                             INDEX `purchase_goods_id_fk`(`goods_id`) USING BTREE,
                             CONSTRAINT `purchase_goods_id_fk` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '进货表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES (1, 1, '宜家', 20, 80, '2022-06-01 08:30:00');
INSERT INTO `purchase` VALUES (5, 2, '宜家', 50, 5, '2022-06-01 00:00:00');
INSERT INTO `purchase` VALUES (6, 3, '宜家', 100, 50, '2022-06-07 00:39:47');

-- ----------------------------
-- Table structure for return_goods
-- ----------------------------
DROP TABLE IF EXISTS `return_goods`;
CREATE TABLE `return_goods`  (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `goods_id` int NULL DEFAULT NULL COMMENT '商品ID',
                                 `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名',
                                 `customer_id` int NULL DEFAULT NULL COMMENT '客户ID',
                                 `order_id` int NULL DEFAULT NULL COMMENT '销售订单ID',
                                 `return_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '退货时间',
                                 `state` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '待审核' COMMENT '状态',
                                 PRIMARY KEY (`id`) USING BTREE,
                                 INDEX `return_customer_id_fk`(`customer_id`) USING BTREE,
                                 INDEX `return_goods_id_fk`(`goods_id`) USING BTREE,
                                 INDEX `return_order_id_fk`(`order_id`) USING BTREE,
                                 CONSTRAINT `return_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                 CONSTRAINT `return_goods_id_fk` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                 CONSTRAINT `return_order_id_fk` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '退货单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_goods
-- ----------------------------
INSERT INTO `return_goods` VALUES (1, 1, 'BLÅHAJ 布罗艾', 1, 1, '2022-06-06 22:44:34', '已审核');
INSERT INTO `return_goods` VALUES (2, 2, 'POKAL 博克尔', 2, 2, '2022-06-07 00:36:28', '已审核');

-- ----------------------------
-- Triggers structure for table exchange_goods
-- ----------------------------
DROP TRIGGER IF EXISTS `exchange_goods_insert_trigger`;
delimiter ;;
CREATE TRIGGER `exchange_goods_insert_trigger` AFTER INSERT ON `exchange_goods` FOR EACH ROW begin
    update `order` set state = '待换货' where `order`.id = NEW.order_id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table exchange_goods
-- ----------------------------
DROP TRIGGER IF EXISTS `exchange_goods_update_trigger`;
delimiter ;;
CREATE TRIGGER `exchange_goods_update_trigger` AFTER UPDATE ON `exchange_goods` FOR EACH ROW begin
    select `order`.quantity into @exchange_quantity from `order` where id = NEW.goods_id;
    if OLD.state = '待审核' and NEW.state = '已审核' then
        update `order` set state = '已完成' where `order`.id = NEW.order_id;
    end if;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table order
-- ----------------------------
DROP TRIGGER IF EXISTS `order_trigger`;
delimiter ;;
CREATE TRIGGER `order_trigger` AFTER INSERT ON `order` FOR EACH ROW begin
    if NEW.point is not null then
        update customer
        set point = customer.point + NEW.point
        where customer.id = New.customer_id;
    end if;
    if New.goods_id is not null and NEW.quantity is not null then
        update goods
        set inventory = goods.inventory - NEW.quantity
        where goods.id = NEW.goods_id;
    end if;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table purchase
-- ----------------------------
DROP TRIGGER IF EXISTS `purchase_trigger`;
delimiter ;;
CREATE TRIGGER `purchase_trigger` AFTER INSERT ON `purchase` FOR EACH ROW begin
    update goods set inventory = goods.inventory + NEW.quantity
    where goods.id = New.goods_id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table return_goods
-- ----------------------------
DROP TRIGGER IF EXISTS `return_goods_insert_trigger`;
delimiter ;;
CREATE TRIGGER `return_goods_insert_trigger` AFTER INSERT ON `return_goods` FOR EACH ROW begin
    update `order` set state = '待退货' where `order`.id = NEW.order_id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table return_goods
-- ----------------------------
DROP TRIGGER IF EXISTS `return_goods_update_trigger`;
delimiter ;;
CREATE TRIGGER `return_goods_update_trigger` AFTER UPDATE ON `return_goods` FOR EACH ROW begin
    select `order`.quantity into @return_quantity from `order` where id = NEW.goods_id;
    if OLD.state = '待审核' and NEW.state = '已审核' then
        update goods set inventory = goods.inventory + @return_quantity where goods.id = NEW.goods_id;
        update `order` set state = '已完成' where `order`.id = NEW.order_id;
    end if;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
