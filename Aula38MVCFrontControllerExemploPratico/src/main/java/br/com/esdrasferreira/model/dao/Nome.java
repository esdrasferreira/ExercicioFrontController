package br.com.esdrasferreira.model.dao;

import java.io.File;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.entity.Produto;

public class Nome extends Command {

	@Override
	public void process() throws Exception {

		HttpSession sessao = request.getSession(true);
		if (sessao == null) {
			forward("logout");
		}

		try {
			Produto produto = (Produto) sessao.getAttribute("produto");
			String nomeProduto = produto.getImagem();

//			String caminhoDoUsuario = System.getProperty("user.home");

			String caminhoDaImagem = "imagens" + File.separator + nomeProduto;

//					caminhoDaImagem = caminhoDoUsuario + File.separator +
//					 "appservers" + File.separator
//					 + "arquivos" + File.separator + "imagens"+File.separator + nomeProduto;

			System.out.println(caminhoDaImagem);
			produto.setImagem(caminhoDaImagem);

			request.setAttribute("produto", produto);

			forward("imagens");

		} catch (

		Exception e) {
			redirectResource("logout");
		}

	}

}
