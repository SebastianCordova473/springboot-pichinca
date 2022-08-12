-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `genero` VARCHAR(45) NULL,
  `edad` INT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(45) NULL DEFAULT NULL,
  `identificacion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contraseña` VARCHAR(45) NULL DEFAULT NULL,
  `estado` TINYINT NULL DEFAULT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cliente_persona1_idx` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `mydb`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`cuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cuenta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero_cuenta` VARCHAR(45) NULL DEFAULT NULL,
  `tipo_cuenta` VARCHAR(45) NULL DEFAULT NULL,
  `saldo_inicial` FLOAT NULL DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  `id_movimiento` INT NULL DEFAULT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cuenta_cliente1_idx` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_cuenta_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `mydb`.`cliente` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`movimientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`movimientos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NULL DEFAULT NULL,
  `tipo_movimiento` VARCHAR(45) NULL DEFAULT NULL,
  `saldo_inicial` FLOAT NULL DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  `cuenta_id` INT NOT NULL,
  PRIMARY KEY (`id`, `cuenta_id`),
  INDEX `fk_movimientos_cuenta1_idx` (`cuenta_id` ASC) VISIBLE,
  CONSTRAINT `fk_movimientos_cuenta1`
    FOREIGN KEY (`cuenta_id`)
    REFERENCES `mydb`.`cuenta` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
