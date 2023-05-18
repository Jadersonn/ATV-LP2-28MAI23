create schema atvlp2;
CREATE TABLE departamento (
  id INT PRIMARY KEY AUTO_INCREMENT ,
  nome VARCHAR(100)
);
CREATE TABLE funcionario (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  cargo VARCHAR(100),
  departamentoId INT,
  FOREIGN KEY (departamentoId) REFERENCES departamento(id)
  ON DELETE CASCADE 
  ON UPDATE CASCADE
);

