package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.PessoaBean;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}

	public void salvarUsuario(PessoaBean bean) {

		try {
			String sql = "insert into public.usuario(login, senha) values (?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bean.getLogin());
			preparedStatement.setString(2, bean.getSenha());
			preparedStatement.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<PessoaBean> listar() throws Exception {

		List<PessoaBean> usuarios = new ArrayList<PessoaBean>();

		String sql = "select * from public.usuario";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			PessoaBean pessoaBean = new PessoaBean();
			pessoaBean.setId(resultSet.getLong("id"));
			pessoaBean.setLogin(resultSet.getString("login"));
			pessoaBean.setSenha(resultSet.getString("senha"));
			usuarios.add(pessoaBean);
		}

		return usuarios;
	}

	public void delete(String login) {
		try {
			String sql = "delete from public.usuario where login=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login);
			preparedStatement.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public PessoaBean buscar(String login) throws SQLException {

		String sql = "select * from public.usuario where login=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, login);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			PessoaBean bean = new PessoaBean();
			bean.setId(resultSet.getLong("id"));
			bean.setLogin(resultSet.getString("login"));
			bean.setSenha(resultSet.getString("senha"));
			return bean;
		}

		return null;
	}

	public void editar(Long id, PessoaBean pessoaBean) {
		try {
			String sql = "update public.usuario(login,senha) set login=?, senha=? where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, pessoaBean.getLogin());
			preparedStatement.setString(2, pessoaBean.getSenha());
			preparedStatement.setLong(3, id);
			preparedStatement.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
