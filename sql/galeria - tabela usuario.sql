create database galeria;

use galeria;

#drop table usr_usuario;

create table usr_usuario(
	usr_id bigint(20) primary key auto_increment,
    usr_nome varchar(50) not null,
    usr_senha varchar(250) not null,
    usr_usuario varchar(25) not null unique,
    usr_email varchar(50) not null unique
);

alter table usr_usuario add column usr_id_papel bigint(20) not null;

commit;

#delete from usr_usuario where usr_id = 1;

#select * from usr_usuario;

#select * from usr_usuario where usr_id = 105 or 1=1;




