package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import model.DAO;
import model.JavaBeans;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAO dao = new DAO();

	public Controller() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/main")) {
			contatos(request, response);
		} else if(action.equals("/insert")) {
			insert(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("agenda.jsp");
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		JavaBeans contato = new JavaBeans(nome, telefone, email);
		dao.insert(contato);
		response.sendRedirect("main");
	}
}
