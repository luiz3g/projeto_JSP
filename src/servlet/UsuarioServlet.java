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

			if (acao.equalsIgnoreCase("delete")) {
				int id = Integer.valueOf(request.getParameter("user"));
				daoUsuario.delete(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				dispatcher.forward(request, response);

			}

			if (acao.equalsIgnoreCase("editar")) {

				String login = request.getParameter("user");
				PessoaBean pessoaBean = daoUsuario.buscar(login);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", pessoaBean);
				dispatcher.forward(request, response);
			}

			if (acao.equalsIgnoreCase("listarUsuarios")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
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

		try {
			
			if (!daoUsuario.validarCadastro(request.getParameter("login"))) {
				pessoaBean.setLogin(request.getParameter("login"));
				pessoaBean.setSenha(request.getParameter("senha"));
				pessoaBean.setNome(request.getParameter("nome"));
				daoUsuario.salvarUsuario(pessoaBean);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");

			request.setAttribute("usuarios", daoUsuario.listar());
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
