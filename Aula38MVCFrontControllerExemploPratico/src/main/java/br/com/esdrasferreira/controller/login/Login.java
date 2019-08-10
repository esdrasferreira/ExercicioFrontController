package br.com.esdrasferreira.controller.login;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.dao.UsuarioDao;
import br.com.esdrasferreira.model.entity.Usuario;

public class Login extends Command {

	@Override
	public void process() throws Exception {

		HttpSession sessao = request.getSession(true);
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");

		if (usuario != null && usuario != "" && senha != null && senha != "") {
			System.out.println("login.java aqui...");
			try {
				Usuario user = new Usuario();
				UsuarioDao dao = new UsuarioDao();

				user = dao.login(usuario, senha);

				if (user == null) {

					forward("index");
				}

				sessao.setAttribute("usuario", user.getUsuario());
				sessao.setAttribute("idUsuario", user.getId());

				redirectResource("listar-produto");

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}
}
