package com.github.faeldn.todo.repositorio;

import java.util.List;

public interface ReposUi <K,T>{
	
	public List<T> all();
	public T one(K id);
	public void insert(T entity);
	public void update(T entity);
	public void delete(K id);

}
