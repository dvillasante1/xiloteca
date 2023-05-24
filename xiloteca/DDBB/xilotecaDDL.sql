CREATE DATABASE  IF NOT EXISTS `xiloteca` 
/*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `xiloteca`;


DROP TABLE IF EXISTS `muestras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `muestras` (
  `id_muestra` int NOT NULL AUTO_INCREMENT,
  `cient_acept1` varchar(255) DEFAULT NULL,
  `cient_acept2` varchar(255) DEFAULT NULL,
  `cient_acept3` varchar(255) DEFAULT NULL,
  `cient_acept4` varchar(255) DEFAULT NULL,
  `familia` varchar(255) DEFAULT NULL,
  `sinonimo` varchar(255) DEFAULT NULL,
  `vulgar` longtext,
  `muestra_jb` varchar(255) DEFAULT NULL,
  `muestra_lab` varchar(255) DEFAULT NULL,
  `muestra_mic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_muestra`)
) ENGINE=MyISAM AUTO_INCREMENT=502 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
