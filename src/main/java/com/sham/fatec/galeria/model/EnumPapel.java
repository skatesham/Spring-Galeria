package com.sham.fatec.galeria.model;

public enum EnumPapel {
	
	VISITANTE("Visitante"),
	USUARIO_COMUM("Usuario Comum"),
	ADMINISTRADOR("Adminsitrador");
	
	private String descricao;

	private EnumPapel(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
