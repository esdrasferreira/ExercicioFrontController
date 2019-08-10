package br.com.esdrasferreira.model.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import br.com.esdrasferreira.controller.system.Command;

public class Upload extends Command {

	@Override
	public void process() throws Exception {

		HttpSession sessao = request.getSession(true);
		if (sessao == null) {
			forward("logout");
		}

		try {

			String id = request.getParameter("idProduto");

			String caminhoDoMeuAplicativo = request.getServletContext().getRealPath("");

			String caminhoDoUsuario = System.getProperty("user.home");
//			String caminhoDaClasse = System.getProperty("user.dir");
//			String nomeDoArquivo = request.getPart("upload").getName();
//			long tamanhoDoArquivo = request.getPart("upload").getSize();
			String tipoDoArquivo = request.getPart("upload").getContentType();

			if (request.getContentType().indexOf("multipart/form-data") >= 0) {

				List<String> tiposPermitidos = new ArrayList<String>();
				tiposPermitidos.add("image/jpeg");
				tiposPermitidos.add("image/png");

				if (tiposPermitidos.contains(tipoDoArquivo)) {

					String diretorioParaUploadDeImagens = caminhoDoMeuAplicativo + "arquivos" + File.separator
							+ "imagens";

					diretorioParaUploadDeImagens = caminhoDoUsuario + File.separator + "appservers" + File.separator
							+ "arquivos" + File.separator + "imagens";

					System.out.println(diretorioParaUploadDeImagens);
					String nomeOriginalDoArquivo = null;

					for (Part part : request.getParts()) {
						nomeOriginalDoArquivo = nomeDoArquivo(part);
						if (nomeOriginalDoArquivo != "") {
							part.write(diretorioParaUploadDeImagens + File.separator + nomeOriginalDoArquivo);

							try {
								int Id = Integer.parseInt(id);

								ProdutoDao produtoDao = new ProdutoDao();
								produtoDao.addImagemAoProduto(nomeOriginalDoArquivo, Id);

							} catch (Exception e) {

								e.printStackTrace();
							}

						} else {

							redirectResource("listar-produto");
						}
					}

				}

			} else {
				redirectResource("listar-produto");
			}
			redirectResource("listar-produto");

		} catch (

		Exception e) {
			redirectResource("logout");
		}

	}

	public String nomeDoArquivo(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}

		return "";
	}

}
