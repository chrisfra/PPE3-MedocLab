-- bdmedoclab doit être créée

-- ----------------------------------------------------------------------------------------------------------------------
-- CREATION DES TABLES---------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS forme(
	identifiant INT NOT NULL auto_increment,
	nom VARCHAR(50),
	CONSTRAINT pk_forme PRIMARY KEY (identifiant)
)ENGINE=InnoDB;
-- ----------------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS medicament(
	identifiant INT NOT NULL auto_increment,
	nom VARCHAR(50) unique,
	dateBrevet datetime,
	dateAMM datetime,
	dateRetrait datetime,
	idForme INT NOT NULL,
	CONSTRAINT pk_medicament PRIMARY KEY (identifiant),
	CONSTRAINT fk_medicament_forme FOREIGN KEY (idForme) REFERENCES forme (identifiant)
)ENGINE=InnoDB;
-- ----------------------------------------------------------------------------------------------------------------------
-- INSERTION DES TUPLES--------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------
INSERT INTO forme (nom) VALUES ('Comprimé');
INSERT INTO forme (nom) VALUES ('Gélule');
INSERT INTO forme (nom) VALUES ('Solution');
INSERT INTO forme (nom) VALUES ('Poudre');
-- ----------------------------------------------------------------------------------------------------------------------
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('RETROVIR','1995-5-12','1996-11-27',NULL,2);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('ALKERAN','1997-2-16','2001-11-21',NULL,3);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('EPIVIR',NULL,'2010-4-18',NULL,3);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('FLOLAN',NULL,'2003-1-16',NULL,4);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('HYCAMTIN',NULL,'2000-10-5',NULL,4);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('ESKAZOLE','2002-2-7','2008-10-4',NULL,1);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('VENTOLINE',NULL,'2013-2-5',NULL,3);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('ZIAGEN','2001-3-3','2009-10-15',NULL,1);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('ZEFFIX',NULL,'2004-2-11',NULL,1);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('TELZIR','2009-3-15',NULL,NULL,1);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('ATRIANCE','2003-5-14','2009-11-25',NULL,3);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('VOLIBRIS','2004-8-17','2008-8-6',NULL,1);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('LAMIVUDINE',NULL,'2009-1-9',NULL,1);
INSERT INTO medicament (nom,dateBrevet,dateAMM,dateRetrait,idForme) VALUES ('TAFINLAR','2007-3-23','2008-4-18',NULL,2);
-- ----------------------------------------------------------------------------------------------------------------------

