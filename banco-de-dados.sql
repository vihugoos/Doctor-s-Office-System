CREATE DATABASE consultorio;

USE consultorio;

CREATE TABLE tb_doutor (
    id_doutor int auto_increment primary key,
    nome_doutor varchar (50) not null,
    cpf_doutor varchar(14) not null,
    rg_doutor varchar(20) not null,
    sexo varchar(9) not null,
    data_nasc date not null,
    endereco varchar(60),
    telefone varchar(14),
    especialidade varchar(30) not null,
    numero_cro int not null
);

CREATE TABLE tb_paciente (
    id_paciente int auto_increment primary key,
    nome_paciente varchar(50) not null,
    sexo_paciente varchar(9) not null,
    rg_paciente varchar(20) not null,
    cpf_paciente varchar(14) not null,
    dat_nasc_paciente date,
    endereco_paciente varchar(80),
    telefone_paciente varchar(14) 
);

CREATE TABLE tb_usuario (
    id_usuario int auto_increment primary key,
    nome_usuario varchar(50) not null,
    sexo_usuario varchar(9) not null,
    rg_usuario varchar(20) not null,
    cpf_usuario varchar(14) not null,
    dat_nasc_usuario date,
    endereco_usuario varchar(80),
    telefone_usuario varchar(14),
    longin_usuario varchar(15) not null,
    senha_usuario int (12) not null 
);

CREATE TABLE tb_agenda (
    id_agenda int auto_increment primary key,
    id_doutor int,
    id_paciente int,
    data_agenda date not null,
    turno varchar(30) not null,
    status_Agenda varchar (30) 
);

ALTER TABLE tb_agenda ADD CONSTRAINT fk_doutor_agenda FOREIGN KEY (id_doutor) REFERENCES tb_doutor(id_doutor);

ALTER TABLE tb_agenda ADD CONSTRAINT fk_paciente_agenda FOREIGN KEY (id_paciente) REFERENCES tb_paciente (id_paciente);
