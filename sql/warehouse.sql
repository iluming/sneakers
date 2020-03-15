/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : warehouse

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 12/03/2020 22:57:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`  (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌',
  `brand_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `brand_company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `brand_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `brand_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌的国家',
  PRIMARY KEY (`brand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '品牌也是供应商的信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES (1, 'nike', 'nike公司', NULL, '美国');
INSERT INTO `brand` VALUES (2, '彪马', 'PUMA集团', NULL, '德国');

-- ----------------------------
-- Table structure for input_apply
-- ----------------------------
DROP TABLE IF EXISTS `input_apply`;
CREATE TABLE `input_apply`  (
  `input_id` int(11) NOT NULL AUTO_INCREMENT,
  `sneakers_id` int(11) NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` float(11, 2) NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `num_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数量单位',
  `apply_time` datetime(0) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `net_weight` double(10, 2) NULL DEFAULT NULL COMMENT '净重',
  `invoice_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票号码',
  `applicant_id` int(255) NULL DEFAULT NULL,
  `supplier_id` int(255) NULL DEFAULT NULL COMMENT '供应商id',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓位',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`input_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of input_apply
-- ----------------------------
INSERT INTO `input_apply` VALUES (1, 1, '1', 1.00, 1, '1', '2020-03-03 14:30:57', 1.00, 1.00, 1.00, '1', 1, 22222, '1', '待审可');
INSERT INTO `input_apply` VALUES (2, 1, '1', 1.00, 1, '1', '2020-03-03 14:30:57', 1.00, 1.00, 1.00, '1', 1, 22222, '1', '待审可');
INSERT INTO `input_apply` VALUES (3, 1, '1', 1.00, 1, '1', '2020-03-03 14:30:57', 1.00, 1.00, 1.00, '1', 1, 22222, '1', '待审可');
INSERT INTO `input_apply` VALUES (4, 1, '1', 1.00, 1, '1', '2020-03-03 14:30:57', 1.00, 1.00, 1.00, '1', 1, 22222, '1', '待审可');
INSERT INTO `input_apply` VALUES (5, 1, '1', 1.00, 1, '1', '2020-03-03 14:30:57', 1.00, 1.00, 1.00, '1', 1, 22222, '1', '待审可');
INSERT INTO `input_apply` VALUES (6, 1, '1', 1.00, 1, '1', '2020-03-03 14:30:57', 1.00, 1.00, 1.00, '1', 1, 22222, '1', '待审可');
INSERT INTO `input_apply` VALUES (7, 1, '1', 1.00, 1, '1', '2020-03-03 14:30:57', 1.00, 1.00, 1.00, '1', 1, 22222, '1', '待审可');
INSERT INTO `input_apply` VALUES (8, 1, '1', 1.00, 1, '1', '2020-03-03 14:30:57', 1.00, 1.00, 1.00, '1', 1, 22222, '1', '待审可');
INSERT INTO `input_apply` VALUES (9, 1, '1', 1.00, 1, '1', '2020-03-03 14:30:57', 1.00, 1.00, 1.00, '1', 1, 22222, '1', '待审可');
INSERT INTO `input_apply` VALUES (10, 1, '1', 1.00, 1, '1', '2020-03-03 14:30:57', 1.00, 1.00, 1.00, '1', 1, 22222, '1', '待审可');
INSERT INTO `input_apply` VALUES (11, 1, '1', 1.00, 1, '1', '2020-03-03 14:30:57', 1.00, 1.00, 1.00, '1', 1, 22222, '1', '待审可');

-- ----------------------------
-- Table structure for output_apply
-- ----------------------------
DROP TABLE IF EXISTS `output_apply`;
CREATE TABLE `output_apply`  (
  `output_wh_id` int(11) NOT NULL AUTO_INCREMENT,
  `sneakers_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` float(11, 2) NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `output_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`output_wh_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property`  (
  `property_id` int(11) NOT NULL AUTO_INCREMENT,
  `species_id` int(11) NULL DEFAULT NULL,
  `property_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`property_id`) USING BTREE,
  INDEX `fk_property_category`(`species_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 262 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of property
-- ----------------------------
INSERT INTO `property` VALUES (1, 1, '码数');
INSERT INTO `property` VALUES (2, 1, '颜色');
INSERT INTO `property` VALUES (3, 1, '高度');
INSERT INTO `property` VALUES (4, 1, '性别');

-- ----------------------------
-- Table structure for property_value
-- ----------------------------
DROP TABLE IF EXISTS `property_value`;
CREATE TABLE `property_value`  (
  `pro_vlaue_id` int(11) NOT NULL AUTO_INCREMENT,
  `sneaker_id` int(11) NULL DEFAULT NULL COMMENT '球鞋id',
  `property_id` int(11) NULL DEFAULT NULL COMMENT '属性id',
  `property_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`pro_vlaue_id`) USING BTREE,
  INDEX `fk_propertyvalue_property`(`property_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14106 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of property_value
-- ----------------------------
INSERT INTO `property_value` VALUES (1, 1, 2, 'honhse');
INSERT INTO `property_value` VALUES (2, 1, 1, '40');
INSERT INTO `property_value` VALUES (3, 1, 2, 'lvse');
INSERT INTO `property_value` VALUES (4, 1, 4, 'nv');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '放管理员，用户，超级管理员',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员');
INSERT INTO `role` VALUES (2, '用户');
INSERT INTO `role` VALUES (3, '超级管理员');
INSERT INTO `role` VALUES (4, '供应商');

-- ----------------------------
-- Table structure for sneakers
-- ----------------------------
DROP TABLE IF EXISTS `sneakers`;
CREATE TABLE `sneakers`  (
  `sneakers_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '球鞋',
  `sneakers_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `species_id` int(11) NULL DEFAULT NULL COMMENT '种类',
  `brand_id` int(11) NULL DEFAULT NULL COMMENT '品牌',
  `sneakers_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `sneakers_inventory` int(11) NULL DEFAULT NULL COMMENT '库存',
  `sneakers_listed_time` datetime(0) NULL DEFAULT NULL COMMENT '上市时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`sneakers_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sneakers
-- ----------------------------
INSERT INTO `sneakers` VALUES (1, '111', 1, 1, 100.00, 1, '2020-03-02 20:52:37', '2020-03-02 20:52:48');
INSERT INTO `sneakers` VALUES (2, '啊大', 2, 2, 200.00, 1, '2020-03-12 19:22:10', '2020-03-12 19:23:22');
INSERT INTO `sneakers` VALUES (3, '啊大', 2, 2, 200.00, 1, '2020-03-12 19:22:10', '2020-03-12 19:23:22');
INSERT INTO `sneakers` VALUES (4, '啊大', 2, 2, 200.00, 1, '2020-03-12 19:22:10', '2020-03-12 19:23:22');
INSERT INTO `sneakers` VALUES (5, '啊大', 2, 2, 200.00, 1, '2020-03-12 19:22:10', '2020-03-12 19:23:22');
INSERT INTO `sneakers` VALUES (6, '啊大', 2, 2, 200.00, 1, '2020-03-12 19:22:10', '2020-03-12 19:23:22');
INSERT INTO `sneakers` VALUES (7, '啊大', 2, 2, 200.00, 1, '2020-03-12 19:22:10', '2020-03-12 19:23:22');
INSERT INTO `sneakers` VALUES (8, '啊大', 2, 2, 200.00, 1, '2020-03-12 19:22:10', '2020-03-12 19:23:22');
INSERT INTO `sneakers` VALUES (9, '啊大', 2, 2, 200.00, 1, '2020-03-12 19:22:10', '2020-03-12 19:23:22');
INSERT INTO `sneakers` VALUES (10, '啊大', 2, 2, 200.00, 1, '2020-03-12 19:22:10', '2020-03-12 19:23:22');
INSERT INTO `sneakers` VALUES (11, '啊大', 2, 2, 200.00, 1, '2020-03-12 19:22:10', '2020-03-12 19:23:22');

-- ----------------------------
-- Table structure for species
-- ----------------------------
DROP TABLE IF EXISTS `species`;
CREATE TABLE `species`  (
  `species_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '种类',
  `species_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `species_create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`species_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of species
-- ----------------------------
INSERT INTO `species` VALUES (1, '运动型', '2020-03-02 20:15:07');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sector` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  `partition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属公司分区Partition',
  `entry_time` datetime(0) NULL DEFAULT NULL COMMENT '入职日期',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '开户日期',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '1', '1', '1', '1', '1', '1', '1', '1', '2020-03-05 16:59:05', '2020-03-05 16:59:08');
INSERT INTO `user_info` VALUES (2, '1111', NULL, '111', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (3, '111', '123', '1111', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (4, '1116666', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '111', NULL, NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (5, '1113166', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '122', NULL, NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (6, '11131666', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '131', NULL, '666', '12354', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (7, NULL, '40bd001563085fc35165329ea1ff5c5ecbdbbeef', '311231', NULL, NULL, '131', '3131', '131', '2020-03-05 00:00:00', NULL);
INSERT INTO `user_info` VALUES (8, NULL, 'c348c1794df04a0473a11234389e74a236833822', 'HH', NULL, NULL, '123131', '12312', 'WY', NULL, NULL);
INSERT INTO `user_info` VALUES (9, NULL, 'd6a9450dc08555d6ecfaf7162e5267f401e6dd9a', '啊大', NULL, NULL, '1231', '阿萨德', '啊大', NULL, NULL);
INSERT INTO `user_info` VALUES (10, NULL, '6d95c1847219c633950f8f1ceca9761315abfc19', 'AD', NULL, NULL, 'ADD1', 'AD', 'AD', NULL, NULL);
INSERT INTO `user_info` VALUES (11, NULL, '632667547e7cd3e0466547863e1207a8c0c0c549', '11', NULL, NULL, '啊大', '231', '啊大', NULL, NULL);
INSERT INTO `user_info` VALUES (12, NULL, 'e794a80eb109162d579df51db6d52e223bb0e9be', '啊大', NULL, NULL, '1231', '123', '啊啊', NULL, NULL);
INSERT INTO `user_info` VALUES (13, NULL, 'e794a80eb109162d579df51db6d52e223bb0e9be', '啊大', NULL, NULL, '1231', '1231', '啊大', NULL, NULL);
INSERT INTO `user_info` VALUES (14, NULL, 'd30f79cf7fef47bd7a5611719f936539bec0d2e9', '啊大', NULL, NULL, '2312', '13', '阿萨德', NULL, NULL);
INSERT INTO `user_info` VALUES (15, '123', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '管理员啊大', NULL, NULL, '1231', '1331', 'ADSA', NULL, NULL);
INSERT INTO `user_info` VALUES (16, '666', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '阿达啊', NULL, NULL, '111', '111', '啊哒哒', NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 15, 3);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `warehouse_id` int(11) NOT NULL,
  `sneakers_id` int(11) NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` float(11, 1) NULL DEFAULT NULL,
  `inventory` int(11) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`warehouse_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库存表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (1, 1, 'hongse', 40.0, 100);

SET FOREIGN_KEY_CHECKS = 1;
