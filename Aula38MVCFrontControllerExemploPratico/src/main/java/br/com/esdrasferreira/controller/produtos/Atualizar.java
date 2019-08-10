package br.com.esdrasferreira.controller.produtos;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.dao.UsuarioProdutoDao;
import br.com.esdrasferreira.model.entity.UsuarioProduto;

public class Atualizar extends Command {

	@Override
	public void process() throws Exception {

		System.out.println("Atualizar.java..aqui");

		HttpSession sessao = request.getSession(true);
		if (sessao == null) {
			forward("logout");
		}

		try {
			String idProduto = request.getParameter("idProduto");

			int userID = (Integer) sessao.getAttribute("idUsuario");
			System.out.println(userID);
			int id = Integer.parseInt(idProduto);

			UsuarioProduto userProd = new UsuarioProduto();
			UsuarioProdutoDao userProdDao = new UsuarioProdutoDao();
			userProd = userProdDao.getDados(userID, id);
			request.setAttribute("usuario", userProd);
			forward("atualizalista");

		} catch (Exception e) {
			redirectResource("logout");
		}

	}

}
