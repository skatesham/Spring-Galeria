package com.sham.fatec.galeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pap_papel")
public class Papel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pap_id")
	private long id;

	@Column(name = "pap_descricao", unique = true, length = 50, nullable = false)
	private String descricao;

	public Papel() {
	}

	public Papel(EnumPapel descricao) {
		this.descricao = descricao.getDescricao();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		String str = String.format("Objeto Papel - ID: %d / Desc: %s", id, descricao);
		return str;
	}
	
	

}
