package br.com.esdrasferreira.controller.produtos;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.dao.ProdutoDao;
import br.com.esdrasferreira.model.dao.UsuarioDao;
import br.com.esdrasferreira.model.entity.Produto;
import br.com.esdrasferreira.model.entity.Usuario;

public class Galeria extends Command {

	@Override
	public void process() throws Exception {
		System.out.println("Galeria.java..aqui");

		HttpSession sessao = request.getSession(true);
		if (sessao == null) {
			forward("logout");
		}

		try {
			int userID = (Integer) sessao.getAttribute("idUsuario");
			System.out.println(userID);
			Usuario user = new Usuario();
			UsuarioDao userDao = new UsuarioDao();
			ProdutoDao produtoDAO = new ProdutoDao();

			user = userDao.getUser(userID);

			List<Produto> produtos = produtoDAO.todos(userID);

			sessao.setAttribute("produtoList", produtos);

			redirectResource("nomes-imagens");

		} catch (Exception e) {
			redirectResource("logout");
		}

	}

}
