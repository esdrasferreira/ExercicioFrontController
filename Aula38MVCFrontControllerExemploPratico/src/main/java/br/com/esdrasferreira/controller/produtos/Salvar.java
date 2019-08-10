package br.com.esdrasferreira.controller.produtos;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.dao.ProdutoDao;
import br.com.esdrasferreira.model.dao.UsuarioDao;
import br.com.esdrasferreira.model.entity.Usuario;

public class Salvar extends Command {

	@Override
	public void process() throws Exception {

		System.out.println("Salvar.java..aqui");

		HttpSession sessao = request.getSession(true);
		if (sessao == null) {
			forward("logout");
		}

		try {
			int userID = (Integer) sessao.getAttribute("idUsuario");
			System.out.println(userID);

			Usuario user = new Usuario();
			UsuarioDao userDao = new UsuarioDao();

			String novoProduto = request.getParameter("txtRq");

			if (novoProduto == "") {

				user = userDao.getUser(userID);

				request.setAttribute("usuario", user);
				request.setAttribute("erros", "Necessário um nome do produto para salvar.");

				forward("addproduto");

			} else {
				ProdutoDao produtoDAO = new ProdutoDao();
				produtoDAO.addProduto(novoProduto, userID);

				redirectResource("listar-produto");
			}
		} catch (Exception e) {
			redirectResource("logout");
		}

	}

}
