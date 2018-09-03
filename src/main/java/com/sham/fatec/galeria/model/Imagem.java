package com.sham.fatec.galeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ima_imagem")
public class Imagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "ima_id")
	private long id;
	
	@Column(name = "ima_nome")
	private String nome;
	
	@Column(name = "ima_tamanho")
	private String tamanho;
	
	@Column(name = "ima_tipo")
	private String tipo;
	
	@Column (name = "ima_imagem")
	private byte[] imagemBlob;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ima_id_usuario")
	private Usuario usuario;
	
	public Imagem() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getImagemBlob() {
		return imagemBlob;
	}

	public void setImagemBlob(byte[] imagemBlob) {
		this.imagemBlob = imagemBlob;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		String str = String.format("Nome: %s, Tipo: %s", nome, tipo);
		return str; 
	}
	
	

}
