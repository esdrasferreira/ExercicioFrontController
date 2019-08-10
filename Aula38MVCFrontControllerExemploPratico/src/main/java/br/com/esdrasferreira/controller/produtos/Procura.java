package br.com.esdrasferreira.controller.produtos;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.dao.ProdutoDao;
import br.com.esdrasferreira.model.dao.UsuarioDao;
import br.com.esdrasferreira.model.entity.Produto;
import br.com.esdrasferreira.model.entity.Usuario;

public class Procura extends Command {

	@Override
	public void process() throws Exception {

		System.out.println("Procura.java..aqui");

		HttpSession sessao = request.getSession(true);
		if (sessao == null) {
			forward("logout");
		}

		try {
			int userID = (Integer) sessao.getAttribute("idUsuario");
			System.out.println(userID);

			ProdutoDao produtoDAO = new ProdutoDao();
			Usuario user = new Usuario();
			UsuarioDao userDao = new UsuarioDao();

			String valorProcura = request.getParameter("produtoSearch");

			List<Produto> produtos = produtoDAO.pesquisaPorNomeProduto(valorProcura, userID);

			user = userDao.getUser(userID);

			request.setAttribute("produtoList", produtos);
			request.setAttribute("usuario", user);

			forward("resultadopesquisa");

		} catch (Exception e) {
			redirectResource("logout");
		}

	}

}
