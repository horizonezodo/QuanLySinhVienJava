-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: truonghoc
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `hocsinh`
--

DROP TABLE IF EXISTS `hocsinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hocsinh` (
  `id` int NOT NULL,
  `hsname` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` int NOT NULL,
  `taikhoan` varchar(255) NOT NULL,
  `mark` float NOT NULL,
  `lop` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lop` (`lop`),
  CONSTRAINT `hocsinh_ibfk_2` FOREIGN KEY (`lop`) REFERENCES `lop` (`lopid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocsinh`
--

LOCK TABLES `hocsinh` WRITE;
/*!40000 ALTER TABLE `hocsinh` DISABLE KEYS */;
INSERT INTO `hocsinh` VALUES (2019201122,'Le Huy Hung','Ha Noi','huyhung29@gmail.com',12345678,'2019201122',3.32,5),(2019606017,'Nguyen Van Dung','Hung Yen','yikiharase@gmail.com',12345678,'2019606017',3,6),(2019606677,'Nguyen Van Bach','Hung Yen','VanBach@gmail.com',12345332,'2019606677',7.7,6),(2019606975,'Nguyen Duc Hiep','Hung Yen','horizonezodo@gmail.com',327747289,'2019606975',3.03,6),(2019661177,'Pham Minh Dao','Thai Binh','minhdao@gmail.com',321444555,'2019661177',2.98,6);
/*!40000 ALTER TABLE `hocsinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocsinhacount`
--

DROP TABLE IF EXISTS `hocsinhacount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hocsinhacount` (
  `acount` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  PRIMARY KEY (`acount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocsinhacount`
--

LOCK TABLES `hocsinhacount` WRITE;
/*!40000 ALTER TABLE `hocsinhacount` DISABLE KEYS */;
INSERT INTO `hocsinhacount` VALUES ('2019606975','hiepnguyen'),('2019661177','vandung');
/*!40000 ALTER TABLE `hocsinhacount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa`
--

DROP TABLE IF EXISTS `khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa` (
  `khoaid` int NOT NULL,
  `khoaname` varchar(255) NOT NULL,
  PRIMARY KEY (`khoaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa`
--

LOCK TABLES `khoa` WRITE;
/*!40000 ALTER TABLE `khoa` DISABLE KEYS */;
INSERT INTO `khoa` VALUES (1,'Cong Nghe Thong Tin'),(2,'Tu Dong Hoa'),(3,'Co Khi '),(4,'Du Lịch');
/*!40000 ALTER TABLE `khoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop`
--

DROP TABLE IF EXISTS `lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lop` (
  `lopid` int NOT NULL,
  `lopname` varchar(255) NOT NULL,
  `khoaid` int NOT NULL,
  PRIMARY KEY (`lopid`),
  KEY `khoaid` (`khoaid`),
  CONSTRAINT `lop_ibfk_1` FOREIGN KEY (`khoaid`) REFERENCES `khoa` (`khoaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop`
--

LOCK TABLES `lop` WRITE;
/*!40000 ALTER TABLE `lop` DISABLE KEYS */;
INSERT INTO `lop` VALUES (1,'CNTT 1',1),(2,'CNTT 2',1),(3,'CNTT ',1),(4,'CNTT 4',1),(5,'CNTT 5',1),(6,'CNTT 6',1),(7,'TDH 1',2),(8,'TDH 2',2),(9,'TDH 3',2),(10,'Tự Động Hóa 4',2),(11,'Tự Động Hóa 5',2);
/*!40000 ALTER TABLE `lop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-12 14:01:11
