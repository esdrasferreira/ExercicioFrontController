package br.com.esdrasferreira.controller.produtos;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.dao.ProdutoDao;
import br.com.esdrasferreira.model.dao.UsuarioDao;
import br.com.esdrasferreira.model.entity.Produto;
import br.com.esdrasferreira.model.entity.Usuario;

public class Listar extends Command {

	@Override
	public void process() throws Exception {

		System.out.println("Listar.java..aqui");

		HttpSession sessao = request.getSession(true);

		if (sessao == null) {
			forward("logout");
		}

		try {
			int userID = (Integer) sessao.getAttribute("idUsuario");
			System.out.println("User ID: "+userID);
			String numPagina = request.getParameter("numpagina");
			System.out.println("número da pagina: " + numPagina);
			if (numPagina == null) {
				numPagina = "1";
			}
			int offset = (Integer.parseInt(numPagina) * 10) - 10;
			System.out.println("offset: " + offset);

			ProdutoDao produtoDAO = new ProdutoDao();
			Usuario user = new Usuario();
			UsuarioDao userDao = new UsuarioDao();

			user = userDao.getUser(userID);

			List<Produto> produtos = produtoDAO.todosPaginacao(user.getId(), offset);

			int numRows = produtoDAO.getNumRows();
			int totalPg = numRows / 10;
			if (numRows % 10 != 0) {
				totalPg++;
			}

			request.setAttribute("numPaginas", totalPg);
			request.setAttribute("produtoList", produtos);
			request.setAttribute("usuario", user);
			request.setAttribute("numpagina", numPagina);

			forward("arearestrita");

		} catch (Exception e) {
			redirectResource("logout");
		}

	}

}
