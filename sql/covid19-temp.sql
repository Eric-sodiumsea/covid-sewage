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

/*Table structure for table `infected` */

DROP TABLE IF EXISTS `infected`;

CREATE TABLE `infected` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `sex` int DEFAULT NULL COMMENT '1男性 2女性',
  `age` int DEFAULT NULL,
  `place_id` int DEFAULT NULL COMMENT '对应的地点的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `infected` */

insert  into `infected`(`id`,`name`,`date`,`sex`,`age`,`place_id`) values (1,'张三','2023-01-22',1,50,23),(2,'李四','2023-01-23',2,18,24),(3,'王五','2023-01-22',1,30,23),(4,'人1','2023-01-23',2,25,23);

/*Table structure for table `place` */

DROP TABLE IF EXISTS `place`;

CREATE TABLE `place` (
  `id` int NOT NULL AUTO_INCREMENT,
  `place_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地点名称',
  `longitude` double DEFAULT NULL COMMENT '经度',
  `latitude` double DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `place` */

insert  into `place`(`id`,`place_name`,`longitude`,`latitude`) values (1,'1栋',114.407751,22.70946),(2,'2栋',114.407122,22.709485),(3,'3栋',114.406485,22.709135),(4,'4栋',114.406718,22.708852),(5,'6栋',114.407329,22.70856),(6,'8栋',114.407733,22.70796),(7,'12栋',114.408784,22.708477),(8,'化粪池',114.407976,22.709227),(9,'警务室',114.408012,22.709052),(10,'招标',114.408254,22.709294),(11,'罗湖口岸',NULL,NULL),(12,'福田口岸',NULL,NULL);

/*Table structure for table `place_detail` */

DROP TABLE IF EXISTS `place_detail`;

CREATE TABLE `place_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `place_name` varchar(100) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `father_id` int DEFAULT NULL COMMENT '父节点的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `place_detail` */

insert  into `place_detail`(`id`,`place_name`,`longitude`,`latitude`,`father_id`) values (1,'1栋第1个井口',114.407751,22.70946,1),(2,'1栋第2个井口',114.40723,22.709544,1),(3,'1栋第3个井口',114.40714,22.709652,1),(4,'1栋第4个井口',114.407275,22.709902,1),(5,'2栋第1个井口',114.407122,22.709485,2),(6,'2栋第2个井口',114.40714,114.40714,2),(7,'2栋第4个井口',114.407167,22.70941,2),(8,'3栋第1个井口',114.406485,22.709135,3),(9,'3栋第2个井口',114.406314,22.709002,3),(10,'3栋第3个井口',114.406538,22.708785,3),(11,'4栋第1个井口',114.406718,22.708852,4),(12,'4栋第2个井口',114.406736,22.708994,4),(13,'6栋第1个井口',114.407329,22.70856,5),(14,'6栋第2个井口',114.40732,22.708344,5),(15,'6栋第3个井口',114.407338,22.708185,5),(16,'6-9栋厕所',114.408039,22.708302,5),(17,'8栋第1个井口',114.407733,22.70796,6),(18,'12栋第1个井口',114.408784,22.708477,7),(19,'化粪池1',114.407976,22.709227,8),(20,'化粪池2',114.408173,22.70966,8),(21,'警务室',114.408012,22.709052,9),(22,'招标',114.408254,22.709294,10),(23,'罗湖口岸',NULL,NULL,11),(24,'福田口岸',NULL,NULL,12);

/*Table structure for table `virus` */

DROP TABLE IF EXISTS `virus`;

CREATE TABLE `virus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `quantity` int DEFAULT NULL COMMENT 'CT值',
  `place_id` int DEFAULT NULL COMMENT '对应的地点的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `virus` */

insert  into `virus`(`id`,`name`,`date`,`quantity`,`place_id`) values (1,'病毒1','2023-01-22',35,23),(2,'病毒2','2023-01-23',36,24),(3,'病毒3','2023-01-23',39,23),(4,'病毒4','2023-01-22',35,23),(5,'病毒5','2023-01-24',42,23),(6,'病毒6','2023-01-25',38,24),(7,'病毒7','2023-01-26',40,23),(8,'病毒8','2023-01-27',38,24),(9,'病毒9','2023-01-28',34,23),(10,'病毒10','2023-01-29',35,24),(11,'病毒11','2023-01-30',39,23),(12,'病毒12','2023-01-31',41,24),(13,'病毒13','2023-02-01',37,23),(14,'病毒14','2023-02-02',35,24),(15,'病毒15','2023-02-03',40,23),(16,'病毒16','2023-02-04',37,24),(17,'病毒17','2023-02-05',41,23),(18,'病毒18','2023-02-06',36,24),(19,'病毒19','2023-02-07',36,23),(20,'病毒20','2023-02-08',40,24),(21,'病毒21','2023-02-09',38,23),(22,'病毒22','2023-02-10',41,24),(23,NULL,NULL,NULL,NULL),(24,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
