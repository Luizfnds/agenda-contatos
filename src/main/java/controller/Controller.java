package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.DAO;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DAO dao = new DAO();
	
    public Controller() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao.testaConexao();
	}

}
