package br.com.esdrasferreira.controller.produtos;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;
import br.com.esdrasferreira.model.dao.UsuarioDao;
import br.com.esdrasferreira.model.entity.Usuario;

public class Add extends Command {

	@Override
	public void process() throws Exception {
		
		System.out.println("Add.java..aqui");

		HttpSession sessao = request.getSession(true);
		if(sessao == null) {
			forward("logout");
		}
		try {
			int userID = (Integer) sessao.getAttribute("idUsuario");
			System.out.println(userID);
			Usuario user = new Usuario();
			UsuarioDao userDao = new UsuarioDao();

			user = userDao.getUser(userID);

			request.setAttribute("usuario", user);

			forward("addproduto");
			
		}catch (Exception e) {
			redirectResource("logout");
		}
		

	}

}
