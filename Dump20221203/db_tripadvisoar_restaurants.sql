-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: db_tripadvisoar
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `restaurants`
--

DROP TABLE IF EXISTS `restaurants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurants` (
  `RESTAURANT_ID` int NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) DEFAULT NULL,
  `RESTAURANT_NAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `RESTAURANT_OWNER` varchar(50) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `OPENING_HOURS` varchar(50) DEFAULT NULL,
  `PRICE` varchar(10) DEFAULT NULL,
  `COOKINGTYPE` varchar(50) DEFAULT NULL,
  `CONTACT` varchar(50) DEFAULT NULL,
  `MENU` varchar(255) DEFAULT NULL,
  `SPECIALDIET` varchar(255) DEFAULT NULL,
  `PASSWORD` int DEFAULT NULL,
  PRIMARY KEY (`RESTAURANT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurants`
--

LOCK TABLES `restaurants` WRITE;
/*!40000 ALTER TABLE `restaurants` DISABLE KEYS */;
INSERT INTO `restaurants` VALUES (1,'waffle1','waffle@gmail.com','The Real Waffle','alla','High Avenue 1','17:00-21:30','$$$','Traditional','794731452','The Authenthic, Cheesy Lover, Salted Butter Caramel','Gluten-free,Lactose free',1509442),(2,'pizza1','pizza@gmail.com','Pomodoro','lanonna','Highway Road 10','17:00-21:31','$','French','794731452','House pizza, Melanzane, Tiramisu','None',1509442),(3,'meat1','meat@gmail.com','Hunter Place','mike','Beautiful Road 35','17:00-21:32','$$','Italian','794731452','Steak 300grs, The raw Road, Creme Brulee','Gluten-free,Lactose free',1509442),(4,'japanese1','japanese@gmail.com','Oishii Udon','yoshida','Michel Road 50','17:00-21:33','$','Japanese','794731452','Kitsune Udon, Shouyu Udon, Kare Udon','Gluten-free,Lactose free',1509442),(5,'korean1','korean@gmail.com','The spicy House','seaon','Victoria Road 14','17:00-21:34','$$$','Korean','794731452','Bibimbap, Kimchi, Jjigae','Gluten-free,Lactose free',1509442);
/*!40000 ALTER TABLE `restaurants` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-03 14:04:43
