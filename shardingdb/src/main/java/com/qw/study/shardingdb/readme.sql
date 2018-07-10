DROP DATABASE IF EXISTS shadingdb1;


show DATABASES ;
CREATE DATABASE shadingdb1;
use shadingdb1;
SET NAMES utf8mb4;

CREATE TABLE `order_info_0` (
  id BIGINT AUTO_INCREMENT COMMENT '自增id',
  order_no VARCHAR(20) NOT NULL DEFAULT '111xxxxxxx' COMMENT '订单号',
  order_type INT NOT NULL DEFAULT 0 COMMENT '订单类型',
  passage_name  VARCHAR(50) NOT NULL DEFAULT 'noname' COMMENT '乘机人姓名',
  PRIMARY KEY (id)
) ENGINE InnoDB, COMMENT '订单表';


CREATE TABLE `order_info_1` (
  id BIGINT AUTO_INCREMENT COMMENT '自增id',
  order_no VARCHAR(20) NOT NULL DEFAULT '111xxxxxxx' COMMENT '订单号',
  order_type INT NOT NULL DEFAULT 0 COMMENT '订单类型',
  passage_name  VARCHAR(50) NOT NULL DEFAULT 'noname' COMMENT '乘机人姓名',
  PRIMARY KEY (id)
) ENGINE InnoDB, COMMENT '订单表';



DROP DATABASE IF EXISTS shadingdb0;


show DATABASES ;
CREATE DATABASE shadingdb0;
use shadingdb0;
SET NAMES utf8mb4;

CREATE TABLE `order_info_0` (
  id BIGINT AUTO_INCREMENT COMMENT '自增id',
  order_no VARCHAR(20) NOT NULL DEFAULT '111xxxxxxx' COMMENT '订单号',
  order_type INT NOT NULL DEFAULT 0 COMMENT '订单类型',
  passage_name  VARCHAR(50) NOT NULL DEFAULT 'noname' COMMENT '乘机人姓名',
  PRIMARY KEY (id)
) ENGINE InnoDB, COMMENT '订单表';


CREATE TABLE `order_info_1` (
  id BIGINT AUTO_INCREMENT COMMENT '自增id',
  order_no VARCHAR(20) NOT NULL DEFAULT '111xxxxxxx' COMMENT '订单号',
  order_type INT NOT NULL DEFAULT 0 COMMENT '订单类型',
  passage_name  VARCHAR(50) NOT NULL DEFAULT 'noname' COMMENT '乘机人姓名',
  PRIMARY KEY (id)
) ENGINE InnoDB, COMMENT '订单表';
