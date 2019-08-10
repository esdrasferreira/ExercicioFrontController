package br.com.esdrasferreira.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class Command {
	
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public void init(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;

		this.response = response;
	}
	
	public abstract void process() throws  Exception;
	
	protected void forward(String target)throws Exception{
		
		//target = listarProdutos
		System.out.println("forward do Command...JSP");
		
		target = String.format("%s.jsp", target); //listarProtudos.jsp
		System.out.println(target);
		request.getRequestDispatcher(target).forward(request, response);
	}
	
		
	protected void redirectResource(String target)throws Exception{
		System.out.println("redirectResource do Command...");
		
		target = String.format("%s.html", target); //listarProdutos.jsp
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		System.out.println(contextPath+"/"+target);
		
		response.sendRedirect(contextPath+ "/"+ target);
	}
	
	protected HttpSession getSession() {
		System.out.println("getSession do Command...");
		return request.getSession();
	}

}
