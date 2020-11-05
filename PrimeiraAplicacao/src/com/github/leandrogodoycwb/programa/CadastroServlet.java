package com.github.leandrogodoycwb.programa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "/CadastroServlet",
		urlPatterns = "/cadastro"
)	
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("Veio via GET");
		
		String email = req.getParameter("email");
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		
		writer.write(" Nome: " + nome + " Email:" + email + " Telefone: " + telefone);
		
		
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		
		req.setAttribute("nome", nome);
		req.setAttribute("email", email);
		req.setAttribute("telefone", telefone);
		req.getRequestDispatcher("jsp-cadastro.jsp").forward(req, resp);
		
			
	}
}
