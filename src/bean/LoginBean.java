package bean;

public class LoginBean {

	public boolean ValidarLogin(String login, String senha) {
		return login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin") ? true : false;
	}
}
