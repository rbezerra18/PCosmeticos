package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UsuarioBD;
import objeto.Usuario;

/**
 * Servlet implementation class CadastrarServlet
 */
//@WebServlet("/CadastrarServlet")
public class CadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("pages/cadastrousuario.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = (String) request.getParameter("cpf");
		String nome = (String) request.getParameter("nome");
		String login = (String) request.getParameter("login");
		String senha = (String) request.getParameter("senha");
		
		HttpSession session = request.getSession();		
		
		Usuario u = new Usuario(cpf,nome,login,senha);
		
		System.out.println(cpf);
		System.out.println(nome);
		System.out.println(login);
		System.out.println(senha);
		
		UsuarioBD.addUsuario(u);			
		
		if(u != null){			
			
			session.setAttribute("aviso1", "Usuário cadastrado!");
		}
		doGet(request, response);
	}

}
