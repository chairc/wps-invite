/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : wps

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 28/04/2021 13:59:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for client_code
-- ----------------------------
DROP TABLE IF EXISTS `client_code`;
CREATE TABLE `client_code`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `client` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wps_sid
-- ----------------------------
DROP TABLE IF EXISTS `wps_sid`;
CREATE TABLE `wps_sid`  (
  `wps_id` int(100) NOT NULL AUTO_INCREMENT,
  `wps_sid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`wps_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wps_sid
-- ----------------------------
INSERT INTO `wps_sid` VALUES (1, 'V02S9N83GJqAAMdkbBDnv1OdL7yisYE00a10e7bf003a6172c3');
INSERT INTO `wps_sid` VALUES (2, 'V02SwV15KQ_8n6brU98_2kLnnFUDUOw00adf3fda0026934a7f');
INSERT INTO `wps_sid` VALUES (3, 'V02ShotJqqiWyubCX0VWTlcbgcHqtSQ00a45564e002678124c');
INSERT INTO `wps_sid` VALUES (4, 'V02S7tldy5ltYcikCzJ8PJQDSy_ElEs00a327c3c0026782526');
INSERT INTO `wps_sid` VALUES (5, 'V02SHHyff1XkzHXARGjbBI6uwyk1VzM00a68db04003a33ff25');
INSERT INTO `wps_sid` VALUES (6, 'V02S2oI49T-Jp0_zJKZ5U38dIUSIl8Q00aa679530026780e96');
INSERT INTO `wps_sid` VALUES (7, 'V02SFiqdXRGnH5oAV2FmDDulZyGDL3M00a61660c0026781be1');
INSERT INTO `wps_sid` VALUES (8, 'V02SkHGtbCwoa8Lxn70guCtPBKl630w00abd20b80023372fea');
INSERT INTO `wps_sid` VALUES (9, 'V02SzyNqoo0pUBtPqnZf5j2HjviVuGs00a765fe6002c1dc2b1');
INSERT INTO `wps_sid` VALUES (10, 'V02SC1mOHS0RiUBxeoA8NTliH2h2NGc00a803c35002693584d');
INSERT INTO `wps_sid` VALUES (11, 'V02Sb8gxW2inr6IDYrdHK_ywJnayd6s00ab7472b0026849b17');
INSERT INTO `wps_sid` VALUES (12, 'V02SPoOluAnWda0dTBYTXpdetS97tyI00a16135e002684bb5c');
INSERT INTO `wps_sid` VALUES (13, 'V02SWIvKWYijG6Rggo4m0xvDKj1m7ew00a8e26d3002508b828');
INSERT INTO `wps_sid` VALUES (14, 'V02StVuaNcoKrZ3BuvJQ1FcFS_xnG2k00af250d4002664c02f');
INSERT INTO `wps_sid` VALUES (15, 'V02S2UBSfNlvEprMOn70qP3jHPDqiZU00a7ef4a800341c7c3b');
INSERT INTO `wps_sid` VALUES (16, 'V02Sr3nJ9IicoHWfeyQLiXgvrRpje6E00a240b890023270f97');
INSERT INTO `wps_sid` VALUES (17, 'V02SBsNOf4sJZNFo4jOHdgHg7-2Tn1s00a338776000b669579');
INSERT INTO `wps_sid` VALUES (18, 'V02ScVbtm2pQD49ArcgGLv360iqQFLs014c8062e000b6c37b6');

SET FOREIGN_KEY_CHECKS = 1;
