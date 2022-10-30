package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAO dao = new DAO();
	
	JavaBeans contato = new JavaBeans();

	public Controller() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/main")) {
			contatos(request, response);
		} else if(action.equals("/insert")) {
			insert(request, response);
		} else if(action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}


	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}
	

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		JavaBeans contato = new JavaBeans(nome, telefone, email);
		dao.insert(contato);
		response.sendRedirect("main");
	}

	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setIdcon(request.getParameter("idcon"));
		dao.selecionarContato(contato);
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("telefone", contato.getTelefone());
		request.setAttribute("email", contato.getEmail());
		RequestDispatcher rd = request.getRequestDispatcher("editarContato.jsp");
		rd.forward(request, response);
	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		dao.alterarContato(contato);
		response.sendRedirect("main");
	}
	
	
}
