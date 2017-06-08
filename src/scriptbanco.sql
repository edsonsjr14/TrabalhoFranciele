-- MySQL Script generated by MySQL Workbench
-- 06/01/17 11:35:53
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nomeUsuario` VARCHAR(45) NOT NULL,
  `loginUsuario` VARCHAR(15) NOT NULL,
  `senhaUsuario` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Mensagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Mensagem` (
  `idMensagem` INT NOT NULL AUTO_INCREMENT,
  `conteudoMensagem` VARCHAR(500) NOT NULL,
  `idDestinatario` INT NOT NULL,
  `idRemetente` INT NOT NULL,
  `dataMensagem` DATETIME NOT NULL,
  PRIMARY KEY (`idMensagem`),
  INDEX `fkidUsuario_idx` (`idDestinatario` ASC),
  INDEX `fkidRemetente_idx` (`idRemetente` ASC),
  CONSTRAINT `fkidDestinario`
    FOREIGN KEY (`idDestinatario`)
    REFERENCES `mydb`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidRemetente`
    FOREIGN KEY (`idRemetente`)
    REFERENCES `mydb`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;