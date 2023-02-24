/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.31 : Database - covid19
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`covid19` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `covid19`;

/*Table structure for table `infected` */

DROP TABLE IF EXISTS `infected`;

CREATE TABLE `infected` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `sex` int DEFAULT NULL COMMENT '1男性 2女性',
  `age` int DEFAULT NULL,
  `port` varchar(100) DEFAULT NULL COMMENT '对应的口岸',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `infected` */

insert  into `infected`(`id`,`name`,`date`,`sex`,`age`,`port`) values (1,'张三','2023-01-22',1,50,'罗湖口岸'),(2,'李四','2023-01-23',2,18,'福田口岸'),(3,'王五','2023-01-22',1,30,'罗湖口岸'),(4,'人1','2023-01-23',2,25,'罗湖口岸');

/*Table structure for table `port` */

DROP TABLE IF EXISTS `port`;

CREATE TABLE `port` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `port` */

/*Table structure for table `virus` */

DROP TABLE IF EXISTS `virus`;

CREATE TABLE `virus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `date` varchar(100) DEFAULT NULL,
  `quantity` double DEFAULT NULL COMMENT '病毒载量',
  `port` varchar(100) DEFAULT NULL COMMENT '对应的口岸',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `virus` */

insert  into `virus`(`id`,`name`,`date`,`quantity`,`port`) values (1,'病毒1','2023-01-22',5.5,'罗湖口岸'),(2,'病毒2','2023-01-23',6,'福田口岸'),(3,'病毒3','2023-01-23',6.5,'罗湖口岸'),(4,'病毒4','2023-01-22',9,'罗湖口岸');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
