package br.com.esdrasferreira.controller.produtos;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.dao.ProdutoDao;
import br.com.esdrasferreira.model.entity.Produto;

public class VerImagem extends Command {

	@Override
	public void process() throws Exception {

		System.out.println("VerImagem.java..aqui");

		HttpSession sessao = request.getSession(true);
		if (sessao == null) {
			forward("logout");
		}

		try {

			int userID = (Integer) sessao.getAttribute("idUsuario");
			System.out.println(userID);

			String idProduto = request.getParameter("idProduto");

			int id = Integer.parseInt(idProduto);

			Produto produto = new Produto();
			ProdutoDao produtoDAO = new ProdutoDao();
			produto = produtoDAO.pesquisaPorID(id);

			sessao.setAttribute("produto", produto);

			redirectResource("nome-imagem");

		} catch (Exception e) {
			redirectResource("logout");
		}

	}

}
