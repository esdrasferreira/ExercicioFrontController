package br.com.esdrasferreira.controller.produtos;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.dao.ProdutoDao;

public class Excluir extends Command {

	@Override
	public void process() throws Exception {

		System.out.println("Excluir.java..aqui");
		HttpSession sessao = request.getSession(true);
		if (sessao == null) {
			forward("logout");
		}

		try {
			int userID = (Integer) sessao.getAttribute("idUsuario");
			System.out.println(userID);
			String idProduto = request.getParameter("idProduto");
			int id = Integer.parseInt(idProduto);
			ProdutoDao produtoDAO = new ProdutoDao();
			produtoDAO.excluir(id);

			redirectResource("listar-produto");

		} catch (Exception e) {
			redirectResource("logout");
		}

	}

}
