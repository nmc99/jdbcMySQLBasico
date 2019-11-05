package org.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBasico {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver"); // Busca la clase. Si no se encuentra lanza un error
			String url = "jdbc:mysql://localhost:3306/primera";
			String user = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);
			String consulta = "SELECT * FROM clientes";
			Statement st = conn.createStatement();
			ResultSet resultado = st.executeQuery(consulta);
			while(resultado.next()) {
				System.out.println(resultado.getString("nombre"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}