/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.31 : Database - covid19-temp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`covid19-temp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `covid19-temp`;

/*Table structure for table `environ` */

DROP TABLE IF EXISTS `environ`;

CREATE TABLE `environ` (
  `列一` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `environ` */

insert  into `environ`(`列一`,`id`) values ('1',1),('测试1',2);

/*Table structure for table `infected` */

DROP TABLE IF EXISTS `infected`;

CREATE TABLE `infected` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `sex` int DEFAULT NULL COMMENT '1男性 2女性',
  `age` int DEFAULT NULL,
  `place_detail_id` int DEFAULT NULL COMMENT '对应的地点的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `infected` */

insert  into `infected`(`id`,`name`,`date`,`sex`,`age`,`place_detail_id`) values (1,'张三','2023-03-22',1,50,1),(2,'李四','2023-03-23',2,18,1),(3,'王五','2023-03-22',1,30,1),(4,'陈六','2023-03-23',2,25,1),(5,'人05','2023-03-24',1,20,1),(6,'人06','2023-03-25',2,27,1),(7,'人07','2023-03-25',1,42,1),(8,'人08','2023-03-26',2,37,1),(9,'人09','2023-03-27',1,28,1),(10,'人10','2023-03-27',2,31,1),(11,'人11','2023-03-19',1,41,1),(12,'人12','2023-03-19',2,23,1),(13,'人13','2023-03-20',1,36,1),(14,'人14','2023-03-21',2,22,1);

/*Table structure for table `place` */

DROP TABLE IF EXISTS `place`;

CREATE TABLE `place` (
  `id` int NOT NULL AUTO_INCREMENT,
  `place_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地点名称',
  `longitude` double DEFAULT NULL COMMENT '经度',
  `latitude` double DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `place` */

insert  into `place`(`id`,`place_name`,`longitude`,`latitude`) values (1,'竹韵花园',114.407751,22.70946),(28,'创业路污水泵站',NULL,NULL),(29,'登良路污水泵站',NULL,NULL),(30,'前海污水泵站',NULL,NULL),(31,'南山水质净化厂',NULL,NULL),(32,'蛇口水质净化厂',NULL,NULL),(33,'西丽水质净化厂',NULL,NULL),(34,'福星泵站',NULL,NULL),(35,'皇岗村截污泵站',NULL,NULL),(36,'石厦泵站',NULL,NULL),(37,'福田保税区泵房',NULL,NULL),(38,'福田水质净化厂',NULL,NULL),(39,'滨河水质净化厂',NULL,NULL);

/*Table structure for table `place_detail` */

DROP TABLE IF EXISTS `place_detail`;

CREATE TABLE `place_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `place_name` varchar(100) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `father_id` int DEFAULT NULL COMMENT '父节点的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `place_detail` */

insert  into `place_detail`(`id`,`place_name`,`longitude`,`latitude`,`father_id`) values (1,'1栋第1个井口',114.407751,22.70946,1),(2,'1栋第2个井口',114.40723,22.709544,1),(3,'1栋第3个井口',114.40714,22.709652,1),(4,'1栋第4个井口',114.407275,22.709902,1),(5,'2栋第1个井口',114.407122,22.709485,1),(6,'2栋第2个井口',114.40714,114.40714,1),(7,'2栋第4个井口',114.407167,22.70941,1),(8,'3栋第1个井口',114.406485,22.709135,1),(9,'3栋第2个井口',114.406314,22.709002,1),(10,'3栋第3个井口',114.406538,22.708785,1),(11,'4栋第1个井口',114.406718,22.708852,1),(12,'4栋第2个井口',114.406736,22.708994,1),(13,'6栋第1个井口',114.407329,22.70856,1),(14,'6栋第2个井口',114.40732,22.708344,1),(15,'6栋第3个井口',114.407338,22.708185,1),(16,'6-9栋厕所',114.408039,22.708302,1),(17,'8栋第1个井口',114.407733,22.70796,1),(18,'12栋第1个井口',114.408784,22.708477,1),(19,'化粪池1',114.407976,22.709227,1),(20,'化粪池2',114.408173,22.70966,1),(21,'警务室',114.408012,22.709052,1),(22,'招标',114.408254,22.709294,1),(25,'创业路污水泵站',NULL,NULL,28),(26,'登良路污水泵站',NULL,NULL,29),(27,'前海污水泵站',NULL,NULL,30),(28,'南山水质净化厂',NULL,NULL,31),(29,'蛇口水质净化厂',NULL,NULL,32),(30,'西丽水质净化厂',NULL,NULL,33),(31,'福星泵站',NULL,NULL,34),(32,'皇岗村截污泵站',NULL,NULL,35),(33,'石厦泵站',NULL,NULL,36),(34,'福田保税区泵房',NULL,NULL,37),(35,'福田水质净化厂一（厂内泵站）',NULL,NULL,38),(36,'福田水质净化厂二（凤塘泵站）',NULL,NULL,38),(37,'滨河水质净化厂（进厂前端管网竖井）',NULL,NULL,39);

/*Table structure for table `virus` */

DROP TABLE IF EXISTS `virus`;

CREATE TABLE `virus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `quantity` int DEFAULT NULL COMMENT 'CT值',
  `place_detail_id` int DEFAULT NULL COMMENT '对应的地点的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `virus` */

insert  into `virus`(`id`,`name`,`date`,`quantity`,`place_detail_id`) values (1,'病毒1','2023-02-19',35,1),(2,'病毒2','2023-02-20',36,1),(3,'病毒3','2023-02-20',39,1),(4,'病毒4','2023-02-18',35,1),(5,'病毒5','2023-02-21',42,1),(6,'病毒6','2023-02-22',38,1),(7,'病毒7','2023-02-23',40,1),(8,'病毒8','2023-02-24',38,1),(9,'病毒9','2023-02-25',34,1),(10,'病毒10','2023-02-26',35,1),(11,'病毒11','2023-02-27',39,1),(12,'病毒12','2023-02-28',41,1),(13,'病毒13','2023-03-01',37,1),(14,'病毒14','2023-03-02',35,1),(15,'病毒15','2023-03-03',40,1),(16,'病毒16','2023-03-04',37,1),(17,'病毒17','2023-03-05',41,1),(18,'病毒18','2023-03-06',36,1),(19,'病毒19','2023-03-07',36,1),(20,'病毒20','2023-03-08',40,1),(21,'病毒21','2023-03-09',38,1),(22,'病毒22','2023-03-10',41,1),(23,NULL,NULL,NULL,NULL),(24,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
