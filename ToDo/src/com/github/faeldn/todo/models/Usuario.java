package com.github.faeldn.todo.models;

public class Usuario {
	
	private Integer id;
	private String name;
	private String email;
	private String cargo;
	
	
	public Usuario(Integer id, String name, String email, String cargo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cargo = cargo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	

}
