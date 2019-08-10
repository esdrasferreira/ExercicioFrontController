package br.com.esdrasferreira.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.esdrasferreira.controller.system.Command;

@WebServlet("*.html")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 5, // 5mb
maxFileSize = 1024 * 1024 * 20, // 20mb
maxRequestSize = 1024 * 1024 * 40 // 40mb

)
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Properties mapping;

	public void init() throws ServletException {
		System.out.println("init..................ServletController..........................init");
		ServletContext context = getServletContext(); // meu aplicativo Aula38MVC......

		try {
			InputStream inputStream = context.getResourceAsStream("/WEB-INF/mapping.properties");
			mapping = new Properties();
			mapping.load(inputStream);
			System.out.println("servletController...................................................mapping.load..");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servletController...................................................doGet..");
		command(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servletController...................................................doPost..");
		command(request, response);
	}

	protected void command(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		System.out.println("path: "+path);
		String index ="index.html";
		

		path = path.substring(1, path.indexOf("."));

		System.out.println(String.format("Aqui é o path: %s", path));

		String commandClass = mapping.getProperty(path);
		System.out.println("commandClass: ..."+commandClass);

		if (commandClass == null) {
			throw new ServletException(String.format("O caminho '%s' não existe", path));
		}
		try {
			Command command = (Command) Class.forName(commandClass).getDeclaredConstructor().newInstance();
			command.init(request, response);
			command.process();
		} catch (Exception e) {
			request.setAttribute("Exception", e);
			throw new ServletException(e);
		}

	}

	public void destroy() {
		System.out.println("servletController......................destroy.........................................................destroy..");
		super.destroy();
	}

}
