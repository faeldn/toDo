package com.github.faeldn.todo.models;

public class Tarefa {
	
	private int id;
	private char status;
	private Usuario usuario;
	private String titulo;
	private String descricao;
	
	
	public Tarefa(int id, char status, Usuario usuario, String titulo, String descricao) {
		super();
		this.id = id;
		this.status = status;
		this.usuario = usuario;
		this.titulo = titulo;
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public char getStatus() {
		return status;
	}


	public void setStatus(char status) {
		this.status = status;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	

}
