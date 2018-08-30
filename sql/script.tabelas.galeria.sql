use galeria;

/* TABELA USUARIO*/

drop table IF EXISTS usr_usuario;

create table usr_usuario(
	usr_id bigint(20) primary key auto_increment,
    usr_nome varchar(50) not null,
    usr_senha varchar(250) not null,
    usr_usuario varchar(25) not null unique,
    usr_email varchar(50) not null unique
);

alter table usr_usuario add column usr_id_papel bigint(20) not null;


/* TABELA PAPEL*/

drop table if exists pap_papel;

create table pap_papel(
	pap_id bigint(20) primary key auto_increment,
    pap_descricao varchar(50) not null
	);

commit;

/* TABELA INSERIR PAPEIS*/
insert into pap_papel(pap_descricao) values("Visitante");
insert into pap_papel(pap_descricao) values("Usuario Comum");
insert into pap_papel(pap_descricao) values("Administrador");

/* SET TABELA USUARIO AND INSERT USUARIOS*/
alter table usr_usuario add constraint foreign key(usr_id_papel) references pap_papel(pap_id);

insert into usr_usuario(usr_nome, usr_senha, usr_usuario, usr_email, usr_id_papel) values("Administrador", "admin", "admin", "admin@admin.com", 3);

insert into usr_usuario(usr_nome, usr_senha, usr_usuario, usr_email, usr_id_papel) values("Sham Vinicius", "123", "sham", "sham@admin.com", 2);

insert into usr_usuario(usr_nome, usr_senha, usr_usuario, usr_email, usr_id_papel) values("Lucao", "123", "lucas", "lucas@admin.com", 2);


/* TABELA IMAGEM*/

drop table if exists ima_imagem;

create table ima_imagem(
	ima_id bigint(20) primary key,
    ima_id_usuario bigint(20) not null,
    ima_nome varchar(50) not null,
    ima_tamanho varchar(20) not null,
    ima_tipo varchar(20) not null,
    ima_imagem blob not null
    );
    
alter table ima_imagem add constraint foreign key (ima_id_usuario) references usr_usuario(usr_id);

commit;