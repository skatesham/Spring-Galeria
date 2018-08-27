use galeria;

drop table pap_papel;

create table pap_papel(
	pap_id bigint(20) primary key auto_increment,
    pap_descricao varchar(50) not null
	);
    
alter table usr_usuario add constraint foreign key (usr_id_papel) references pap_papel(pap_id);

commit;