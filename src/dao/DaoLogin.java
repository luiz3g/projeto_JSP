package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class DaoLogin {

	private Connection connection;

	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}

	public boolean validarLogin(String login, String senha) throws Exception {
		String sql = "select * from public.usuario where login= ? and senha = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, login);
		statement.setString(2, senha);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			return true;
		}

		return false;

	}
}
