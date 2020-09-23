package com.github.faeldn.todo.ui;

import java.util.List;
import java.util.Scanner;

import com.github.faeldn.todo.models.Usuario;
import com.github.faeldn.todo.repositorio.ReposUser;
import com.github.faeldn.todo.repositorio.ReposUserDb;

public class ControllerUser {
	
//	private ReposUser repositorioUsuario = new ReposUser();
	private ReposUserDb repositorioUsuario = new ReposUserDb();
	
	private Scanner scan = new Scanner(System.in);
	
	public void listaTodos() {
		List<Usuario> lista = this.repositorioUsuario.all();
		
		if (lista.isEmpty()) {
			System.out.println("Sem usuários cadastrados");
		}
		
		lista.forEach (u -> {
			System.out.println("ID: " + u.getId());
			System.out.println("Nome: " + u.getName());
			System.out.println("Email: " + u.getEmail());
			System.out.println("Cargo: " + u.getCargo());
			System.out.println("_______________________");
		});
	}
	
	public void listaUm() {
		System.out.println("Digite o ID a ser buscado: ");
		int id = scan.nextInt();
		scan.nextLine();
		Usuario user = repositorioUsuario.one(id);
		if (!user.equals(null)) {
			System.out.println("ID: " + user.getId());
			System.out.println("Nome: " + user.getName());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Cargo: " + user.getCargo());
			System.out.println("___________________________");
			} else {
				System.out.println("Usuário não existe.");
			}		
	}
	
	public void adicionar() {
		Integer id;
		String name;
		String email;
		String cargo;
		
		
		System.out.println("Digite o ID: ");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Digite o nome do Usuário: ");
		name = scan.nextLine();
		System.out.println("Digite seu email: ");
		email = scan.nextLine();
		System.out.println("Digite seu cargo: ");
		cargo = scan.nextLine();		
		Usuario u = new Usuario(id, name, email, cargo);
		repositorioUsuario.insert(u);
		System.out.println("Usuário Cadastrado com sucesso!");
	}
	
	public void alterar() {
		System.out.println("Digite o ID a ser alterado: ");
		int id = scan.nextInt();
		scan.nextLine();
		Usuario userOld = repositorioUsuario.one(id);
		if (!userOld.equals(null)) {
			System.out.println("Nome cadastrado: " + userOld.getName());
			System.out.println("Email cadastrado: " + userOld.getEmail());
			System.out.println("Cargo cadastrado: " + userOld.getCargo());
			
			System.out.println("Digite os novos dados: ");
			System.out.println("Digite o novo nome do Usuário: ");
			String name = scan.nextLine();
			System.out.println("Digite seu novo email: ");
			String email = scan.nextLine();
			System.out.println("Digite seu novo cargo: ");
			String cargo = scan.nextLine();
			Usuario userNew = new Usuario(userOld.getId(), name, email, cargo);
			repositorioUsuario.update(userNew);
			System.out.println("Usuário alterado com sucesso.");
		} else {
			System.out.println("Usuário não encontrado.");
		}
	}
	
	public void remover() {
		System.out.println("Digite o ID a ser removido: ");
		int id = scan.nextInt();
		scan.nextLine();
		repositorioUsuario.delete(id);
		System.out.println("Usuário removido com sucesso.");		
	}
}
