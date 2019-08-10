package br.com.esdrasferreira.model.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.entity.Produto;

public class Nomes extends Command {

	@Override
	public void process() throws Exception {

		HttpSession sessao = request.getSession(true);
		if (sessao == null) {
			forward("logout");
		}

		try {
			String caminhoDoUsuario = System.getProperty("user.home");
			List<Produto> produtos2 = new ArrayList<Produto>();
			List<Produto> produtos = (List<Produto>) sessao.getAttribute("produtoList");

			for (Iterator<Produto> list = produtos.iterator(); list.hasNext();) {

				Produto prod = (Produto) list.next();
				String nomeProduto = prod.getImagem();
				String caminhoDaImagem = "imagens" + File.separator + nomeProduto;
				prod.setImagem(caminhoDaImagem);
				System.out.println(caminhoDaImagem);
				produtos2.add(prod);

			}

//					caminhoDaImagem = caminhoDoUsuario + File.separator +
//					 "appservers" + File.separator
//					 + "arquivos" + File.separator + "imagens"+File.separator + nomeProduto;

			request.setAttribute("produtos2", produtos2);

			forward("galeria");

		} catch (Exception e) {
			redirectResource("logout");
		}

	}

}
