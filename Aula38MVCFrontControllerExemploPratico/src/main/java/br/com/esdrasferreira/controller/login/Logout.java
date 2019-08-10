package br.com.esdrasferreira.controller.login;

import javax.servlet.http.HttpSession;

import br.com.esdrasferreira.controller.system.Command;

public class Logout extends Command{

	@Override
	public void process() throws Exception {

		HttpSession sessao = request.getSession(true);
		sessao.setAttribute("id", null);

		forward("index");
		
		
		
	}

}
