package com.github.faeldn.todo.main;

import java.util.Scanner;

import com.github.faeldn.todo.ui.ControllerUser;

public class Console {

	public static void main(String[] args) {
		
		ControllerUser controllerUser = new ControllerUser();
		
		Scanner menu = new Scanner(System.in);
		
		int opcao = 0;
		do {
			System.out
					.println("### BEM VINDO AO PROGRAMA: SUAS TAREFAS ###");
			System.out.println("\n=================================");
			System.out.println("|1 - Ver Todos os Registros	|");
			System.out.println("|2 - Ver Apenas um Registro	|");
			System.out.println("|3 - Adicionar Registro		|");
			System.out.println("|4 - Alterar Registro		|");
			System.out.println("|5 - Excluir Registro		|");
			System.out.println("|0 - Sair			|");
			System.out.println("=================================\n");
			System.out.println("Opção: ");

			int option = menu.nextInt();
			
			System.out.print("\n");
			switch (option) {
			case 1:
				controllerUser.listaTodos();
				break;
			case 2:
				controllerUser.listaUm();
				break;
			case 3:
				controllerUser.adicionar();
				break;
			case 4:
				controllerUser.alterar();
				break;
			case 5:
				controllerUser.remover();
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			case 0:
				System.out.print("Até logo!");
			}
		} while (opcao != 0);
	}

}
