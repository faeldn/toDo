package com.github.faeldn.todo.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class FactoryJDBC {

	public static Connection criaConn() {
		Connection conn = null;
		try {
			String path = System.getProperty("user.dir");
			String url = "jdbc:sqlite:" + path + "/Banco/BancoDados.db";
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
