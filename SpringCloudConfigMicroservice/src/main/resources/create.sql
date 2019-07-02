-- SCHEMA: public

-- DROP SCHEMA public ;

CREATE SCHEMA public
    AUTHORIZATION postgres;

COMMENT ON SCHEMA public
    IS 'standard public schema';

GRANT ALL ON SCHEMA public TO postgres;

GRANT ALL ON SCHEMA public TO PUBLIC;


--create table fakultet 
DROP TABLE IF EXISTS fakultet CASCADE;
DROP TABLE IF EXISTS departman CASCADE;
DROP TABLE IF EXISTS student CASCADE;
DROP TABLE IF EXISTS status CASCADE;
DROP SEQUENCE IF EXISTS fakultet_seq CASCADE;
DROP SEQUENCE IF EXISTS departman_seq CASCADE;
DROP SEQUENCE IF EXISTS status_seq CASCADE;
DROP SEQUENCE IF EXISTS student_seq CASCADE;

CREATE TABLE fakultet(
	id integer NOT NULL,
    naziv varchar(50) NOT NULL,
    sediste varchar(50)
);

CREATE TABLE departman(
	id integer NOT NULL,
    naziv VARCHAR(50) NOT NULL,
    oznaka VARCHAR(200) NOT NULL,
	fakultet integer NOT NULL
);

CREATE TABLE status(
	id integer NOT NULL,
    naziv varchar(30) NOT NULL,
    oznaka varchar(30) NOT NULL
);

CREATE TABLE student(
	id integer NOT NULL,
    br_indexa varchar(20) NOT NULL,
    ime varchar(30) NOT NULL,
    prezime VARCHAR(50) NOT NULL,
    departman integer NOT NULL,
    status integer NOT NULL
);

ALTER TABLE fakultet ADD CONSTRAINT PK_Fakultet
	PRIMARY KEY(id);
ALTER TABLE departman ADD CONSTRAINT PK_Departman
	PRIMARY KEY(id);
ALTER TABLE status ADD CONSTRAINT PK_Status
	PRIMARY KEY(id);
ALTER TABLE student ADD CONSTRAINT PK_Student
	PRIMARY KEY(id);

ALTER TABLE departman ADD CONSTRAINT FK_Departman_Fakultet
	FOREIGN KEY (fakultet) REFERENCES fakultet (id);
ALTER TABLE student ADD CONSTRAINT FK_Student_Departman
	FOREIGN KEY (departman) REFERENCES departman (id);
ALTER TABLE student ADD CONSTRAINT FK_Student_status
	FOREIGN KEY (status) REFERENCES status (id);

CREATE INDEX IDXFK_Departman_Fakultet
	ON departman (fakultet);
CREATE INDEX IDXFK_Student_Departman
	ON student (departman);
CREATE INDEX IDXFK_Student_Status
	ON student (status);

CREATE SEQUENCE fakultet_seq
INCREMENT 1;
CREATE SEQUENCE departman_seq
INCREMENT 1;
CREATE SEQUENCE status_seq
INCREMENT 1;
CREATE SEQUENCE student_seq
INCREMENT 1;