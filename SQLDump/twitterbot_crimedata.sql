CREATE DATABASE  IF NOT EXISTS `twitterbot` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `twitterbot`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: twitterbot
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `crimedata`
--

DROP TABLE IF EXISTS `crimedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crimedata` (
  `INCIDENT_NUMBER` varchar(100) DEFAULT NULL,
  `DATE_REPORTED` varchar(100) DEFAULT NULL,
  `DATE_OCCURED` varchar(100) DEFAULT NULL,
  `UOR_DESC` varchar(100) DEFAULT NULL,
  `CRIME_TYPE` varchar(100) DEFAULT NULL,
  `NIBRS_CODE` varchar(100) DEFAULT NULL,
  `UCR_HIERARCHY` varchar(100) DEFAULT NULL,
  `ATT_COMP` varchar(100) DEFAULT NULL,
  `LMPD_DIVISION` varchar(100) DEFAULT NULL,
  `LMPD_BEAT` varchar(100) DEFAULT NULL,
  `PREMISE_TYPE` varchar(100) DEFAULT NULL,
  `BLOCK_ADDRESS` varchar(100) DEFAULT NULL,
  `CITY` varchar(100) DEFAULT NULL,
  `ZIP_CODE` varchar(100) DEFAULT NULL,
  `ID` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-20 19:53:23