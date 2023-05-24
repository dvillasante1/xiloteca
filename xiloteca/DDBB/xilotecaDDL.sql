CREATE DATABASE  IF NOT EXISTS `xiloteca`;
CREATE USER 'xiloteca'@'localhost' IDENTIFIED BY 'password';
GRANT ALL ON xiloteca.* TO 'xiloteca'@'localhost';

USE `xiloteca`;

DROP TABLE IF EXISTS `muestras`;
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
) ENGINE=MyISAM AUTO_INCREMENT=502 DEFAULT CHARSET=utf8mb4;
