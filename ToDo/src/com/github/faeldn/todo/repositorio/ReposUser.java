package com.github.faeldn.todo.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.github.faeldn.todo.models.Usuario;

public class ReposUser implements ReposUi<Integer,Usuario> {
	
	private List<Usuario> dbUsers = new ArrayList<Usuario>();

	public List<Usuario> all() {
		return this.dbUsers;
	}

	public Usuario one(Integer id) {
		for (Usuario u : this.dbUsers) {
			if (u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}

	public void insert(Usuario entity) {
		this.dbUsers.add(entity);		
	}

	public void update(Usuario entity) {
		for (Usuario u : this.dbUsers) {
			if (u.getId().equals(entity.getId())) {
				u.setName(entity.getName());
				u.setEmail(entity.getEmail());
				u.setCargo(entity.getCargo());
			}
		}
		
	}

	public void delete(Integer id) {
		int key = 0;
		for (Usuario u : this.dbUsers) {
			if (u.getId().equals(id)) {
				this.dbUsers.remove(key);
			}
			key++;
		}
	}
}
