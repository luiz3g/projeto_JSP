package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe Responsável por fazer a conexão com o banco de dados
 * 
 * @author Luiz Eduardo
 *
 */
public class SingleConnection {

	private static String database = "jdbc:postgresql://localhost:5432/curso_jsp?autoReconnect=true";
	private static String username = "postgres";
	private static String password = "admin";
	private static Connection connection = null;

	static {
		connect();
	}

	public SingleConnection() {
		connect();
	}

	private static void connect() {

		try {

			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(database, username, password);
				connection.setAutoCommit(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar ao banco de dados");
		}

	}

	public static Connection getConnection() {
		return connection;
	}
}
