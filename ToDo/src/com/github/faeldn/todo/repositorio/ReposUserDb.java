package com.github.faeldn.todo.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.faeldn.todo.factory.FactoryJDBC;
import com.github.faeldn.todo.models.Usuario;

public class ReposUserDb implements ReposUi<Integer, Usuario> {

	
	public List<Usuario> all() {
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try (Connection conn = FactoryJDBC.criaConn()) {
			String sql = "SELECT * FROM usuario";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				Usuario u = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"),
						rs.getString("cargo"));
				lista.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Usuario one(Integer id) {
		
		try(Connection conn = FactoryJDBC.criaConn()){
			String sql = "SELECT * FROM usuario where id =?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario u = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"),
						rs.getString("cargo"));
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}

	public void insert(Usuario entity) {
		
		try(Connection conn = FactoryJDBC.criaConn()){
			String sql = "INSERT INTO usuario(nome, email, cargo) VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setString(2, entity.getEmail());
			ps.setString(3, entity.getCargo());
			ps.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Usuario entity) {
		
		try(Connection conn = FactoryJDBC.criaConn()){
			String sql = "UPDATE usuario "
					+ "SET nome = ? ,"
					+ "email = ? ,"
					+ "cargo = ? "
					+ "WHERE id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setString(2, entity.getEmail());
			ps.setString(3, entity.getCargo());
			ps.setInt(4, entity.getId());
			ps.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(Integer id) {
		
		try(Connection conn = FactoryJDBC.criaConn()){
			String sql = "DELETE FROM usuario WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
