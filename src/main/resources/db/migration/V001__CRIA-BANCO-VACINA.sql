-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           10.1.34-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;



CREATE DATABASE IF NOT EXISTS evaccine;

-- Copiando estrutura para tabela tb_pessoa
CREATE TABLE IF NOT EXISTS tb_pessoa (
  codigo bigint NOT NULL AUTO_INCREMENT,
  nome varchar(250) NOT NULL,
  cpf varchar(15) NOT NULL,
  email varchar(500) NOT NULL,
  telefone varchar(20) NOT NULL,
  dataNascimento varchar(10) NOT NULL,
  idade integer NOT NULL,
  
  PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando estrutura para tabela tb_grupo_prioridades
CREATE TABLE IF NOT EXISTS tb_grupo_prioridades (
  codigo bigint NOT NULL AUTO_INCREMENT,
  nome varchar(250) NOT NULL,
  descricao varchar(250) NOT NULL,

  
  PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
