package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PessoaBean;
import dao.DaoUsuario;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoUsuario daoUsuario = new DaoUsuario();

		try {
			String acao = request.getParameter("acao");
			String login = request.getParameter("user");

			if (acao.equalsIgnoreCase("delete")) {
				daoUsuario.delete(login);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				dispatcher.forward(request, response);

			}

			if (acao.equalsIgnoreCase("editar")) {

				PessoaBean pessoaBean = daoUsuario.buscar(login);

				if(pessoaBean.getId() == null) {
					
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", pessoaBean);
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DaoUsuario daoUsuario = new DaoUsuario();
		PessoaBean pessoaBean = new PessoaBean();

		pessoaBean.setLogin(request.getParameter("login"));
		pessoaBean.setSenha(request.getParameter("senha"));
		
		daoUsuario.salvarUsuario(pessoaBean);

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");

			request.setAttribute("usuarios", daoUsuario.listar());
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
