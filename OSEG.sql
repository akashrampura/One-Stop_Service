
CREATE TABLE `oseg_user` (
  `email` varchar(50) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`email`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) 


CREATE TABLE `oseg_url_lookup` (
  `map_id` int(11) NOT NULL AUTO_INCREMENT,
  `Type_Name` varchar(45) DEFAULT NULL,
  `Type_Indicator` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`map_id`),
  UNIQUE KEY `Type_Indicator_UNIQUE` (`Type_Indicator`)
) 


CREATE TABLE `oseg_url` (
  `service_type` int(11) DEFAULT NULL,
  `service_name` varchar(45) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `service_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`service_id`),
  UNIQUE KEY `service_id_UNIQUE` (`service_id`),
  KEY `FK1_idx` (`service_type`),
  KEY `FK101_idx` (`service_name`),
  CONSTRAINT `FK_LOOK` FOREIGN KEY (`service_type`) REFERENCES `oseg_url_lookup` (`map_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) 
