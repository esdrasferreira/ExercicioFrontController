package br.com.esdrasferreira.controller.produtos;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.dao.ProdutoDao;
import br.com.esdrasferreira.model.dao.UsuarioProdutoDao;
import br.com.esdrasferreira.model.entity.Produto;
import br.com.esdrasferreira.model.entity.UsuarioProduto;

public class Update extends Command {

	@Override
	public void process() throws Exception {

		System.out.println("Update.java..aqui");

		HttpSession sessao = request.getSession(true);
		if (sessao == null) {
			forward("logout");
		}

		try {
			String idProduto = request.getParameter("idProduto");
			int userID = (Integer) sessao.getAttribute("idUsuario");
			System.out.println(userID);

			String novoProduto = request.getParameter("novoProduto");

			if (novoProduto == "") {
				int id = Integer.parseInt(idProduto);

				UsuarioProduto userProd = new UsuarioProduto();
				UsuarioProdutoDao userProdDao = new UsuarioProdutoDao();
				userProd = userProdDao.getDados(userID, id);
				request.setAttribute("usuario", userProd);

				request.setAttribute("erros", "Necessário um nome do produto para salvar.");

				forward("atualizalista");

			} else {

				int id = Integer.parseInt(idProduto);
				ProdutoDao produtoDAO = new ProdutoDao();
				Produto produto = new Produto();
				produto.setProduto(novoProduto);
				produto.setId(id);
				produtoDAO.atualizar(produto);

				redirectResource("listar-produto");
			}

		} catch (Exception e) {
			redirectResource("logout");
		}

	}

}
