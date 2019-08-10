package br.com.esdrasferreira.controller.produtos;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.dao.ProdutoDao;
import br.com.esdrasferreira.model.dao.UsuarioDao;
import br.com.esdrasferreira.model.entity.Produto;
import br.com.esdrasferreira.model.entity.Usuario;

public class Imagem extends Command {

	@Override
	public void process() throws Exception {

		System.out.println("Imagem.java..aqui");

		HttpSession sessao = request.getSession(true);
		if (sessao == null) {
			forward("logout");
		}

		try {
			String idProduto = request.getParameter("idProduto");
			int userID = (Integer) sessao.getAttribute("idUsuario");
			System.out.println(userID);
			Usuario user = new Usuario();
			UsuarioDao userDao = new UsuarioDao();
			ProdutoDao produtoDAO = new ProdutoDao();

			int id = Integer.parseInt(idProduto);

			Produto produto = new Produto();
			produto = produtoDAO.pesquisaPorID(id);

			user = userDao.getUser(userID);

			request.setAttribute("usuario", user);

			request.setAttribute("produto", produto);

			forward("addproduto");

		} catch (Exception e) {
			redirectResource("logout");
		}

	}

}
